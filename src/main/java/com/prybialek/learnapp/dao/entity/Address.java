package com.prybialek.learnapp.dao.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "T_ADDRESS")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ADDRESS_SEQ")
    @SequenceGenerator(sequenceName = "T_ADDRESS_SEQ", allocationSize = 1, name = "ADDRESS_SEQ")
    private Long id;

    @Enumerated(EnumType.STRING)
    @NotNull
    private Country country;

    @Column(name = "STREET")
    @NotNull
    private String street;

    public Address() {
        //default constructor
    }

    public Address(@NotNull Country country, @NotNull String street) {
        this.country = country;
        this.street = street;
    }

    public Long getId() {
        return id;
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