package com.stylefeng.guns.common.constant.dictmap;

import com.stylefeng.guns.common.constant.dictmap.base.AbstractDictMap;

/**
 * 水闸信息的字典
 *
 * @author hnsl
 * @email sunlightcs@gmail.com
 * @date 2017-10-23 18:25:09
 */

public class SluiceBaseDict extends AbstractDictMap {

    @Override
    public void init() {

        //编号
        put("sluiceId", "编号");
        //水闸编码
        put("sluiceCode", "水闸编码");
        //工程简称
        put("sluiceName", "工程简称");
        //工程全称
        put("sluiceFullName", "工程全称");
        //工程别名
        put("sluiceAliasName", "工程别名");
        //水闸类别
        put("sluiceType", "水闸类别");
        //所属渠段
        put("canalId", "所属渠段");
        //流量(m^3/s)
        put("sluiceFlow", "流量(m^3/s)");
        //闸门孔数
        put("strobeNumber", "闸门孔数");
        //闸门型式
        put("strobeType", "闸门型式");
        //闸门高度
        put("strobeHeight", "闸门高度");
        //闸门宽度
        put("strobeWidth", "闸门宽度");
        //闸门厚度
        put("strobeThickness", "闸门厚度");
        //启闭机样式
        put("motivityType", "启闭机样式");
        //启闭机动力
        put("motivityPower", "启闭机动力");
        //启闭速度
        put("motivityVelocity", "启闭速度");
        //消能工型式
        put("dissipationType", "消能工型式");
        //退水渠长(m)
        put("dissipationLength", "退水渠长(m)");
        //坡降(上限)
        put("dissipationSlopeUpperLimit", "坡降(上限)");
        //坡降(下限)
        put("dissipationSlopeLowerLimit", "坡降(下限)");
        //施工时间(天)上限
        put("constructionTimeUpperLimit", "施工时间(天)上限");
        //施工时间(天)下限
        put("constructionTimeLowerLimit", "施工时间(天)下限");
        //桩号
        put("stake", "桩号");
        put("", "");
    }

    @Override
    protected void initBeWrapped() {

    }
}
