package com.example.photon.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.photon.model.User;

@Repository("userRepo")
public interface UserRepo extends JpaRepository<User, Long> {

}
