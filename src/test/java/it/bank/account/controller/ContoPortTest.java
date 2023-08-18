package it.bank.account.controller;

import it.bank.account.domain.port.exceptions.ContoPortException;
import it.bank.account.dto.domain.Balance;
import it.bank.account.domain.port.ContoPort;
import it.bank.account.dto.domain.Transaction;
import it.bank.account.dto.rest.MoneyTransferRestRequest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.List;


@SpringBootTest
@RunWith(SpringRunner.class)
class ContoPortTest {
	@Autowired
	ContoPort contoPort;

	@Test
	public void getBalance() throws ContoPortException {
		Balance response = contoPort.getBalance(14537780L);
		Assertions.assertNotNull(response);
		Assertions.assertNotNull(response.getBalance());
	}
	@Test
	public void getTransactions() throws ContoPortException {
		LocalDate fromAccountingDate = LocalDate.of(2019,01,01);
		LocalDate toAccountingDate = LocalDate.of(2019,12,01);

		List<Transaction> transactions = contoPort.getTransactions(14537780L, fromAccountingDate, toAccountingDate);

		Assertions.assertNotNull(transactions);
		Assertions.assertTrue(transactions.size() >= 0);
	}

	@Test
	public void createMoneyTransfer() throws ContoPortException {
		MoneyTransferRestRequest mtrr = new MoneyTransferRestRequest();
		mtrr.setCreditorName("John Doe");
		mtrr.setCreditorAccountCode("IT07M0326849130052923801111");
		mtrr.setDescription("Gift");
		mtrr.setCurrency("EUR");
		mtrr.setAmount("800.0");
		mtrr.setExecutionDate("2023-08-01");
		Assertions.assertThrows(ContoPortException.class, ()-> contoPort.createMoneyTransfer(14537780L, mtrr));

	}


}
