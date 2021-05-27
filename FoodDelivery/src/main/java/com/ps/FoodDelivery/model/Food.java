package com.ps.FoodDelivery.model;


import com.ps.FoodDelivery.utils.FoodEventListener;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;



@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@EntityListeners(FoodEventListener.class)
@Builder
public class Food {

    @Id
    @GeneratedValue(strategy =GenerationType.AUTO)
    private Long id;


    @NotBlank(message = "Food must have a name")
    private String name;

    @NotNull(message = "Food must have a price")
    private double price;


    private String description;
    private int remainingStock;


}
