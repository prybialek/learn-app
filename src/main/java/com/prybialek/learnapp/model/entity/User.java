package com.prybialek.learnapp.model.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "T_USER")
@NamedQueries({
        @NamedQuery(
                name = User.NQ_FIND_USER_BY_NAME_AND_SALARY,
                query = "select u from User u where u.name = :" + User.PARAM_NAME + " and u.salary = :" + User.PARAM_SALARY
        )
})
public class User {

    public static final String NQ_FIND_USER_BY_NAME_AND_SALARY = "findUserByNameAndSalary";
    public static final String PARAM_NAME = "name";
    public static final String PARAM_SALARY = "salary";

//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USER_SEQ")
//    @SequenceGenerator(sequenceName = "T_USER_SEQ", allocationSize = 1, name = "USER_SEQ")
    @Id
    private Long pesel;

    @Column(name = "NAME")
    @NotNull
    private String name;

    @Column(name = "SALARY")
    @NotNull
    private int salary;

    @OneToMany(mappedBy = "addressId.userId", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Address> addresses = new ArrayList<>();

    public User() {
        // default constructor
    }

    public User(@NotNull Long pesel, @NotNull String name, @NotNull int salary, List<Address> addresses) {
        this.pesel = pesel;
        this.name = name;
        this.salary = salary;
        this.addresses = addresses;
    }

    public void setPesel(Long pesel) {
        this.pesel = pesel;
    }

    public Long getPesel() {
        return pesel;
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

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

    public void addAddress(Address address) {
        if (Objects.nonNull(address)) {
            addresses.add(address);
            address.getAddressId().setUserId(this.pesel);
        }
    }

    public void removeAddress(Address address) {
        if (address != null) {
            addresses.remove(address);
            address.getAddressId().setUserId(null);
        }
    }

}
