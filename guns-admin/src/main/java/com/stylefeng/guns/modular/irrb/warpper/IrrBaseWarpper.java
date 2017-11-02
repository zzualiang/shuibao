package com.stylefeng.guns.modular.irrb.warpper;

        import com.stylefeng.guns.common.constant.factory.ConstantFactory;
        import com.stylefeng.guns.core.base.warpper.BaseControllerWarpper;

        import java.util.Map;

/**
 * 灌区基本信息的包装
 *
 * @author hnsl
 * @email sunlightcs@gmail.com
 * @date 2017-10-20 10:21:45
 */

public class IrrBaseWarpper extends BaseControllerWarpper {

    public IrrBaseWarpper(Object list) {
        super(list);
    }

    @Override
    protected void warpTheMap(Map<String, Object> map) {

        Integer sourceId = (Integer) map.get("sourceId");

        //灌区类型
        map.put("irrTypeName", ConstantFactory.me().getIrrTypeName(Integer.parseInt((String) map.get("irrType"))));

        //水源名称
        map.put("sourceName", ConstantFactory.me().getSourceName(sourceId));

    }
}
