package com.example.oopstudy.Business;

public interface ConditionalAction {

  boolean evaluate(Facts facts);

  void perform(Facts facts);

}
