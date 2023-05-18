package com.example.oopstudy;

import java.io.IOException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// 도메인모델링  -> 유스케이스  -> 요구사항 도메인모델에 메세지 수행 객체식별후 , 역할부여 책임할당
// 설계는 대략적으로만 해주고 , 구현을 직접하면서 그에맞게 맞춰가야한다

@SpringBootApplication
public class OopStudyApplication {

	public static void main(String[] args) throws IOException {
		SpringApplication.run(OopStudyApplication.class, args);

		final BankTransactionAnalyzerSimple bankTransactionAnalyzerSimple = new BankTransactionAnalyzerSimple();

		final BankStatementParser bankStatementParser = new BankStatementCSVParser();

		bankTransactionAnalyzerSimple.analyze(args[0], bankStatementParser);




	}

}




