package com.ps.FoodDelivery.service.impl;


import com.ps.FoodDelivery.model.User;
import com.ps.FoodDelivery.repository.UserRepository;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

class UserServiceImplTest {

    private UserServiceImpl userService;

    private static final Long exId = new Long(2);
    private static final User.roles exRole = User.roles.USER;
    private static final String exEmail = "user";
    private static final String exFirstName = "asd";
    private static final String exLastName = "asd";
    private static final String exPassword = "123";
    private static final String exPhoneNumber = "asd";

   // private static final Long nexId = new Long(222);
    private static final User.roles nexRole = User.roles.WORKER;
    private static final String nexEmail = "user1";
    private static final String nexFirstName = "asd1";
    private static final String nexLastName = "asd1";
    private static final String nexPassword = "1231";
    private static final String nexPhoneNumber = "asd1";

    private User user1;
    private User user2;

    @Mock
    private UserRepository userRepository;



    @BeforeEach
    void setUp(){
        initMocks(this);
        user1 = new User();
        user2 = new User();

        user1.setAccountType(User.roles.USER);
        user1.setEmail(exEmail);
        user1.setFirstName(exFirstName);
        user1.setLastName(exLastName);
        user1.setPassword(exPassword);
        user1.setPhoneNumber(exPhoneNumber);

        user2.setAccountType(User.roles.WORKER);
        user2.setEmail(nexEmail);
        user2.setFirstName(nexFirstName);
        user2.setLastName(nexLastName);
        user2.setPassword(nexPassword);
        user2.setPhoneNumber(nexPhoneNumber);

        when(userRepository.findFirstByEmailAndPassword(nexEmail,nexPassword)).thenReturn(user2);
        when(userRepository.findFirstByEmailAndPassword(exEmail,exPassword)).thenReturn(user1);
        when(userRepository.findFirstByEmail(exEmail)).thenReturn(user1);

    }

    @Test
    void addUser(){
        userService = new UserServiceImpl(userRepository);

        userService.addUser(user2);
        User aux = userService.findFirstByEmailAndPassword(nexEmail,nexPassword);

        assertNotNull(aux);
        assertEquals(aux,user2);
    }

/*    @Test
    void updateUser(){

        userService = new UserServiceImpl(userRepository);

        User aux = userService.findFirstByEmail(exEmail);
        assertNotNull(aux);

        aux.setPassword(nexPassword);
        userService.updateUser(exId,aux);

        User aux2 = userService.findFirstByEmail(exEmail);
        assertNotNull(aux2);
        assertEquals(nexPassword,aux2.getPassword());

    }

    @Test
    void deleteUser(){

        userService = new UserServiceImpl(userRepository);

        User aux = userService.findFirstByEmail(exEmail);
        assertNotNull(aux);

        userService.deleteById(aux.getId());
        User aux2 = userService.findFirstByEmail(exEmail);
        assertNull(aux2);
    }*/

}
