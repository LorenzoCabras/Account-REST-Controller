package it.bank.account.dto.rest;

import it.bank.account.dto.domain.moneytransfer.MoneyTransferResponse;

import java.util.Objects;

public class MoneyTransferRestResponse{
    private MoneyTransferResponse payload;
    private String errorMessage;
    public MoneyTransferRestResponse(MoneyTransferResponse payload, String errorMessage) {
        this.payload = payload;
        this.errorMessage = errorMessage;
    }

    public MoneyTransferRestResponse() {
    }

    public MoneyTransferResponse getPayload() {
        return payload;
    }

    public void setPayload(MoneyTransferResponse payload) {
        this.payload = payload;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MoneyTransferRestResponse that = (MoneyTransferRestResponse) o;
        return Objects.equals(payload, that.payload) && Objects.equals(errorMessage, that.errorMessage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(payload, errorMessage);
    }
}
