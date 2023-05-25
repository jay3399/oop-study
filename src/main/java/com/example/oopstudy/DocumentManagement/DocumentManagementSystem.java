package com.example.oopstudy.DocumentManagement;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UnknownFormatConversionException;
import javax.lang.model.type.UnknownTypeException;

public class DocumentManagementSystem {

  private final Map<String, Importer> extensionToImporter = new HashMap<>();

  private final List<Document> documents = new ArrayList<>();

  public void importFile(String path) throws IOException {

    final File file = new File(path);

    if (!file.exists()) {
      throw new FileNotFoundException();
    }

    final int separatorIndex = path.lastIndexOf('.');

    if (separatorIndex != -1) {
      if (separatorIndex == path.length()) {
        throw new UnknownFormatConversionException("No extension " + path);
      }
      final String extension = path.substring(separatorIndex + 1);

      final Importer importer = extensionToImporter.get(extension);

      if (importer == null) {
        throw new UnknownFormatConversionException("for file" + path);
      }

      final Document document = importer.importFile(file);

      documents.add(document);
    } else {
      throw new UnknownFormatConversionException("No extension" + path);
    }

  }

  public List<Document> contents() {
    return documents;
  }

  public DocumentManagementSystem() {
    extensionToImporter.put("letter", new LetterImporter());
    extensionToImporter.put("report", new ReportImporter());
    extensionToImporter.put("jpg", new ImageImporter());
  }
}
