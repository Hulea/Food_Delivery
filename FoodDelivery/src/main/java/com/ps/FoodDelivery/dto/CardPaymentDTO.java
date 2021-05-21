package com.ps.FoodDelivery.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CardPaymentDTO {


    @JsonProperty("id")
    private Long id;

    @JsonProperty("location")
    private String location;

    @JsonProperty("price")
    private double price;

    @JsonProperty("user")
    private Long user;

    @JsonProperty("number")
    private String number;

    @JsonProperty("name")
    private String name;

    @JsonProperty("expiry")
    private String expiry;

    @JsonProperty("cvc")
    private int cvc;
}
