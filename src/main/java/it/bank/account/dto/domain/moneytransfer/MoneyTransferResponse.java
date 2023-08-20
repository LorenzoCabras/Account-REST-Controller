package it.bank.account.dto.domain.moneytransfer;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

public class MoneyTransferResponse {
    private String moneyTransferId;
    private String status;
    private String direction;
    private Creditor creditor;
    private Debtor debtor;
    private String cro;
    private String uri;
    private String trn;
    private String description;
    private LocalDate createdDatetime;
    private LocalDate accountedDatetime;
    private LocalDate debtorValueDate;
    private LocalDate creditorValueDate;
    private Amount amount;
    private boolean isUrgent;
    private boolean isInstant;
    private String feeType;
    private String feeAccountId;
    private List<Fee> fees;
    private boolean hasTaxRelief;

    public MoneyTransferResponse() {
    }

    public MoneyTransferResponse(String moneyTransferId, String status, String direction, Creditor creditor, Debtor debtor, String cro, String uri, String trn, String description, LocalDate createdDatetime, LocalDate accountedDatetime, LocalDate debtorValueDate, LocalDate creditorValueDate, Amount amount, boolean isUrgent, boolean isInstant, String feeType, String feeAccountId, List<Fee> fees, boolean hasTaxRelief) {
        this.moneyTransferId = moneyTransferId;
        this.status = status;
        this.direction = direction;
        this.creditor = creditor;
        this.debtor = debtor;
        this.cro = cro;
        this.uri = uri;
        this.trn = trn;
        this.description = description;
        this.createdDatetime = createdDatetime;
        this.accountedDatetime = accountedDatetime;
        this.debtorValueDate = debtorValueDate;
        this.creditorValueDate = creditorValueDate;
        this.amount = amount;
        this.isUrgent = isUrgent;
        this.isInstant = isInstant;
        this.feeType = feeType;
        this.feeAccountId = feeAccountId;
        this.fees = fees;
        this.hasTaxRelief = hasTaxRelief;
    }

    public String getMoneyTransferId() {
        return moneyTransferId;
    }

