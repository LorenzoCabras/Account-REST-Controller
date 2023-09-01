package it.bank.account.adapter;

import it.bank.account.domain.port.TransactionPort;
import it.bank.account.domain.port.TransactionRepository;
import it.bank.account.dto.domain.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

public class MongoTransactionAdapter implements TransactionPort {
    private final TransactionRepository transactionRepository;
    @Autowired
    public MongoTransactionAdapter(TransactionRepository tr) {
        this.transactionRepository = tr;
    }
    @Override
    public void saveTransactions(List<Transaction> transactions) {
        transactionRepository.saveAll(transactions);
    }

}
