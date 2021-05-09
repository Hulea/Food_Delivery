package com.ps.FoodDelivery.service;


import com.ps.FoodDelivery.dto.RegisterDTO;
import org.springframework.stereotype.Component;

@Component
public interface RegisterService {

    String register(RegisterDTO dto);

}
