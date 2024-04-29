package icu.zzzii.config;

import java.util.List;
import java.util.Map;

public class Prize {
    // 奖品类型
    private String type;
    // 奖品展示内容
    private String material;
    // 奖品展示名称
    private String displayName;
    // 奖品展示描述
    private List<String> lore;
    // 是否有发光效果
    private Boolean enchanted;
    // 奖品稀有度
    private Integer rarity;
    // 奖品概率
    private Double probability;
    // 奖品命令
    private List<String> commands;
    // 奖品物品
    private List<Map<String, Object>> items;

    public Prize() {
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public List<String> getLore() {
        return lore;
    }

    public void setLore(List<String> lore) {
        this.lore = lore;
    }

    public Boolean getEnchanted() {
        return enchanted;
    }

    public void setEnchanted(Boolean enchanted) {
        this.enchanted = enchanted;
    }

    public Integer getRarity() {
        return rarity;
    }

    public void setRarity(Integer rarity) {
        this.rarity = rarity;
    }

    public Double getProbability() {
        return probability;
    }

    public void setProbability(Double probability) {
        this.probability = probability;
    }

    public List<String> getCommands() {
        return commands;
    }

    public void setCommands(List<String> commands) {
        this.commands = commands;
    }

    public List<Map<String, Object>> getItems() {
        return items;
    }

    public void setItems(List<Map<String, Object>> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "Prize{" +
                "type='" + type + '\'' +
                ", material='" + material + '\'' +
                ", displayName='" + displayName + '\'' +
                ", lore=" + lore +
                ", enchanted=" + enchanted +
                ", rarity=" + rarity +
                ", probability=" + probability +
                ", commands=" + commands +
                ", items=" + items +
                '}';
    }
}
