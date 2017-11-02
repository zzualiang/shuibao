package com.stylefeng.guns.common.constant.dictmap;

import com.stylefeng.guns.common.constant.dictmap.base.AbstractDictMap;

/**
 * 灌区基本信息的字典
 *
 * @author hnsl
 * @email sunlightcs@gmail.com
 * @date 2017-10-20 10:21:45
 */

public class IrrBaseDict extends AbstractDictMap {

    @Override
    public void init() {

        //编号
        put("irrId", "编号");
        //灌区编码
        put("irrCode", "灌区编码");
        //水源编码
        put("sourceId", "水源编码");
        //灌区名称
        put("irrName", "灌区名称");
        //灌区类型
        put("irrType", "灌区类型");
        //上级管理单位
        put("upperManageunit", "上级管理单位");
        //设计灌溉面积
        put("designIrrigateArea", "设计灌溉面积");
        //渠首取水位置
        put("cheadSite", "渠首取水位置");
        //渠首设计流量
        put("cheadFlux", "渠首设计流量");
        //总干渠长度
        put("trunkLegth", "总干渠长度");
        //灌溉范围
        put("irrigationArea", "灌溉范围");
        //创建时间
        put("created", "创建时间");
        //更新时间
        put("modified", "更新时间");
        put("", "");
    }

    @Override
    protected void initBeWrapped() {

    }
}
