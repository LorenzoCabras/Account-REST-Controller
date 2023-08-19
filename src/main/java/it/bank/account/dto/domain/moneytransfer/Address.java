package it.bank.account.dto.domain.moneytransfer;

public class Address {
    private String address;
    private String city;
    private String countryCode;

    public Address(String address, String city, String countryCode) {
        this.address = address;
        this.city = city;
        this.countryCode = countryCode;
    }

    public Address() {
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    @Override
    public String toString() {
        return "Address{" +
                "address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", countryCode='" + countryCode + '\'' +
                '}';
    }
}

