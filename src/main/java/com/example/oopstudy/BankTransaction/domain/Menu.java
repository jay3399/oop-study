package com.example.oopstudy.BankTransaction.domain;

import java.util.ArrayList;
import java.util.List;

public class Menu {

  private List<MenuItem> items = new ArrayList<>();

  public MenuItem getItem(String itemName) {

    return items.stream().filter(menuItem -> menuItem.getName().equals(itemName))
        .findAny().orElse(null);
  }

}
