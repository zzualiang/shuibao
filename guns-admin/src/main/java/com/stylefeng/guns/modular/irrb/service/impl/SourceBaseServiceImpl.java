package com.stylefeng.guns.modular.irrb.service.impl;

import com.stylefeng.guns.modular.irrb.dao.SourceBaseDao;
import org.springframework.stereotype.Service;
import com.stylefeng.guns.modular.irrb.service.ISourceBaseService;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * 水源信息Service
 *
 * @author hnsl
 * @email sunlightcs@gmail.com
 * @date 2017-10-20 11:22:38
 */
@Service
public class SourceBaseServiceImpl implements ISourceBaseService {
    @Resource
    private SourceBaseDao sourceBaseDao;


    @Override
    public List<Map<String, Object>> list(String condition,String sourceTypeS,String sourceTypeB) {
        List<Map<String, Object>> list = this.sourceBaseDao.list(condition, sourceTypeS, sourceTypeB);
        return list;
    }
}
