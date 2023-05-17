package com.example.oopstudy;

import com.example.oopstudy.domain.BankTransaction;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class BankStatementProcessor {

  // 모든연산에서 ,메서드인수인 입출금내역목록을 공유. 필드로 뺀다

  private final List<BankTransaction> bankTransactions;

  public BankStatementProcessor(List<BankTransaction> bankTransaction) {
    this.bankTransactions = bankTransaction;
  }


  public double calculateTotalAmount() {
    double total = 0d;

    for (final BankTransaction bankTransaction : bankTransactions) {
      total += bankTransaction.getAmount();
    }

    return total;
  }

  public double calculateTotalInMonth(final Month month) {
    double total = 0d;

    for (final BankTransaction bankTransaction : bankTransactions) {
      if (bankTransaction.getDate().getMonth() == month) {
        total += bankTransaction.getAmount();
      }
    }
    return total;
  }

  public double calculateForCategory(final String category) {
    double total = 0d;

    for (final BankTransaction bankTransaction : bankTransactions) {
      if (bankTransaction.getDescription().equals(category)) {
        total += bankTransaction.getAmount();
      }
    }

    return total;

  }


}
