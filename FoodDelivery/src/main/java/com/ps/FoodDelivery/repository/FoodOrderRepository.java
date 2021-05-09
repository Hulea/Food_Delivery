package com.ps.FoodDelivery.repository;

import com.ps.FoodDelivery.model.Food;
import com.ps.FoodDelivery.model.FoodOrder;
import com.ps.FoodDelivery.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FoodOrderRepository extends CrudRepository<FoodOrder,Long> {

    @Query(value = "select * from food_order",nativeQuery = true)
    List<FoodOrder> showAllFoodOrders();
    FoodOrder findFirstByUser(User user);
    void deleteByUser(User user);

}
