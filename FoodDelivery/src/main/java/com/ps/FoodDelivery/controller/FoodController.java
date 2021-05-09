package com.ps.FoodDelivery.controller;


import com.ps.FoodDelivery.exceptions.ApiExceptionResponse;
import com.ps.FoodDelivery.service.FoodOrderService;
import com.ps.FoodDelivery.service.FoodService;
import com.ps.FoodDelivery.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RequestMapping("/food")
@RestController
public class FoodController {

    private final FoodService foodService;
    private final UserService userService;
    private final FoodOrderService foodOrderService;

    public FoodController(FoodService foodService, UserService userService, FoodOrderService foodOrderService) {
        this.foodService = foodService;
        this.userService = userService;
        this.foodOrderService = foodOrderService;
    }

    @PostMapping("/{id}/{food}")
    public ResponseEntity addFoodToOrder(@PathVariable Long id,@PathVariable String food){

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(foodOrderService.addFoodRet(
                        foodOrderService.findFirstByUser(userService.findById(id)), foodService.findFirstByName(food))
                );

    }

    @PostMapping("/removefoodfromorder/{id}/{food}")
    public ResponseEntity removeFoodFromOrder(@PathVariable Long id, @PathVariable String food) throws ApiExceptionResponse {


        System.out.println(id + " ////////// " + food);

        return ResponseEntity.status(HttpStatus.OK)
        .body(foodOrderService.removeFoodRet(
            foodOrderService.findFirstByUser(userService.findById(id)),
            foodService.findFirstByName(food))
            );

    }





}
