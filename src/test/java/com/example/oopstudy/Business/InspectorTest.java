package com.example.oopstudy.Business;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class InspectorTest {

  @Test
  void inspectOneConditionEvaluatesTrue() {

    final Facts facts = new Facts();

    facts.addFacts("jobTitle", "CEO");

    final ConditionalAction conditionalAction = new JobTitleCondition();

    final Inspector inspector = new Inspector(conditionalAction);

    final List<Report> reportList = inspector.inspect(facts);

    Assertions.assertThat(reportList.size()).isEqualTo(1);
    Assertions.assertThat(reportList.get(0).isPositive()).isEqualTo(true);



  }

  private static class JobTitleCondition implements ConditionalAction{
    @Override
    public boolean evaluate(Facts facts) {
      return "CEO".equals(facts.getFact("jobTitle"));

    }

    @Override
    public void perform(Facts facts) {
      throw new UnsupportedOperationException();
    }
  }
}