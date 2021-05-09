package com.ps.FoodDelivery.service;

import com.ps.FoodDelivery.model.FoodTransport;
import com.ps.FoodDelivery.model.User;

import java.util.List;

public interface FoodTransportService {
    List<FoodTransport> findByUser(User user);
    void addFoodTransport(FoodTransport foodTransport);
    String addFoodTransportRet(FoodTransport foodTransport);
    FoodTransport findFirstByUser(User user);
}
