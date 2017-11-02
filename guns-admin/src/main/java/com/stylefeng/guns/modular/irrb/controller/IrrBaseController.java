package com.stylefeng.guns.modular.irrb.controller;


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
        import com.stylefeng.guns.common.constant.dictmap.IrrBaseDict;
        import com.stylefeng.guns.common.exception.BizExceptionEnum;
        import com.stylefeng.guns.common.exception.BussinessException;
        import com.stylefeng.guns.common.persistence.dao.IrrBaseMapper;
        import com.stylefeng.guns.common.persistence.model.Irrb.IrrBase;
        import com.stylefeng.guns.core.base.controller.BaseController;
        import com.stylefeng.guns.core.log.LogObjectHolder;
        import com.stylefeng.guns.modular.irrb.dao.IrrBaseDao;
        import com.stylefeng.guns.modular.irrb.warpper.IrrBaseWarpper;


/**
 * 灌区基本信息控制器
 *
 * @author hnsl
 * @email sunlightcs@gmail.com
 * @date 2017-10-20 10:21:45
 */

@Controller
@RequestMapping("/irrbase")
public class IrrBaseController extends BaseController {

    private String PREFIX = "/irrb/irrbase/";

    @Resource
    private IrrBaseMapper irrBaseMapper;

    @Resource
    private IrrBaseDao irrBaseDao;

    /**
     * 跳转到灌区基本信息首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "irrbase.html";
    }

    /**
     * 跳转到添加灌区基本信息
     */
    @RequestMapping("/irrbase_add")
    public String irrBaseAdd() {
        return PREFIX + "irrbase_add.html";
    }

    /**
     * 跳转到修改灌区基本信息
     */
    @RequestMapping("/irrbase_update/{irrId}")
    public String irrBaseUpdate(@PathVariable("irrId" ) Integer irrId, Model model) {

        IrrBase irrBase = this.irrBaseMapper.selectById(irrId);
        model.addAttribute("irrBase",irrBase);
        LogObjectHolder.me().set(irrBase);

        return PREFIX + "irrbase_edit.html";
    }

    /**
     * 获取灌区基本信息列表
     */
    @ApiOperation(value = "灌区基本信息列表",notes = "灌区基本信息列表API接口")
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    @ResponseBody
    public Object list(@RequestParam(value = "condition",required = false) String condition,@RequestParam(value = "irrType",required = false) String irrType) {
        List<Map<String, Object>> list = this.irrBaseDao.list(condition,irrType);
        return super.warpObject(new IrrBaseWarpper(list));
    }

    /**
     * 新增灌区基本信息
     */
    @ApiOperation(value = "新增灌区基本信息",notes = "新增灌区基本信息API接口")
    @BussinessLog(value = "添加灌区基本信息", key = "irrId", dict = IrrBaseDict.class)
    @PostMapping(value = "/add")
    @ResponseBody
    public Object add(@Valid IrrBase irrBase, BindingResult result) {

        if (result.hasErrors()) {
            throw new BussinessException(BizExceptionEnum.REQUEST_NULL);
        }
        //创建时间
        irrBase.setCreated(new Date());
        //更新时间
        irrBase.setModified(new Date());

        irrBaseMapper.insert(irrBase);

        return super.SUCCESS_TIP;
    }

    /**
     * 删除灌区基本信息
     */
    @BussinessLog(value = "删除灌区基本信息", key = "irrId", dict = IrrBaseDict.class)
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete(@RequestParam Integer irrId) {
        irrBaseMapper.deleteById(irrId);
        return SUCCESS_TIP;
    }


    /**
     * 修改灌区基本信息
     */
    @BussinessLog(value = "修改灌区基本信息", key = "irrId", dict = IrrBaseDict.class)
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update(@Valid IrrBase irrBase, BindingResult result) {
        if (result.hasErrors()) {
            throw new BussinessException(BizExceptionEnum.REQUEST_NULL);
        }

        irrBase.setModified(new Date());

        this.irrBaseMapper.updateById(irrBase);
        return super.SUCCESS_TIP;
    }

    /**
     * 灌区基本信息详情
     */
    @RequestMapping(value = "/detail")
    @ResponseBody
    public Object detail() {
        return null;
    }
}

