package com.example.oopstudy.domain;

public class Customer {


  public Coffee createOrder(String itemName, Menu menu, Barista barista) {

    MenuItem item = menu.getItem(itemName);

    Coffee order = barista.createOrder(item);

    return order;
  }


}
