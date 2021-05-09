package com.ps.FoodDelivery.service.impl;

import com.ps.FoodDelivery.model.Offer;
import com.ps.FoodDelivery.model.User;
import com.ps.FoodDelivery.repository.OfferRepository;
import com.ps.FoodDelivery.service.OfferService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OfferServiceImpl implements OfferService {

    private final OfferRepository offerRepository;

    public OfferServiceImpl(OfferRepository offerRepository){
        this.offerRepository = offerRepository;
    }


    @Override
    public Offer findFirstByUser(User user) {
        return offerRepository.findFirstByUser(user);
    }

    @Override
    public List<Offer> showAllOffers() {
        return offerRepository.showAllOffers();
    }
}
