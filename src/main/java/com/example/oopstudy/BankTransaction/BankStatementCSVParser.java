package com.example.oopstudy.BankTransaction;

import com.example.oopstudy.BankTransaction.domain.BankTransaction;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;


/**
 *  파싱기능을 , 다른클래스와 메서드에 위임 !
 *  Bank객체에서 직접 추출하기떄문에 내부 파싱방법 알필요가 없다.
 *  파싱기능은 독립적으로 구현이된것 , 캡슐화된기능 , 내부구조를 몰라도 상관없다 , 그저사용하면 될뿐
 *  만약 외부 요구사항이 바뀌어도 , 재사용이 가능해진다.
 *
 */

public class BankStatementCSVParser implements BankStatementParser {

  public static final DateTimeFormatter DATE_PATTERN = DateTimeFormatter.ofPattern("dd-MM-yyyy");

  public BankTransaction parseFrom(final String line) {

    final String[] columns = line.split(",");

    final LocalDate date = LocalDate.parse(columns[0], DATE_PATTERN);

    final double amount = Double.parseDouble(columns[1]);

    final String description = columns[2];

    return new BankTransaction(date, amount, description);


  }

  /**
   * Processor -> 라인파싱메세지전달 to Parser->  Parser 는 파싱책임을 갖고 자율적으로 파싱메서드를 실행 = Parser.parseLinesFrom
   * Processor 는 날짜 가격 설명만을 반환받으면 된다.
   * BankTransaction 이란 날짜/가격/설명을 갖고있는 캡슐화된 객체를 만들고 ,Parser 는 그것을 반환한다.
   * @param lines
   * @return
   */

  public List<BankTransaction> parseLinesFrom(final List<String> lines) {

    final List<BankTransaction> bankTransactions = new ArrayList<>();

    for (final String line : lines) {
      bankTransactions.add(parseFrom(line));
    }

    return bankTransactions;

  }



}
