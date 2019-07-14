package com.prybialek.learnapp.model.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class AddressId implements Serializable {

    @Enumerated(EnumType.STRING)
    @NotNull
    private Country country;

    @Column(name = "STREET")
    @NotNull
    private String street;

    @Column(name = "PESEL")
    @NotNull
    private Long userId;

    public AddressId() {
        // default constructor
    }

    public AddressId(@NotNull Country country, @NotNull String street, @NotNull Long userId) {
        this.country = country;
        this.street = street;
        this.userId = userId;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AddressId addressId = (AddressId) o;
        return country == addressId.country &&
                Objects.equals(street, addressId.street) &&
                Objects.equals(userId, addressId.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(country, street, userId);
    }

}
