package com.ps.FoodDelivery.GUI;

import com.ps.FoodDelivery.model.User;
import com.ps.FoodDelivery.repository.*;
import com.ps.FoodDelivery.service.FoodOrderService;
import com.ps.FoodDelivery.service.FoodService;
import com.ps.FoodDelivery.service.FoodTransportService;
import com.ps.FoodDelivery.service.OfferService;
import com.ps.FoodDelivery.service.impl.RestaurantServiceImpl;
import com.ps.FoodDelivery.service.impl.UserServiceImpl;

import javax.swing.*;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login {

    public JFrame frame = new JFrame();
    private JTextField textField;
    private JPasswordField passwordField;
    private AdminGUI adminGUI;
    private UserGUI userGUI;
    private WorkerGUI workerGUI;


    public Login(UserRepository userRepository,
                 UserServiceImpl userService,
                 FoodOrderRepository foodOrderRepository,
                 OfferRepository offerRepository,
                 RestaurantRepository restaurantRepository,
                 FoodTransportService foodTransportService,
                 FoodService foodService,
                 RestaurantServiceImpl restaurantService,
                 FoodOrderService foodOrderService,
                 OfferService offerService) {
        frame.setBounds(100, 100, 300, 350);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JButton btnNewButton = new JButton("Login");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                UserServiceImpl userService = new UserServiceImpl(userRepository);
                if(userService.verifyCredentials(textField.getText(),passwordField.getText())) {
                    User aux = userRepository.findFirstByEmail(textField.getText());
                    if(aux.getAccountType() == User.roles.ADMIN)
                        adminGUI = new AdminGUI(userRepository,
                                userService,
                                foodOrderRepository,
                                offerRepository,
                                restaurantService,
                                foodService);
                    if(aux.getAccountType() == User.roles.USER)
                        userGUI = new UserGUI(userRepository,
                                userService,
                                restaurantRepository,
                                foodOrderService,
                                foodTransportService,
                                foodService,
                                restaurantService,
                                offerService,
                                aux.getId());
                    if(aux.getAccountType() == User.roles.WORKER)
                        workerGUI = new WorkerGUI();
                }
                else JOptionPane.showMessageDialog(frame,"Wrong credentials!");

            }
        });

        btnNewButton.setBounds(100, 170, 85, 25);
        frame.getContentPane().add(btnNewButton);

        textField = new JTextField();
        textField.setBounds(100, 70, 85, 20);
        frame.getContentPane().add(textField);
        textField.setColumns(10);

        passwordField = new JPasswordField();
        passwordField.setBounds(100, 120, 85, 20);
        frame.getContentPane().add(passwordField);
        frame.setVisible(true);

        JButton btnRegister = new JButton("Register");
        btnRegister.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RegisterGUI aux = new RegisterGUI(userRepository);
            }
        });
        btnRegister.setBounds(100, 225, 85, 25);
        frame.getContentPane().add(btnRegister);

        JButton btnForgotCredentials = new JButton("Forgot credentials?");
        btnForgotCredentials.setBounds(100, 275, 85, 25);
        frame.getContentPane().add(btnForgotCredentials);
    }


}
