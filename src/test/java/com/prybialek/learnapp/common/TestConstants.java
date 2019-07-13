package com.prybialek.learnapp.common;

import com.prybialek.learnapp.controller.dto.AddressDTO;
import com.prybialek.learnapp.dao.entity.Address;
import com.prybialek.learnapp.dao.entity.Country;

import java.util.Arrays;
import java.util.List;

public interface TestConstants {

    String TEST_USER_1 = "TestUser1";
    String TEST_USER_2 = "TestUser2";
    String TEST_USER_3 = "TestUser3";

    int TEST_SALARY_1 = 10000;
    int TEST_SALARY_2 = 20000;
    int TEST_SALARY_3 = 30000;

    List<Address> TEST_ADDRESSES_PL = Arrays.asList(new Address(Country.PL,"Testowa 1"), new Address(Country.PL,"Testowa 2"));
    List<Address> TEST_ADDRESSES_EN = Arrays.asList(new Address(Country.EN,"Test Street 1"), new Address(Country.EN,"Test Street 2"));
    List<Address> TEST_ADDRESSES_DE = Arrays.asList(new Address(Country.DE,"Test Strasse 1"), new Address(Country.DE,"Test Strasse 2"));

    List<AddressDTO> TEST_ADDRESSES_DTO_PL = Arrays.asList(new AddressDTO(Country.PL,"Testowa 1"), new AddressDTO(Country.PL,"Testowa 2"));
    List<AddressDTO> TEST_ADDRESSES_DTO_EN = Arrays.asList(new AddressDTO(Country.EN,"Test Street 1"), new AddressDTO(Country.EN,"Test Street 2"));
    List<AddressDTO> TEST_ADDRESSES_DTO_DE = Arrays.asList(new AddressDTO(Country.DE,"Test Strasse 1"), new AddressDTO(Country.DE,"Test Strasse 2"));

}
