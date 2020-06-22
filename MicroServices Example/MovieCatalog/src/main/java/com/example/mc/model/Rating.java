package com.example.mc.model;

import java.io.Serializable;

public class Rating implements Serializable {
  private long userId;
  
  private long movieId;
  
  private int rating;
  
  public Rating(){}

  public Rating(long userId, long movieId, int rating) {
    super();
    this.userId = userId;
    this.movieId = movieId;
    this.rating = rating;
  }

  public long getUserId() {
    return userId;
  }

  public void setUserId(long userId) {
    this.userId = userId;
  }

  public long getMovieId() {
    return movieId;
  }

  public void setMovieId(long movieId) {
    this.movieId = movieId;
  }

  public int getRating() {
    return rating;
  }

  public void setRating(int rating) {
    this.rating = rating;
  }

}
