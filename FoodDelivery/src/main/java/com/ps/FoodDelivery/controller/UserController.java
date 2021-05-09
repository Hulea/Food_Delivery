package com.ps.FoodDelivery.controller;

import com.ps.FoodDelivery.dto.UserDTO;
import com.ps.FoodDelivery.exceptions.ApiExceptionResponse;
import com.ps.FoodDelivery.model.Food;
import com.ps.FoodDelivery.model.FoodOrder;
import com.ps.FoodDelivery.model.User;
import com.ps.FoodDelivery.service.FoodOrderService;
import com.ps.FoodDelivery.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {

    private final UserService userService;


    public UserController(UserService userService ){
        this.userService = userService;
    }

/*    @GetMapping("/orders")
    public ResponseEntity<List<Food>> getOrderedFoods(){

        return ResponseEntity.status(HttpStatus.OK).body(userService.)

    }*/

    @PostMapping("/add")
    public ResponseEntity addUser(@RequestBody UserDTO dto) throws ApiExceptionResponse{
        User.roles role = User.roles.USER;
        User aux = User.builder()
                .firstName(dto.getFirstname())
                .lastName(dto.getLastname())
                .phoneNumber(dto.getPhonenumber())
                .email(dto.getEmail())
                .password(dto.getPassword())
                .accountType(role)
                .build();


        //System.out.println(userService.addUserRet(aux));
        return ResponseEntity.status(HttpStatus.OK).body(userService.addUserRet(aux));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteUser(@PathVariable Long id) throws ApiExceptionResponse{


        return ResponseEntity.status(HttpStatus.OK).body(userService.deleteById(id));
    }

    @PutMapping("/update")
    public ResponseEntity updateUser(@RequestBody UserDTO dto) throws ApiExceptionResponse{
        return ResponseEntity.status(HttpStatus.OK).body(userService.updateUser(dto));
    }

    @GetMapping("/allusers")
    public List<User> findAllUsers(){
        return userService.findAllUsers();
    }

    @GetMapping()
    public ResponseEntity findAllUu(){
        return ResponseEntity.status(HttpStatus.OK).body(userService.findAllUsers());
    }

    @GetMapping("/{email}")
    public ResponseEntity findByEmail(@PathVariable  String email){
        return ResponseEntity.status(HttpStatus.OK).body(userService.findByEmail(email));
    }

    @GetMapping("/emailReq")
    public ResponseEntity findByEmailReq(@RequestParam(defaultValue = "admin") String email){
        return ResponseEntity.status(HttpStatus.OK).body(userService.findByEmail(email));
    }

    @GetMapping("/id/{id}")
    public ResponseEntity findById(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(userService.findById(id));
    }

    @GetMapping("/2param/{email}/{id}")
    public ResponseEntity findByEmailAndId(@PathVariable String email,@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(userService.findFirstByEmailAndId(email,id));
    }

}
