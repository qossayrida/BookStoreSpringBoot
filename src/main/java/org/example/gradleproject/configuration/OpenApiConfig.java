package org.example.gradleproject.configuration;


import io.swagger.v3.oas.models.*;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {
    @Bean
    public OpenAPI bookstoreOpenAPI() {
        return new OpenAPI()
                .info(new Info().title("BookStore API")
                        .description("API for BookStore application")
                        .version("v1.0.0"))
                .externalDocs(new ExternalDocumentation()
                        .description("GitHub Repository")
                        .url("https://github.com/qossayrida/BookStoreSpringBoot-GenericServices"));
    }
}