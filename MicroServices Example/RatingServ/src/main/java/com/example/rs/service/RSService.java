package com.example.rs.service;

import java.util.List;

import com.example.rs.model.Rating;

public interface RSService 
{
    void createRating(Rating rating);
    List<Rating> getRating();
}
