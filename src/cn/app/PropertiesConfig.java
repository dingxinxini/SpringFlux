package cn.app;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 读取Properties文件内容
 */

@Component
public class PropertiesConfig {

    @Value("${spring.datasource.driverClassName}")
    private String driverClassName;

    @Value("${spring.datasource.jdbcUrl}")
    private String jdbcUrl;

    @Value("${spring.datasource.userName}")
    private String userName;


    @Value("${spring.datasource.passWord}")
    private String passWord;

    @Value("${mybatis.typeAliases.package}")
    private String mybatistypeAliasespackage;

    @Value("${mybatis.mapper.location}")
    private String location;

    @Value("${spring.web.upload.maxUploadSize}")
    private Integer MaxFileUpload;

    public String getDriverClassName() {
        return driverClassName;
    }

    public void setDriverClassName(String driverClassName) {
        this.driverClassName = driverClassName;
    }

    public String getJdbcUrl() {
        return jdbcUrl;
    }

    public void setJdbcUrl(String jdbcUrl) {
        this.jdbcUrl = jdbcUrl;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getMybatistypeAliasespackage() {
        return mybatistypeAliasespackage;
    }

    public void setMybatistypeAliasespackage(String mybatistypeAliasespackage) {
        this.mybatistypeAliasespackage = mybatistypeAliasespackage;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Integer getMaxFileUpload() {
        return MaxFileUpload;
    }

    public void setMaxFileUpload(Integer maxFileUpload) {
        MaxFileUpload = maxFileUpload;
    }


}
