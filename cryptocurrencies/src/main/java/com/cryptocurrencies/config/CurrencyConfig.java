package com.cryptocurrencies.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CurrencyConfig {

	@Value("${corsAllowedOrigins}")
	private String corsAllowedOrigins;

	@Value("${corsAllowedMethods}")
	private String corsAllowedMethods;

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**")
						.allowedOrigins(corsAllowedOrigins.split(","))
						.allowedMethods(corsAllowedMethods.split(","))
						.exposedHeaders("X-Auth-Token");
			}
		};
	}
}
