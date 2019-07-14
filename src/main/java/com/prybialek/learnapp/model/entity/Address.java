package com.prybialek.learnapp.model.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "T_ADDRESS")
public class Address {

    @EmbeddedId
    private AddressId addressId;

    public Address() {
        // default constructor
    }

    public Address(AddressId addressId) {
        this.addressId = addressId;
    }

    public AddressId getAddressId() {
        return addressId;
    }

    public void setAddressId(AddressId addressId) {
        this.addressId = addressId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return addressId.equals(address.addressId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(addressId);
    }

}
