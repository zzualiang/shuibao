package com.stylefeng.guns.modular.irrb.dao;

        import com.stylefeng.guns.core.node.ZTreeNode;
        import org.apache.ibatis.annotations.Param;

        import java.util.List;
        import java.util.Map;

/**
 * 渠道基本信息Dao
 * 
 * @author hnsl
 * @email sunlightcs@gmail.com
 * @date 2017-10-22 10:08:16
 */

public interface CanalBaseDao {
    /**
     * 获取ztree的节点列表
     *
     * @return
     * @date 2017年2月17日 下午8:28:43
     */
    List<ZTreeNode> tree();

    List<Map<String, Object>> list(@Param("condition") String condition,@Param("canalType") String canalType,@Param("irrId") String irrId);
}
