package com.ps.FoodDelivery.repository;

import com.ps.FoodDelivery.model.Food;
import com.ps.FoodDelivery.model.Restaurant;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RestaurantRepository extends CrudRepository<Restaurant,Long> {


    @Query(value = "select * from restaurant",nativeQuery = true)
    List<Restaurant> showAllRestaurants();

    Restaurant findFirstById(Long id);
    Restaurant findFirstByName(String name);
    Restaurant removeById(Long id);
    void deleteById(Long id);

}
