package com.doh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 *
 */

@SpringBootApplication
@EnableCaching
public class DOHCommonTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(DOHCommonTestApplication.class, args);
    }

}
