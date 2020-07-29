package com.hardsurvive.functions;

import cn.nukkit.event.Listener;
import com.hardsurvive.HardSurvive;

/**
 * @author SmallasWater
 */
public interface BaseFunction extends Listener {


    /**
     * 功能名称
     *
     * @return 功能的名称
     * */
    String getName();

    /**
     * 功能入口
     * @param plugin 类
     * */
    void onStart(HardSurvive plugin);

    /**
     * 功能关闭
     * @param plugin 类
     * */
    void onDisable(HardSurvive plugin);




}
