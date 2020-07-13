package com.example.mc.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.mc.model.Rating;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class RatingInfo {
  
  @Autowired
  private RestTemplate restTemplate;
  
  @HystrixCommand(fallbackMethod = "getFallbackrating")
  public ResponseEntity<Rating[]> getRating(){
    ResponseEntity<Rating[]> ratings = restTemplate.getForEntity("http://localhost:8082/ratings/getRating", Rating[].class);
    return ratings;
  }
  
  //this is the fallback method which can be default/hardcode response or cache response.
  public ResponseEntity<Rating[]> getFallbackrating(){
    Rating r = new Rating();
    r.setMovieId(0);
    r.setRating(0);
    r.setUserId(0);
    Rating[] ratings = new Rating[1];
    ratings[0] = r;
    return new ResponseEntity<Rating[]>(HttpStatus.OK);
  }
}
