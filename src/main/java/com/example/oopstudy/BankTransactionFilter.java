package com.example.oopstudy;

import com.example.oopstudy.domain.BankTransaction;


@FunctionalInterface
public interface BankTransactionFilter {

  boolean test(BankTransaction bankTransaction);

}
