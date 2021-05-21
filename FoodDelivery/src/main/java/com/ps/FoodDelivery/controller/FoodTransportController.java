package com.ps.FoodDelivery.controller;


<<<<<<< HEAD
import com.ps.FoodDelivery.dto.CardPaymentDTO;
=======
>>>>>>> 583e829b44b8ed474109c9b0b4d0a65ffeb42dd4
import com.ps.FoodDelivery.dto.FoodTransportDTO;
import com.ps.FoodDelivery.exceptions.ApiExceptionResponse;
import com.ps.FoodDelivery.model.FoodTransport;
import com.ps.FoodDelivery.service.FoodOrderService;
import com.ps.FoodDelivery.service.FoodTransportService;
import com.ps.FoodDelivery.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalTime;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/transport")
public class FoodTransportController {

    private final FoodOrderService foodOrderService;
    private final FoodTransportService foodTransportService;
    private final UserService userService;


    public FoodTransportController(FoodOrderService foodOrderService, FoodTransportService foodTransportService, UserService userService) {
        this.foodOrderService = foodOrderService;
        this.foodTransportService = foodTransportService;
        this.userService = userService;
    }

    @PostMapping("/add")
    public ResponseEntity addTransport(@RequestBody FoodTransportDTO dto) throws ApiExceptionResponse{

        LocalTime time = LocalTime.now();

        System.out.println("transpppp" + dto.getLocation());

        FoodTransport aux =
                FoodTransport.builder()
                .location(dto.getLocation())
                .price(dto.getPrice())
                .departure(time)
                .arrival(time.plusMinutes(15))
                .user(userService.findById(dto.getUser()))
                .foodOrder(foodOrderService.findFirstByUser(userService.findById(dto.getUser())))
                .build();

        System.out.println("transpppp" + aux);

        return ResponseEntity.status(HttpStatus.OK).body(foodTransportService.addFoodTransportRet(aux));

    }


<<<<<<< HEAD

    @PostMapping("/addwithcard")
    public ResponseEntity addTransportWithCard(@RequestBody CardPaymentDTO dto) throws ApiExceptionResponse{

        LocalTime time = LocalTime.now();

        System.out.println("Transport Location: " + dto.getLocation());

        FoodTransport aux =
                FoodTransport.builder()
                        .location(dto.getLocation())
                        .price(dto.getPrice())
                        .departure(time)
                        .arrival(time.plusMinutes(15))
                        .user(userService.findById(dto.getUser()))
                        .foodOrder(foodOrderService.findFirstByUser(userService.findById(dto.getUser())))
                        .build();


        System.out.println(dto.getNumber());
        System.out.println(dto.getName());
        System.out.println(dto.getExpiry());
        System.out.println(dto.getCvc());

        return ResponseEntity.status(HttpStatus.OK).body(foodTransportService.addFoodTransportRet(aux));

    }


=======
>>>>>>> 583e829b44b8ed474109c9b0b4d0a65ffeb42dd4
    @GetMapping("/usertransport/{id}")
    public ResponseEntity<List<FoodTransport>> returnTransport(@PathVariable Long id){

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(foodTransportService.findByUser(userService.findFirstById(id)));

    }

}
