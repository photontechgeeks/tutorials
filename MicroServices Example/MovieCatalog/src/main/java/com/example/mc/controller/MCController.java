package com.example.mc.controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.mc.model.CatalogItem;
import com.example.mc.model.Rating;
import com.example.mc.model.Movie;
import com.example.mc.model.User;
import com.example.mc.service.MCService;
import com.example.mc.service.MovieInfo;
import com.example.mc.service.RatingInfo;

@RestController
@RequestMapping("/catalog")
public class MCController {
  
  @Autowired
  private MCService mcService;
  
  
  @Autowired
  private MovieInfo movieInfo;
  
  @Autowired
  private RatingInfo ratingInfo;
  
  
  @PostMapping(value="/createUser", consumes="application/json")
  @ResponseStatus(HttpStatus.CREATED)
  public void createUser(@RequestBody User user){
    mcService.createUser(user);
  }
  
  @GetMapping(value="/{userId}")
  public List<CatalogItem> getCatalog(@PathVariable("userId") String userId){
    //CHECK BELOW METHOD FOR FAULT TOLERANCE/RESILIENCE
    ResponseEntity<Rating[]> ratings = ratingInfo.getRating();
    Rating[] rating = ratings.getBody();
    List<Rating> rlist = Arrays.asList(rating);
    List<Rating> ulist = rlist.stream().filter(x -> userId.equals(String.valueOf(x.getUserId()))).collect(Collectors.toList());
    
    return ulist.stream().map(y -> movieInfo.getCatalogItem(y)).collect(Collectors.toList());
   
  }

}
