package icu.zzzii.command;

import icu.zzzii.Lottery;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LotteryCommands implements CommandExecutor, TabCompleter {
    private final Map<String, Command> commands = new HashMap<>();

    public LotteryCommands(Lottery plugin) {
        commands.put("reload", new ReloadCommand(plugin));
        commands.put("admin", new AdminCommand(plugin));
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, org.bukkit.command.@NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (command.getName().equalsIgnoreCase("lottery") && args.length > 0) {
            Command cmd = commands.get(args[0].toLowerCase());
            if (cmd != null) {
                return cmd.execute(sender, args);
            }
        }
        return false;
    }

    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender sender, org.bukkit.command.@NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (command.getName().equalsIgnoreCase("lottery")) {
            if (args.length == 1) {
                return Stream.of("reload", "admin")
                        .filter(s -> s.startsWith(args[0]))
                        .collect(Collectors.toList());
            }
            if (args.length == 2 && args[0].equalsIgnoreCase("admin")) {
                return Stream.of("info")
                        .filter(s -> s.startsWith(args[1]))
                        .collect(Collectors.toList());
            }
        }
        return Collections.emptyList();
    }

}
