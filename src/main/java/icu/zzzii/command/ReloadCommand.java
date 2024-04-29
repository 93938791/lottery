package icu.zzzii.command;

import icu.zzzii.config.YamlConfigParser;
import icu.zzzii.Lottery;
import org.bukkit.command.CommandSender;

public class ReloadCommand implements Command {
    private final Lottery plugin;

    public ReloadCommand(Lottery plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean execute(CommandSender sender, String[] args) {
        YamlConfigParser.parsePrizes(plugin.getPrizesFile());
        YamlConfigParser.parsePrizePool(plugin.getPrizePoolFile());
        sender.sendMessage("配置文件已重新加载。");
        return true;
    }
}
