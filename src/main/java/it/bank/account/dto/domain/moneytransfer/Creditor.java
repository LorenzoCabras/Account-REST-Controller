package it.bank.account.dto.domain.moneytransfer;
public class Creditor {
    private String name;
    private Account account;
    private Address address;

    public Creditor(String name, Account account, Address address) {
        this.name = name;
        this.account = account;
        this.address = address;
    }

    public Creditor() {
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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Creditor{" +
                "name='" + name + '\'' +
                ", account=" + account +
                ", address=" + address +
                '}';
    }
}

