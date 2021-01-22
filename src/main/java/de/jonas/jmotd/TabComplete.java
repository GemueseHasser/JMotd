package de.jonas.jmotd;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

/**
 * Hier wird die Anzeige implementiert, die hinterher getabt werden kann.
 */
public class TabComplete implements TabCompleter {
    //<editor-fold desc="implementation">
    @Nullable
    @Override
    public List<String> onTabComplete(
        @NotNull final CommandSender sender,
        @NotNull final Command cmd,
        @NotNull final String label,
        @NotNull final String[] args
    ) {
        if (args.length == 1) {
            List<String> list = new ArrayList<>();
            list.add("rl");
            return list;
        }
        return null;
    }
    //</editor-fold>
}
