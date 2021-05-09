package com.ps.FoodDelivery.service;

import com.ps.FoodDelivery.model.Offer;
import com.ps.FoodDelivery.model.User;

import java.util.List;

public interface OfferService {
    Offer findFirstByUser(User user);
    List<Offer> showAllOffers();}
