package com.example.oopstudy;

import com.example.oopstudy.domain.SummaryStatistics;

public interface Exporter {

  /**
   * void 반환형식은 아무 도움이 되지않고 , 기능 파악도 힘들다 테스트또한 어렵다
   */
//  void export(SummaryStatistics summaryStatistics);

  String export(SummaryStatistics summaryStatistics);


}
