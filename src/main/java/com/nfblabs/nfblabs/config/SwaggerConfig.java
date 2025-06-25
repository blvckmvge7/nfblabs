package com.nfblabs.nfblabs.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI().info(new Info()
                .title("API Reserva de Cursos Online NFBLabs")
                .version("1.0")
                .description("Documentación de la plataforma de cursos online"));
    }
}
