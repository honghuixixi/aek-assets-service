package com.aek;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import feign.Request;

@SpringBootApplication
@EnableTransactionManagement
@EnableDiscoveryClient
@EnableAutoConfiguration
@EnableEurekaClient
@EnableFeignClients
@EnableScheduling
public class AssetsApplication {
	public static void main(String[] args) {
		SpringApplication.run(AssetsApplication.class, args);
	}

	@Bean
	Request.Options feignOptions() {
		return new Request.Options(/** connectTimeoutMillis **/
				100 * 1000, /** readTimeoutMillis **/
				100 * 1000);
	}
}
