package com.hardsurvive.data;

import cn.nukkit.Player;
import cn.nukkit.utils.Config;
import com.hardsurvive.HardSurvive;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lt_name
 */
public class PlayerConfigManager {

    private final HardSurvive hardSurvive;

    private static final Map<Player, Config> PLAYER_CONFIG_CACHE = new HashMap<>();

    public PlayerConfigManager(HardSurvive hardSurvive) {
        this.hardSurvive = hardSurvive;
    }

    /**
     * 获取玩家数据
     *
     * @param player 玩家
     * @return {@link Config}
     */
    public Config getPlayerConfig(Player player) {
        Config config;
        if (!PLAYER_CONFIG_CACHE.containsKey(player)) {
            String name = player.getName();
            config = new Config(this.hardSurvive.getDataFolder() +
                    "/players/" + name.subSequence(0, 1) + "/" + name + ".yml", Config.YAML);
            PLAYER_CONFIG_CACHE.put(player, config);
        }else {
            config = PLAYER_CONFIG_CACHE.get(player);
        }
        return config;
    }

    /**
     * 清理配置缓存
     *
     * @param player 玩家
     */
    public void removeCache(Player player) {
        PLAYER_CONFIG_CACHE.remove(player);
    }

}
