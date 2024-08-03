package org.carp.essentials.helpers;

import org.bukkit.configuration.file.YamlConfiguration;
import org.carp.essentials.Anvil;

import java.io.File;

public class ConfigHelper {

    public static YamlConfiguration getConfig() {

        File configFile = new File(Anvil.getInstance().getDataFolder(), "config.yml");

        if(!configFile.exists()) {
            Anvil.getInstance().saveDefaultConfig();
        }

        return YamlConfiguration.loadConfiguration(configFile);
    }
}
