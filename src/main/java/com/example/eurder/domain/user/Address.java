package com.example.eurder.domain.user;

import com.example.eurder.domain.Views;
import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotEmpty;
import java.util.Objects;

@Embeddable
public class Address {

    @Column(name = "street")
    @JsonView(Views.Public.class)
    @NotEmpty(message = "street can't be empty")
    private String street;

    @Column(name = "houseNumber")
    @JsonView(Views.Public.class)
    @NotEmpty(message = "house number can't be empty")
    private String houseNumber;

    @Column(name = "zipp")
    @JsonView(Views.Public.class)
    @NotEmpty(message = "zipp can't be empty")
    private String zipp;

    @Column(name = "city")
    @JsonView(Views.Public.class)
    private String city;

    @Column(name = "country")
    @JsonView(Views.Public.class)
    @NotEmpty(message = "country can't be empty")
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
