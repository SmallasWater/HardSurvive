package com.hardsurvive.functions;

import cn.nukkit.event.Listener;
import cn.nukkit.utils.Config;
import com.hardsurvive.HardSurvive;

import java.io.File;

/**
 * @author SmallasWater
 */
public abstract class BaseFunction implements Listener {

    private Config config;

    private final HardSurvive plugin;

    protected BaseFunction(HardSurvive plugin){
        this.plugin = plugin;
    }

    /**
     * 功能名称
     *
     * @return 功能的名称
     * */
    public abstract String getName();

    /**
     * 功能入口
     * */
    public abstract void onStart();

    /**
     * 功能关闭
     * */
    public abstract void onDisable();

    /**
     * 获取配置文件路径
     * @return 路径
     * */
    public String getFunctionDataFolder(){
        return plugin.getDataFolder()+"/"+getName();
    }

    /**
     * 获取配置
     * @return {@link Config}
     * */
    public Config getConfig(){
        if(!new File(getFunctionDataFolder()+"/"+getName()+".yml").exists()){
            plugin.saveResource(getName()+".yml","/"+getName()+"/"+getName()+".yml",false);
        }
        if(config == null) {
            config = new Config(getFunctionDataFolder() + "/" + getName() + ".yml");
        }
        return config;
    }




}
