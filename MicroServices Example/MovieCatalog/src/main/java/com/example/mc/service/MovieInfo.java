package com.example.mc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.mc.model.CatalogItem;
import com.example.mc.model.Movie;
import com.example.mc.model.Rating;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class MovieInfo {
  
  @Autowired
  private RestTemplate restTemplate;
  
  @HystrixCommand(fallbackMethod = "getFallbackCatalog")
  public CatalogItem getCatalogItem(Rating y){
    Movie movie = restTemplate.getForObject("http://localhost:8081/movies/"+y.getMovieId(), Movie.class);
    return new CatalogItem(movie.getName(), movie.getReleaseYear(), y.getRating()); 
  }
  
  //this is the fallback method which can be default/hardcode response or cache response.
  public CatalogItem getFallbackCatalog(){
    return new CatalogItem("No Movie", "0000", 0); 
  }
}