    public void setMoneyTransferId(String moneyTransferId) {
        this.moneyTransferId = moneyTransferId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public Creditor getCreditor() {
        return creditor;
    }

    public void setCreditor(Creditor creditor) {
        this.creditor = creditor;
    }

    public Debtor getDebtor() {
        return debtor;
    }

    public void setDebtor(Debtor debtor) {
        this.debtor = debtor;
    }

    public String getCro() {
        return cro;
    }

    public void setCro(String cro) {
        this.cro = cro;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getTrn() {
        return trn;
    }

    public void setTrn(String trn) {
        this.trn = trn;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getCreatedDatetime() {
        return createdDatetime;
    }

    public void setCreatedDatetime(LocalDate createdDatetime) {
        this.createdDatetime = createdDatetime;
    }

    public LocalDate getAccountedDatetime() {
        return accountedDatetime;
    }

    public void setAccountedDatetime(LocalDate accountedDatetime) {
        this.accountedDatetime = accountedDatetime;
    }

    public LocalDate getDebtorValueDate() {
        return debtorValueDate;
    }

    public void setDebtorValueDate(LocalDate debtorValueDate) {
        this.debtorValueDate = debtorValueDate;
    }

    public LocalDate getCreditorValueDate() {
        return creditorValueDate;
    }

    public void setCreditorValueDate(LocalDate creditorValueDate) {
        this.creditorValueDate = creditorValueDate;
    }

    public Amount getAmount() {
        return amount;
    }

    public void setAmount(Amount amount) {
        this.amount = amount;
    }

    public boolean isUrgent() {
        return isUrgent;
    }

    public void setUrgent(boolean urgent) {
        isUrgent = urgent;
    }

    public boolean isInstant() {
        return isInstant;
    }

    public void setInstant(boolean instant) {
        isInstant = instant;
    }

    public String getFeeType() {
        return feeType;
    }

    public void setFeeType(String feeType) {
        this.feeType = feeType;
    }

    public String getFeeAccountId() {
        return feeAccountId;
    }

    public void setFeeAccountId(String feeAccountId) {
        this.feeAccountId = feeAccountId;
    }

    public List<Fee> getFees() {
        return fees;
    }

    public void setFees(List<Fee> fees) {
        this.fees = fees;
    }

    public boolean isHasTaxRelief() {
        return hasTaxRelief;
    }

    public void setHasTaxRelief(boolean hasTaxRelief) {
        this.hasTaxRelief = hasTaxRelief;
    }

// Inner class
    public static class Debtor {
        private String name;
        private Account account;

    public Debtor(String name, Account account) {
        this.name = name;
        this.account = account;
    }

    @Override
    public String toString() {
        return "Debtor{" +
                "name='" + name + '\'' +
                ", account=" + account +
                '}';
    }

    public Debtor() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}

// Inner class
    public static class Amount {
        private double debtorAmount;
        private String debtorCurrency;
        private double creditorAmount;
        private String creditorCurrency;
        private String creditorCurrencyDate;
        private double exchangeRate;

    public Amount(double debtorAmount, String debtorCurrency, double creditorAmount, String creditorCurrency, String creditorCurrencyDate, double exchangeRate) {
        this.debtorAmount = debtorAmount;
        this.debtorCurrency = debtorCurrency;
        this.creditorAmount = creditorAmount;
        this.creditorCurrency = creditorCurrency;
        this.creditorCurrencyDate = creditorCurrencyDate;
        this.exchangeRate = exchangeRate;
    }

    @Override
    public String toString() {
        return "Amount{" +
                "debtorAmount=" + debtorAmount +
                ", debtorCurrency='" + debtorCurrency + '\'' +
                ", creditorAmount=" + creditorAmount +
                ", creditorCurrency='" + creditorCurrency + '\'' +
                ", creditorCurrencyDate='" + creditorCurrencyDate + '\'' +
                ", exchangeRate=" + exchangeRate +
                '}';
    }

    public Amount() {
    }

    public double getDebtorAmount() {
        return debtorAmount;
    }

    public void setDebtorAmount(double debtorAmount) {
        this.debtorAmount = debtorAmount;
    }

    public String getDebtorCurrency() {
        return debtorCurrency;
    }

    public void setDebtorCurrency(String debtorCurrency) {
        this.debtorCurrency = debtorCurrency;
    }

    public double getCreditorAmount() {
        return creditorAmount;
    }

    public void setCreditorAmount(double creditorAmount) {
        this.creditorAmount = creditorAmount;
    }

    public String getCreditorCurrency() {
        return creditorCurrency;
    }

    public void setCreditorCurrency(String creditorCurrency) {
        this.creditorCurrency = creditorCurrency;
    }

    public String getCreditorCurrencyDate() {
        return creditorCurrencyDate;
    }

    public void setCreditorCurrencyDate(String creditorCurrencyDate) {
        this.creditorCurrencyDate = creditorCurrencyDate;
    }

    public double getExchangeRate() {
        return exchangeRate;
    }

    public void setExchangeRate(double exchangeRate) {
        this.exchangeRate = exchangeRate;
    }
}

// Inner class
    public static class Fee {
        private String feeCode;
        private String description;
        private double amount;
        private String currency;

    public Fee(String feeCode, String description, double amount, String currency) {
        this.feeCode = feeCode;
        this.description = description;
        this.amount = amount;
        this.currency = currency;
    }

    @Override
    public String toString() {
        return "Fee{" +
                "feeCode='" + feeCode + '\'' +
                ", description='" + description + '\'' +
                ", amount=" + amount +
                ", currency='" + currency + '\'' +
                '}';
    }

    public Fee() {
    }

    public String getFeeCode() {
        return feeCode;
    }

    public void setFeeCode(String feeCode) {
        this.feeCode = feeCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MoneyTransferResponse that = (MoneyTransferResponse) o;
        return isUrgent == that.isUrgent && isInstant == that.isInstant && hasTaxRelief == that.hasTaxRelief && Objects.equals(moneyTransferId, that.moneyTransferId) && Objects.equals(status, that.status) && Objects.equals(direction, that.direction) && Objects.equals(creditor, that.creditor) && Objects.equals(debtor, that.debtor) && Objects.equals(cro, that.cro) && Objects.equals(uri, that.uri) && Objects.equals(trn, that.trn) && Objects.equals(description, that.description) && Objects.equals(createdDatetime, that.createdDatetime) && Objects.equals(accountedDatetime, that.accountedDatetime) && Objects.equals(debtorValueDate, that.debtorValueDate) && Objects.equals(creditorValueDate, that.creditorValueDate) && Objects.equals(amount, that.amount) && Objects.equals(feeType, that.feeType) && Objects.equals(feeAccountId, that.feeAccountId) && Objects.equals(fees, that.fees);
    }

    @Override
    public int hashCode() {
        return Objects.hash(moneyTransferId, status, direction, creditor, debtor, cro, uri, trn, description, createdDatetime, accountedDatetime, debtorValueDate, creditorValueDate, amount, isUrgent, isInstant, feeType, feeAccountId, fees, hasTaxRelief);
    }

    @Override
    public String toString() {
        return "MoneyTransferResponse{" +
                "moneyTransferId='" + moneyTransferId + '\'' +
                ", status='" + status + '\'' +
                ", direction='" + direction + '\'' +
                ", creditor=" + creditor +
                ", debtor=" + debtor +
                ", cro='" + cro + '\'' +
                ", uri='" + uri + '\'' +
                ", trn='" + trn + '\'' +
                ", description='" + description + '\'' +
                ", createdDatetime='" + createdDatetime + '\'' +
                ", accountedDatetime='" + accountedDatetime + '\'' +
                ", debtorValueDate='" + debtorValueDate + '\'' +
                ", creditorValueDate='" + creditorValueDate + '\'' +
                ", amount=" + amount +
                ", isUrgent=" + isUrgent +
                ", isInstant=" + isInstant +
                ", feeType='" + feeType + '\'' +
                ", feeAccountId='" + feeAccountId + '\'' +
                ", fees=" + fees +
                ", hasTaxRelief=" + hasTaxRelief +
                '}';
    }
}
