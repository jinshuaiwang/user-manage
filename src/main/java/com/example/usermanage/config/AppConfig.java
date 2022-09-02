package com.example.usermanage.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * User: wangjinshuai
 * Time: 2022-05-11 9:19 PM
 * Email: jinshuaiwang@gmail.com
 */
@Configuration
@ComponentScan("com.example.usermanage")
@MapperScan("com.example.usermanage.server.service.mapper")
public class AppConfig {

    @Bean
    public SqlSessionFactory sqlSessionFactory() throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(dataSource());
        return factoryBean.getObject();
    }

    public DataSource dataSource() {
        HikariConfig config = new HikariConfig();

        // TODO 参数提到配置文件里
        // 其他参数配置参见GitHub：https://github.com/brettwooldridge/HikariCP
        config.setDriverClassName("com.mysql.jdbc.Driver");
        config.setJdbcUrl("jdbc:mysql://localhost:3306/interview");
        config.setUsername("root");
        config.setPassword("");
        config.addDataSourceProperty("connectionTimeout", "1000"); // 连接超时：1秒
        config.addDataSourceProperty("idleTimeout", "60000"); // 空闲超时：60秒
        config.addDataSourceProperty("maximumPoolSize", "20"); // 最大连接数：10
        config.addDataSourceProperty("minimumIdle", "2"); // 最小连接数：2

        return new HikariDataSource(config);
    }
}
