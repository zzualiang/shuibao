package com.stylefeng.guns.common.constant.dictmap;

import com.stylefeng.guns.common.constant.dictmap.base.AbstractDictMap;

/**
 * 渠道基本信息的字典
 *
 * @author hnsl
 * @email sunlightcs@gmail.com
 * @date 2017-10-22 10:08:16
 */

public class CanalBaseDict extends AbstractDictMap {

    @Override
    public void init() {

		            //编号
            put("canalId","编号");
		            //渠道编码
            put("canalCode","渠道编码");
		            //灌区编码
            put("irrId","灌区编码");
		            //渠道名称
            put("canalName","渠道名称");
		            //渠道类型
            put("canalType","渠道类型");
		            //渠道长度（公里）
            put("canalLength","渠道长度（公里）");
		            //控制面积（万亩）
            put("canalControlArea","控制面积（万亩）");
		            //规划供水面积（万亩）
            put("canalPlanArea","规划供水面积（万亩）");
		            //上级渠道标识符
            put("upperCanalId","上级渠道标识符");
		            //上级渠道桩号
            put("upperCanalStake","上级渠道桩号");
		            //创建时间
            put("created","创建时间");
		            //更新时间
            put("modified","更新时间");
		        put("","");
    }

    @Override
    protected void initBeWrapped() {

    }
}
