package com.ps.FoodDelivery.GUI;

import com.ps.FoodDelivery.model.User;
import com.ps.FoodDelivery.repository.UserRepository;
import com.ps.FoodDelivery.service.impl.UserServiceImpl;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class RegisterGUI {


    public RegisterGUI(UserRepository userRepository) {
        JFrame frame = new JFrame();
        frame.setVisible(true);
        frame.setBounds(100, 100, 280, 300);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JTextArea txtrFirstName = new JTextArea();
        txtrFirstName.setBounds(10, 11, 115, 22);
        txtrFirstName.setText("First Name");
        txtrFirstName.setEditable(false);
        frame.getContentPane().add(txtrFirstName);

        JTextArea txtrLastName = new JTextArea();
        txtrLastName.setBounds(10, 42, 115, 22);
        txtrLastName.setText("Last Name");
        txtrLastName.setEditable(false);
        frame.getContentPane().add(txtrLastName);

        JTextArea txtrEmail = new JTextArea();
        txtrEmail.setBounds(10, 75, 115, 22);
        txtrEmail.setText("Email");
        txtrEmail.setEditable(false);
        frame.getContentPane().add(txtrEmail);

        JTextArea txtrPhoneNumber = new JTextArea();
        txtrPhoneNumber.setBounds(10, 108, 115, 22);
        txtrPhoneNumber.setText("Phone Number");
        txtrPhoneNumber.setEditable(false);
        frame.getContentPane().add(txtrPhoneNumber);

        JTextArea txtrPassword = new JTextArea();
        txtrPassword.setBounds(10, 141, 115, 22);
        txtrPassword.setText("Password");
        txtrPassword.setEditable(false);
        frame.getContentPane().add(txtrPassword);

        JTextField firstNameField = new JTextField();
        firstNameField.setBounds(135, 13, 115, 20);
        frame.getContentPane().add(firstNameField);
        firstNameField.setColumns(10);

        JTextField lastNameField = new JTextField();
        lastNameField.setBounds(135, 44, 115, 20);
        lastNameField.setColumns(10);
        frame.getContentPane().add(lastNameField);

        JTextField emailField = new JTextField();
        emailField.setBounds(135, 77, 115, 20);
        emailField.setColumns(10);
        frame.getContentPane().add(emailField);

        JTextField phoneNumberField = new JTextField();
        phoneNumberField.setBounds(135, 110, 115, 20);
        phoneNumberField.setColumns(10);
        frame.getContentPane().add(phoneNumberField);

        JTextField passwordField = new JTextField();
        passwordField.setBounds(135, 143, 115, 20);
        passwordField.setColumns(10);
        frame.getContentPane().add(passwordField);

        JButton btnNewButton = new JButton("Register");
        btnNewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

<<<<<<< HEAD
                User aux =  User.builder().
                        firstName(firstNameField.getText()).
                        lastName(lastNameField.getText()).
                        phoneNumber(phoneNumberField.getText()).
                        email(emailField.getText()).
                        password(passwordField.getText()).
                        accountType(User.roles.USER)
                        .build();
=======
                User aux = new User(null,firstNameField.getText(),
                        lastNameField.getText(),
                        phoneNumberField.getText(),
                        emailField.getText(),
                        passwordField.getText(),
                        User.roles.USER);
>>>>>>> 583e829b44b8ed474109c9b0b4d0a65ffeb42dd4


                    try {
                        if (userRepository.findFirstByEmail(aux.getEmail()).getEmail() == null)
                        //if(aux.getEmail().equals(userRepository.findFirstByEmail(aux.getEmail()).getEmail()))
                            JOptionPane.showMessageDialog(frame,"Email is already used!");
                    }
                    catch(NullPointerException ex)
                    {
                        JOptionPane.showMessageDialog(frame, "Registration successful!");
                        userRepository.save(aux);

                    }

            }
        });
        btnNewButton.setBounds(10, 190, 115, 23);
        frame.getContentPane().add(btnNewButton);


        JButton btnBack = new JButton("Back");
        btnBack.setBounds(135, 190, 115, 23);
        frame.getContentPane().add(btnBack);
    }




}

