package com.example.mc.service;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mc.exception.BadReqException;
import com.example.mc.model.CatalogItem;
import com.example.mc.model.User;
import com.example.mc.repo.MCRepo;

@Service("mcService")
public class MCServiceImpl  implements MCService{
  
  @Autowired
  private MCRepo mcRepo;

  @Override
  public void createUser(User user) {
    User userObj = mcRepo.findOne(user.getId());
    if(Objects.nonNull(userObj)){
      throw new BadReqException("User is already present");
    }else{
       mcRepo.save(user);
    }
  }

  //@Override
  /*public List<CatalogItem> getCatalog(String userId) {
    User userObj = mcRepo.findOne(Long.valueOf(userId));
    
    if(Objects.nonNull(userObj)){
      return userObj.getCatalogItem();
    }else{
       throw new BadReqException("No data present");
    }
  }*/

}
