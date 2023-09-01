package it.bank.account.controller;

import it.bank.account.adapter.FabrickRestAdapter;
import it.bank.account.adapter.MongoTransactionAdapter;
import it.bank.account.domain.port.FabrickPort;
import it.bank.account.domain.port.TransactionRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@ComponentScan(basePackages = "it.bank.account")
@EnableMongoRepositories(basePackages = "it.bank.account")
public class ControllerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ControllerApplication.class, args);
	}
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

	@Bean
	public FabrickPort notificationSender() {
		return new FabrickRestAdapter();
	}
	@Bean
	public MongoTransactionAdapter mongoTransactionAdapter(TransactionRepository transactionRepository) {
		return new MongoTransactionAdapter(transactionRepository);
	}

}
