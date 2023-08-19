package it.bank.account.adapter;

import it.bank.account.domain.port.ContoPort;
import it.bank.account.domain.port.exceptions.ContoPortException;
import it.bank.account.dto.domain.Balance;
import it.bank.account.dto.domain.Transaction;
import it.bank.account.dto.domain.moneytransfer.MoneyTransferResponse;
import it.bank.account.dto.rest.MoneyTransferRestRequest;
import it.bank.account.dto.rest.MoneyTransferRestResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.logging.Logger;

@ComponentScan(basePackages = "it.bank.account")
@RestController
public class AccountsAdapter {
    private static final Logger LOGGER = Logger.getLogger(AccountsAdapter.class.getName());
    private final ContoPort contoPort;

    @Autowired
    public AccountsAdapter(ContoPort contoPort) {
        this.contoPort = contoPort;
    }

    @RequestMapping(value = "/api/accounts/{accountId}/transactions", method = RequestMethod.GET)
    public ResponseEntity<List<Transaction>> getTransactions(@PathVariable Long accountId,
                                                             @RequestParam String fromAccountingDate,
                                                             @RequestParam String toAccountingDate) {
        try {
            List<Transaction> transactions = contoPort.getTransactions(accountId, LocalDate.parse(fromAccountingDate), LocalDate.parse(toAccountingDate));
            return new ResponseEntity<>(transactions, HttpStatus.OK);
        } catch (ContoPortException e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/api/accounts/{accountId}/moneyTransfer", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity<MoneyTransferRestResponse> createMoneyTransfer(@PathVariable Long accountId,
                                                                         @RequestBody MoneyTransferRestRequest mtr) {
        LOGGER.info("AccountsAdapter - createMoneyTransfer");
        try {
            MoneyTransferResponse response = contoPort.createMoneyTransfer(accountId, mtr);
            LOGGER.info("AccountsAdapter - Money transfer successful");
            MoneyTransferRestResponse restResponse = new MoneyTransferRestResponse();
            restResponse.setPayload(response);
            return new ResponseEntity<>(restResponse, HttpStatus.OK);
        } catch (ContoPortException e) {
            LOGGER.severe("AccountsAdapter - ERROR: " + e.getMessage());
            MoneyTransferRestResponse errorResponse = new MoneyTransferRestResponse();
            errorResponse.setErrorMessage("Error creating money transfer: " + e.getMessage());
            return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
        }
    }

    // Method to retrieve the balance, which takes 'accountId' as a parameter and sends a GET to the API by invoking the getBalance of 'contoPort'.
    @RequestMapping(value = "/api/accounts/{accountId}/balance", method = RequestMethod.GET)
    public ResponseEntity<Balance> getBalance(@PathVariable Long accountId) {
        try {
            Balance balance = contoPort.getBalance(accountId);
            return new ResponseEntity<>(balance, HttpStatus.OK);
        } catch (ContoPortException e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
