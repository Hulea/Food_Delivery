package com.ps.FoodDelivery.service;

import com.ps.FoodDelivery.model.Food;
import com.ps.FoodDelivery.model.FoodOrder;
import com.ps.FoodDelivery.model.User;

import java.util.List;

public interface FoodOrderService {
    List<FoodOrder> showAllFoodOrders();
    FoodOrder findFirstByUser(User user);
    double computePrice(FoodOrder f);
    void addFoodOrder(FoodOrder foodOrder);
    void deleteByUser(User user);
    String deleteByUserRet(User user);
    void addFood(FoodOrder foodOrder,Food food);
    String addFoodRet(FoodOrder foodOrder,Food food);

    void removeFood(FoodOrder foodOrder,Food food);
    String removeFoodRet(FoodOrder foodOrder,Food food);

    void save(FoodOrder foodOrder);

    //String exportFoodOrder(FoodOrder foodOrder, String fileType);

}