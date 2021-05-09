package com.ps.FoodDelivery.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ps.FoodDelivery.model.Food;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class RestaurantDTO {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("location")
    private String location;



}
