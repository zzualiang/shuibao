package com.stylefeng.guns.core.template.config;

public class SqlConfig {
    private ContextConfig contextConfig;

    private String sqlPathTemplate;

    public void init() {
        sqlPathTemplate = "\\sql\\{}\\{}.sql";
    }

    public String getSqlPathTemplate() {
        return sqlPathTemplate;
    }

    public ContextConfig getContextConfig() {
        return contextConfig;
    }

    public void setContextConfig(ContextConfig contextConfig) {
        this.contextConfig = contextConfig;
    }
}
