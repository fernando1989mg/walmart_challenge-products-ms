package com.walmart.challenge;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class WalmartChallengeProductsMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(WalmartChallengeProductsMsApplication.class, args);
	}
	
    @CrossOrigin
    @RequestMapping(method = RequestMethod.GET, value = "/health")
    public ResponseEntity<String> health() {
    	
    	return new ResponseEntity<>("ok", HttpStatus.OK);
    }

}
