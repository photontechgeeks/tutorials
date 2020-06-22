package com.example.mi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.mi.model.Movie;
import com.example.mi.service.MIService;

@RestController
@RequestMapping("/movies")
public class MIController {
  
  @Autowired
  private MIService miService;
  
  @PostMapping(value="/createMovie", consumes="application/json")
  @ResponseStatus(HttpStatus.CREATED)
  public void createMovie(@RequestBody Movie movie){
    miService.createMovie(movie);
  }
  
  @GetMapping(value="/{movieId}")
  public Movie getMovie(@PathVariable("movieId") String movieId){
    Movie movie = miService.getMovie(movieId);
    return movie;
  }

}
