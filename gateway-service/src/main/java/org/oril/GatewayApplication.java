package org.oril;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import java.util.Map;

@SpringBootApplication
@EnableEurekaClient
@EnableCircuitBreaker
public class GatewayApplication {
    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication.class);
    }
//    @Bean
//    public RouteLocator routes(RouteLocatorBuilder builder) {
//        return builder.routes()
//                .route("circuitbreaker_route", r -> r.path("/consumingServiceEndpoint")
//                        .filters(f -> f.circuitBreaker(c -> c.name("myCircuitBreaker").fallbackUri("forward:/inCaseOfFailureUseThis"))
//                                .rewritePath("/consumingServiceEndpoint", "/backingServiceEndpoint")).uri("lb://backing-service:8088")
//                        .build();
//    }

}

