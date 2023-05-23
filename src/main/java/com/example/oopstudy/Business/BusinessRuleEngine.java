package com.example.oopstudy.Business;

import java.util.ArrayList;
import java.util.List;

public class BusinessRuleEngine {

  private final List<Action> actions;

  public final Facts facts;



  /**
   * runnable 인터페이스 대신 , Action이라는 별도의 인터페이스를 사용해서 , 구체적액션 결합을 제거한다
   */
  public void addAction(final Action action) {
    this.actions.add(action);
  }

  public int count() {
//    throw new UnsupportedOperationException();
    return this.actions.size();
  }

  public void run() {
//    this.actions.forEach(Action::perForm);
    this.actions.forEach(action -> action.perForm(facts));
  }

  public BusinessRuleEngine(Facts facts)
  {
    this.actions = new ArrayList<>();
    this.facts = facts;
  }


}
