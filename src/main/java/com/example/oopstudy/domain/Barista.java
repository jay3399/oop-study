package com.example.oopstudy.domain;

public class Barista {

  public Coffee createOrder(MenuItem menuItems) {
    return Coffee.createCoffee(menuItems);
  }

}
