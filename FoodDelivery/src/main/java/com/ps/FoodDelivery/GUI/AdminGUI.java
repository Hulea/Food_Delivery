package com.ps.FoodDelivery.GUI;


import com.ps.FoodDelivery.repository.FoodOrderRepository;
import com.ps.FoodDelivery.repository.OfferRepository;
import com.ps.FoodDelivery.repository.UserRepository;
import com.ps.FoodDelivery.service.FoodService;
import com.ps.FoodDelivery.service.RestaurantService;
import com.ps.FoodDelivery.service.impl.UserServiceImpl;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class AdminGUI {

    private JFrame frmAdmin;
    private AdminUserGUI adminUserGUI;
    private AdminRestaurantGUI adminRestaurantGUI;

    public AdminGUI(UserRepository userRepository,
                    UserServiceImpl userService,
                    FoodOrderRepository foodOrderRepository,
                    OfferRepository offerRepository,
                    RestaurantService restaurantService,
                    FoodService foodService) {

        frmAdmin = new JFrame();
        frmAdmin.setTitle("Admin");
        frmAdmin.setVisible(true);
        frmAdmin.setBounds(100, 100, 200, 235);
        frmAdmin.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frmAdmin.getContentPane().setLayout(null);

        JButton usersBtn = new JButton("Users");
        usersBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                adminUserGUI = new AdminUserGUI(userRepository,
                        userService,
                        foodOrderRepository,
                        offerRepository);

            }
        });
        usersBtn.setBounds(10, 11, 164, 50);
        frmAdmin.getContentPane().add(usersBtn);


        JButton workersBtn = new JButton("Workers");
        workersBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        workersBtn.setBounds(10, 74, 164, 50);
        frmAdmin.getContentPane().add(workersBtn);


        JButton restaurantBtn = new JButton("Restaurants");
        restaurantBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    adminRestaurantGUI = new AdminRestaurantGUI(
                            restaurantService,
                            foodService
                    );
            }
        });
        restaurantBtn.setBounds(10, 135, 164, 50);
        frmAdmin.getContentPane().add(restaurantBtn);

    }
}

