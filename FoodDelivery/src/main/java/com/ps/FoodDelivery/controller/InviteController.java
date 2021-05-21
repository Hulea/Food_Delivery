package com.ps.FoodDelivery.controller;


import com.ps.FoodDelivery.service.EmailSenderService;
import com.ps.FoodDelivery.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/invite")
public class InviteController {

    private final EmailSenderService emailSenderService;

    public InviteController(EmailSenderService emailSenderService ){
        this.emailSenderService = emailSenderService;
    }

    @PostMapping("/{email}")
    public ResponseEntity notifyCreation(@PathVariable String email){

        String body = "Join the food delivery app!\n Link:...";

        emailSenderService.sendSimpleEmail(email,
                body,
                "Join the food delivery app! ");

        System.out.println("mail de invite " + email);
        return ResponseEntity.status(HttpStatus.OK).body(email);
    }
}
