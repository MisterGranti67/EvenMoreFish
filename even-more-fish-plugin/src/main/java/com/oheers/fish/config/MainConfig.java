package com.oheers.fish.config;

import com.oheers.fish.EvenMoreFish;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;

import java.util.List;
import java.util.logging.Level;

public class MainConfig {

    private final EvenMoreFish plugin;
    private FileConfiguration config;

    public MainConfig(EvenMoreFish plugin) {
        this.plugin = plugin;
        reload();
    }

    public void reload() {
        config = plugin.getConfig();
    }

    public int configVersion() {
        return config.getInt("config-version");
    }

    public String getLocale() {
        return config.getString("locale", "en");
    }

    public FileConfiguration getConfig() {
        return this.config;
    }

    public int getCompetitionDuration() {
        return config.getInt("competitions.duration");
    }

    public boolean doingRandomDurability() {
        return config.getBoolean("random-durability", true);
    }

    public boolean databaseEnabled() {
        return doingExperimentalFeatures() && config.getBoolean("database", true);
    }

    public boolean isDatabaseOnline() {
        return databaseEnabled() && !EvenMoreFish.databaseV3.usingVersionV2();
    }

    public boolean isCompetitionUnique() {
        return config.getBoolean("fish-only-in-competition", false);
    }

    public boolean getEnabled() {
        return config.getBoolean("enabled", true);
    }

    public boolean worldWhitelist() {
        return !config.getStringList("allowed-worlds").isEmpty();
    }

    public List<String> getAllowedRegions() {
        return config.getStringList("allowed-regions");
    }

    public List<String> getAllowedWorlds() {
        return config.getStringList("allowed-worlds");
    }

    public boolean isEconomyEnabled() {
        return config.getBoolean("enable-economy", true);
    }
    
    public boolean isVanillaFishing() {
        return config.getBoolean("vanilla-fishing", true);
    }

    public String getSellType() {return config.getString("sell-type", "money");}

    public String getFiller() {
        return config.getString("gui.filler", "GRAY_STAINED_GLASS_PANE");
    }

    public String getFillerError() {
        return config.getString("gui.filler-error", "RED_STAINED_GLASS_PANE");
    }

    public String getSellItem() {
        return config.getString("gui.sell-item", "GOLD_INGOT");
    }

    public String getSellItemConfirm() {
        return config.getString("gui.sell-item-confirm", "GOLD_BLOCK");
    }

    public String getSellItemError() {
        return config.getString("gui.sell-item-error", "REDSTONE_BLOCK");
    }

    public Integer getGUISize() {
        int returning = config.getInt("gui.size", 3);
        if (returning <= 0 || returning > 5) return 3;
        else return returning;
    }

    public String getBarStyle() {
        return config.getString("barstyle", "SEGMENTED_10");
    }

    public boolean sellOverDrop() {
        return config.getBoolean("gui.sell-over-drop", false);
    }

    public boolean disableMcMMOTreasure() {
        return config.getBoolean("disable-mcmmo-loot", true);
    }

    public boolean disableAureliumSkills() {
        return config.getBoolean("disable-aureliumskills-loot", true);
    }

    public String rewardEffect() {
        return config.getString("reward-gui.reward-effect");
    }

    public String rewardItem() {
        return config.getString("reward-gui.reward-item");
    }

    public String rewardMoney() {
        return config.getString("reward-gui.reward-money");
    }

    public String rewardHealth() {
        return config.getString("reward-gui.reward-health");
    }

    public String rewardHunger() {
        return config.getString("reward-gui.reward-hunger");
    }

    public String rewardCommand(String command) {
        return config.getString("reward-gui.command-override." + command);
    }

    public Material getSellAllMaterial() {
        String s = config.getString("gui.sell-all-item", "COD_BUCKET");
        try {
            return Material.valueOf(s);
        } catch (IllegalArgumentException exception) {
            EvenMoreFish.logger.log(Level.SEVERE, s + " is not a valid material type in config.yml gui.sell-all-item.");
        }
        return Material.COD_BUCKET;
    }

    public Material getSellAllConfirmMaterial() {
        String s = config.getString("gui.sell-all-item-confirm", "TROPICAL_FISH_BUCKET");
        try {
            return Material.valueOf(s);
        } catch (IllegalArgumentException exception) {
            EvenMoreFish.logger.log(Level.SEVERE, s + " is not a valid material type in config.yml gui.sell-all-item-confirm.");
        }
        return Material.TROPICAL_FISH_BUCKET;
    }

    public Material getSellAllErrorMaterial() {
        String s = config.getString("gui.sell-all-item-error", "SALMON_BUCKET");
        try {
            return Material.valueOf(s);
        } catch (IllegalArgumentException exception) {
            EvenMoreFish.logger.log(Level.SEVERE, s + " is not a valid material type in config.yml gui.sell-all-item-confirm.");
        }
        return Material.SALMON_BUCKET;
    }

    public int getSellAllSlot() {
        int returning = config.getInt("gui.sell-all-slot", 6);
        if (returning > 9 || returning < 1) return 6;
        else return returning;
    }

    public int getSellSlot() {
        int returning = config.getInt("gui.sell-slot", 4);
        if (returning > 9 || returning < 1) return 4;
        else return returning;
    }

    public boolean isMysql() {
        return config.getBoolean("mysql.use-mysql", false);
    }

    public boolean doDBVerbose() {
        return !config.getBoolean("disable-db-verbose", false);
    }

    public String getAddress() {
        return config.getString("mysql.address", "localhost");
    }

    public String getDatabase() {
        return config.getString("mysql.database", "evenmorefish");
    }

    public String getUsername() {
        return config.getString("mysql.username", "root");
    }

    public String getPassword() {
        return config.getString("mysql.password", "");
    }

    public boolean blockPlacingHeads() {
        return config.getBoolean("place-head-fish", false);
    }

    public boolean requireNBTRod() {
        return config.getBoolean("require-nbt-rod", false);
    }

    public boolean requireFishingPermission() {
        return config.getBoolean("requires-fishing-permission", false);
    }

    public boolean blockCrafting() {
        return config.getBoolean("block-crafting", false);
    }
    public boolean debugSession() {
        return config.getBoolean("debug-session", false);
    }

    public boolean doingExperimentalFeatures() {
        return config.getBoolean("experimental-features", false);
    }

    public boolean useAdditionalAddons() {
        return config.getBoolean("addons.additional-addons", true);
    }
}
