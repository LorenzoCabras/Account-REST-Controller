package it.bank.account.adapter;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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
@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class AccountsAdapter {
    private static final Logger LOGGER = Logger.getLogger(AccountsAdapter.class.getName());
    private final ContoPort contoPort;

    @Autowired
    public AccountsAdapter(ContoPort contoPort) {
        this.contoPort = contoPort;
    }
    @Operation(summary = "Retrieve a list of transactions for a specific account within a given time range")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "404", description = "Account not found")
    })
    @RequestMapping(value = "/api/accounts/{accountId}/transactions", method = RequestMethod.GET)
    public ResponseEntity<List<Transaction>> getTransactions(@PathVariable Long accountId,
                                                             @RequestParam String fromAccountingDate,
                                                             @RequestParam String toAccountingDate) {
        LOGGER.info("AccountsAdapter - getTransactions");
        try {
            List<Transaction> transactions = contoPort.getTransactions(accountId, LocalDate.parse(fromAccountingDate), LocalDate.parse(toAccountingDate));
            LOGGER.info("Transactions fetched successfully");
            return new ResponseEntity<>(transactions, HttpStatus.OK);
        } catch (ContoPortException e) {
            LOGGER.severe("AccountsAdapter - ERROR: " + e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            LOGGER.severe("AccountsAdapter - ERROR: " + e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Operation(summary = "Make a new money transfer")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "400", description = "Bad Request")
    })
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
        } catch (Exception e) {
            LOGGER.severe("AccountsAdapter - ERROR: " + e.getMessage());
            MoneyTransferRestResponse errorResponse = new MoneyTransferRestResponse();
            errorResponse.setErrorMessage("An unexpected error occurred");
            return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Method to retrieve the balance, which takes 'accountId' as a parameter and sends a GET to the API by invoking the getBalance of 'contoPort'.
    @Operation(summary = "Retrieves the balance of a specific cash account")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "404", description = "Account not found")
    })
    @RequestMapping(value = "/api/accounts/{accountId}/balance", method = RequestMethod.GET)
    public ResponseEntity<Balance> getBalance(@PathVariable Long accountId) {
        LOGGER.info("AccountsAdapter - getBalance");
        try {
            Balance balance = contoPort.getBalance(accountId);
            LOGGER.info("Balance fetched successfully");
            return new ResponseEntity<>(balance, HttpStatus.OK);
        } catch (ContoPortException e) {
            LOGGER.severe("AccountsAdapter - ERROR: " + e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            LOGGER.severe("AccountsAdapter - ERROR: " + e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
