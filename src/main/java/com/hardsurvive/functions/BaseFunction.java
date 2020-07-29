package com.hardsurvive.functions;

import cn.nukkit.event.Listener;
import com.hardsurvive.HardSurvive;

/**
 * @author SmallasWater
 */
public abstract class BaseFunction implements Listener {


    private final HardSurvive plugin;

    protected BaseFunction(HardSurvive plugin){
        this.plugin = plugin;
    }
    /**
     * 功能名称
     *
     * @return 功能的名称
     * */
    abstract public String getName();

    /**
     * 功能入口
     * */
    abstract public void onStart();

    /**
     * 功能关闭
     * */
    abstract public void onDisable();

    /**
     * 获取配置文件路径
     * */
    public String getFunctionDataFolder(){
        return plugin.getDataFolder()+"/"+getName();
    }




}
