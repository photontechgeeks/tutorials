package com.example.mc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableCircuitBreaker
public class MCApplication {

	public static void main(String[] args) {
		SpringApplication.run(MCApplication.class, args);
	}
	
	@Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder){
      return builder.build();
    }
	
	//below commented code is to set Timeout for each request explicitly
    /*@Bean
    public RestTemplate getRestTemplate(){
      HttpComponentsClientHttpRequestFactory r = new HttpComponentsClientHttpRequestFactory();
      r.setConnectTimeout(3000);
      return new RestTemplate(r);
    }*/

}
