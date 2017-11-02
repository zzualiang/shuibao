package com.stylefeng.guns.template;

import com.stylefeng.guns.core.template.config.ContextConfig;
import com.stylefeng.guns.core.template.engine.SimpleTemplateEngine;
import com.stylefeng.guns.core.template.engine.base.GunsTemplateEngine;

import java.io.IOException;

/**
 * 测试Guns模板引擎
 *
 * @author fengshuonan
 * @date 2017-05-09 20:27
 */
public class TemplateGenerator {

    public static void main(String[] args) throws IOException {
        ContextConfig contextConfig = new ContextConfig();
        contextConfig.setBizChName("灌区基本信息");
        contextConfig.setBizEnName("irrbsbase");
        contextConfig.setModuleName("irrb");
        contextConfig.setSqlName("irrb_s");
        contextConfig.setProjectPath("G:\\IdeaProjects\\guns\\guns-admin");

        contextConfig.setAddPageSwitch(true);
        contextConfig.setEditPageSwitch(true);
        contextConfig.setControllerSwitch(true);
        contextConfig.setDaoSwitch(true);
        contextConfig.setIndexPageSwitch(true);
        contextConfig.setInfoJsSwitch(true);
        contextConfig.setJsSwitch(true);
        contextConfig.setDaoSwitch(true);
        contextConfig.setServiceSwitch(true);
        contextConfig.setSqlSwitch(true);


        GunsTemplateEngine gunsTemplateEngine = new SimpleTemplateEngine();
        gunsTemplateEngine.setContextConfig(contextConfig);
        gunsTemplateEngine.start();
    }

}
