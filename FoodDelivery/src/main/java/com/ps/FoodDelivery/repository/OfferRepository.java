package com.ps.FoodDelivery.repository;

import com.ps.FoodDelivery.model.Offer;
import com.ps.FoodDelivery.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OfferRepository extends CrudRepository<Offer,Long> {

    @Query(value = "select * from offers",nativeQuery = true)
    List<Offer> showAllOffers();

    void deleteById(Long id);

    Offer findFirstByUser(User user);

}
