package com.fontys.crowdfund.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**") // Allow all paths
                        .allowedOrigins("http://localhost:3000") // Specify allowed origins (adjust this as needed)
                        .allowedMethods("GET", "POST", "PUT", "DELETE") // Specify allowed HTTP methods
                        .allowedHeaders("*") // Allow all headers
                        .allowCredentials(true); // Allow credentials (cookies, authorization headers, etc.)
            }
        };
    }
}
