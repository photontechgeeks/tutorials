package com.example.rs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.rs.model.Rating;
import com.example.rs.service.RSService;

@RestController
@RequestMapping("/ratings")
public class RSController {
  
  @Autowired
  private RSService rsService;
  
  @PostMapping(value="/createRating", consumes="application/json")
  @ResponseStatus(HttpStatus.CREATED)
  public void createRating(@RequestBody Rating rating){
    rsService.createRating(rating);
  }
  
  /*@GetMapping(value="/{userId}")
  public List<Rating> getRating(@PathVariable("userId") String userId){
    List<Rating> ratings = rsService.getRating(userId);
    return ratings;
  }*/
  
  @GetMapping(value="/getRating")
  public List<Rating> getRating(){
    List<Rating> ratings = rsService.getRating();
    return ratings;
  }

}
