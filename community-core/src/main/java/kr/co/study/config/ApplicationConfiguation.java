package kr.co.study.config;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;

import javax.sql.DataSource;

/**
 * Created by coupang on 2017. 5. 23..
 */

@Configuration
@ComponentScan(value = "kr.co.study")
@PropertySource(value = { "classpath:properties/datasource.properties" })
public class ApplicationConfiguation {

	@Autowired
	private Environment env;

	@Bean(destroyMethod = "close")
	public DataSource dataSource() {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName(env.getProperty("database.DriverClassName"));
		dataSource.setUrl(env.getProperty("jdbc:mysql://localhost:3306/community"));
		dataSource.setUsername(env.getProperty("database.UserName"));
		dataSource.setPassword(env.getProperty("database.Password"));
		dataSource.setDefaultAutoCommit(false);
		return dataSource;
	}

	@Bean
	public PropertySourcesPlaceholderConfigurer placeholderConfigurer() {
		return new PropertySourcesPlaceholderConfigurer();
	}

}
