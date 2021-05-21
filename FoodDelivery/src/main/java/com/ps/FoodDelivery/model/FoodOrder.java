package com.ps.FoodDelivery.model;
<<<<<<< HEAD
=======

>>>>>>> 583e829b44b8ed474109c9b0b4d0a65ffeb42dd4
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
<<<<<<< HEAD
=======

>>>>>>> 583e829b44b8ed474109c9b0b4d0a65ffeb42dd4
import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class FoodOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne
    private User user;

    @ManyToMany(fetch=FetchType.EAGER)
    private List<Food> foodList;

}
