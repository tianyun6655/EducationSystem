package com.education;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

@SpringBootApplication
@EnableAutoConfiguration
@Configuration
@ComponentScan
@MapperScan("com.education.mapper")
public class EducationSystemBackEndApplication extends SpringBootServletInitializer {
	@Bean
	@ConfigurationProperties(prefix = "test.datasource")
	public DataSource dataSource() {
		return new org.apache.tomcat.jdbc.pool.DataSource();

	}
	
	@Bean
	public SqlSessionFactory sqlSessionFactoryBean() throws Exception {
		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		sqlSessionFactoryBean.setDataSource(dataSource());

		PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();

		sqlSessionFactoryBean.setMapperLocations(resolver.getResources("classpath:/mybatis/*.xml"));

		return sqlSessionFactoryBean.getObject();
	}
	

	@Bean
	public PlatformTransactionManager transactionManager() {
		return new DataSourceTransactionManager(dataSource());

	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(EducationSystemBackEndApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(EducationSystemBackEndApplication.class, args);
	}
}
