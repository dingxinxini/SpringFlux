package cn.app;

import com.zaxxer.hikari.HikariDataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.support.TransactionTemplate;

import javax.sql.DataSource;


@Configuration
@ComponentScan
//@EnableAspectJAutoProxy//开启AOP功能
//@EnableTransactionManagement//开启事务管理
//@EnableAsync //开启异步模式功能

@MapperScan("cn.app.dao")
@PropertySource("classpath:mapper/application.properties")
public class AppConfig {

    @Bean
    public DataSource dataSource(PropertiesConfig propertiesConfig) {
        HikariDataSource hikariDataSource = new HikariDataSource();
        hikariDataSource.setUsername(propertiesConfig.getUserName());
        hikariDataSource.setPassword(propertiesConfig.getPassWord());
        hikariDataSource.setJdbcUrl(propertiesConfig.getJdbcUrl());
        hikariDataSource.setDriverClassName(propertiesConfig.getDriverClassName());
        return hikariDataSource;
    }

    @Bean
    public SqlSessionFactoryBean sqlSessionFactoryBean(DataSource dataSource, PropertiesConfig config) throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        //配置数据源
        sqlSessionFactoryBean.setDataSource(dataSource);

        //别名
        sqlSessionFactoryBean.setTypeHandlersPackage(config.getMybatistypeAliasespackage());

        //通过spring的核心实现类获取mybatis的mapper映射文件
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        Resource[] resource = resolver.getResources(config.getLocation());
        sqlSessionFactoryBean.setMapperLocations(resource);
        return sqlSessionFactoryBean;
    }
   @Bean
    public PlatformTransactionManager transactionManager(DataSource dataSource) {
        //DataSourceTransactionManager 数据源事务管理器    PlatformTransactionManager 平台事务管理器
        DataSourceTransactionManager dataSourceTransactionManager = new DataSourceTransactionManager();
        dataSourceTransactionManager.setDataSource(dataSource);
        return dataSourceTransactionManager;
    }

    @Bean
    public TransactionTemplate transactionTemplate(PlatformTransactionManager transactionManager) {
        TransactionTemplate transactionTemplate = new TransactionTemplate();
        transactionTemplate.setTransactionManager(transactionManager);
        return transactionTemplate;

    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }


//    public String getUrl() {
//        return url;
//    }
//
//    public void setUrl(String url) {
//        this.url = url;
//    }
//
//    @Value("${url}")
//    private String url;
//    @Bean
//    public static TaskExecutor taskExecutor(){
//        ConcurrentTaskExecutor concurrentTaskExecutor = new ConcurrentTaskExecutor();
//        return concurrentTaskExecutor;
//    }
//
//    @Conditional(TestCondition.class)
//    @Bean
//    public SmbmsUser smbmsUser(){
//        return new SmbmsUser();
//    }

}
