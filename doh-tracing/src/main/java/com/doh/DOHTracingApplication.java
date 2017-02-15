package com.doh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import zipkin.server.EnableZipkinServer;




@SpringBootApplication
@EnableZipkinServer
public class DOHTracingApplication {

    public static void main(String[] args) {
        SpringApplication.run(DOHTracingApplication.class, args);
    }

}
