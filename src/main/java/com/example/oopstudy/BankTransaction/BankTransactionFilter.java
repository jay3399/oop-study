package com.example.oopstudy.BankTransaction;

import com.example.oopstudy.BankTransaction.domain.BankTransaction;


@FunctionalInterface
public interface BankTransactionFilter {

  boolean test(BankTransaction bankTransaction);

}
