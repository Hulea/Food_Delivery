package com.ps.FoodDelivery.service.impl;

import com.ps.FoodDelivery.dto.UserDTO;
import com.ps.FoodDelivery.model.User;
import com.ps.FoodDelivery.repository.UserRepository;
import com.ps.FoodDelivery.service.UserService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
<<<<<<< HEAD
import java.time.LocalTime;
=======
>>>>>>> 583e829b44b8ed474109c9b0b4d0a65ffeb42dd4
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public boolean verifyCredentials(String email, String pass) {

        User aux = userRepository.findFirstByEmail(email);
        return pass.equals(aux.getPassword());

    }



    @Transactional
    @Override
    public void updateUser(Long usr,User newUser) {

        User aux = userRepository.findById(usr).orElseThrow();
        aux.setFirstName(newUser.getFirstName());
        aux.setLastName(newUser.getLastName());
        aux.setEmail(newUser.getEmail());
        aux.setPhoneNumber(newUser.getPhoneNumber());
        aux.setPassword(newUser.getPassword());
        userRepository.save(aux);
    }

    @Override
    public List<User> findAllUsers() {
        return this.userRepository.showAllUsers();
    }

    @Override
    public List<User> findByEmail(String email) {
        return userRepository.findAllByEmail(email);
    }

    @Override
    public User findById(Long id) {
        return userRepository.findFirstById(id);
    }

    @Override
    public User findFirstByEmailAndId(String email, Long id) {
        return userRepository.findFirstByEmailAndId(email,id);
    }

    @Override
    public void addUser(User user) {
        this.userRepository.save(user);
    }

    @Override
    public User addUserRet(User user) {
        return userRepository.save(user);
    }

    @Override
    public User findFirstByEmailAndPassword(String email, String password) {
        return userRepository.findFirstByEmailAndPassword(email,password);
    }

    @Override
    public User findFirstByEmail(String email) {
        return userRepository.findFirstByEmail(email);
    }

    @Override
    public String deleteById(Long id) {
        userRepository.deleteById(id);
        return "ok delete";
    }

    @Override
    public String updateUser(UserDTO dto) {
        User aux = userRepository.findFirstById(dto.getId());

        System.out.println(aux);
        aux.setFirstName(dto.getFirstname());
        aux.setLastName(dto.getLastname());
        aux.setPhoneNumber(dto.getPhonenumber());
        aux.setEmail(dto.getEmail());
        aux.setPassword(dto.getPassword());

        userRepository.save(aux);

        return "update ok";
    }

    @Override
    public User findFirstById(Long id) {
        return userRepository.findFirstById(id);
    }
<<<<<<< HEAD

    @Override
    public String loginTimestamp(String email) {
        User aux = userRepository.findFirstByEmail(email);

        System.out.println(aux);
        aux.setLoginTime(LocalTime.now());
        aux.setLogged(true);

        userRepository.save(aux);

        return "ok login timestamp";

    }

    @Override
    public String logoutTimestamp(String email) {

        User aux = userRepository.findFirstByEmail(email);

        System.out.println(aux);
        aux.setLogoutTime(LocalTime.now());
        aux.setLogged(false);

        userRepository.save(aux);

        return "ok logout timestamp";

    }

    @Override
    public int getNoOfLoggedUsers() {
        return userRepository.getLoggedUsers().size();
    }
=======
>>>>>>> 583e829b44b8ed474109c9b0b4d0a65ffeb42dd4
}
