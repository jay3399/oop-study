package com.example.oopstudy.BankTransaction;

import com.example.oopstudy.BankTransaction.domain.BankTransaction;
import java.time.Month;

public class BankTransactionInFebAndExpensive implements BankTransactionFilter {

  @Override
  public boolean test(BankTransaction bankTransaction) {
    return bankTransaction.getDate().getMonth() == Month.FEBRUARY && bankTransaction.getAmount() > 1_000;
  }
}
