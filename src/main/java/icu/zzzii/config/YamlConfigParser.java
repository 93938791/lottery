package icu.zzzii.config;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static org.bukkit.Bukkit.getLogger;

/**
 * 配置文件解析
 * */
public class YamlConfigParser {

    /**
     * 读取yml文件
     * */
    public static FileConfiguration loadYamlFile(File file) {
        if (!file.exists()) {
            System.out.println("File " + file.getName() + " does not exist.");
            return null;
        }
        return YamlConfiguration.loadConfiguration(file);
    }

    /**
     * 转换为Map列表
     */
    public static @NotNull List<Map<?, ?>> getMapList(@NotNull FileConfiguration config, String path) {
        return config.getMapList(path);
    }

    /**
     * 读取奖品配置文件
     * @param file 配置文件
     * return 奖品列表
     * */
    public static List<Prize> parsePrizes(File file) {
        FileConfiguration config = loadYamlFile(file);
        if (config == null) {
            throw new IllegalArgumentException("没有找到奖励的配置文件");
        }
        List<Map<?, ?>> prizesList = getMapList(config, "prizes");
        List<Prize> prizes = new ArrayList<>();
        int index = 1;
        for (Map<?, ?> prizeMap : prizesList) {
            @SuppressWarnings("unchecked")
            LinkedHashMap<String,Object> prizeInfo = (LinkedHashMap<String, Object>) prizeMap.get(index);
            Prize prize = new Prize();
            prize.setType((String) prizeInfo.get("type"));
            prize.setMaterial((String) prizeInfo.get("material"));
            prize.setDisplayName((String) prizeInfo.get("displayName"));
            @SuppressWarnings("unchecked")
            List<String> lore = (List<String>) prizeInfo.get("lore");
            prize.setLore(lore);
            prize.setEnchanted((Boolean) prizeInfo.get("enchanted"));
            prize.setRarity((Integer) prizeInfo.get("rarity"));
            prize.setProbability((Double) prizeInfo.get("probability"));
            @SuppressWarnings("unchecked")
            List<String> commands = (List<String>) prizeInfo.get("commands");
            prize.setCommands(commands);
            @SuppressWarnings("unchecked")
            List<Map<String, Object>> items = (List<Map<String, Object>>) prizeInfo.get("items");
            prize.setItems(items);
            prizes.add(prize);
            index++;
        }
        return prizes;
    }


    /**
     * 读取奖池配置文件
     * @param file 配置文件
     * return 奖池对象
     * */
    public static PrizePool parsePrizePool(File file) {

        FileConfiguration config = loadYamlFile(file);
        if (config == null) {
            throw new IllegalArgumentException("没有找到奖池的配置文件");
        }
        List<Map<?, ?>> poolList = getMapList(config, "prizePool");
        getLogger().info(String.valueOf(poolList.size()));
        List<PrizePool.Pool> pools = new ArrayList<>();
        for (Map<?, ?> poolMap : poolList) {
            PrizePool.Pool pool = new PrizePool.Pool();
            pool.setPay((Integer) poolMap.get("pay"));
            pool.setProbability((Double) poolMap.get("probability"));
            @SuppressWarnings("unchecked")
            List<Integer> prizes = (List<Integer>) poolMap.get("prizes");
            pool.setPrizes(prizes);
            @SuppressWarnings("unchecked")
            List<Integer> consolationPrize = (List<Integer>) poolMap.get("consolation-prize");
            pool.setConsolationPrize(consolationPrize);
            pools.add(pool);
        }

        PrizePool prizePool = new PrizePool();
        prizePool.setPrizePool(pools);
        return prizePool;
    }

}
