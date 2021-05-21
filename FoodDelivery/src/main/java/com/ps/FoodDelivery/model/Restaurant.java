package com.ps.FoodDelivery.model;


<<<<<<< HEAD
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.xml.bind.annotation.XmlRootElement;
import java.rmi.MarshalException;
=======
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
>>>>>>> 583e829b44b8ed474109c9b0b4d0a65ffeb42dd4
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
<<<<<<< HEAD
@XmlRootElement(name = "restaurant")
@ToString
=======
>>>>>>> 583e829b44b8ed474109c9b0b4d0a65ffeb42dd4
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

<<<<<<< HEAD
    @NotBlank(message = "Restaurant must have a name")
    private String name;

    @NotBlank(message = "Restaurant must have a location")
=======
    private String name;
>>>>>>> 583e829b44b8ed474109c9b0b4d0a65ffeb42dd4
    private String location;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<Food> food;

}
