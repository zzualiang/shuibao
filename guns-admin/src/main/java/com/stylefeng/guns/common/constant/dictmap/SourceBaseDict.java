package com.stylefeng.guns.common.constant.dictmap;

import com.stylefeng.guns.common.constant.dictmap.base.AbstractDictMap;

/**
 * 水源信息的字典
 *
 * @author hnsl
 * @email sunlightcs@gmail.com
 * @date 2017-10-20 11:22:38
 */

public class SourceBaseDict extends AbstractDictMap {

    @Override
    public void init() {

        //水源编码
        put("sourceId", "水源编码");
        //水源编码
        put("sourceCode", "水源编码");
        //水源名称
        put("sourceName", "水源名称");
        //水源工程类型
        put("sourceTypeB", "水源工程类型");
        //水源类型
        put("sourceTypeS", "水源类型");
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
