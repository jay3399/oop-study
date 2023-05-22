package com.example.oopstudy.DocumentManagement;

import static com.example.oopstudy.DocumentManagement.Attributes.*;

import java.io.File;
import java.io.IOException;
import java.util.Map;

public class InvoiceImporter implements Importer{

  private static final String NAME_PREFIX = "Dear ";
  private static final String AMOUNT_PREFIX = "Amount ";

  @Override
  public Document importFile(File file) throws IOException {
    final TextFile textFile = new TextFile(file);

    textFile.addLineSuffix(NAME_PREFIX, PATIENT);
    textFile.addLineSuffix(AMOUNT_PREFIX, AMOUNT);

    final Map<String, String> attributes = textFile.getAttributes();
    attributes.put("TYPE", "INVOICE");
    return new Document(attributes);
  }
}


//Amount: length:7
//0123456 : substring.index 는 7부터 .

