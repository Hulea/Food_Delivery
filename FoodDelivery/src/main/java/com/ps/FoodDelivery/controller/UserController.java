package com.ps.FoodDelivery.controller;

import com.ps.FoodDelivery.dto.UserDTO;
import com.ps.FoodDelivery.exceptions.ApiExceptionResponse;
<<<<<<< HEAD
import com.ps.FoodDelivery.model.User;
import com.ps.FoodDelivery.service.UserService;
import com.ps.FoodDelivery.utils.PasswordEncryption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.simp.SimpMessagingTemplate;
=======
import com.ps.FoodDelivery.model.Food;
import com.ps.FoodDelivery.model.FoodOrder;
import com.ps.FoodDelivery.model.User;
import com.ps.FoodDelivery.service.FoodOrderService;
import com.ps.FoodDelivery.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
>>>>>>> 583e829b44b8ed474109c9b0b4d0a65ffeb42dd4
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {

    private final UserService userService;

<<<<<<< HEAD
    private final SimpMessagingTemplate template;

    public UserController(UserService userService, SimpMessagingTemplate template){
        this.userService = userService;
        this.template = template;
    }

=======

    public UserController(UserService userService ){
        this.userService = userService;
    }

/*    @GetMapping("/orders")
    public ResponseEntity<List<Food>> getOrderedFoods(){

        return ResponseEntity.status(HttpStatus.OK).body(userService.)

    }*/
>>>>>>> 583e829b44b8ed474109c9b0b4d0a65ffeb42dd4

    @PostMapping("/add")
    public ResponseEntity addUser(@RequestBody UserDTO dto) throws ApiExceptionResponse{
        User.roles role = User.roles.USER;
<<<<<<< HEAD

        String asd = "asd";

=======
>>>>>>> 583e829b44b8ed474109c9b0b4d0a65ffeb42dd4
        User aux = User.builder()
                .firstName(dto.getFirstname())
                .lastName(dto.getLastname())
                .phoneNumber(dto.getPhonenumber())
                .email(dto.getEmail())
<<<<<<< HEAD
                .password(PasswordEncryption.encrypt(dto.getPassword(),asd))
                .accountType(role)
                .key1(asd)
=======
                .password(dto.getPassword())
                .accountType(role)
>>>>>>> 583e829b44b8ed474109c9b0b4d0a65ffeb42dd4
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

<<<<<<< HEAD
    @PostMapping("/timestamp/login")
    public ResponseEntity loginTimestamp(@RequestBody String email) throws ApiExceptionResponse{
        return ResponseEntity.status(HttpStatus.OK).body(userService.loginTimestamp(email));
    }

    @PostMapping("/timestamp/logout")
    public ResponseEntity logoutTimestamp(@RequestBody Long id) throws ApiExceptionResponse{
        return ResponseEntity.status(HttpStatus.OK).body(userService.logoutTimestamp(userService.findById(id).getEmail()));
    }


    @GetMapping("/allusers")
    public List<User> findAllUsers(){
        template.convertAndSend("/topic/socket/notif","asdadsasdasdasdaasdasdadsadasd");
        return userService.findAllUsers();
    }

    @GetMapping("/loggedusers")
    public int getNoOfLoggedUsers(){
        System.out.println("nr of logged users:" +  userService.getNoOfLoggedUsers());
        return userService.getNoOfLoggedUsers();
    }

=======
    @GetMapping("/allusers")
    public List<User> findAllUsers(){
        return userService.findAllUsers();
    }

>>>>>>> 583e829b44b8ed474109c9b0b4d0a65ffeb42dd4
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

<<<<<<< HEAD





=======
>>>>>>> 583e829b44b8ed474109c9b0b4d0a65ffeb42dd4
}
