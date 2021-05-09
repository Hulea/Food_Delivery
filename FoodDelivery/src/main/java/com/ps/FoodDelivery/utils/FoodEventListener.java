package com.ps.FoodDelivery.utils;

import com.ps.FoodDelivery.model.Food;

import javax.persistence.PostPersist;

public class FoodEventListener {

    @PostPersist
    public void notifyCreation(Food food){

        System.out.println("new food " + food.getName() + ", id = " + food.getId());

    }

}
