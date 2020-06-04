package com.example.photon.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class User implements Serializable {
  @Id
  private Long id;
  @Column(name="name")
  private String name;
  @Column(name="address")
  private String address;
  public User(){}
  
  public Long getId() {
    return id;
  }
  public void setId(Long id) {
    this.id = id;
  }
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public String getAddress() {
    return address;
  }
  public void setAddress(String address) {
    this.address = address;
  }
  public User(Long id, String name, String address) {
    super();
    this.id = id;
    this.name = name;
    this.address = address;
  }

}
