package com.stylefeng.guns.modular.irrb.dao;

        import org.apache.ibatis.annotations.Param;

        import java.util.List;
        import java.util.Map;

/**
 * 水源信息Dao
 * 
 * @author hnsl
 * @email sunlightcs@gmail.com
 * @date 2017-10-20 11:22:38
 */

public interface SourceBaseDao {
    List<Map<String, Object>> list(@Param("condition") String condition, @Param("sourceTypeS") String sourceTypeS, @Param("sourceTypeB") String sourceTypeB);
}
