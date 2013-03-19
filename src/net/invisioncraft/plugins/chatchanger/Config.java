package net.invisioncraft.plugins.chatchanger;

import org.bukkit.configuration.file.FileConfiguration;

/**
 * Created with IntelliJ IDEA.
 * User: Justin
 * Date: 3/18/13
 * Time: 10:23 PM
 */
public class Config {
    public ChatChanger plugin;
    public FileConfiguration config;

    public Config(ChatChanger plugin) {
        this.plugin = plugin;
        config = plugin.getConfig();

        config.options().copyDefaults(true);
        plugin.saveDefaultConfig();
    }

    public String getChannel(String worldName) {
        return config.getString("worlds." + worldName);
    }
}
