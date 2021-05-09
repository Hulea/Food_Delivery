package com.ps.FoodDelivery.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
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

    private String location;
    private double price;
     LocalTime departure;
     LocalTime arrival;

    @OneToOne
    private User user;

    @OneToOne
    private FoodOrder foodOrder;

}
