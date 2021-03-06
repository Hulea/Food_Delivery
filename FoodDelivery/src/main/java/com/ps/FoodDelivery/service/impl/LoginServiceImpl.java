package com.ps.FoodDelivery.service.impl;


import com.ps.FoodDelivery.GUI.Login;
import com.ps.FoodDelivery.dto.CredentialsDTO;
import com.ps.FoodDelivery.dto.LoginSuccessDTO;
import com.ps.FoodDelivery.exceptions.ApiExceptionResponse;
import com.ps.FoodDelivery.model.User;
import com.ps.FoodDelivery.repository.UserRepository;
import com.ps.FoodDelivery.service.LoginService;
import com.ps.FoodDelivery.utils.PasswordEncryption;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class LoginServiceImpl implements LoginService {

    private final UserRepository userRepository;

    public LoginServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public LoginSuccessDTO login(CredentialsDTO dto) throws ApiExceptionResponse {

        User user = userRepository.findFirstByEmail(dto.getEmail());

        if(user==null){

            throw ApiExceptionResponse.builder()
                    .errors(Collections.singletonList("Bad credentials"))
                    .message("User not found")
                    .status(HttpStatus.NOT_FOUND)
                    .build();
        }

        LoginSuccessDTO response;
        User.roles role = user.getAccountType();

        if(role.equals(User.roles.USER)){
            response = LoginSuccessDTO.builder().id(user.getId()).role(role).build();
        }
        else{
            response = LoginSuccessDTO.builder().role(role).build();
        }

        if(dto.getPassword().equals(PasswordEncryption.decrypt(user.getPassword(),user.getKey1()))){
            return response;
        }

        throw ApiExceptionResponse.builder()
                .errors(Collections.singletonList("Bad credentials"))
                .message("Invalid password")
                .status(HttpStatus.NOT_FOUND)
                .build();
    }
}