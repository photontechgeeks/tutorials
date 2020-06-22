package com.example.rs.service;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.rs.exception.BadReqException;
import com.example.rs.model.Rating;
import com.example.rs.repo.RSRepo;

@Service("rsService")
public class RSServiceImpl  implements RSService{
  
  @Autowired
  private RSRepo rsRepo;

  @Override
  public void createRating(Rating rating) {
    
     rsRepo.save(rating);

  }

  @Override
  public List<Rating> getRating() {
    //Rating rObj = rsRepo.findOne(Long.valueOf(userId));
    List<Rating> rObj = rsRepo.findAll();
    
    if(Objects.nonNull(rObj)){
      //System.out.println(rObj.get(0).get);
      return rObj;
    }else{
       throw new BadReqException("No data present");
    }
  }

}
