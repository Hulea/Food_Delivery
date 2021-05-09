package com.ps.FoodDelivery.service.impl;

import com.ps.FoodDelivery.model.FoodTransport;
import com.ps.FoodDelivery.model.User;
import com.ps.FoodDelivery.repository.FoodTransportRepository;
import com.ps.FoodDelivery.service.FoodTransportService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodTransportServiceImpl implements FoodTransportService {

    private final FoodTransportRepository foodTransportRepository;

    public FoodTransportServiceImpl(FoodTransportRepository foodTransportRepository) {
        this.foodTransportRepository = foodTransportRepository;
    }

    @Override
    public List<FoodTransport> findByUser(User user) {
         return foodTransportRepository.findByUser(user);
    }

    @Override
    public void addFoodTransport(FoodTransport foodTransport) {
        this.foodTransportRepository.save(foodTransport);
    }

    @Override
    public String addFoodTransportRet(FoodTransport foodTransport) {
        this.foodTransportRepository.save(foodTransport);
        return "ok transport add";
    }

    @Override
    public FoodTransport findFirstByUser(User user) {
        return foodTransportRepository.findFirstByUser(user);
    }
}
