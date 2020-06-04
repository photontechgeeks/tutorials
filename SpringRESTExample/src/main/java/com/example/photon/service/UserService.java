package com.example.photon.service;

import java.util.List;

import com.example.photon.model.User;

public interface UserService 
{
    void createUser(User user);
    List<User> getUser();
}
