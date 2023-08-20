package it.bank.account.dto.domain;

import java.time.LocalDate;
import java.util.Objects;


public class Balance {
    private LocalDate date;
    private double balance;
    private double availableBalance;
    private String currency;

    public Balance(){}
    public Balance(LocalDate date, double balance, double availableBalance, String currency) {
        this.date = date;
        this.balance = balance;
        this.availableBalance = availableBalance;
        this.currency = currency;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getAvailableBalance() {
        return availableBalance;
    }

    public void setAvailableBalance(double availableBalance) {
        this.availableBalance = availableBalance;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Balance balance1 = (Balance) o;
        return Double.compare(balance, balance1.balance) == 0 && Double.compare(availableBalance, balance1.availableBalance) == 0 && Objects.equals(date, balance1.date) && Objects.equals(currency, balance1.currency);
    }

    @Override
    public int hashCode() {
        return Objects.hash(date, balance, availableBalance, currency);
    }
}
