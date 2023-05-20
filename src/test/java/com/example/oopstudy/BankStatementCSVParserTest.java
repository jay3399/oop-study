package com.example.oopstudy;

import static org.assertj.core.api.Assertions.*;

import com.example.oopstudy.BankTransaction.BankStatementCSVParser;
import com.example.oopstudy.BankTransaction.BankStatementParser;
import com.example.oopstudy.BankTransaction.domain.BankTransaction;
import java.time.LocalDate;
import java.time.Month;
import org.junit.jupiter.api.Test;

class BankStatementCSVParserTest {


  private final BankStatementParser bankStatementParser = new BankStatementCSVParser();


  @Test
  public void shouldParseOneCorrectLine() throws Exception {

    final String line = "30-01-2017,-50,Tesco";

    final BankTransaction result = bankStatementParser.parseFrom(line);

    final BankTransaction expected = new BankTransaction(LocalDate.of(2017, Month.JANUARY, 30), -50,
        "Tesco");

    final double tolerance = 0.0d;

    assertThat(result.getDate()).isEqualTo(expected.getDate());
    assertThat(result.getAmount()).isEqualTo(expected.getAmount());
    assertThat(result.getDescription()).isEqualTo(expected.getDescription());






  }


}