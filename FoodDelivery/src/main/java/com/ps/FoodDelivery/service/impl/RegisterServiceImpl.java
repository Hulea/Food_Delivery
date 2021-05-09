package com.ps.FoodDelivery.service.impl;

import com.ps.FoodDelivery.dto.RegisterDTO;
import com.ps.FoodDelivery.model.User;
import com.ps.FoodDelivery.repository.UserRepository;
import com.ps.FoodDelivery.service.RegisterService;

public class RegisterServiceImpl implements RegisterService {

    private final UserRepository userRepository;

    public RegisterServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public String register(RegisterDTO dto) {

        User user = User.builder()
                .firstName(dto.getFirstname())
                .lastName(dto.getLastname())
                .phoneNumber(dto.getPhonenumber())
                .email(dto.getEmail())
                .password(dto.getPassword())
                .accountType(User.roles.USER)
                .build();

        userRepository.save(user);
        return "ok";

    }
}
