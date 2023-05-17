package com.example.oopstudy.domain;

import java.time.LocalDate;
import lombok.Data;

@Data
public class BankTransaction {

  private final LocalDate date;
  private final double amount;
  private final String description;




}
