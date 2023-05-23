package com.example.oopstudy.DocumentManagement;

import static com.example.oopstudy.DocumentManagement.Attributes.PATH;
import static java.util.stream.Collectors.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;


/**
 * 도메인 클래스 , 반복되는 복사붙여넣기작업 -> 도메인클래스의 필요성 , 등장
 */
public class TextFile {


  private final Map<String, String> attributes;

  private final List<String> lines;


  public TextFile(final File file) throws IOException {
    attributes = new HashMap<>();
    attributes.put(PATH, file.getPath());
    lines = Files.lines(file.toPath()).collect(toList());
  }

  public Map<String, String> getAttributes() {
    return attributes;
  }

  int addLines(final int start, final Predicate<String> isEnd, final String attributesName) {

    final StringBuilder accumulator = new StringBuilder();
    int lineNumber;

    for (lineNumber = start; lineNumber < lines.size(); lineNumber++) {

      final String line = lines.get(lineNumber);

      if (isEnd.test(line)) {
        break;
      }

      accumulator.append(line);
      accumulator.append("\n");
    }

    attributes.put(attributesName, accumulator.toString().trim());
    return lineNumber;
  }


  void addLineSuffix(final String prefix, final String attributesName) {
    for (final String line : lines) {
      if (line.startsWith(prefix)) {
        attributes.put(attributesName, line.substring(prefix.length()));
        break;
      }
    }

  }


}
