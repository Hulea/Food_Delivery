package com.ps.FoodDelivery.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalTime;

@Getter
@Setter
public class FoodTransportDTO {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("location")
    private String location;

    @JsonProperty("price")
    private double price;

    @JsonProperty("user")
    private Long user;
}
