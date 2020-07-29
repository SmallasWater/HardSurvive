package com.hardsurvive;

import cn.nukkit.plugin.PluginBase;
import com.hardsurvive.functions.BaseFunction;
import com.hardsurvive.functions.defaults.ThirstFunction;

import java.util.LinkedList;
import java.util.List;

/**
 * @author SmallasWater
 */
public class HardSurvive extends PluginBase {

    private static final List<BaseFunction> FUNCTIONS = new LinkedList<>();

    @Override
    public void onEnable() {
        this.getLogger().info("正在启动插件, 开始加载模块");
        this.initFunction();
        for(BaseFunction function : FUNCTIONS) {
            function.onStart();
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

    @Override
    public void onDisable() {
        for(BaseFunction function: FUNCTIONS) {
            function.onDisable();
        }
    }
}
