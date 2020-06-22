package com.example.rs.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.rs.model.Rating;

@Repository("rsRepo")
public interface RSRepo extends JpaRepository<Rating, Long> {

}
