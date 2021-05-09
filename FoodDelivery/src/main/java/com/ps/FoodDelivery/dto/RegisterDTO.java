package com.ps.FoodDelivery.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterDTO {

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




}
