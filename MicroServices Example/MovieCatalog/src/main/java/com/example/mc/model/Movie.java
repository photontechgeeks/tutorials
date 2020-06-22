package com.example.mc.model;

import java.io.Serializable;

public class Movie implements Serializable {

  private long movieId;
  
  private String name;
  
  private String releaseYear;
  
  public long getMovieId() {
    return movieId;
  }

  public void setMovieId(long movieId) {
    this.movieId = movieId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getReleaseYear() {
    return releaseYear;
  }

  public void setReleaseYear(String releaseYear) {
    this.releaseYear = releaseYear;
  }

  public Movie(long movieId, String name, String releaseYear) {
    super();
    this.movieId = movieId;
    this.name = name;
    this.releaseYear = releaseYear;
  }

  public Movie(){}

}
