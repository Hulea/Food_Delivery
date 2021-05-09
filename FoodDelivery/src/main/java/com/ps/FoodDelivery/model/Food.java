package com.ps.FoodDelivery.model;


import com.ps.FoodDelivery.utils.FoodEventListener;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

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
    private String name;
    private double price;
    private String description;
    private int remainingStock;


}
