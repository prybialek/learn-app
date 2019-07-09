package com.prybialek.learnapp.dao.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "T_USER")
@NamedQueries({
        @NamedQuery(
                name = User.NQ_FIND_USER_BY_NAME_AND_SALARY,
                query = "select u from User u where u.name = :" + User.PARAM_USER + " and u.salary = :" + User.PARAM_SALARY
        )
})
public class User {

    public static final String NQ_FIND_USER_BY_NAME_AND_SALARY = "findUserByNameAndSalary";
    public static final String PARAM_USER = "user";
    public static final String PARAM_SALARY = "salary";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USER_SEQ")
    @SequenceGenerator(sequenceName = "T_USER_SEQ", allocationSize = 1, name = "USER_SEQ")
    private Long id;

    @Column(name = "NAME")
    @NotNull
    private String name;

    @Column(name = "SALARY")
    @NotNull
    private int salary;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    @JoinColumn(name = "USER_ID")
    @NotNull
    private List<Address> addresses;

    public User() {
        // default constructor
    }

    public User(@NotNull String name, @NotNull int salary, @NotNull List<Address> addresses) {
        this.name = name;
        this.salary = salary;
        this.addresses = addresses;
    }

    public Long getId() {
        return id;
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
}
