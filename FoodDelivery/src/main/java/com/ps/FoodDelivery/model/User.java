package com.ps.FoodDelivery.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalTime;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class User {

    public enum roles{USER,WORKER,ADMIN};

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull(message = "User must have a First Name")
    private String firstName;
    @NotNull(message = "User must have a Last Name")
    private String lastName;
    private String phoneNumber;
    private String email;
    private String password;

    private roles accountType;

    private LocalTime loginTime;
    private LocalTime logoutTime;
    private boolean logged;

    private String key1;


}