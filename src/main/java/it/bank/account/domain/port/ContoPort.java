package it.bank.account.domain.port;

import it.bank.account.domain.port.exceptions.ContoPortException;
import it.bank.account.dto.domain.Balance;
import it.bank.account.dto.domain.moneytransfer.MoneyTransferRequest;
import it.bank.account.dto.domain.moneytransfer.MoneyTransferResponse;
import it.bank.account.dto.domain.Transaction;
import it.bank.account.dto.rest.MoneyTransferRestRequest;

import java.time.LocalDate;
import java.util.List;

public interface ContoPort {
        public Balance getBalance(long accountId) throws ContoPortException;
        public MoneyTransferResponse createMoneyTransfer(Long accountId, MoneyTransferRestRequest moneyTransferRestRequestRequest) throws ContoPortException;
        public List<Transaction> getTransactions(long accountId, LocalDate fromDate, LocalDate toDate) throws ContoPortException;;
}
