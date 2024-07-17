package com.lucas.auth.configs;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class SwaggerConfig implements WebMvcConfigurer {

    @Bean
    public OpenAPI usersMicroserviceOpenAPI() {
        return new OpenAPI().info(
                new Info().title("Auth-token")
                        .description("teste de autenticação usando token JWT")
                        .version("1.0"));
    }

    @Override
    public void addViewControllers(final ViewControllerRegistry viewControllerRegistry) {
        viewControllerRegistry.addRedirectViewController("/","/swagger-ui.html");
        viewControllerRegistry.addRedirectViewController("/swagger-ui","swagger-ui.html");
    }


}
