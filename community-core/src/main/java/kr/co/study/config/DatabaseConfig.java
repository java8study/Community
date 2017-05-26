package kr.co.study.config;

import org.apache.commons.dbcp.BasicDataSource;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/**
 * Created by coupang on 2017. 5. 24..
 */
@Configuration
@PropertySource(value = { "classpath:properties/datasource.properties" })
@EnableTransactionManagement
public class DatabaseConfig implements EnvironmentAware {

	@Autowired
	private Environment environment;

	@Bean(destroyMethod = "close")
	public DataSource dataSource() {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName(environment.getProperty("database.DriverClassName"));
		dataSource.setUrl(environment.getProperty("database.Url"));
		dataSource.setUsername(environment.getProperty("database.UserName"));
		dataSource.setPassword(environment.getProperty("database.Password"));
		dataSource.setDefaultAutoCommit(true);
		return dataSource;
	}

	@Bean
	public PropertySourcesPlaceholderConfigurer placeholderConfigurer() {
		return new PropertySourcesPlaceholderConfigurer();
	}

	@Bean
	public PlatformTransactionManager transactionManager() {
		return new DataSourceTransactionManager(dataSource());
	}

	public void setEnvironment(Environment environment) {
		this.environment = environment;
	}
}
