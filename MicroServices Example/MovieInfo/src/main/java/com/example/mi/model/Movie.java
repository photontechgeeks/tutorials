package com.example.mi.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="movie") 
public class Movie implements Serializable {
  @Id
  private long movieId;
  @Column(name="name")
  private String name;
  @Column(name="releaseYear")
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
