package kr.co.study.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

/**
 * Created by coupang on 2017. 5. 23..
 */
@EnableAutoConfiguration
public class ApplicationInitialisation {

	public static void main(String[] args){
		SpringApplication.run(ApplicationInitialisation.class, args);
	}
}
