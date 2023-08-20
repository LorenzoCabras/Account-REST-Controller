package it.bank.account.dto.rest;

import java.util.Objects;

public class MoneyTransferRestRequest {
    private String creditorName;
    private String creditorAccountCode;
    private String description;
    private String currency;
    private String amount;
    private String executionDate;

    public MoneyTransferRestRequest() {
    }

    public MoneyTransferRestRequest(String creditorName, String creditorAccountCode, String description, String currency, String amount, String executionDate) {
        this.creditorName = creditorName;
        this.creditorAccountCode = creditorAccountCode;
        this.description = description;
        this.currency = currency;
        this.amount = amount;
        this.executionDate = executionDate;
    }

    public String getCreditorName() {
        return creditorName;
    }

    public void setCreditorName(String creditorName) {
        this.creditorName = creditorName;
    }

    public String getCreditorAccountCode() {
        return creditorAccountCode;
    }

    public void setCreditorAccountCode(String creditorAccountCode) {
        this.creditorAccountCode = creditorAccountCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getExecutionDate() {
        return executionDate;
    }

    public void setExecutionDate(String executionDate) {
        this.executionDate = executionDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MoneyTransferRestRequest that = (MoneyTransferRestRequest) o;
        return Objects.equals(creditorName, that.creditorName) && Objects.equals(creditorAccountCode, that.creditorAccountCode) && Objects.equals(description, that.description) && Objects.equals(currency, that.currency) && Objects.equals(amount, that.amount) && Objects.equals(executionDate, that.executionDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(creditorName, creditorAccountCode, description, currency, amount, executionDate);
    }
}
