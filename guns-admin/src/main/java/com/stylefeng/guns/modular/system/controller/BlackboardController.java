package com.stylefeng.guns.modular.system.controller;

import com.stylefeng.guns.core.base.controller.BaseController;
import com.stylefeng.guns.modular.system.dao.NoticeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

/**
 * 总览信息
 *
 * @author fengshuonan
 * @Date 2017年3月4日23:05:54
 */
@Controller

public class BlackboardController extends BaseController {

    @Autowired
    NoticeDao noticeDao;

    /**
     * 跳转到黑板
     */
    @RequestMapping("/blackboard")
    public String blackboard(Model model) {
        List<Map<String, Object>> notices = noticeDao.list(null);
        model.addAttribute("noticeList",notices);
        return "/blackboard.html";
    }

    /**
     * 跳转到地图展示
     */
    @RequestMapping("/map")
    public String map() {

        return "/map.html";
    }
}
