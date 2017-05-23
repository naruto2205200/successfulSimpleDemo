package com.example;

import com.example.util.MybatisConfiguration;
import com.github.pagehelper.PageHelper;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.apache.tomcat.jdbc.pool.DataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import java.util.Properties;

/**
 * Created by naruto on 2017/5/15.
 */
@SpringBootApplication
@MapperScan("com.example.mapper")
public class Application  extends SpringBootServletInitializer {
    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }

    @Bean
    @ConfigurationProperties(prefix="spring.datasource")
    public DataSource dataSource() {
        return new DataSource();
    }

    //提供SqlSeesion
    @Bean
    public SqlSessionFactory sqlSessionFactoryBean() throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource());
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        //MybatisConfiguration config= new MybatisConfiguration();
        //Interceptor[] plugins =  new Interceptor[]{config.pageHelper()};
        //sqlSessionFactoryBean.setPlugins(plugins);

        sqlSessionFactoryBean.setMapperLocations(resolver.getResources("classpath:/mybatis/*.xml"));
        return sqlSessionFactoryBean.getObject();
    }

//    @Bean
//    public SqlSessionFactory sqlSessionFactory1() {
//
//        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
//        bean.setDataSource(dataSource());
//
//        //分页插件
//        PageHelper pageHelper = new PageHelper();
//        Properties properties = new Properties();
//        properties.setProperty("dialect", "mysql");
//        properties.setProperty("reasonable", "false");
//        properties.setProperty("pageSizeZero", "true");
//        pageHelper.setProperties(properties);
//        bean.setPlugins(new Interceptor[]{pageHelper});
//
//        try {
//            //指定mapper xml目录
//            ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
//            bean.setMapperLocations(resolver.getResources("classpath:/mybatis/*.xml"));
//            return bean.getObject();
//        } catch (Exception e) {
//            logger.error(e.getMessage(), e);
//            throw new RuntimeException(e);
//        }
//    }

    @Bean
    public PlatformTransactionManager transactionManager() {
        return new DataSourceTransactionManager(dataSource());
    }
}
