package org.carp.essentials;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import org.carp.essentials.helpers.ConfigHelper;
import org.carp.essentials.listeners.AnvilListener;

public final class Anvil extends JavaPlugin implements Listener {

    private static Plugin instance;

    public static Plugin getInstance() {
        return instance;
    }

    public static YamlConfiguration config;

    @Override
    public void onEnable() {
        instance = this;
        config = ConfigHelper.getConfig();

        // Plugin startup logic
        getServer().getPluginManager().registerEvents(new AnvilListener(), instance);

        if (config.getBoolean("General.debug")) {
            getLogger().info("Is in Debug Mode.");
        }
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
