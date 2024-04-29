package icu.zzzii.command;

import icu.zzzii.Lottery;
import icu.zzzii.config.PrizePool;
import org.bukkit.command.CommandSender;

public class AdminCommand implements Command {

    private final Lottery plugin;

    public AdminCommand(Lottery plugin) {
        this.plugin = plugin;
    }
    @Override
    public boolean execute(CommandSender sender, String[] args) {
        if (args.length > 1 && args[1].equalsIgnoreCase("info")) {
            // 处理 "info" 参数的逻辑
            sender.sendMessage("Admin info command executed.");
        } else {
            PrizePool prizePool = plugin.getPrizePool();
            sender.sendMessage("奖池："+prizePool);
        }
        return true;
    }
}
