package com.finalproject.warehousemanagementsystem.util;

import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public GroupedOpenApi publicApi() {
        return GroupedOpenApi.builder()
                .group("public")
                .addOpenApiCustomiser(openApi -> openApi.info(new Info().title("/api/v1")
                        .description("API Documentation")
                        .version("1.0")))
                .build();
    }
}
