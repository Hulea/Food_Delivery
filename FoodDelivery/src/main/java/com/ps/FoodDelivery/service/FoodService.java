package com.ps.FoodDelivery.service;

import com.ps.FoodDelivery.model.Food;

public interface FoodService {

    Food findFirstByName(String name);
    void decrementStock(Food food);
    void incrementStock(Food food);

}
