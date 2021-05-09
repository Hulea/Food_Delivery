package com.ps.FoodDelivery.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.ps.FoodDelivery.model.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("firstname")
    private String firstname;

    @JsonProperty("lastname")
    private String lastname;

    @JsonProperty("phonenumber")
    private String phonenumber;

    @JsonProperty("email")
    private String email;

    @JsonProperty("password")
    private String password;

    @JsonProperty("role")
    private User.roles role;
}
