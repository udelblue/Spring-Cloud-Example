package com.doh;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.core.env.Environment;

/**
 *
 */
@SpringBootApplication
@EnableEurekaServer
public class DOHDiscoveryApplication {

    public static void main(String[] args) {
        SpringApplication.run(DOHDiscoveryApplication.class, args);
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
