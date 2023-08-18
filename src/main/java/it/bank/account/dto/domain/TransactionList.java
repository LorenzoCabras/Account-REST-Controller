package it.bank.account.dto.domain;

import java.util.List;

public class TransactionList {
    private List<Transaction> list;

    public List<Transaction> getList() {
        return list;
    }

    public void setList(List<Transaction> list) {
        this.list = list;
    }
}
