package it.bank.account.domain.port;

import it.bank.account.dto.domain.Transaction;

import java.util.List;

public interface TransactionPort {
    void saveTransactions(List<Transaction> transactions);

}
