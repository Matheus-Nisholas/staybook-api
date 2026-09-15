package com.nisholas.staybook.infrastructure.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI staybookOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Staybook API")
                        .version("1.0.0")
                        .description("API REST para gerenciamento de acomodações, desenvolvida com Java, Spring Boot e Clean Architecture.")
                        .contact(new Contact()
                                .name("Matheus Nisholas")
                                .url("https://github.com/Matheus-Nisholas")));
    }
}
