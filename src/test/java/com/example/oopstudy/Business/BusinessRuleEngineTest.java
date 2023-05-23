package com.example.oopstudy.Business;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;


/**
 * 실페하는 테스트구현 -> 모든테스트실행 -> 기능이 동작하는 코드구현 -> 모든테스트 실행 -> * +리펙터링
 */
class BusinessRuleEngineTest {

  @Test
  void shouldHavaNoRulesInitially() {

    Facts facts = new Facts();

    BusinessRuleEngine businessRuleEngine = new BusinessRuleEngine(facts);

    int count = businessRuleEngine.count();

    Assertions.assertThat(count).isEqualTo(0);

  }
//
//  @Test
//  void shouldAddTwoActions() {
//
//    final BusinessRuleEngine businessRuleEngine = new BusinessRuleEngine();
//
//    businessRuleEngine.addAction(() -> {});
//    businessRuleEngine.addAction(() ->{});
//
//  }


  @Test
  void shouldExecuteOneAction() {
    final Facts facts = mock(Facts.class);

    final BusinessRuleEngine businessRuleEngine = new BusinessRuleEngine(facts);

    final Action mock = mock(Action.class);



    businessRuleEngine.addAction(mock);


    businessRuleEngine.run();

    verify(mock).perForm(facts);




  }
}

