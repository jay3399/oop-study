package com.example.oopstudy;

import com.example.oopstudy.domain.BankTransaction;

@FunctionalInterface
public interface BankTransactionSummarizer {

  double summarize(double accumulator, BankTransaction transaction);

}
