package com.ps.FoodDelivery.controller;

import com.ps.FoodDelivery.model.Offer;
import com.ps.FoodDelivery.service.OfferService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/offer")
public class OfferController {

    private final OfferService offerService;

    public OfferController(OfferService offerService){
        this.offerService = offerService;
    }


    @GetMapping("/admin")
<<<<<<< HEAD
    public List<Offer> findAllOffers(){
        return offerService.showAllOffers();
=======
    public ResponseEntity<List<Offer>> findAllOffers(){
        return ResponseEntity.status(HttpStatus.OK).body(offerService.showAllOffers());
>>>>>>> 583e829b44b8ed474109c9b0b4d0a65ffeb42dd4
    }

}
