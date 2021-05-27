package com.ps.FoodDelivery.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import javax.validation.constraints.NotBlank;

import java.time.LocalTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class FoodTransport {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    @NotBlank(message = "Cannot transport food without a location")
    private String location;




    private double price;
     LocalTime departure;
     LocalTime arrival;

    @OneToOne
    private User user;

    @OneToOne
    private FoodOrder foodOrder;

}
