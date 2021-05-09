package com.ps.FoodDelivery.service;

import com.ps.FoodDelivery.dto.CredentialsDTO;
import com.ps.FoodDelivery.dto.LoginSuccessDTO;
import com.ps.FoodDelivery.exceptions.ApiExceptionResponse;
import org.springframework.stereotype.Component;

@Component
public interface LoginService {
    LoginSuccessDTO login(CredentialsDTO dto) throws ApiExceptionResponse;
}
