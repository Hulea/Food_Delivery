package com.ps.FoodDelivery.service.impl;

import com.ps.FoodDelivery.model.Food;
import com.ps.FoodDelivery.model.FoodOrder;
import com.ps.FoodDelivery.model.User;
import com.ps.FoodDelivery.repository.FoodOrderRepository;
import com.ps.FoodDelivery.repository.UserRepository;
import com.ps.FoodDelivery.service.FoodOrderService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class FoodOrderServiceImpl implements FoodOrderService {


    private final FoodOrderRepository foodOrderRepository;

    public FoodOrderServiceImpl(FoodOrderRepository foodOrderRepository){
        this.foodOrderRepository = foodOrderRepository;
    }


    @Override
    public List<FoodOrder> showAllFoodOrders() {
        return this.foodOrderRepository.showAllFoodOrders();
    }

    @Override
    public FoodOrder findFirstByUser(User user) {
        return this.foodOrderRepository.findFirstByUser(user);
    }

    @Override
    public double computePrice(FoodOrder f) {
        double sum = 0;
        for(Food i : f.getFoodList())
            sum += i.getPrice();
        return sum;
    }

    @Override
    public void addFoodOrder(FoodOrder foodOrder) {
        foodOrderRepository.save(foodOrder);
    }

    @Override
    @Transactional
    public void deleteByUser(User user) {
        foodOrderRepository.deleteByUser(user);
    }

    @Override
    @Transactional
    public String deleteByUserRet(User user) {
        foodOrderRepository.deleteByUser(user);
        return "ok delete user food order";
    }

    @Override
    public void addFood(FoodOrder foodOrder, Food food) {

        /*List<Food> aux = null;
        foodOrder.setFoodList(aux);
        try {
            aux = foodOrder.getFoodList();
            aux.add(food);
        }
        catch(Exception ex){
            aux = new ArrayList<Food>();
            aux.add(food);
        }*/
        List<Food> aux =foodOrder.getFoodList();
        aux.add(food);

        foodOrder.setFoodList(aux);
        foodOrderRepository.save(foodOrder);

    }

    @Override
    public String addFoodRet(FoodOrder foodOrder, Food food) {
        List<Food> aux =foodOrder.getFoodList();
        aux.add(food);

        foodOrder.setFoodList(aux);
        foodOrderRepository.save(foodOrder);

        return "food added to order";
    }

    @Override
    public void removeFood(FoodOrder foodOrder, Food food) {
        List<Food> aux = foodOrder.getFoodList();
        aux.remove(food);

        foodOrder.setFoodList(aux);
        foodOrderRepository.save(foodOrder);
    }


    @Override
    public String removeFoodRet(FoodOrder foodOrder, Food food) {
        List<Food> aux = foodOrder.getFoodList();
        aux.remove(food);

        foodOrder.setFoodList(aux);
        foodOrderRepository.save(foodOrder);

        return "ok remove";
    }



    @Override
    public void save(FoodOrder foodOrder) {
        foodOrderRepository.save(foodOrder);
    }


}
