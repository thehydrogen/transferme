package me.hydro.transfer.command;

import me.hydro.transfer.TransferMe;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TransferMeCommand implements CommandExecutor {

    @Override
    public boolean onCommand(final CommandSender sender, final Command command, final String label, final String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("You need to be a player to use this command");
            return true;
        }

        final Player player = (Player) sender;

        if (args.length == 0) {
            sender.sendMessage(ChatColor.RED + "/transfer <ip>");

            return true;
        }

        final String ip = args[0];

        player.sendMessage(ChatColor.GREEN + "Sending transfer request for " + ip);

        TransferMe.INSTANCE.getLunarTransfer().transferPlayer(player, ip);

        return true;
    }
}
