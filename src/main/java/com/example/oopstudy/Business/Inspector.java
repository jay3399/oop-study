package com.example.oopstudy.Business;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * 팩트 , 조건부액션 , 결과를 포함하는 리포트 모록을 반환
 */
public class Inspector {

  private final List<ConditionalAction> conditionalActionList;


  public Inspector(final ConditionalAction... conditionalActions) {
    this.conditionalActionList = Arrays.asList(conditionalActions);
  }

  public List<Report> inspect(final Facts facts) {

    final List<Report> reportList = new ArrayList<>();

    for (ConditionalAction conditionalAction : conditionalActionList) {
      final boolean conditionResult = conditionalAction.evaluate(facts);
      reportList.add(new Report(conditionalAction, facts, conditionResult));
    }

    return reportList;
  }

}
