package com.example.oopstudy;

import com.example.oopstudy.BankTransaction.BankStatementCSVParser;
import com.example.oopstudy.BankTransaction.BankStatementParser;
import com.example.oopstudy.BankTransaction.BankTransactionAnalyzerSimple;
import com.example.oopstudy.Business.BusinessRuleEngine;
import com.example.oopstudy.Business.Facts;
import com.example.oopstudy.Business.Stage;
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

		Facts facts = new Facts();

//		var facts = new Facts();  ,  가독성에 문제가 없을떄만! 사용한다 .

		facts.addFacts("jobTitle", "CEO");

		BusinessRuleEngine businessRuleEngine = new BusinessRuleEngine(facts);


		businessRuleEngine.addAction(
				facts1 -> {
					var jobTitle = facts.getFact("jobTitle");
					System.out.println("jobTitle = " + jobTitle);
				}
		);

		businessRuleEngine.addAction(
				facts1 ->{
					var forecastedAmount = 0.0;
					var dealStage = Stage.valueOf(facts1.getFact("stage"));
					var amount = Double.parseDouble(facts1.getFact("amount"));

					if (dealStage == Stage.LEAD) {
						forecastedAmount = amount * 0.2;
					} else if (dealStage == Stage.EVALUATING) {
						forecastedAmount = amount * 0.5;
					} else if (dealStage == Stage.INTERESTED) {
						forecastedAmount = amount * 0.5;
					} else if (dealStage == Stage.CLOSED) {
						forecastedAmount = amount;
					}
					facts.addFacts("forecastedAmount", String.valueOf(forecastedAmount));
				}
		);


		businessRuleEngine.addAction(
				facts1 -> {
					var forecastedAmount = 0.0;
					var dealStage = Stage.valueOf(facts1.getFact("stage"));
					var amount = Double.parseDouble(facts1.getFact("amount"));
					switch (dealStage) {
						case LEAD:
							forecastedAmount = amount * 0.2;
							break;
						case EVALUATING:
							forecastedAmount = amount * 0.5;
							break;
						case INTERESTED:
							forecastedAmount = amount * 0.8;
							break;
						case CLOSED:
							forecastedAmount = amount;
							break;
					}
				}
		);

		/**
		 * JDK 14 이후부터 지원  , enum의 모든값을 스위치에서 소모했는지 확인이 가능
		 */
//
//		businessRuleEngine.addAction(
//				facts1 -> {
//
//					var dealStage = Stage.valueOf(facts1.getFact("stage"));
//					var amount = Double.parseDouble(facts1.getFact("amount"));
//
//					var forecastedAmount = amount * switch (dealStage) {
//						case LEAD -> 0.2;
//						case EVALUATING -> 0.5;
//						case INTERESTED -> 0.8;
//						case CLOSED -> 1;
//					};
//
//				}
//		);
//




	}

}




