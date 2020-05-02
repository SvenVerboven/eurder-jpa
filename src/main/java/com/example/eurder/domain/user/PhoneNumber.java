package com.example.eurder.domain.user;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotEmpty;
import java.util.Objects;

@Embeddable
public class PhoneNumber {

    @Column(name = "countryCode")
    @NotEmpty(message = "country code can't be empty")
    private String countryCode;

    @Column(name = "number")
    @NotEmpty(message = "phone number can't be empty")
    private String number;

    public PhoneNumber(String countryCode, String number) {
        this.countryCode = countryCode;
        this.number = number;
    }

    public PhoneNumber() {
    }

    public String getCountryCode() {
        return countryCode;
    }

    public String getNumber() {
        return number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PhoneNumber that = (PhoneNumber) o;
        return Objects.equals(getCountryCode(), that.getCountryCode()) &&
                Objects.equals(getNumber(), that.getNumber());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCountryCode(), getNumber());
    }
}
