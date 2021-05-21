package com.ps.FoodDelivery.model;


import com.ps.FoodDelivery.utils.FoodEventListener;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
<<<<<<< HEAD
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
=======
>>>>>>> 583e829b44b8ed474109c9b0b4d0a65ffeb42dd4

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
<<<<<<< HEAD

    @NotBlank(message = "Food must have a name")
    private String name;

    @NotNull(message = "Food must have a price")
    private double price;

=======
    private String name;
    private double price;
>>>>>>> 583e829b44b8ed474109c9b0b4d0a65ffeb42dd4
    private String description;
    private int remainingStock;


}
