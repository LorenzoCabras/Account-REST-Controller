package it.bank.account.dto.domain;

import java.util.Objects;

public class TransactionType {
    private String enumeration;
    private String value;

    public TransactionType(String enumeration, String value) {
        this.enumeration = enumeration;
        this.value = value;
    }

    public TransactionType() {
    }

    public String getEnumeration() {
        return enumeration;
    }

    public void setEnumeration(String enumeration) {
        this.enumeration = enumeration;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TransactionType that = (TransactionType) o;
        return Objects.equals(enumeration, that.enumeration) && Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(enumeration, value);
    }

    @Override
    public String toString() {
        return "TransactionType{" +
                "enumeration='" + enumeration + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
