package de.jonas;

import de.jonas.jmotd.LoadMotd;
import de.jonas.jmotd.TabComplete;
import de.jonas.jmotd.ReloadMotd;
import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public class JMotd extends JavaPlugin {

    public static final String PREFIX = ChatColor.GREEN + "[JMotd] " + ChatColor.GRAY;

    private static final ConsoleCommandSender CONSOLE = Bukkit.getConsoleSender();

    @Getter
    public static JMotd instance;

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

    private void loadConfig() {
        getConfig().options().copyDefaults(true);
        saveConfig();
    }

}
