package com.ps.FoodDelivery.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
<<<<<<< HEAD
import javax.validation.constraints.NotBlank;
=======
>>>>>>> 583e829b44b8ed474109c9b0b4d0a65ffeb42dd4
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

<<<<<<< HEAD
    @NotBlank(message = "Cannot transport food without a location")
    private String location;

=======
    private String location;
>>>>>>> 583e829b44b8ed474109c9b0b4d0a65ffeb42dd4
    private double price;
     LocalTime departure;
     LocalTime arrival;

    @OneToOne
    private User user;

    @OneToOne
    private FoodOrder foodOrder;

}
