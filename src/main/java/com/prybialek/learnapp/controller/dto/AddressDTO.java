package com.prybialek.learnapp.controller.dto;

import com.prybialek.learnapp.dao.entity.Country;

public class AddressDTO {

    private Long id;
    private Country country;
    private String street;

    public AddressDTO() {
        // default constructor
    }

    public AddressDTO(Country country, String street) {
        this.country = country;
        this.street = street;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

}
