package de.jonas;

import de.jonas.jmotd.LoadMotd;
import de.jonas.jmotd.ReloadMotd;
import de.jonas.jmotd.TabComplete;
import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

/**
 * Die Haupt- und Main-Klasse, in der alles zusammen läuft und in der alles registriert wird.
 */
public class JMotd extends JavaPlugin {


    //<editor-fold desc="CONSTANTS">
    /** Der Prefix, der vor allen Nachrichten steht, die von diesem Plugin versendet werden. */
    public static final String PREFIX = ChatColor.GREEN + "[JMotd] " + ChatColor.GRAY;
    /** Die Konsole, der die Aktivierungs-Nachricht bzw die Deaktivierungs-Nachricht angezeigt wird. */
    private static final ConsoleCommandSender CONSOLE = Bukkit.getConsoleSender();
    //</editor-fold>


    //<editor-fold desc="STATIC-FIELDS">
    /** Die Instanz, mit der auf dieses Plugin zugegriffen werden kann. */
    @Getter
    private static JMotd instance;
    //</editor-fold>

    //<editor-fold desc="setup and shutdown">
    @Override
    public void onEnable() {
        instance = this;
        CONSOLE.sendMessage(PREFIX + "Das Plugin wurde erfolgreich aktiviert!");

        Objects.requireNonNull(getCommand("motd")).setExecutor(new ReloadMotd());
        Objects.requireNonNull(getCommand("motd")).setTabCompleter(new TabComplete());

        loadConfig();

        new LoadMotd();
    }

    @Override
    public void onDisable() {
        CONSOLE.sendMessage(PREFIX + "Das Plugin wurde deaktiviert!");
    }
    //</editor-fold>

    /**
     * Die Config wird mit allen Inhalten, die voreingestellt sind, geladen.
     */
    private void loadConfig() {
        getConfig().options().copyDefaults(true);
        saveConfig();
    }

}
