package com.prybialek.learnapp.common;

import com.prybialek.learnapp.controller.dto.AddressDTO;
import com.prybialek.learnapp.model.entity.Address;
import com.prybialek.learnapp.model.entity.AddressId;
import com.prybialek.learnapp.model.entity.Country;

import java.util.Arrays;
import java.util.List;

public interface TestConstants {

    Long TEST_ID_1 = 1L;
    Long TEST_ID_2 = 2L;
    Long TEST_ID_3 = 3L;

    String TEST_USER_1 = "TestUser1";
    String TEST_USER_2 = "TestUser2";
    String TEST_USER_3 = "TestUser3";

    int TEST_SALARY_1 = 10000;
    int TEST_SALARY_2 = 20000;
    int TEST_SALARY_3 = 30000;

    List<Address> TEST_ADDRESSES_PL = Arrays.asList(new Address(new AddressId(Country.PL,"Testowa 1",1L)), new Address(new AddressId(Country.PL,"Testowa 2",1L)));
    List<Address> TEST_ADDRESSES_EN = Arrays.asList(new Address(new AddressId(Country.EN,"Test Street 1",2L)), new Address(new AddressId(Country.EN,"Test Street 2",2L)));
    List<Address> TEST_ADDRESSES_DE = Arrays.asList(new Address(new AddressId(Country.DE,"Test Strasse 1",3L)), new Address(new AddressId(Country.DE, "Test Strasse 2",3L)));

    List<AddressDTO> TEST_ADDRESSES_DTO_PL = Arrays.asList(new AddressDTO(Country.PL,"Testowa 1"), new AddressDTO(Country.PL,"Testowa 2"));
    List<AddressDTO> TEST_ADDRESSES_DTO_EN = Arrays.asList(new AddressDTO(Country.EN,"Test Street 1"), new AddressDTO(Country.EN,"Test Street 2"));
    List<AddressDTO> TEST_ADDRESSES_DTO_DE = Arrays.asList(new AddressDTO(Country.DE,"Test Strasse 1"), new AddressDTO(Country.DE,"Test Strasse 2"));

}
