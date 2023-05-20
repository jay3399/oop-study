package com.example.oopstudy.BankTransaction.domain;

public class Coffee {

  private String name;
  private int cost;

  private void setName(String name) {
    this.name = name;
  }
  private void setCost(int cost) {
    this.cost = cost;
  }

  private Coffee() {
  }

  public static Coffee createCoffee(MenuItem menuItem) {
    Coffee coffee = new Coffee();

    coffee.setName(menuItem.getName());
    coffee.setCost(menuItem.getCost());

    return coffee;
  }



}
