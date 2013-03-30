/*
This file is part of ChatChanger.

    ChatChanger is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    ChatChanger is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with ChatChanger.  If not, see <http://www.gnu.org/licenses/>.
*/

package net.invisioncraft.plugins.chatchanger.listeners;

import com.palmergames.bukkit.TownyChat.Chat;
import net.invisioncraft.plugins.chatchanger.ChatChanger;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChangedWorldEvent;

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
