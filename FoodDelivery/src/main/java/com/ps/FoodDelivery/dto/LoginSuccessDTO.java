package com.ps.FoodDelivery.dto;

import com.ps.FoodDelivery.model.User;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class LoginSuccessDTO {
    private User.roles role;
    private Long id;
}
