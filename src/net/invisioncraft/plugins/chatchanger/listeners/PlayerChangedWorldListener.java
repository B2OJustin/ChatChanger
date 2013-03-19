package net.invisioncraft.plugins.chatchanger.listeners;

import com.palmergames.bukkit.TownyChat.Chat;
import net.invisioncraft.plugins.chatchanger.ChatChanger;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChangedWorldEvent;

/**
 * Created with IntelliJ IDEA.
 * User: Justin
 * Date: 3/18/13
 * Time: 8:10 PM
 */
public class PlayerChangedWorldListener implements Listener {
    public Chat townyChat;
    public ChatChanger plugin;

    public PlayerChangedWorldListener(ChatChanger plugin) {
        this.plugin = plugin;
        townyChat = (Chat) plugin.getServer().getPluginManager().getPlugin("TownyChat");
    }

    @EventHandler(priority = EventPriority.NORMAL, ignoreCancelled = true)
    public void onPlayerChangedWorld(PlayerChangedWorldEvent event) {
        String playerName = event.getPlayer().getName();
        String channelName = plugin.config.getChannel(event.getPlayer().getWorld().getName());
        townyChat.getChannelsHandler().getChannel(channelName).join(playerName);
    }
}
