package com.ps.FoodDelivery.GUI;

import com.ps.FoodDelivery.model.FoodOrder;
import com.ps.FoodDelivery.model.Offer;
import com.ps.FoodDelivery.model.User;
import com.ps.FoodDelivery.repository.FoodOrderRepository;
import com.ps.FoodDelivery.repository.OfferRepository;
import com.ps.FoodDelivery.repository.UserRepository;
import com.ps.FoodDelivery.service.impl.UserServiceImpl;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminUserGUI {

    private JTable offersTable;

    public AdminUserGUI(UserRepository userRepository,
                        UserServiceImpl userService,
                        FoodOrderRepository foodOrderRepository,
                        OfferRepository offerRepository) {

        JFrame frame = new JFrame();
        frame.setBounds(100, 100, 955, 730);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        frame.setVisible(true);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 380, 597, 300);
        frame.getContentPane().add(scrollPane);



        JScrollPane scrollPane_1 = new JScrollPane();
        scrollPane_1.setBounds(629, 33, 300, 300);
        frame.getContentPane().add(scrollPane_1);



        JScrollPane scrollPane_2 = new JScrollPane();
        scrollPane_2.setBounds(629, 380, 300, 300);
        frame.getContentPane().add(scrollPane_2);



        JComboBox comboBox = new JComboBox();
        comboBox.addItem("ADMIN");
        comboBox.addItem("USER");
        comboBox.addItem("WORKER");

        comboBox.setBounds(10, 229, 86, 22);
        frame.getContentPane().add(comboBox);

        JLabel lblNewLabel = new JLabel("Users");
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setBounds(281, 359, 46, 14);
        frame.getContentPane().add(lblNewLabel);

        JLabel lblOrders = new JLabel("Orders");
        lblOrders.setHorizontalAlignment(SwingConstants.CENTER);
        lblOrders.setBounds(752, 11, 46, 14);
        frame.getContentPane().add(lblOrders);

        JLabel lblOffers = new JLabel("Offers");
        lblOffers.setHorizontalAlignment(SwingConstants.CENTER);
        lblOffers.setBounds(752, 359, 46, 14);
        frame.getContentPane().add(lblOffers);

        JTextField idField = new JTextField();
        idField.setBounds(119, 8, 86, 20);
        frame.getContentPane().add(idField);
        idField.setColumns(10);

        JLabel idLabel = new JLabel("Id");
        idLabel.setBounds(10, 11, 46, 14);
        frame.getContentPane().add(idLabel);

        JLabel firstNameLabel = new JLabel("First Name");
        firstNameLabel.setBounds(10, 36, 86, 14);
        frame.getContentPane().add(firstNameLabel);

        JTextField firstNameField = new JTextField();
        firstNameField.setColumns(10);
        firstNameField.setBounds(119, 33, 86, 20);
        frame.getContentPane().add(firstNameField);

        JLabel lastNameLabel = new JLabel("Last Name");
        lastNameLabel.setBounds(10, 61, 86, 14);
        frame.getContentPane().add(lastNameLabel);

        JTextField lastNameField = new JTextField();
        lastNameField.setColumns(10);
        lastNameField.setBounds(119, 58, 86, 20);
        frame.getContentPane().add(lastNameField);

        JLabel emailLabel = new JLabel("Email");
        emailLabel.setBounds(10, 86, 86, 14);
        frame.getContentPane().add(emailLabel);

        JTextField emailField = new JTextField();
        emailField.setColumns(10);
        emailField.setBounds(119, 83, 86, 20);
        frame.getContentPane().add(emailField);

        JLabel phoneNumberLabel = new JLabel("Phone number");
        phoneNumberLabel.setBounds(10, 111, 86, 14);
        frame.getContentPane().add(phoneNumberLabel);

        JTextField phoneNumberField = new JTextField();
        phoneNumberField.setColumns(10);
        phoneNumberField.setBounds(119, 108, 86, 20);
        frame.getContentPane().add(phoneNumberField);

        JLabel passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(10, 136, 86, 14);
        frame.getContentPane().add(passwordLabel);

        JTextField passwordField = new JTextField();
        passwordField.setColumns(10);
        passwordField.setBounds(119, 133, 86, 20);
        frame.getContentPane().add(passwordField);

        JButton showUsersBtn = new JButton("Show Users");
        showUsersBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                String[] tableCols = {"Id",
                "First Name",
                "Last Name",
                "Email",
                "Phone Number",
                "Password",
                "Account Type"};

                DefaultTableModel defaultTableModel = new DefaultTableModel(tableCols,0);
                JTable usersTable = new JTable(defaultTableModel);
                scrollPane.setViewportView(usersTable);

                String[] vals = new String[7];

                for(User i : userRepository.showAllUsers()){

                    vals[0] = String.valueOf(i.getId());
                    vals[1] = String.valueOf(i.getFirstName());
                    vals[2] = String.valueOf(i.getLastName());
                    vals[3] = String.valueOf(i.getEmail());
                    vals[4] = String.valueOf(i.getPhoneNumber());
                    vals[5] = String.valueOf(i.getPassword());
                    vals[6] = String.valueOf(i.getAccountType());

                    defaultTableModel.addRow(vals);
                }




                String[] tableCols2 = {"Id",
                        "User",
                        "Ordered Food"};
                DefaultTableModel defaultTableModel2 = new DefaultTableModel(tableCols2,0);
                JTable ordersTable = new JTable(defaultTableModel2);
                scrollPane_1.setViewportView(ordersTable);

                String[] vals2 = new String[3];
                for(FoodOrder i : foodOrderRepository.showAllFoodOrders()){

                    vals2[0] = String.valueOf(i.getId());
                    vals2[1] = String.valueOf(i.getUser().getEmail());

                   /* for(Food j : i.getFoodList())
                        vals[2] = vals[2] + "," + j.getName();*/

                    vals2[2] = String.valueOf(i.getFoodList());

                    defaultTableModel2.addRow(vals2);
                    /*List<Food> aux= i.getFoodList();
                    for(Food j : aux) {
                        vals2[2] = String.valueOf(j.getName());
                        defaultTableModel2.addRow(vals2);*/

                }

            String[] tableCols3 = {"Id","Reduction","User"};
            DefaultTableModel defaultTableModel3 = new DefaultTableModel(tableCols3,0);
            offersTable = new JTable(defaultTableModel3);
            scrollPane_2.setViewportView(offersTable);
            String[] vals3 = new String[3];
            for(Offer i : offerRepository.showAllOffers()){
                vals3[0] = String.valueOf(i.getId());
                vals3[1] = String.valueOf(i.getReduction());
                vals3[2] = i.getUser().getEmail();
                defaultTableModel3.addRow(vals3);
            }


            }
        });
        showUsersBtn.setBounds(7, 161, 89, 23);
        frame.getContentPane().add(showUsersBtn);

        JButton addUserBtn = new JButton("Add User");
        addUserBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if(comboBox.getSelectedItem().equals("ADMIN")) {

                        User aux = User.builder().
                        firstName(firstNameField.getText()).
                        lastName(lastNameField.getText()).
                        email(emailField.getText()).
                        phoneNumber(phoneNumberField.getText()).
                        password(passwordField.getText())
                        .accountType(User.roles.ADMIN).build();

                        userRepository.save(aux);
                }

                if(comboBox.getSelectedItem().equals("USER")) {

                    User aux = User.builder().
                            firstName(firstNameField.getText()).
                            lastName(lastNameField.getText()).
                            email(emailField.getText()).
                            phoneNumber(phoneNumberField.getText()).
                            password(passwordField.getText())
                            .accountType(User.roles.USER).build();

                    userRepository.save(aux);
                }

                if(comboBox.getSelectedItem().equals("WORKER")) {

                    User aux = User.builder().
                            firstName(firstNameField.getText()).
                            lastName(lastNameField.getText()).
                            email(emailField.getText()).
                            phoneNumber(phoneNumberField.getText()).
                            password(passwordField.getText())
                            .accountType(User.roles.WORKER).build();

                    userRepository.save(aux);
                }

            }
        });
        addUserBtn.setBounds(116, 161, 89, 23);
        frame.getContentPane().add(addUserBtn);

        JButton updateUserBtn = new JButton("Update User");
        updateUserBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                User aux = userRepository.findFirstById(Long.parseLong(idField.getText()));
                User tmp = User.builder().
                        firstName(firstNameField.getText()).
                        lastName(lastNameField.getText()).
                        email(emailField.getText()).
                        phoneNumber(phoneNumberField.getText()).
                        password(passwordField.getText()).build();
                userService.updateUser(aux.getId(),tmp);


            }
        });
        updateUserBtn.setBounds(116, 195, 89, 23);
        frame.getContentPane().add(updateUserBtn);

        JButton deleteUserBtn = new JButton("Delete User");
        deleteUserBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                userRepository.deleteById(Long.parseLong(idField.getText()));

            }
        });
        deleteUserBtn.setBounds(7, 195, 89, 23);
        frame.getContentPane().add(deleteUserBtn);


        JLabel offerlbl = new JLabel("Offer id");
        offerlbl.setBounds(241, 11, 86, 14);
        frame.getContentPane().add(offerlbl);

        JTextField offerIdField = new JTextField();
        offerIdField.setColumns(10);
        offerIdField.setBounds(343, 8, 86, 20);
        frame.getContentPane().add(offerIdField);

        JButton btnDeleteOffer = new JButton("Delete Offer");
        btnDeleteOffer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                offerRepository.deleteById(Long.parseLong(offerIdField.getText()));

            }
        });
        btnDeleteOffer.setBounds(238, 82, 89, 23);
        frame.getContentPane().add(btnDeleteOffer);

        JLabel lblReduction = new JLabel("Reduction");
        lblReduction.setBounds(241, 58, 86, 14);
        frame.getContentPane().add(lblReduction);

        JTextField userReductionField = new JTextField();
        userReductionField.setColumns(10);
        userReductionField.setBounds(343, 31, 86, 20);
        frame.getContentPane().add(userReductionField);

        JLabel lblUserReductionId = new JLabel("User Id");
        lblUserReductionId.setBounds(241, 34, 86, 14);
        frame.getContentPane().add(lblUserReductionId);

        JTextField reductionField = new JTextField();
        reductionField.setColumns(10);
        reductionField.setBounds(343, 58, 86, 20);
        frame.getContentPane().add(reductionField);


        JButton btnAddoffer = new JButton("Add Offer");
        btnAddoffer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                Offer aux = Offer.builder().
                        user(userRepository.findFirstById(Long.parseLong(userReductionField.getText()))).
                        reduction(Integer.parseInt(reductionField.getText())).
                        build();
                offerRepository.save(aux);



            }
        });
        btnAddoffer.setBounds(340, 82, 89, 23);
        frame.getContentPane().add(btnAddoffer);




    }
}
