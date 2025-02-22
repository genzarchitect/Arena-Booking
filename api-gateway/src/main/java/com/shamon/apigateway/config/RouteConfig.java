package com.shamon.apigateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RouteConfig {
    @Bean
    public RouteLocator myRoutes(RouteLocatorBuilder builder, JwtAuthenticationFilter jwtAuthenticationFilter){
        return builder.routes()
                .route(p -> p
                        .path("/arena/**")
                        .uri("http://localhost:8007"))
                .route(p -> p
                        .path("/api/v1/ground/image/**")
                        .uri("http://localhost:8005/"))

                .route(p -> p
                        .path("/api/v1/**")
                        .filters(f -> f.filter(jwtAuthenticationFilter))
                        .uri("http://localhost:8005"))
                .route(p -> p
                        .path("/booking/**")
                        .filters(f -> f.filter(jwtAuthenticationFilter))
                        .uri("http://localhost:8003/"))
                .route(p -> p
                        .path("/slot/**")
                        .uri("http://localhost:8003/"))
                .route(p -> p
                        .path("/api/v2/**")
                        .uri("http://localhost:8009/"))
                .route(p -> p
                        .path("/User/**")
                        .uri("http://localhost:8011/"))
                .route(p -> p
                        .path("/**")
                        .uri("http://localhost:8013/"))
                .build();
    }

}
