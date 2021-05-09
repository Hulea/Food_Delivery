package com.ps.FoodDelivery.service;

import com.ps.FoodDelivery.dto.RestaurantDTO;
import com.ps.FoodDelivery.exceptions.ApiExceptionResponse;
import com.ps.FoodDelivery.model.Food;
import com.ps.FoodDelivery.model.Restaurant;

import java.util.List;

public interface RestaurantService {
    //void addFood(Restaurant dto,Food food);
    List<Food> getRestaurantFood(Long id);
    List<Food> getRestaurantFood(String name);
    List<Restaurant> showAllRestaurants();
    void addRestaurant(Restaurant restaurant);
    Restaurant addRestaurantRet(Restaurant restaurant);
    Restaurant findFirstByName(String name);
    Restaurant findFirstById(Long id);
    String deleteById(Long id);

    String updateRestaurant(RestaurantDTO dto);

}
