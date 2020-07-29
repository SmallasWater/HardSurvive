package com.hardsurvive.functions.defaults;


import cn.nukkit.Player;
import com.hardsurvive.HardSurvive;
import com.hardsurvive.functions.BaseFunction;

import java.util.HashMap;
import java.util.Map;

/**
 * @author SmallasWater
 */
public class ThirstFunction extends BaseFunction {

    private final Map<Player, Float> thirstValue = new HashMap<>();

    public ThirstFunction(HardSurvive plugin) {
        super(plugin);
    }

    @Override
    public String getName() {
        return "thirst";
    }

    @Override
    public void onStart() {

    }

    @Override
    public void onDisable() {

    }

    public Map<Player, Float> getThirstValue() {
        return this.thirstValue;
    }

    public float getThirstValue(Player player) {
        return this.thirstValue.getOrDefault(player, 20F);
    }

}
