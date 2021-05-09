package com.ps.FoodDelivery.repository;

import com.ps.FoodDelivery.model.Food;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FoodRepository extends CrudRepository<Food,Long> {

    Food findFirstByName(String name);

}

