package it.bank.account.dto.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.Objects;
@Document(collection = "transactions")
public class Transaction {
    @Id
    private long transactionId;
    private long operationId;
    private LocalDate accountingDate;
    private LocalDate valueDate;
    private TransactionType type;
    private double amount;
    private String currency;
    private String description;

    public Transaction(long transactionId, long operationId, LocalDate accountingDate, LocalDate valueDate, TransactionType type, double amount, String currency, String description) {
        this.transactionId = transactionId;
        this.operationId = operationId;
        this.accountingDate = accountingDate;
        this.valueDate = valueDate;
        this.type = type;
        this.amount = amount;
        this.currency = currency;
        this.description = description;
    }

    public Transaction() {
    }

    public long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(long transactionId) {
        this.transactionId = transactionId;
    }

    public long getOperationId() {
        return operationId;
    }

    public void setOperationId(long operationId) {
        this.operationId = operationId;
    }

    public LocalDate getAccountingDate() {
        return accountingDate;
    }

    public void setAccountingDate(LocalDate accountingDate) {
        this.accountingDate = accountingDate;
    }

    public LocalDate getValueDate() {
        return valueDate;
    }

    public void setValueDate(LocalDate valueDate) {
        this.valueDate = valueDate;
    }

    public TransactionType getType() {
        return type;
    }

    public void setType(TransactionType type) {
        this.type = type;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transaction that = (Transaction) o;
        return transactionId == that.transactionId && operationId == that.operationId && Double.compare(amount, that.amount) == 0 && Objects.equals(accountingDate, that.accountingDate) && Objects.equals(valueDate, that.valueDate) && Objects.equals(type, that.type) && Objects.equals(currency, that.currency) && Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(transactionId, operationId, accountingDate, valueDate, type, amount, currency, description);
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "transactionId=" + transactionId +
                ", operationId=" + operationId +
                ", accountingDate=" + accountingDate +
                ", valueDate=" + valueDate +
                ", type=" + type +
                ", amount=" + amount +
                ", currency='" + currency + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
