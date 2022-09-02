package com.example.usermanage.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import javax.sql.DataSource;

/**
 * User: wangjinshuai
 * Time: 2022-05-11 9:19 PM
 * Email: jinshuaiwang@gmail.com
 */
@Configuration
@ComponentScan("com.example.usermanage")
@MapperScan("com.example.usermanage.server.service.mapper")
@PropertySource("classpath:application.properties")
public class AppConfig {

    @Autowired
    private Environment environment;

    @Bean
    public SqlSessionFactory sqlSessionFactory() throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(dataSource());
        return factoryBean.getObject();
    }

    public DataSource dataSource() {
        HikariConfig config = new HikariConfig();

        // 其他参数配置参见GitHub：https://github.com/brettwooldridge/HikariCP
        config.setDriverClassName(environment.getProperty("spring.datasource.driver-class-name"));
        config.setJdbcUrl(environment.getProperty("spring.datasource.url"));
        config.setUsername(environment.getProperty("spring.datasource.username"));
        config.setPassword(environment.getProperty("spring.datasource.password"));
        config.addDataSourceProperty("connectionTimeout", environment.getProperty("spring.datasource.connectionTimeout")); // 连接超时：1秒
        config.addDataSourceProperty("idleTimeout", environment.getProperty("spring.datasource.idleTimeout")); // 空闲超时：60秒
        config.addDataSourceProperty("maximumPoolSize", environment.getProperty("spring.datasource.maximumPoolSize")); // 最大连接数：10
        config.addDataSourceProperty("minimumIdle", environment.getProperty("spring.datasource.minimumIdle")); // 最小连接数：2

        return new HikariDataSource(config);
    }
}
