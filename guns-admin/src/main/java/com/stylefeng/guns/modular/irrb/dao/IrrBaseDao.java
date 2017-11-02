package com.stylefeng.guns.modular.irrb.dao;

        import org.apache.ibatis.annotations.Param;

        import java.util.List;
        import java.util.Map;

/**
 * 灌区基本信息Dao
 * 
 * @author hnsl
 * @email sunlightcs@gmail.com
 * @date 2017-10-20 10:21:45
 */

public interface IrrBaseDao {
    List<Map<String, Object>> list(@Param("condition") String condition, @Param("irrType") String irrType);
}
