package com.doh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import de.codecentric.boot.admin.config.EnableAdminServer;

/**
 * Created by Tarun Kumar Sukhu 
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableAdminServer
public class DOHAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(DOHAdminApplication.class, args);
    }

}
