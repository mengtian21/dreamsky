package com.travle.dreamsky.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Component
@MapperScan(basePackages = "com.travle.dreamsky.mapper")
@PropertySource("classpath:/config/druid.yml")

public class DruidDataSourceConfig {

    @Autowired
    private Environment env;

//    @Value("${url}")
//    private String url;

    @Bean
    @Primary
    public DruidDataSource dataSource(){

        DruidDataSource dataSource = new DruidDataSource();


        dataSource.setDriverClassName(env.getProperty("driver-class-name"));
        dataSource.setUrl(env.getProperty("url"));
        dataSource.setUsername(env.getProperty("db-username"));
        dataSource.setPassword(env.getProperty("password"));
        dataSource.setInitialSize(Integer.parseInt(env.getProperty("initialSize")));
        dataSource.setMinIdle(Integer.parseInt(env.getProperty("minIdle")));
        dataSource.setMaxActive(Integer.parseInt(env.getProperty("maxActive")));
        dataSource.setMaxWait(Integer.parseInt(env.getProperty("maxWait")));

        return dataSource;
    }

    @Bean
    public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception{
        SqlSessionFactoryBean sessionFactoryBean = new SqlSessionFactoryBean();
        Resource[] resources = null;
        ResourcePatternResolver resourcePatternResolver = new PathMatchingResourcePatternResolver();
        String mapperPackage = env.getProperty("mapper-locations");
        resources = resourcePatternResolver.getResources(mapperPackage);

        sessionFactoryBean.setMapperLocations(resources);
        sessionFactoryBean.setDataSource(dataSource);
        SqlSessionFactory sqlSessionFactory = sessionFactoryBean.getObject();

        return sqlSessionFactory;
    }

    @Bean
    public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory){
        return new SqlSessionTemplate(sqlSessionFactory);
    }

    @Bean
    public DataSourceTransactionManager transactionManager(DataSource dataSource){
        return new DataSourceTransactionManager(dataSource);
    }
}
