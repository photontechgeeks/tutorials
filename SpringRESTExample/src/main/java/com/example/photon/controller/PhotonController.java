package com.example.photon.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.photon.model.User;
import com.example.photon.service.UserService;

@RestController
@RequestMapping("/photon")
public class PhotonController {
  
  @Autowired
  private UserService userService;
  
  @PostMapping(value="/createUser", consumes="application/json")
  @ResponseStatus(HttpStatus.CREATED)
  public void createUser(@RequestBody User user){
    userService.createUser(user);
  }
  
  @GetMapping(value="/getUser")
  public List<User> getUser(){
    List<User> userlist = userService.getUser();
    return userlist;
  }

}
