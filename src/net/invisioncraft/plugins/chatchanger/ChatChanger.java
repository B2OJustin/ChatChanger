package net.invisioncraft.plugins.chatchanger;

import net.invisioncraft.plugins.chatchanger.listeners.PlayerChangedWorldListener;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Level;

/**
 * Created with IntelliJ IDEA.
 * User: Justin
 * Date: 3/18/13
 * Time: 8:01 PM
 */
public final class ChatChanger extends JavaPlugin {
    public static ChatChanger plugin;
    public Config config;

    @Override
    public void onEnable() {
        ChatChanger.plugin = this;
        config = new Config(this);
        if(getServer().getPluginManager().getPlugin("TownyChat") == null) {
            getLogger().log(Level.WARNING, "TownyChat not found, disabling plugin.");
            this.getServer().getPluginManager().disablePlugin(this);
            return;
        }
        getServer().getPluginManager().registerEvents(new PlayerChangedWorldListener(this), this);
    }

    @Override
    public void onDisable() {

    }

    public static ChatChanger getPlugin() {
        return plugin;
    }
}
