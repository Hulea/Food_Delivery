package com.ps.FoodDelivery.service.impl;

import com.ps.FoodDelivery.model.Food;
import com.ps.FoodDelivery.repository.FoodRepository;
import com.ps.FoodDelivery.service.FoodService;
import org.springframework.stereotype.Service;

@Service
public class FoodServiceImpl implements FoodService {
    private final FoodRepository foodRepository;

    public FoodServiceImpl(FoodRepository foodRepository){
        this.foodRepository = foodRepository;
    }

    @Override
    public Food findFirstByName(String name) {
        return foodRepository.findFirstByName(name);
    }

    @Override
    public void decrementStock(Food food) {

        food.setRemainingStock(food.getRemainingStock() - 1);
        foodRepository.save(food);

    }

    @Override
    public void incrementStock(Food food) {
        food.setRemainingStock(food.getRemainingStock() + 1);
        foodRepository.save(food);
    }
}
