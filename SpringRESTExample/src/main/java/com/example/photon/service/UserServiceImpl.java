package com.example.photon.service;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.photon.exception.BadReqException;
import com.example.photon.model.User;
import com.example.photon.repo.UserRepo;

@Service("userService")
public class UserServiceImpl  implements UserService{
  
  @Autowired
  private UserRepo userRepo;

  @Override
  public void createUser(User user) {
    User userObj = userRepo.findOne(user.getId());
    if(Objects.nonNull(userObj)){
      throw new BadReqException("User is already present");
    }else{
       userRepo.save(user);
    }
    
    
  }

  @Override
  public List<User> getUser() {
    List<User> userList = userRepo.findAll();
    
    if(Objects.nonNull(userList)){
      return userList;
    }else{
       throw new BadReqException("No Users present");
    }
  }

}
