package com.ps.FoodDelivery.controller;

import com.ps.FoodDelivery.dto.RegisterDTO;
import com.ps.FoodDelivery.dto.UserDTO;
import com.ps.FoodDelivery.model.User;
import com.ps.FoodDelivery.service.EmailSenderService;
import com.ps.FoodDelivery.service.RegisterService;
import com.ps.FoodDelivery.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.PostPersist;

@RestController
@RequestMapping("/register")
public class RegisterController {

    private final UserService userService;
    private final EmailSenderService emailSenderService;

    public RegisterController(UserService userService,EmailSenderService emailSenderService ){
        this.userService = userService;
        this.emailSenderService = emailSenderService;
    }

    @PostMapping("/{email}")
    public ResponseEntity notifyCreation(@PathVariable String email){

        String body = "Your account has been successfully created " + email;

        emailSenderService.sendSimpleEmail("dummy.mail312@gmail.com",
                 body,
                "FoodDelivery App");

        System.out.println("mail de inregistrare pt " + email);
        return ResponseEntity.status(HttpStatus.OK).body(email);
    }

    /*
	@Autowired
	private EmailSenderService service;

	@EventListener(ApplicationReadyEvent.class)
	public void triggerMail(){

		service.sendSimpleEmail("dummy.mail312@gmail.com","bodyyyy","subjecttt");

	}*/
}
