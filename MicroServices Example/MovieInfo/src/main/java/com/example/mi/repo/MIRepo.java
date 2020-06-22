package com.example.mi.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.mi.model.Movie;

@Repository("miRepo")
public interface MIRepo extends JpaRepository<Movie, Long> {

}
