package com.sparrow.app;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

/**
 * @author Jay
 * @time 2015年5月21日
 */
@Configuration
@ImportResource(value = {"classpath*:META-INF/spring/applicationContext*.xml"})
//@ImportResource(value = "classpath*:META-INF/spring/applicationContext*.xml")"classpath*:META-INF/logback.xml",
@PropertySource(value = "classpath:app.properties")
@ComponentScan(basePackages = { "com.sparrow" })
@EnableAspectJAutoProxy
public class ApplicationConfig {

	@Bean
	public RestTemplate restTemplate() {
		ClientHttpRequestFactory clientHttpRequestFactory = new HttpComponentsClientHttpRequestFactory();
		return new RestTemplate(clientHttpRequestFactory);
	}

}
