package de.jonas.jmotd;

import de.jonas.JMotd;
import org.bukkit.Bukkit;
import org.bukkit.craftbukkit.v1_16_R3.CraftServer;

import java.util.Objects;

/**
 * Die MOTD, welche in der Config eingestellt ist, wird gesetzt.
 */
public class LoadMotd {


    //<editor-fold desc="CONSTRUCTORS">
    /**
     * Es wird eine neue und vollstaändig unabhängige Instanz der {@link LoadMotd} Klasse erstellt, mit der dann die
     * Server-MOTD aufgrund der MOTD in der Config gesetzt wird.
     */
    public LoadMotd() {
        String lineOne = Objects.requireNonNull(JMotd.getInstance().getConfig().getString(
            "Config.motd.lineOne"
        )).replace("&", "§");
        String lineTwo = Objects.requireNonNull(JMotd.getInstance().getConfig().getString(
            "Config.motd.lineTwo"
        )).replace("&", "§");
        ((CraftServer) Bukkit.getServer()).getServer().setMotd(lineOne + "\n" + lineTwo);
    }
    //</editor-fold>
}
