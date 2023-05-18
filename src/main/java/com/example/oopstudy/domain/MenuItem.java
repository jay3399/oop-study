package com.example.oopstudy.domain;


import lombok.Data;
import lombok.Getter;

public class MenuItem {

  private String name;
  private int cost;


  public String getName() {
    return name;
  }

  public int getCost() {
    return cost;
  }
}
