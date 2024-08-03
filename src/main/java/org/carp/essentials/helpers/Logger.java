package org.carp.essentials.helpers;

import org.bukkit.ChatColor;
import org.carp.essentials.Anvil;

public class Logger {

    private String text;

    public static Logger getLogger() {
        return new Logger();
    }

    public Logger info(String text) {
        this.text = ChatColor.DARK_GRAY+"[" + ChatColor.BLUE+"INFO" + ChatColor.DARK_GRAY+"]" + ChatColor.DARK_GRAY+": " + ChatColor.WHITE+text;
        return this;
    }

    public Logger warn(String text) {
        this.text = ChatColor.DARK_GRAY+"[" + ChatColor.RED+"WARN" + ChatColor.DARK_GRAY+"]" + ChatColor.DARK_GRAY+": " + ChatColor.WHITE+text;
        return this;
    }

    public void send() {

        if (text != null) {

            String content = ChatColor.DARK_GRAY+"[" + ChatColor.GOLD+ Anvil.getInstance().getName() + ChatColor.DARK_GRAY+"]" + " " + this.text;

            System.out.println(content);

            this.clearTextCache();
        }
    }

    private void clearTextCache() {
        text = null;
    }
}
