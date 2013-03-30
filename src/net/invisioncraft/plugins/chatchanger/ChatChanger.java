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

package net.invisioncraft.plugins.chatchanger;

import net.invisioncraft.plugins.chatchanger.listeners.PlayerChangedWorldListener;
import org.bukkit.plugin.java.JavaPlugin;
import java.util.logging.Level;

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
        }
        if(isEnabled()) {
            getServer().getPluginManager().registerEvents(new PlayerChangedWorldListener(this), this);
        }
    }

    @Override
    public void onDisable() {

    }

    public static ChatChanger getPlugin() {
        return plugin;
    }
}
