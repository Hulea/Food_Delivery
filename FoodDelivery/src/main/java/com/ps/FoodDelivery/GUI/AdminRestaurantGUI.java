package com.ps.FoodDelivery.GUI;

import com.ps.FoodDelivery.model.Restaurant;
import com.ps.FoodDelivery.service.FoodService;
import com.ps.FoodDelivery.service.RestaurantService;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminRestaurantGUI {

    private JFrame frame;
    private JTable restaurantTable;
    private JTextField idTextField;
    private JTextField nameTextField;
    private JTextField locationTextField;


    public AdminRestaurantGUI(RestaurantService restaurantService,
                              FoodService foodService) {

        frame = new JFrame();
        frame.setVisible(true);
        frame.setBounds(100, 100, 945, 635);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 11, 653, 384);
        frame.getContentPane().add(scrollPane);



        JButton fillBtn = new JButton("Fill");
        fillBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String[] tableCols = {"Id","Name","Location","Food"};

                DefaultTableModel defaultTableModel = new DefaultTableModel(tableCols,0);
                restaurantTable = new JTable(defaultTableModel);
                scrollPane.setViewportView(restaurantTable);

                String[] vals = new String[4];

                for(Restaurant i : restaurantService.showAllRestaurants()){

                    vals[0] = String.valueOf(i.getId());
                    vals[1] = String.valueOf(i.getName());
                    vals[2] = String.valueOf(i.getLocation());
                    vals[3] = i.getFood().toString();
                    defaultTableModel.addRow(vals);
                }


            }
        });
        fillBtn.setBounds(99, 507, 89, 23);
        frame.getContentPane().add(fillBtn);

        JButton addButton = new JButton("Add");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


            }
        });
        addButton.setBounds(0, 507, 89, 23);
        frame.getContentPane().add(addButton);

        JLabel lblNewLabel = new JLabel("Id");
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setBounds(10, 410, 76, 14);
        frame.getContentPane().add(lblNewLabel);

        JLabel lblName = new JLabel("Name");
        lblName.setHorizontalAlignment(SwingConstants.CENTER);
        lblName.setBounds(13, 443, 76, 14);
        frame.getContentPane().add(lblName);

        JLabel lblNewLabel_1_1 = new JLabel("Location");
        lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_1_1.setBounds(13, 468, 76, 14);
        frame.getContentPane().add(lblNewLabel_1_1);

        JButton removeBtn = new JButton("Remove");
        removeBtn.setBounds(0, 538, 89, 23);
        frame.getContentPane().add(removeBtn);

        idTextField = new JTextField();
        idTextField.setBounds(103, 407, 86, 20);
        frame.getContentPane().add(idTextField);
        idTextField.setColumns(10);

        nameTextField = new JTextField();
        nameTextField.setColumns(10);
        nameTextField.setBounds(103, 438, 86, 20);
        frame.getContentPane().add(nameTextField);

        locationTextField = new JTextField();
        locationTextField.setColumns(10);
        locationTextField.setBounds(103, 465, 86, 20);
        frame.getContentPane().add(locationTextField);
    }
}

