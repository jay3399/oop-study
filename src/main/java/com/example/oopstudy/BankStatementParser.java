package com.example.oopstudy;

import com.example.oopstudy.domain.BankTransaction;
import java.util.List;


/**
 * 결합도
 * 어떤클래스가 , 구현시 얼마나 많은지식 ( 다른클래스 ) 을 참조했는가
 * 많은 클래스 참조시 , 기능변경시 유면성 -- , 어떤 클래스의 코드를 바꾸면 이클래스에 의존하는 모든클래스가 바뀌어버린다
 *
 * 시계 -> 내부기능 몰라도 , 내부기능이 바뀌어도 , 사용하는데는 문제가없다
 * 인터페이스와 구현이 결합이 안돼있다
 *
 * statementProcessor 는 CSV에 의존 , JSON XML 을 지원하게하려면 리펙토링 작업이필요
 *
 */

public interface BankStatementParser {

  BankTransaction parseFrom(String line);

  List<BankTransaction> parseLinesFrom(List<String> lines);



}
