package com.example.oopstudy.BankTransaction;

import com.example.oopstudy.BankTransaction.domain.BankTransaction;

@FunctionalInterface
public interface BankTransactionSummarizer {

  double summarize(double accumulator, BankTransaction transaction);

}
