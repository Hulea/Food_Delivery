package com.ps.FoodDelivery.controller;


import com.ps.FoodDelivery.dto.FoodDTO;
import com.ps.FoodDelivery.exceptions.ApiExceptionResponse;
import com.ps.FoodDelivery.model.Food;
import com.ps.FoodDelivery.model.FoodOrder;
import com.ps.FoodDelivery.service.FoodOrderService;
import com.ps.FoodDelivery.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
 
@RestController
@CrossOrigin
public class FoodOrderController {

    private final FoodOrderService foodOrderService;
    private final UserService userService;

    public FoodOrderController(FoodOrderService foodOrderService,
                               UserService userService){
        this.foodOrderService = foodOrderService;
        this.userService = userService;
    }

    @GetMapping("user/orders/{user}")
    public ResponseEntity<List<Food>> getFoodOrders(@PathVariable Long user){

            //System.out.println(user);

        System.out.println(foodOrderService.
                findFirstByUser(userService.
                        findById(user)).
                getFoodList());

            return ResponseEntity.status(HttpStatus.OK).
                    body(foodOrderService.
                            findFirstByUser(userService.
                                    findById(user)).
                            getFoodList());
    }

    @DeleteMapping("/foodorder/delete/{id}")
    public ResponseEntity deleteOrder(@PathVariable Long id){
        
        return ResponseEntity.status(HttpStatus.OK)
                .body(foodOrderService.deleteByUserRet(userService.findById(id)));

    }



}
