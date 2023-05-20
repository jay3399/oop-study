package com.example.oopstudy.DocumentManagement;

import java.io.File;
import java.io.IOException;

public interface Importer {

  /**
   *  공개 API는 , 다른종류의 사용자 인터페이스로 감싸진 상태  , 어떤 파일을 지원해야하는지 알 수 없다 . -> String 으로 간단하게 처리
   *  해당 인터페이스는 , 강한원칙을 적용 , 파일을 가르키는 전용형식을 사용하므로 오류발생범위 줄인다.
   */
  Document importFile(File file) throws IOException;

}
