package com.example.mc.model;

import java.io.Serializable;

public class CatalogItem implements Serializable {
  
  private String movieName;
  private String releaseYear;
  private int rating;
  
  public CatalogItem(){}
  public CatalogItem(String movieName, String releaseYear, int rating) {
    super();
    this.movieName = movieName;
    this.releaseYear = releaseYear;
    this.rating = rating;
  }
  
  public int getRating() {
    return rating;
  }
  public void setRating(int rating) {
    this.rating = rating;
  }
  public String getMovieName() {
    return movieName;
  }
  public void setMovieName(String movieName) {
    this.movieName = movieName;
  }
  public String getReleaseYear() {
    return releaseYear;
  }
  public void setCast(String releaseYear) {
    this.releaseYear = releaseYear;
  }

}
