package de.jonas.jmotd;

import de.jonas.JMotd;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

import static de.jonas.JMotd.PREFIX;

/**
 * Hier wird der Command, der zum neu laden der MOTD bzw Config zuständig ist, implementiert.
 */
public class ReloadMotd implements CommandExecutor {
    //<editor-fold desc="implementation">
    @Override
    public boolean onCommand(
        @NotNull final CommandSender sender,
        @NotNull final Command cmd,
        @NotNull final String label,
        @NotNull final String[] args
    ) {
        if (!sender.hasPermission("motd")) {
            sender.sendMessage(PREFIX + "Dazu hast du keine Rechte!");
            return true;
        }
        if (args.length != 1) {
            sender.sendMessage(PREFIX + "Um die MOTDneu zu laden, gebe /motd rl ein!");
            return true;
        }
        JMotd.getInstance().reloadConfig();
        new LoadMotd();
        sender.sendMessage(PREFIX + "Du hast die MOTD neu geladen!");
        return true;
    }
    //</editor-fold>
}
