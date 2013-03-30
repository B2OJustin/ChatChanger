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

import org.bukkit.configuration.file.FileConfiguration;

public class Settings {
    public ChatChanger plugin;
    public FileConfiguration config;

    public Settings(ChatChanger plugin) {
        this.plugin = plugin;
        config = plugin.getConfig();

        config.options().copyDefaults(true);
        plugin.saveDefaultConfig();
    }

    public String getChannel(String worldName) {
        return config.getString("worlds." + worldName);
    }
}
