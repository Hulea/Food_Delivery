package com.ps.FoodDelivery.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ps.FoodDelivery.model.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FoodDTO {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("price")
    private double price;

    @JsonProperty("description")
    private String description;

    @JsonProperty("remainingstock")
    private int remainingstock;

}