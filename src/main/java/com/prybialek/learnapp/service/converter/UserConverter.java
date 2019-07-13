package com.prybialek.learnapp.service.converter;

import com.prybialek.learnapp.controller.dto.AddressDTO;
import com.prybialek.learnapp.controller.dto.UserDTO;
import com.prybialek.learnapp.dao.entity.Address;
import com.prybialek.learnapp.dao.entity.User;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class UserConverter {

    public List<UserDTO> convertToUserDTOs(List<User> users) {
       return users.stream().map(this::convertToUserDTO).collect(Collectors.toList());
    }

    public User convertToUser(UserDTO userDTO) {
        User user = new User();
        user.setName(userDTO.getName());
        user.setSalary(userDTO.getSalary());
        if (Objects.nonNull(userDTO.getAddresses())) {
            userDTO.getAddresses().forEach(a -> user.addAddress(convertToAddress(a)));
        }

        return user;
    }

    private UserDTO convertToUserDTO(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setName(user.getName());
        userDTO.setSalary(user.getSalary());
        if(Objects.nonNull(user.getAddresses())) {
            userDTO.setAddresses(user.getAddresses().stream().map(this::convertToAddressDTO).collect(Collectors.toList()));
        }

        return userDTO;
    }

    private Address convertToAddress(AddressDTO addressDTO) {
        Address address = new Address();
        address.setCountry(addressDTO.getCountry());
        address.setStreet(addressDTO.getStreet());

        return address;
    }

    private AddressDTO convertToAddressDTO(Address address) {
        AddressDTO addressDTO = new AddressDTO();
        addressDTO.setId(address.getId());
        addressDTO.setCountry(address.getCountry());
        addressDTO.setStreet(address.getStreet());

        return addressDTO;
    }

}
