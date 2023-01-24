package me.hydro.transfer;

import lombok.Getter;
import me.exro.lunartransfer.LunarTransfer;
import me.hydro.transfer.command.TransferMeCommand;
import org.bukkit.plugin.java.JavaPlugin;

@Getter
public final class TransferMe extends JavaPlugin {

    public static TransferMe INSTANCE = null;

    private LunarTransfer lunarTransfer;

    @Override
    public void onEnable() {
        // Set instance singleton
        INSTANCE = this;

        // Register LunarTransfer
        lunarTransfer = new LunarTransfer(this);

        // Register command
        getCommand("transfer").setExecutor(new TransferMeCommand());
    }
}
