package com.doh;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.core.env.Environment;

/**
 *
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableCaching
public class DOHAuthApplication {

    public static void main(String[] args) {
        SpringApplication.run(DOHAuthApplication.class, args);
    }

    
    
    @Autowired
  	Environment environment;
  	@PostConstruct
  	public void postrun() 
  	{
  		String port = environment.getProperty("server.port");
  		System.out.println("!!!!!!-------- Running at port " + port + " --------!!!!!!" );
  	}
}
