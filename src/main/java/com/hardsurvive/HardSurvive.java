package com.hardsurvive;

import cn.nukkit.plugin.PluginBase;
import com.hardsurvive.data.PlayerConfigManager;
import com.hardsurvive.functions.BaseFunction;
import com.hardsurvive.functions.defaults.ThirstFunction;

import java.util.LinkedList;
import java.util.List;

/**
 * @author SmallasWater
 */
public class HardSurvive extends PluginBase {

    private static HardSurvive hardSurvive;

    private PlayerConfigManager playerConfigManager;

    private static final List<BaseFunction> FUNCTIONS = new LinkedList<>();

    public static HardSurvive getInstance() {
        return hardSurvive;
    }

    @Override
    public void onEnable() {
        hardSurvive = this;
        this.getLogger().info("正在启动插件, 开始加载模块");
        this.playerConfigManager = new PlayerConfigManager(this);
        this.initFunction();
        for(BaseFunction function : FUNCTIONS) {
            function.setEnabled(true);
            this.getServer().getPluginManager().registerEvents(function,this);
            this.getLogger().info("成功启动"+function.getName()+"模块");
        }
    }

    private void initFunction() {
        registerFunction(new ThirstFunction(this));
    }

    private static void registerFunction(BaseFunction function) {
        FUNCTIONS.add(function);
    }

    public PlayerConfigManager getPlayerConfigManager() {
        return this.playerConfigManager;
    }

    @Override
    public void onDisable() {
        for(BaseFunction function : FUNCTIONS) {
            function.setEnabled(false);
        }
    }

}
