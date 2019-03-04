package com.github.arocketman.controllers;



import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.jboss.jandex.Main;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController



@RequestMapping("/")
public class ServiceController {
 @Autowired
 private Environment env;
 @Autowired
 RestTemplate restTemplate;
 private static final Logger logger = LogManager.getLogger(Main.class);
 
 @GetMapping(value = "/public")
 public String index(){
     return "Here would be deployed publics services";
 }

 @GetMapping("private/{urlid}")
 //Consuming a service by GET method
 String getHelloOperation(@PathVariable("urlid") String urlid) {
	 String serviceURL=env.getProperty("rest.url");

	 return restTemplate.getForObject(serviceURL + urlid, String.class);
 }

 
 @Bean
 public RestTemplate rest() {
 return new RestTemplate();
 }
 
}
 