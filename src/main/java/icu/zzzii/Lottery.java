package icu.zzzii;

import icu.zzzii.command.LotteryCommands;
import icu.zzzii.config.Prize;
import icu.zzzii.config.PrizePool;
import icu.zzzii.config.YamlConfigParser;
import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.command.PluginCommand;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.util.List;

public final class Lottery extends JavaPlugin implements Listener {

    private File prizesFile;
    private File prizePoolFile;
    private List<Prize> prizes;
    private PrizePool prizePool;

    @Override
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(this,this);
        prizesFile = new File(getDataFolder(), "prizes.yml");
        prizePoolFile = new File(getDataFolder(), "prizePool.yml");

        // 检查 prizes.yml 文件是否存在，如果不存在，就创建一个新的文件，并写入默认的配置信息
        if (!prizesFile.exists()) {
            saveResource("prizes.yml", false);
        }

        if (!prizePoolFile.exists()) {
            saveResource("prizePool.yml", false);
        }

        // 在启动时直接加载配置文件
         prizes = YamlConfigParser.parsePrizes(prizesFile);
         prizePool = YamlConfigParser.parsePrizePool(prizePoolFile);
        LotteryCommands lotteryCommands = new LotteryCommands(this);
        PluginCommand lotteryCommand = this.getCommand("lottery");
        if (lotteryCommand != null) {
            lotteryCommand.setExecutor(lotteryCommands);
            lotteryCommand.setTabCompleter(lotteryCommands);
        } else {
            getLogger().warning("plugin.yml 中未定义命令“lottery”");
        }
    }

    @Override
    public void onDisable() {
        // 插件关闭逻辑
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event){
        event.getPlayer().sendMessage(Component.text(event.getPlayer().getPing()+" ms!"));
        getLogger().info(event.getPlayer().getName()+" 加入了游戏");
    }


    public File getPrizesFile() {
        return prizesFile;
    }

    public File getPrizePoolFile() {
        return prizePoolFile;
    }

    public List<Prize> getPrizes() {
        return prizes;
    }

    public PrizePool getPrizePool() {
        return prizePool;
    }
}
