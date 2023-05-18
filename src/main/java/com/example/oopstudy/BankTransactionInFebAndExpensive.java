package com.example.oopstudy;

import com.example.oopstudy.BankTransactionFilter;
import com.example.oopstudy.domain.BankTransaction;
import java.time.Month;

public class BankTransactionInFebAndExpensive implements BankTransactionFilter {

  @Override
  public boolean test(BankTransaction bankTransaction) {
    return bankTransaction.getDate().getMonth() == Month.FEBRUARY && bankTransaction.getAmount() > 1_000;
  }
}
