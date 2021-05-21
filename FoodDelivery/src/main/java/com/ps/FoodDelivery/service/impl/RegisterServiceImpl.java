package com.ps.FoodDelivery.service.impl;

import com.ps.FoodDelivery.dto.RegisterDTO;
import com.ps.FoodDelivery.model.User;
import com.ps.FoodDelivery.repository.UserRepository;
import com.ps.FoodDelivery.service.RegisterService;
<<<<<<< HEAD
import com.ps.FoodDelivery.utils.PasswordEncryption;

import javax.security.auth.kerberos.EncryptionKey;
=======
>>>>>>> 583e829b44b8ed474109c9b0b4d0a65ffeb42dd4

public class RegisterServiceImpl implements RegisterService {

    private final UserRepository userRepository;

    public RegisterServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public String register(RegisterDTO dto) {

<<<<<<< HEAD
        String asd = "asd";

=======
>>>>>>> 583e829b44b8ed474109c9b0b4d0a65ffeb42dd4
        User user = User.builder()
                .firstName(dto.getFirstname())
                .lastName(dto.getLastname())
                .phoneNumber(dto.getPhonenumber())
                .email(dto.getEmail())
<<<<<<< HEAD
                .password(PasswordEncryption.encrypt(dto.getPassword(),asd))
                .password(dto.getPassword())
                .accountType(User.roles.USER)
                .key1(asd)
=======
                .password(dto.getPassword())
                .accountType(User.roles.USER)
>>>>>>> 583e829b44b8ed474109c9b0b4d0a65ffeb42dd4
                .build();

        userRepository.save(user);
        return "ok";

    }
}
