package com.devsuperior.dslist.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig {

	@Value("${cors.origins}")	// pega o valor de cors.origins (definida em application.properties)
								// e joga para o atributo corsOrigins abaixo
	private String corsOrigins;
	
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**").allowedMethods("*").allowedOrigins(corsOrigins);
			}
		};
	}
	
}

// No Railway (plataforma de nuvem usada para o deploy), definimos um terceiro valor para CORS_ORIGINS,
// que passa também a ser considerado para a operação acima de definição origens CORS permitidas