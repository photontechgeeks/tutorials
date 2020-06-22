package com.example.mc.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.mc.model.User;

@Repository("mcRepo")
public interface MCRepo extends JpaRepository<User, Long> {

}
