package com.cy.mybatisplusdemo.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {
    //定义一个通过Druid获取连接数据源信息
    @Bean //将但前类的对象交给Spring容器管理，将方法的返回值对象自动交给Spring容器
    //表示加载properties配置文件中指定前缀的属性的值
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource getDruid() {
        //自定返回的Druid连接池数据源对象(连接池的默认修改成Druid)
        return new DruidDataSource();
    }

}
