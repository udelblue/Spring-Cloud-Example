package com.doh.api.controllers.rest;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
 


@RestController
@RequestMapping("/")
public class TestRestController {


@Autowired 
private Random random;
	
	
    @RequestMapping("/title")
    public String getTitle(Principal user) {
    	try{
    	int millis = this.random.nextInt(1000); 
    	Thread.sleep(millis); 

    	}catch(Exception e){}
        return new String("API SERVER IS ALIVE" + (user == null ? "" : " " + user.getName()));
    }

    
    @RequestMapping("/test")
    public String getTitle() {
       	try{
        	int millis = this.random.nextInt(1000); 
        	Thread.sleep(millis); 

        	}catch(Exception e){}
        return new String("Testing 123" );
    }
    
    
    @RequestMapping("/time")
    public String getTime() {
    	
       	try{
        	int millis = this.random.nextInt(1000); 
        	Thread.sleep(millis); 

        	}catch(Exception e){}
    	 DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    	    Date date = new Date();
    	
        return new String(dateFormat.format(date) );
    }
    
    @RequestMapping("/date")
    public Date getdime() {
    	
       	try{
        	int millis = this.random.nextInt(1000); 
        	Thread.sleep(millis); 

        	}catch(Exception e){}
    	 DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    	    Date date = new Date();
    	
        return date;
    }
    
    
   
    
    
    @RequestMapping("/user")
    public Principal user(Principal user) {
        return user;
    }

}
