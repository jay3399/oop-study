package com.example.oopstudy.DocumentManagement;


import java.util.Map;

/**
 * 도메인 클래스를 사용시 , 개념에 이름을 붙이고 수행할수있는 동작과 값을 제한하므로 발견성을 개선 , 버그발생범위를 제한.
 */
public class Document {

  private final Map<String, String> attributes;

  Document(Map<String, String> attributes) {
    this.attributes = attributes;
  }

  public String getAttribute(final String attributeName) {
    return attributes.get(attributeName);
  }
}
