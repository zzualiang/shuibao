package com.stylefeng.guns.modular.irrb.dao;

        import org.apache.ibatis.annotations.Param;

        import java.util.List;
        import java.util.Map;

/**
 * 水闸信息Dao
 * 
 * @author hnsl
 * @email sunlightcs@gmail.com
 * @date 2017-10-23 18:25:09
 */

public interface SluiceBaseDao {
    List<Map<String, Object>> list(@Param("condition") String condition);
}
