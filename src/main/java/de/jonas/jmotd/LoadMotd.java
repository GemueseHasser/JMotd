package de.jonas.jmotd;

import de.jonas.JMotd;
import org.bukkit.Bukkit;
import org.bukkit.craftbukkit.v1_16_R3.CraftServer;

public class LoadMotd {

    public LoadMotd() {
        String lineOne = JMotd.getInstance().getConfig().getString(
            "Config.motd.lineOne"
        ).replace("&", "§");
        String lineTwo = JMotd.getInstance().getConfig().getString(
            "Config.motd.lineTwo"
        ).replace("&", "§");
        ((CraftServer) Bukkit.getServer()).getServer().setMotd(lineOne + "\n" + lineTwo);
    }

}
