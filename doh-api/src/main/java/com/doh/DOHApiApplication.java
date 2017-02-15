package com.doh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.sleuth.sampler.AlwaysSampler;
import org.springframework.context.annotation.Bean;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

/**
 *
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableCaching
//@EnableResourceServer
public class DOHApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(DOHApiApplication.class, args);
    }
    
    //remove in production
    @Bean
    public AlwaysSampler alwaysSampler() {

        return new AlwaysSampler();
    }
    
    

}
