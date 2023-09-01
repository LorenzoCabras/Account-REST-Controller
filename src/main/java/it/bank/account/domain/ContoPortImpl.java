package it.bank.account.domain;

import it.bank.account.domain.port.FabrickPort;
import it.bank.account.domain.port.TransactionPort;
import it.bank.account.domain.port.exceptions.ContoPortException;
import it.bank.account.domain.port.exceptions.FabrickException;
import it.bank.account.dto.domain.Balance;
import it.bank.account.dto.domain.moneytransfer.Account;
import it.bank.account.dto.domain.moneytransfer.Creditor;
import it.bank.account.dto.domain.moneytransfer.MoneyTransferRequest;
import it.bank.account.dto.domain.moneytransfer.MoneyTransferResponse;
import it.bank.account.dto.domain.Transaction;
import it.bank.account.domain.port.ContoPort;
import it.bank.account.dto.rest.MoneyTransferRestRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ContoPortImpl implements ContoPort {

    @Autowired
    private FabrickPort fabricAdapter;
    @Autowired
    private TransactionPort transactionPort;

    public ContoPortImpl() {
    }

    @Override
    public Balance getBalance(long accountId) throws ContoPortException {
        Balance result;
        try {
            return fabricAdapter.getBalance(accountId).getPayload();
        } catch (FabrickException e) {
            throw new ContoPortException(e.getMessage());
        }
    }

    @Override
    public MoneyTransferResponse createMoneyTransfer(Long accountId, MoneyTransferRestRequest moneyTransferRestRequest) throws ContoPortException {
        try {
            MoneyTransferRequest mtr = convertRestRequestToFullRequest(moneyTransferRestRequest);
            return fabricAdapter.createMoneyTransfer(accountId, mtr).getPayload();
        } catch (FabrickException e) {
            throw new ContoPortException(e.getMessage());
        }
    }

    //Converting the MoneyTransferRestRequest object into a MoneyTransferRequest object
    private MoneyTransferRequest convertRestRequestToFullRequest(MoneyTransferRestRequest restRequest) {
        MoneyTransferRequest fullRequest = new MoneyTransferRequest();
        fullRequest.setCreditor(new Creditor(restRequest.getCreditorName(), new Account(restRequest.getCreditorAccountCode(),null),null));
        fullRequest.setDescription(restRequest.getDescription());
        fullRequest.setCurrency(restRequest.getCurrency());
        fullRequest.setAmount(Double.parseDouble(restRequest.getAmount()));
        fullRequest.setExecutionDate(restRequest.getExecutionDate());
        return fullRequest;
    }
    @Override
    public List<Transaction> getTransactions(long accountId, LocalDate fromAccountingDate, LocalDate toAccountingDate) throws ContoPortException {
        try {
            List<Transaction> transactions = fabricAdapter.getTransactions(accountId, fromAccountingDate, toAccountingDate).getPayload().getList();
            transactionPort.saveTransactions(transactions);
            return transactions;
        } catch (FabrickException e) {
            throw new ContoPortException(e.getMessage());
        }
    }
}
