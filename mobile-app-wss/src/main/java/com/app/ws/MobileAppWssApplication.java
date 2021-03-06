package com.app.ws;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

//import com.app.ws.security.AppProperties;

@SpringBootApplication
public class MobileAppWssApplication {

	public static void main(String[] args) {
		SpringApplication.run(MobileAppWssApplication.class, args);
	}

//	@Bean
//	public BCryptPasswordEncoder bCryptPasswordEncoder()
//	{
//		return new BCryptPasswordEncoder();
//	}
	@Bean
	public SpringApplicationContext springApplicationContext()
	{
		return new SpringApplicationContext();
	}
	/*@Bean(name="AppProperties")
	public AppProperties getappProperties()
	{
		return new AppProperties();
	}
	*/
}
