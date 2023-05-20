package com.example.oopstudy.BankTransaction.domain;

public class Barista {

  public Coffee createOrder(MenuItem menuItems) {
    return Coffee.createCoffee(menuItems);
  }

}
