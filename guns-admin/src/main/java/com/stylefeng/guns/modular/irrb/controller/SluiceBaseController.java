package com.stylefeng.guns.modular.irrb.controller;


        import com.stylefeng.guns.common.constant.factory.ConstantFactory;
        import com.stylefeng.guns.common.persistence.model.Irrb.SluiceBase;
        import io.swagger.annotations.Api;
        import io.swagger.annotations.ApiImplicitParam;
        import io.swagger.annotations.ApiOperation;
        import io.swagger.annotations.ApiParam;
        import org.springframework.stereotype.Controller;
        import org.springframework.validation.BindingResult;
        import org.springframework.web.bind.annotation.*;
        import org.springframework.ui.Model;

        import javax.annotation.Resource;
        import javax.validation.Valid;
        import java.util.List;
        import java.util.Map;

        import com.stylefeng.guns.common.annotion.BussinessLog;
        import com.stylefeng.guns.common.annotion.Permission;
        import com.stylefeng.guns.common.constant.Const;
        import com.stylefeng.guns.common.constant.dictmap.SluiceBaseDict;
        import com.stylefeng.guns.common.exception.BizExceptionEnum;
        import com.stylefeng.guns.common.exception.BussinessException;
        import com.stylefeng.guns.common.persistence.dao.SluiceBaseMapper;
        import com.stylefeng.guns.common.persistence.model.Irrb.SourceBase;
        import com.stylefeng.guns.core.base.controller.BaseController;
        import com.stylefeng.guns.core.log.LogObjectHolder;
        import com.stylefeng.guns.modular.irrb.dao.SluiceBaseDao;
        import com.stylefeng.guns.modular.irrb.warpper.SluiceBaseWarpper;


/**
 * 水闸信息控制器
 *
 * @author hnsl
 * @email sunlightcs@gmail.com
 * @date 2017-10-23 18:25:09
 */

@Controller
@RequestMapping("/sluicebase")
public class SluiceBaseController extends BaseController {

    private String PREFIX = "/irrb/sluicebase/";

    @Resource
    private SluiceBaseMapper sluiceBaseMapper;

    @Resource
    private SluiceBaseDao sluiceBaseDao;

    /**
     * 跳转到水闸信息首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "sluicebase.html";
    }

    /**
     * 跳转到添加水闸信息
     */
    @RequestMapping("/sluicebase_add")
    public String sluiceBaseAdd() {
        return PREFIX + "sluicebase_add.html";
    }

    /**
     * 跳转到修改水闸信息
     */
    @RequestMapping("/sluicebase_update/{sluiceId}")
    public String sluiceBaseUpdate(@PathVariable("sluiceId" ) Integer sluiceId, Model model) {

        SluiceBase sluiceBase = this.sluiceBaseMapper.selectById(sluiceId);
        model.addAttribute("sluiceBase",sluiceBase);
        model.addAttribute("canalName", ConstantFactory.me().getCanalName(sluiceBase.getCanalId()));
        LogObjectHolder.me().set(sluiceBase);

        return PREFIX + "sluicebase_edit.html";
    }

    /**
     * 获取水闸信息列表
     */
    @ApiOperation(value = "水闸信息列表",notes = "水闸信息列表API接口")
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    @ResponseBody
    public Object list(@RequestParam(value = "condition",required = false) String condition) {
        List<Map<String, Object>> list = this.sluiceBaseDao.list(condition);
        return super.warpObject(new SluiceBaseWarpper(list));
    }

    /**
     * 新增水闸信息
     */
    @ApiOperation(value = "新增水闸信息",notes = "新增水闸信息API接口")
    @BussinessLog(value = "添加水闸信息", key = "sluiceId", dict = SluiceBaseDict.class)
    @PostMapping(value = "/add")
    @ResponseBody
    public Object add(@Valid SluiceBase sluiceBase, BindingResult result) {

        if (result.hasErrors()) {
            throw new BussinessException(BizExceptionEnum.REQUEST_NULL);
        }

        sluiceBaseMapper.insert(sluiceBase);
        return super.SUCCESS_TIP;
    }

    /**
     * 删除水闸信息
     */
    @BussinessLog(value = "删除水闸信息", key = "sluiceId", dict = SluiceBaseDict.class)
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete(@RequestParam Integer sluiceId) {
        sluiceBaseMapper.deleteById(sluiceId);
        return SUCCESS_TIP;
    }


    /**
     * 修改水闸信息
     */
    @BussinessLog(value = "修改水闸信息", key = "sluiceId", dict = SluiceBaseDict.class)
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update(@Valid SluiceBase sluiceBase, BindingResult result) {
        if (result.hasErrors()) {
            throw new BussinessException(BizExceptionEnum.REQUEST_NULL);
        }

        this.sluiceBaseMapper.updateById(sluiceBase);
        return super.SUCCESS_TIP;
    }

    /**
     * 水闸信息详情
     */
    @RequestMapping(value = "/detail")
    @ResponseBody
    public Object detail() {
        return null;
    }
}

