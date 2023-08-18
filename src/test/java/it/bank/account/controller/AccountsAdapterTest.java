package it.bank.account.controller;

import it.bank.account.dto.domain.Balance;
import it.bank.account.dto.domain.Transaction;
import it.bank.account.dto.domain.moneytransfer.MoneyTransferResponse;
import it.bank.account.dto.rest.MoneyTransferRestRequest;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.util.List;


@SpringBootTest
@RunWith(SpringRunner.class)
public class AccountsAdapterTest {
    private final long accountId = 14537780L;

    @Autowired
    private RestTemplate restTemplate;

    @Test
    public void testGetBalance(){
        ResponseEntity<Balance> response = restTemplate.getForEntity("http://localhost:8080/api/accounts/" + accountId +"/balance/", Balance.class);
        Assert.assertEquals(HttpStatus.OK, response.getStatusCode());
        Balance balance = response.getBody();
        Assert.assertNotNull(balance);
        Assert.assertNotNull(balance.getBalance());
    }
    @Test
    public void testGetTransactions() {
        String fromAccountingDate = "2019-01-01";
        String toAccountingDate = "2019-12-01";
        String url = String.format("http://localhost:8080/api/accounts/%d/transactions?fromAccountingDate=%s&toAccountingDate=%s", accountId, fromAccountingDate, toAccountingDate);
        ResponseEntity<List> response = restTemplate.getForEntity(url, List.class);
        Assert.assertEquals(HttpStatus.OK, response.getStatusCode());
        List<Transaction> transactionList = response.getBody();
        Assert.assertNotNull(transactionList);
    }

    @Test
    public void testCreateMoneyTransfer() {
        MoneyTransferRestRequest request = new MoneyTransferRestRequest();
        request.setCreditorName("John Doe");
        request.setCreditorAccountCode("IT07M0326849130052923801111");
        request.setDescription("Gift");
        request.setCurrency("EUR");
        request.setAmount("800.0");
        request.setExecutionDate("2023-08-01");
            ResponseEntity<MoneyTransferResponse> responseEntity = restTemplate.postForEntity(
                    "http://localhost:8080/api/accounts/" + accountId + "/moneyTransfer",
                    request,
                    MoneyTransferResponse.class
            );
            MoneyTransferResponse response = responseEntity.getBody();
            Assert.assertNotNull(response);

    }
}
