package com.stylefeng.guns.common.constant.factory;

import com.stylefeng.guns.common.constant.cache.Cache;
import com.stylefeng.guns.common.constant.cache.CacheKey;
import com.stylefeng.guns.common.persistence.model.Dict;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;

/**
 * 常量生产工厂的接口
 *
 * @author fengshuonan
 * @date 2017-06-14 21:12
 */
public interface IConstantFactory {

    /**
     * 根据用户id获取用户名称
     *
     * @author stylefeng
     * @Date 2017/5/9 23:41
     */
    String getUserNameById(Integer userId);

    /**
     * 根据用户id获取用户账号
     *
     * @author stylefeng
     * @date 2017年5月16日21:55:371
     */
    String getUserAccountById(Integer userId);

    /**
     * 通过角色ids获取角色名称
     */
    @Cacheable(value = Cache.CONSTANT, key = "'" + CacheKey.ROLES_NAME + "'+#roleIds")
    String getRoleName(String roleIds);

    /**
     * 通过角色id获取角色名称
     */
    @Cacheable(value = Cache.CONSTANT, key = "'" + CacheKey.SINGLE_ROLE_NAME + "'+#roleId")
    String getSingleRoleName(Integer roleId);

    /**
     * 通过角色id获取角色英文名称
     */
    @Cacheable(value = Cache.CONSTANT, key = "'" + CacheKey.SINGLE_ROLE_TIP + "'+#roleId")
    String getSingleRoleTip(Integer roleId);

    /**
     * 获取部门名称
     */
    @Cacheable(value = Cache.CONSTANT, key = "'" + CacheKey.DEPT_NAME + "'+#deptId")
    String getDeptName(Integer deptId);

    /**
     * 获取水源名称
     */
    @Cacheable(value = Cache.CONSTANT, key = "'" + CacheKey.SOURCE_NAME + "'+#sourceId")
    String getSourceName(Integer sourceId);

    /**
     * 获取灌区名称
     */
    @Cacheable(value = Cache.CONSTANT, key = "'" + CacheKey.IRR_NAME + "'+#irrId")
    String getIrrName(Integer irrId);

    /**
     * 获取渠道名称
     */
    @Cacheable(value = Cache.CONSTANT, key = "'" + CacheKey.CANAL_NAME + "'+#canalId")
    String getCanalName(Integer canalId);

    /**
     * 获取菜单的名称们(多个)
     */
    String getMenuNames(String menuIds);

    /**
     * 获取菜单名称
     */
    String getMenuName(Integer menuId);

    /**
     * 获取菜单名称通过编号
     */
    String getMenuNameByCode(String code);

    /**
     * 获取字典名称
     */
    String getDictName(Integer dictId);

    /**
     * 获取通知标题
     */
    String getNoticeTitle(Integer dictId);

    /**
     * 根据字典名称和字典中的值获取对应的名称
     */
    String getDictsByName(String name, Integer val);

    /**
     * 获取性别名称
     */
    String getSexName(Integer sex);

    /**
     * 获取用户登录状态
     */
    String getStatusName(Integer status);

    /**
     * 获取菜单状态
     */
    String getMenuStatusName(Integer status);

    /**
     * 查询字典
     */
    List<Dict> findInDict(Integer id);

    /**
     * 获取被缓存的对象(用户删除业务)
     */
    String getCacheObject(String para);

    /**
     * 获取子部门id
     */
    List<Integer> getSubDeptId(Integer deptid);

    /**
     * 获取所有父部门id
     */
    List<Integer> getParentDeptIds(Integer deptid);


    /**
     * 获取灌区类型名称
     */
    String getIrrTypeName(Integer irrType);

    /**
     * 获取水源类型名称
     */
    String getSourceTypeSName(Integer sourceTypeS);

    /**
     * 获取水源工程类型名称
     */
    String getSourceTypeBName(Integer sourceTypeB);

    /**
     * 获取渠道类型名称
     *
     */
    String getCanalTypeName(Integer canalType);

    /**
     * 获取水闸类型名称
     */
    String getSluiceTypeName(Integer sluiceType);

    /**
     * 获取闸类型名称
     */
    String getStrobeTypeName(Integer strobeType);

}
