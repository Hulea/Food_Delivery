package com.ps.FoodDelivery.service;

import com.ps.FoodDelivery.dto.UserDTO;
import com.ps.FoodDelivery.model.User;

import java.util.List;

public interface UserService {

    boolean verifyCredentials(String email,String pass);
    void updateUser(Long usr,User newUser);
    List<User> findAllUsers();
    List<User> findByEmail(String email);
    User findById(Long id);
    User findFirstByEmailAndId(String email, Long id);
    void addUser(User user);
    User addUserRet(User user);
    User findFirstByEmailAndPassword(String email,String password);
    User findFirstByEmail(String email);
    String deleteById(Long id);
    String updateUser(UserDTO dto);
    User findFirstById(Long id);
<<<<<<< HEAD
    String loginTimestamp(String email);
    String logoutTimestamp(String email);
    int getNoOfLoggedUsers();
=======
>>>>>>> 583e829b44b8ed474109c9b0b4d0a65ffeb42dd4

}
