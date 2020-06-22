package com.example.mi.service;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mi.exception.BadReqException;
import com.example.mi.model.Movie;
import com.example.mi.model.Movie;
import com.example.mi.repo.MIRepo;

@Service("miService")
public class MIServiceImpl  implements MIService{
  
  @Autowired
  private MIRepo miRepo;

  @Override
  public void createMovie(Movie movie) {
    Movie movieObj = miRepo.findOne(movie.getMovieId());
    if(Objects.nonNull(movieObj)){
      throw new BadReqException("Movie is already present");
    }else{
       miRepo.save(movie);
    }
  }

  @Override
  public Movie getMovie(String movieId) {
    Movie movieObj = miRepo.findOne(Long.valueOf(movieId));
    
    if(Objects.nonNull(movieObj)){
      return movieObj;
    }else{
       throw new BadReqException("No data present");
    }
   
  }

}
