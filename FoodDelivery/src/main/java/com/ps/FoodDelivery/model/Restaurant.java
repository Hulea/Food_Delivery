package com.ps.FoodDelivery.model;


import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.xml.bind.annotation.XmlRootElement;
import java.rmi.MarshalException;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@XmlRootElement(name = "restaurant")
@ToString
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "Restaurant must have a name")
    private String name;

    @NotBlank(message = "Restaurant must have a location")
    private String location;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<Food> food;

}