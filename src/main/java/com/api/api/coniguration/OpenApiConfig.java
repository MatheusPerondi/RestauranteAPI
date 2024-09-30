package com.api.api.coniguration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {
    //http://localhost:8082/api/swagger-ui/index.html
    @Bean
    public OpenAPI customOpenAPI(){
        return new OpenAPI()
                .info(new Info()
                        .title("API Rest para restaurante")
                        .version("0.0.1")
                        .description("API para atender um restaurante, sistema de pratos, bebidas, pedidos, categoria e reservas, apenas para estudo"));
    }
}
