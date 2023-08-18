package it.bank.account.domain.port;

import it.bank.account.domain.port.exceptions.FabrickException;
import it.bank.account.dto.domain.Balance;
import it.bank.account.dto.domain.moneytransfer.MoneyTransferRequest;
import it.bank.account.dto.domain.moneytransfer.MoneyTransferResponse;
import it.bank.account.dto.fabrick.FabrickResponse;
import it.bank.account.dto.domain.TransactionList;

import java.time.LocalDate;

public interface FabrickPort {
    FabrickResponse<Balance> getBalance(long accountId) throws FabrickException;
    FabrickResponse<TransactionList> getTransactions(long accountId, LocalDate fromDate, LocalDate toDate)  throws FabrickException;
    FabrickResponse<MoneyTransferResponse> createMoneyTransfer(Long accountId, MoneyTransferRequest moneyTransferRequest) throws FabrickException;
}
