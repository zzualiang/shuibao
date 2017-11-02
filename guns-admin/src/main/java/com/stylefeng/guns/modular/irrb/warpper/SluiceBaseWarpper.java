package com.stylefeng.guns.modular.irrb.warpper;

import com.stylefeng.guns.common.constant.Const;
import com.stylefeng.guns.common.constant.factory.ConstantFactory;
import com.stylefeng.guns.core.base.warpper.BaseControllerWarpper;
import com.stylefeng.guns.core.util.Convert;
import com.stylefeng.guns.core.util.ToolUtil;

import java.util.Map;

/**
 * 水闸信息的包装
 *
 * @author hnsl
 * @email sunlightcs@gmail.com
 * @date 2017-10-23 18:25:09
 */

public class SluiceBaseWarpper extends BaseControllerWarpper {

    public SluiceBaseWarpper(Object list) {
        super(list);
    }

    @Override
    protected void warpTheMap(Map<String, Object> map) {

        // 闸类型
        if (ToolUtil.isNotEmpty(map.get("sluiceType"))) {
            map.put("sluiceTypeName", ConstantFactory.me().getSluiceTypeName(Integer.parseInt((String) map.get("sluiceType"))));
        } else {
            map.put("sluiceTypeName", Const.NULL_VALUE);
        }

        // 渠段名称
        if (ToolUtil.isNotEmpty(map.get("canalId"))) {
            map.put("canalName", ConstantFactory.me().getCanalName((Integer) map.get("canalId")));
        } else {
            map.put("canalName", Const.NULL_VALUE);
        }


        // strobeType 闸门类型名称
        if (ToolUtil.isNotEmpty(map.get("strobeType"))) {
            map.put("strobeTypeName", ConstantFactory.me().getStrobeTypeName(Integer.parseInt((String) map.get("strobeType"))));
        } else {
            map.put("strobeTypeName", Const.NULL_VALUE);
        }

        // dissipationSlopeLimit 坡降范围

        String dissipationSlopeUpperLimit, dissipationSlopeLowerLimit;

        if (ToolUtil.isNotEmpty(map.get("dissipationSlopeUpperLimit"))) {
            dissipationSlopeUpperLimit = map.get("dissipationSlopeUpperLimit").toString();

        } else {
            dissipationSlopeUpperLimit = Const.NULL_VALUE;

        }

        if (ToolUtil.isNotEmpty(map.get("dissipationSlopeLowerLimit"))) {
            dissipationSlopeLowerLimit = map.get("dissipationSlopeLowerLimit").toString();

        } else {
            dissipationSlopeLowerLimit = Const.NULL_VALUE;

        }

        map.put("dissipationSlopeLimit", (dissipationSlopeLowerLimit + "-" + dissipationSlopeUpperLimit));


        // constructionTimeUpperLimit 施工时间

        String constructionTimeUpperLimit, constructionTimeLowerLimit;

        if (ToolUtil.isNotEmpty(map.get("constructionTimeUpperLimit"))) {
            constructionTimeUpperLimit = map.get("constructionTimeUpperLimit").toString();

        } else {
            constructionTimeUpperLimit = Const.NULL_VALUE;

        }

        if (ToolUtil.isNotEmpty(map.get("constructionTimeLowerLimit"))) {
            constructionTimeLowerLimit = map.get("constructionTimeLowerLimit").toString();

        } else {
            constructionTimeLowerLimit = Const.NULL_VALUE;

        }

        map.put("constructionTimeLimit", (constructionTimeLowerLimit + "-" + constructionTimeUpperLimit));

        // 桩号转换
        String stakeFormat =  (Convert.toInt(map.get("stake")) / 1000) + "+" + (Convert.toInt(map.get("stake")) % 1000);
        map.put("stakeFormat", stakeFormat);

    }
}
