package com.example.eurder.domain.user;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable
public class Address {

    @Column(name = "street")
    private String street;

    @Column(name = "houseNumber")
    private String houseNumber;

    @Column(name = "zipp")
    private String zipp;

    @Column(name = "city")
    private String city;

    @Column(name = "country")
    private String country;

    public Address(String street, String houseNumber, String zipp, String city, String country) {
        this.street = street;
        this.houseNumber = houseNumber;
        this.zipp = zipp;
        this.city = city;
        this.country = country;
    }

    public Address() {
    }

    public String getStreet() {
        return street;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public String getZipp() {
        return zipp;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return Objects.equals(getStreet(), address.getStreet()) &&
                Objects.equals(getHouseNumber(), address.getHouseNumber()) &&
                Objects.equals(getZipp(), address.getZipp()) &&
                Objects.equals(getCity(), address.getCity()) &&
                Objects.equals(getCountry(), address.getCountry());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getStreet(), getHouseNumber(), getZipp(), getCity(), getCountry());
    }
}
