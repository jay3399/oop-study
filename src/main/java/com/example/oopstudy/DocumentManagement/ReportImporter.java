package com.example.oopstudy.DocumentManagement;

import static com.example.oopstudy.DocumentManagement.Attributes.*;

import java.io.File;
import java.io.IOException;
import java.util.Map;

public class ReportImporter implements Importer {


  private static final String PATIENT = "Patient: ";
  @Override
  public Document importFile(File file) throws IOException {
    TextFile textFile = new TextFile(file);

    textFile.addLineSuffix(PATIENT, Attributes.PATIENT);

    textFile.addLines(2, line -> {return false;}, BODY);

    Map<String, String> attributes = textFile.getAttributes();

    attributes.put(TYPE, "REPORT");

    return new Document(attributes);


  }
}
