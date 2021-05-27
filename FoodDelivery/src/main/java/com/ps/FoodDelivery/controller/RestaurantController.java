package com.ps.FoodDelivery.controller;

import com.ps.FoodDelivery.dto.RestaurantDTO;
import com.ps.FoodDelivery.exceptions.ApiExceptionResponse;
import com.ps.FoodDelivery.model.Food;
import com.ps.FoodDelivery.model.Restaurant;
import com.ps.FoodDelivery.service.RestaurantService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("/restaurant")

public class RestaurantController {

    private final RestaurantService restaurantService;
    private final SimpMessagingTemplate template;

    public RestaurantController(RestaurantService restaurantService, SimpMessagingTemplate template){
        this.restaurantService = restaurantService;
        this.template = template;
    }


    @PostMapping("/add")
    public ResponseEntity addRestaurant(@RequestBody RestaurantDTO dto) throws ApiExceptionResponse{

        template.convertAndSend("/topic/socket/notif2","A new restaurant has joined our platform! Check out "+ dto.getName() + ", from " + dto.getLocation());

        Restaurant aux = Restaurant.builder()
                .name(dto.getName())
                .location(dto.getLocation())
                .build();

        System.out.println(aux);

        return ResponseEntity.status(HttpStatus.OK).body(restaurantService.addRestaurantRet(aux));

    }


    @DeleteMapping("/delete/{id}")

    public ResponseEntity deleteRestaurant(@PathVariable Long id) throws ApiExceptionResponse{

        return ResponseEntity.status(HttpStatus.OK).body(restaurantService.deleteById(id));

    }

    @PutMapping("/update")
    public ResponseEntity updateRestaurant(@RequestBody RestaurantDTO dto) throws  ApiExceptionResponse{

        return ResponseEntity.status(HttpStatus.OK).body(restaurantService.updateRestaurant(dto));
    }


    @GetMapping("/user")
    public ResponseEntity<List<Restaurant>> findAllRestaurants(){
        return ResponseEntity.status(HttpStatus.OK).body(restaurantService.showAllRestaurants());
    }

    @GetMapping("/{name}")
    public ResponseEntity<List<Food>> getRestaurantFood(@PathVariable String name){
        return ResponseEntity.status(HttpStatus.OK).body(restaurantService.getRestaurantFood(name));
    }

    @GetMapping("/restaurant")
    public ResponseEntity findRestaurant(@PathVariable String name){
        return ResponseEntity.status(HttpStatus.OK).body(restaurantService.findFirstByName(name));
    }

    @GetMapping("/xml")
    public ResponseEntity exportXML(){
        return ResponseEntity.status(HttpStatus.OK).body(restaurantService.exportRestaurants(restaurantService.showAllRestaurants(),"xml"));
    }

}