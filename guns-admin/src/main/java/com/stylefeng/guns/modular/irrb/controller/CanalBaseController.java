package com.stylefeng.guns.modular.irrb.controller;


        import com.stylefeng.guns.common.constant.factory.ConstantFactory;
        import com.stylefeng.guns.common.persistence.model.Dept;
        import com.stylefeng.guns.common.persistence.model.Irrb.CanalBase;
        import com.stylefeng.guns.core.node.ZTreeNode;
        import com.stylefeng.guns.core.support.BeanKit;
        import com.stylefeng.guns.core.util.ToolUtil;
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
        import com.stylefeng.guns.common.constant.dictmap.CanalBaseDict;
        import com.stylefeng.guns.common.exception.BizExceptionEnum;
        import com.stylefeng.guns.common.exception.BussinessException;
        import com.stylefeng.guns.common.persistence.dao.CanalBaseMapper;
        import com.stylefeng.guns.core.base.controller.BaseController;
        import com.stylefeng.guns.core.log.LogObjectHolder;
        import com.stylefeng.guns.modular.irrb.dao.CanalBaseDao;
        import com.stylefeng.guns.modular.irrb.warpper.CanalBaseWarpper;


/**
 * 渠道基本信息控制器
 *
 * @author hnsl
 * @email sunlightcs@gmail.com
 * @date 2017-10-22 10:08:16
 */

@Controller
@RequestMapping("/canalbase")
public class CanalBaseController extends BaseController {

    private String PREFIX = "/irrb/canalbase/";

    @Resource
    private CanalBaseMapper canalBaseMapper;

    @Resource
    private CanalBaseDao canalBaseDao;

    /**
     * 跳转到渠道基本信息首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "canalbase.html";
    }

    /**
     * 跳转到添加渠道基本信息
     */
    @RequestMapping("/canalbase_add")
    public String canalBaseAdd() {
        return PREFIX + "canalbase_add.html";
    }

    /**
     * 跳转到渠道基本信息详情
     */
    @RequestMapping(value = "/canalbase_info/{canalId}")
    public String detail(@PathVariable("canalId" ) Integer canalId, Model model) {

        CanalBase canalBase = this.canalBaseMapper.selectById(canalId);

        model.addAttribute("canalBase",super.warpObject(new CanalBaseWarpper(ToolUtil.ConvertObjToMap(canalBase))));

        return PREFIX + "canalbase_info.html";
    }

    /**
     * 跳转到修改渠道基本信息
     */
    @RequestMapping("/canalbase_update/{canalId}")
    public String canalBaseUpdate(@PathVariable("canalId" ) Integer canalId, Model model) {

        CanalBase canalBase = this.canalBaseMapper.selectById(canalId);

        model.addAttribute("canalBase",canalBase);
        model.addAttribute("upperCanalName", ConstantFactory.me().getCanalName(canalBase.getUpperCanalId()));
        LogObjectHolder.me().set(canalBase);

        return PREFIX + "canalbase_edit.html";
    }

    /**
     * 获取部门的tree列表
     */
    @ApiOperation(value = "渠道系统树",notes = "渠道系统树API接口")
    @RequestMapping(value = "/tree",method = RequestMethod.GET)
    @ResponseBody
    public List<ZTreeNode> tree() {

        List<ZTreeNode> tree = this.canalBaseDao.tree();

        tree.add(ZTreeNode.createParent());

        return tree;
    }

    /**
     * 获取渠道基本信息列表
     */
    @ApiOperation(value = "渠道基本信息列表",notes = "渠道基本信息列表API接口")
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    @ResponseBody
    public Object list(@RequestParam(value = "condition",required = false) String condition,
                       @RequestParam(value = "canalType",required = false) String canalType,
                       @RequestParam(value = "irrId",required = false) String irrId) {
        List<Map<String, Object>> list = this.canalBaseDao.list(condition,canalType,irrId);
        return super.warpObject(new CanalBaseWarpper(list));
    }

    /**
     * 新增渠道基本信息
     */
    @ApiOperation(value = "新增渠道基本信息",notes = "新增渠道基本信息API接口")
    @BussinessLog(value = "添加渠道基本信息", key = "canalId", dict = CanalBaseDict.class)
    @PostMapping(value = "/add")
    @ResponseBody
    public Object add(@Valid CanalBase canalBase, BindingResult result) {

        if (result.hasErrors()) {
            throw new BussinessException(BizExceptionEnum.REQUEST_NULL);
        }

        canalBase.setCreated(new Date());

        canalBase.setModified(new Date());

        CanalSetPids(canalBase);

        canalBaseMapper.insert(canalBase);
        return super.SUCCESS_TIP;
    }

    /**
     * 删除渠道基本信息
     */
    @BussinessLog(value = "删除渠道基本信息", key = "canalId", dict = CanalBaseDict.class)
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete(@RequestParam Integer canalId) {
        canalBaseMapper.deleteById(canalId);
        return SUCCESS_TIP;
    }


    /**
     * 修改渠道基本信息
     */
    @BussinessLog(value = "修改渠道基本信息", key = "canalId", dict = CanalBaseDict.class)
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update(@Valid CanalBase canalBase, BindingResult result) {
        if (result.hasErrors()) {
            throw new BussinessException(BizExceptionEnum.REQUEST_NULL);
        }
        canalBase.setModified(new Date());

        this.canalBaseMapper.updateById(canalBase);
        return super.SUCCESS_TIP;
    }



    private void CanalSetPids(CanalBase canalBase) {
        if (ToolUtil.isEmpty(canalBase.getUpperCanalId()) || canalBase.getUpperCanalId().equals(0)) {
            canalBase.setUpperCanalId(0);
            canalBase.setUpperCanalIds("[0],");
        } else {
            int pid = canalBase.getUpperCanalId();
            CanalBase temp = canalBaseMapper.selectById(pid);
            String pids = temp.getUpperCanalIds();
            canalBase.setUpperCanalId(pid);
            canalBase.setUpperCanalIds(pids + "[" + pid + "],");
        }
    }
}

