package com.stylefeng.guns.modular.irrb.warpper;

        import com.stylefeng.guns.common.constant.factory.ConstantFactory;
        import com.stylefeng.guns.core.base.warpper.BaseControllerWarpper;

        import java.util.Map;

/**
 * 渠道基本信息的包装
 *
 * @author hnsl
 * @email sunlightcs@gmail.com
 * @date 2017-10-22 10:08:16
 */

public class CanalBaseWarpper extends BaseControllerWarpper {

    public CanalBaseWarpper(Object list) {
        super(list);
    }

    @Override
    protected void warpTheMap(Map<String, Object> map) {
        Integer irrId = (Integer) map.get("irrId");

        Integer upperCanalId = (Integer) map.get("upperCanalId");

        //灌区类型
        map.put("canalTypeName", ConstantFactory.me().getCanalTypeName(Integer.parseInt((String) map.get("canalType"))));

        //上级渠道名称
        map.put("upperCanalName",ConstantFactory.me().getCanalName(upperCanalId));

        //灌区名称
        map.put("irrName",ConstantFactory.me().getIrrName(irrId));

    }
}
