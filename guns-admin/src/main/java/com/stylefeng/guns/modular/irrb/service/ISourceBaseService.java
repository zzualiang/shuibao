package com.stylefeng.guns.modular.irrb.service;

import java.util.List;
import java.util.Map;

/**
 * 水源信息Service
 *
 * @author hnsl
 * @email sunlightcs@gmail.com
 * @date 2017-10-20 11:22:38
 */
public interface ISourceBaseService {
    //获取水源列表
    List<Map<String, Object>> list(String condition, String sourceTypeS, String sourceTypeB);

}