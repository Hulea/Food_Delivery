package com.ps.FoodDelivery.controller;

import com.ps.FoodDelivery.dto.CredentialsDTO;
import com.ps.FoodDelivery.exceptions.ApiExceptionResponse;
import com.ps.FoodDelivery.service.LoginService;
import com.ps.FoodDelivery.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class LoginController {

    private final LoginService loginService;


    public LoginController(LoginService loginService){
        this.loginService = loginService;

    }

    @PostMapping("/login")
    public ResponseEntity loginReq(@RequestBody CredentialsDTO dto) throws ApiExceptionResponse{
        return ResponseEntity.status(HttpStatus.OK).body(loginService.login(dto));
    }


}
