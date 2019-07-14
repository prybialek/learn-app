package com.prybialek.learnapp.controller.dto;

import java.util.ArrayList;
import java.util.List;

public class UserDTO {

    private Long pesel;
    private String name;
    private int salary;
    private List<AddressDTO> addresses = new ArrayList<>();

    public UserDTO() {
        // default constructor
    }

    public UserDTO(String name, int salary, List<AddressDTO> addresses) {
        this.name = name;
        this.salary = salary;
        this.addresses = addresses;
    }

    public Long getPesel() {
        return pesel;
    }

    public void setPesel(Long pesel) {
        this.pesel = pesel;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public List<AddressDTO> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<AddressDTO> addresses) {
        this.addresses = addresses;
    }

}
