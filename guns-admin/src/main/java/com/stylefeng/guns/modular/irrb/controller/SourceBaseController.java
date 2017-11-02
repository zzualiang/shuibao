package com.stylefeng.guns.modular.irrb.controller;


import com.stylefeng.guns.modular.irrb.service.ISourceBaseService;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.stylefeng.guns.common.annotion.BussinessLog;
import com.stylefeng.guns.common.constant.dictmap.SourceBaseDict;
import com.stylefeng.guns.common.exception.BizExceptionEnum;
import com.stylefeng.guns.common.exception.BussinessException;
import com.stylefeng.guns.common.persistence.dao.SourceBaseMapper;
import com.stylefeng.guns.common.persistence.model.Irrb.SourceBase;
import com.stylefeng.guns.core.base.controller.BaseController;
import com.stylefeng.guns.core.log.LogObjectHolder;
import com.stylefeng.guns.modular.irrb.dao.SourceBaseDao;
import com.stylefeng.guns.modular.irrb.warpper.SourceBaseWarpper;


/**
 * 水源信息控制器
 *
 * @author hnsl
 * @email sunlightcs@gmail.com
 * @date 2017-10-20 11:22:38
 */

@Controller
@RequestMapping("/sourcebase")
public class SourceBaseController extends BaseController {

    private String PREFIX = "/irrb/sourcebase/";

    @Resource
    private SourceBaseMapper sourceBaseMapper;

    @Resource
    private SourceBaseDao sourceBaseDao;

    @Resource
    private ISourceBaseService iSourceBaseService;

    /**
     * 跳转到水源信息首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "sourcebase.html";
    }

    /**
     * 跳转到添加水源信息
     */
    @RequestMapping("/sourcebase_add")
    public String sourceBaseAdd() {
        return PREFIX + "sourcebase_add.html";
    }

    /**
     * 跳转到修改水源信息
     */
    @RequestMapping("/sourcebase_update/{sourceId}")
    public String sourceBaseUpdate(@PathVariable("sourceId") Integer sourceId, Model model) {

        SourceBase sourceBase = this.sourceBaseMapper.selectById(sourceId);
        model.addAttribute("sourceBase", sourceBase);
        LogObjectHolder.me().set(sourceBase);

        return PREFIX + "sourcebase_edit.html";
    }

    /**
     * 获取水源信息列表
     */
    @ApiOperation(value = "水源信息列表", notes = "水源信息列表API接口")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public Object list(@RequestParam(value = "condition", required = false) String condition,
                       @RequestParam(value = "sourceTypeB", required = false) String sourceTypeB,
                       @RequestParam(value = "sourceTypeS", required = false) String sourceTypeS) {
        List<Map<String, Object>> list = this.iSourceBaseService.list(condition, sourceTypeS, sourceTypeB);

        return super.warpObject(new SourceBaseWarpper(list));
    }


    /**
     * 新增水源信息
     */
    @ApiOperation(value = "新增水源信息", notes = "新增水源信息API接口")
    @BussinessLog(value = "添加水源信息", key = "sourceId", dict = SourceBaseDict.class)
    @PostMapping(value = "/add")
    @ResponseBody
    public Object add(@Valid SourceBase sourceBase, BindingResult result) {

        if (result.hasErrors()) {
            throw new BussinessException(BizExceptionEnum.REQUEST_NULL);
        }
        //创建时间
        sourceBase.setCreated(new Date());
        //更新时间
        sourceBase.setModified(new Date());
        sourceBaseMapper.insert(sourceBase);
        return super.SUCCESS_TIP;
    }

    /**
     * 删除水源信息
     */
    @BussinessLog(value = "删除水源信息", key = "sourceId", dict = SourceBaseDict.class)
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete(@RequestParam Integer sourceId) {
        sourceBaseMapper.deleteById(sourceId);
        return SUCCESS_TIP;
    }


    /**
     * 修改水源信息
     */
    @BussinessLog(value = "修改水源信息", key = "sourceId", dict = SourceBaseDict.class)
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update(@Valid SourceBase sourceBase, BindingResult result) {
        if (result.hasErrors()) {
            throw new BussinessException(BizExceptionEnum.REQUEST_NULL);
        }
        //更新时间
        sourceBase.setModified(new Date());

        this.sourceBaseMapper.updateById(sourceBase);
        return super.SUCCESS_TIP;
    }

    /**
     * 水源信息详情
     */
    @RequestMapping(value = "/detail")
    @ResponseBody
    public Object detail() {
        return null;
    }
}

