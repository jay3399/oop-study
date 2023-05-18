package com.example.oopstudy;

import com.example.oopstudy.domain.BankTransaction;
import com.example.oopstudy.domain.SummaryStatistics;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class BankStatementProcessor {

  // 모든연산에서 ,메서드인수인 입출금내역목록을 공유. 필드로 뺀다
  private final List<BankTransaction> bankTransactions;

  public BankStatementProcessor(List<BankTransaction> bankTransaction) {
    this.bankTransactions = bankTransaction;
  }


  /**
   * 거래내역의 여러속성을 조합할수록 복잡해진다 반복로직 , 비지니스가 결합되어 분리가 어려움 코드가 반복 반복로직과 , 비지니스로직이 결합돼있다 -> 인터페이스로 분리 ->
   * by 개방폐쇄원칙 , 코드를 직접바꾸지않고 해당 메서드나 클래스의 동작을 바꾼다
   */

  public double summarizeTransactions(final BankTransactionSummarizer bankTransactionSummarizer) {
    double result = 0;

    for (final BankTransaction bankTransaction : bankTransactions) {
      result = bankTransactionSummarizer.summarize(result, bankTransaction);
    }
    return result;
  }

  public double calculateTotalInMonth(final Month month) {
    return summarizeTransactions(
        ((accumulator, transaction) -> transaction.getDate().getMonth() == month ? accumulator
            + transaction.getAmount() : accumulator));
  }




  public List<BankTransaction> findTransaction(final BankTransactionFilter bankTransactionFilter) {

    final List<BankTransaction> result = new ArrayList<>();


    for (final BankTransaction bankTransaction : bankTransactions) {
      if (bankTransactionFilter.test(bankTransaction)) {
        result.add(bankTransaction);
      }
    }

    return result;
  }

  public List<BankTransaction> findTransactionsGreaterThanEqual(final int amount) {
    return findTransaction(bankTransaction -> bankTransaction.getAmount() >= amount);
  }






  public List<BankTransaction> findTransactionInMonthGraterAndGreater(final int amount, final Month month) {
    final List<BankTransaction> result = new ArrayList<>();

    for (final BankTransaction bankTransaction : bankTransactions) {
      if (bankTransaction.getDate().getMonth() == month && bankTransaction.getAmount() > amount) {
        result.add(bankTransaction);
      }
    }
    return result;
  }

  public List<BankTransaction> findTransactionThanGreater(final int amount) {
    final List<BankTransaction> result = new ArrayList<>();

    for (final BankTransaction bankTransaction : bankTransactions) {

      if (bankTransaction.getAmount() > amount) {
        result.add(bankTransaction);
      }

    }

    return result;
  }


  public List<BankTransaction> findTransactionInMonth(final Month month) {

    final List<BankTransaction> result = new ArrayList<>();

    for (final BankTransaction bankTransaction : bankTransactions) {
      if (bankTransaction.getDate().getMonth() == month) {
        result.add(bankTransaction);
      }
    }
    return result;

  }


  public double calculateTotalAmount() {
    double total = 0d;

    for (final BankTransaction bankTransaction : bankTransactions) {
      total += bankTransaction.getAmount();
    }

    return total;
  }

//  public double calculateTotalInMonth(final Month month) {
//    double total = 0d;
//
//    for (final BankTransaction bankTransaction : bankTransactions) {
//      if (bankTransaction.getDate().getMonth() == month) {
//        total += bankTransaction.getAmount();
//      }
//    }
//    return total;
//  }

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
