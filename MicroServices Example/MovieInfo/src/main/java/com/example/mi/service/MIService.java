package com.example.mi.service;

import java.util.List;

import com.example.mi.model.Movie;

public interface MIService 
{
    void createMovie(Movie movie);
    Movie getMovie(String userId);
}
