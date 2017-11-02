package com.stylefeng.guns.modular.irrb.warpper;

        import com.stylefeng.guns.common.constant.factory.ConstantFactory;
        import com.stylefeng.guns.core.base.warpper.BaseControllerWarpper;

        import java.util.Map;

/**
 * 水源信息的包装
 *
 * @author hnsl
 * @email sunlightcs@gmail.com
 * @date 2017-10-20 11:22:38
 */

public class SourceBaseWarpper extends BaseControllerWarpper {

    public SourceBaseWarpper(Object list) {
        super(list);
    }

    @Override
    protected void warpTheMap(Map<String, Object> map) {
        //水源类型名称
        map.put("sourceTypeSName", ConstantFactory.me().getSourceTypeSName(Integer.parseInt((String) map.get("sourceTypeS"))));

        //水源工程类型名称
        map.put("sourceTypeBName", ConstantFactory.me().getSourceTypeBName(Integer.parseInt((String) map.get("sourceTypeB"))));

    }
}
