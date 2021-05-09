package com.ps.FoodDelivery.repository;

import com.ps.FoodDelivery.model.FoodTransport;
import com.ps.FoodDelivery.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FoodTransportRepository extends CrudRepository<FoodTransport,Long> {

    List<FoodTransport> findByUser(User user);

    FoodTransport findFirstByUser(User user);

}
