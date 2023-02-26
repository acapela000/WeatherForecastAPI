package com.charlieThao.weather_forcast_demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.RequestHandler;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Collections;

@Configuration
@EnableWebMvc
public class SwaggerConfiguration {

    private ApiInfo getInfo() {
        return new ApiInfo(
                "WeatherForecastAPI",
                "This is the API for weather forecast",
                "0.0.1",
                " ",
                new Contact("Charlie Thao", " ", "google@gmail.com"),
                "MIT",
                " ",
                Collections.emptyList()
        );
    }

    @Bean
    public Docket swaggerAPI() {
        return new Docket(DocumentationType.OAS_30)
                .apiInfo(getInfo())
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();
    }

}
