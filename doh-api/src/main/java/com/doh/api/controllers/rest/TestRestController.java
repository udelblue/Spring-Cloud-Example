package com.doh.api.controllers.rest;



import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


@RestController
@RequestMapping("/")
public class TestRestController {

    @RequestMapping("/title")
    public String getTitle(Principal user) {
        return new String("API SERVER IS ALIVE" + (user == null ? "" : " " + user.getName()));
    }

    
    @RequestMapping("/test")
    public String getTitle() {
        return new String("Testing 123" );
    }
    
    
    @RequestMapping("/time")
    public String getTime() {
    	
    	 DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    	    Date date = new Date();
    	
        return new String(dateFormat.format(date) );
    }
    
    @RequestMapping("/date")
    public Date getdime() {
    	
    	 DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    	    Date date = new Date();
    	
        return date;
    }
    
    
   
    
    
    @RequestMapping("/user")
    public Principal user(Principal user) {
        return user;
    }

}
