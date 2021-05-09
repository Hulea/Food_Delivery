package com.ps.FoodDelivery.GUI;


import com.ps.FoodDelivery.model.*;
import com.ps.FoodDelivery.repository.*;
import com.ps.FoodDelivery.service.*;
import com.ps.FoodDelivery.service.impl.RestaurantServiceImpl;
import org.aspectj.weaver.World;
import org.dom4j.DocumentException;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class UserGUI {

    private JFrame frame;
    private JTable restaurantTable;
    private Long id;
    private JTable yourOrderTable;
    private JTable foodsTable;

    public UserGUI(UserRepository userRepository,
                   UserService userService,
                   RestaurantRepository restaurantRepository,
                   FoodOrderService foodOrderService,
                   FoodTransportService foodTransportService,
                   FoodService foodService,
                   RestaurantServiceImpl restaurantService,
                   OfferService offerService,
                   Long id) {

        this.id = id;

         JTextField nameField;
         JTextField locationField;

        frame = new JFrame();
        frame.setVisible(true);
        frame.setBounds(100, 100, 460, 600);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel yourOrderLbl = new JLabel("Your Order");
        yourOrderLbl.setBounds(340, 11, 140, 14);
        frame.getContentPane().add(yourOrderLbl);

        JLabel onTheWaylbl = new JLabel("On the way");
        onTheWaylbl.setBounds(340, 121, 140, 14);
        frame.getContentPane().add(onTheWaylbl);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(294, 36, 140, 74);
        frame.getContentPane().add(scrollPane);



        JScrollPane scrollPane_1 = new JScrollPane();
        scrollPane_1.setBounds(294, 139, 140, 74);
        frame.getContentPane().add(scrollPane_1);



        JScrollPane scrollPane_2 = new JScrollPane();
        scrollPane_2.setBounds(10, 296, 206, 254);
        frame.getContentPane().add(scrollPane_2);



        JLabel lblNewLabel = new JLabel("Restaurants");
        lblNewLabel.setBounds(80, 271, 116, 14);
        frame.getContentPane().add(lblNewLabel);

        JScrollPane scrollPane_3 = new JScrollPane();
        scrollPane_3.setBounds(226, 296, 206, 254);
        frame.getContentPane().add(scrollPane_3);



        JLabel lblFoods = new JLabel("Foods");
        lblFoods.setBounds(304, 271, 116, 14);
        frame.getContentPane().add(lblFoods);

        nameField = new JTextField();
        nameField.setText(userService.findById(this.id).getFirstName() + " " + userService.findById(this.id).getLastName());
        nameField.setEditable(false);
        nameField.setBounds(130, 8, 140, 20);
        frame.getContentPane().add(nameField);
        nameField.setColumns(10);

        JLabel lblNewLabel_1 = new JLabel("Name");
        lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_1.setBounds(10, 11, 110, 14);
        frame.getContentPane().add(lblNewLabel_1);

        JLabel lblNewLabel_1_1 = new JLabel("Location");
        lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_1_1.setBounds(10, 37, 110, 14);
        frame.getContentPane().add(lblNewLabel_1_1);

        locationField = new JTextField();
        locationField.setColumns(10);
        locationField.setBounds(130, 34, 140, 20);
        frame.getContentPane().add(locationField);

        JButton fillButton = new JButton("Fill");
        fillButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String[] tableCols =
                        {
                                "Name",
                                "Location"
                        };
                DefaultTableModel defaultTableModel = new DefaultTableModel(tableCols,0);
                restaurantTable = new JTable(defaultTableModel);
                scrollPane_2.setViewportView(restaurantTable);

                String[] vals = new String[2];

                for(Restaurant i : restaurantService.showAllRestaurants())
                {
                    vals[0] = String.valueOf(i.getName());
                    vals[1] = String.valueOf(i.getLocation());
                    defaultTableModel.addRow(vals);
                }











                String tableCols3[] = {"Name","Price"};
                DefaultTableModel defaultTableModel2 = new DefaultTableModel(tableCols3,0);
                yourOrderTable = new JTable(defaultTableModel2);
                scrollPane.setViewportView(yourOrderTable);
                String[] vals3 = new String[2];

              try {
                  for (Food i : foodOrderService.findFirstByUser(userService.findById(id)).getFoodList()) {

                      vals3[0] = i.getName();
                      vals3[1] = i.getPrice() + "";
                      /*for (int k = 0; k < 2; k++)
                          System.out.println("!!!!!!" + vals[k]);*/
                      defaultTableModel2.addRow(vals3);


                  }
              }
              catch(NullPointerException exc)
              {
                  System.out.print("NullPointerException caught");
              }


            }
        });
        fillButton.setBounds(174, 237, 89, 23);
        frame.getContentPane().add(fillButton);

        JButton showFoodButton = new JButton("Show Foods");
        showFoodButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                String[] tableCols2 = {"Name",
                        "Price","Description","Remaining stock"};
                DefaultTableModel defaultTableModel1 = new DefaultTableModel(tableCols2,0);
                foodsTable = new JTable(defaultTableModel1);
                scrollPane_3.setViewportView(foodsTable);

                String[] vals2 = new String[4];


                int selectedRow = restaurantTable.getSelectedRow();
                String auxres = restaurantTable.getModel().getValueAt(selectedRow,0).toString();
                Restaurant index = restaurantRepository.findFirstByName(auxres);
                for(Food i : restaurantService.getRestaurantFood(index.getId()))
                {
                    vals2[0] = String.valueOf(i.getName());
                    vals2[1] = String.valueOf(i.getPrice());
                    vals2[2] = String.valueOf(i.getDescription());
                    vals2[3] = String.valueOf(i.getRemainingStock());
                    defaultTableModel1.addRow(vals2);
                }

            }
        });
        showFoodButton.setBounds(174, 262, 89, 23);
        frame.getContentPane().add(showFoodButton);




        JButton btnAdd = new JButton("Place order");
        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                FoodTransport aux =
                        FoodTransport.builder().
                                location(locationField.getText()).
                                price(foodOrderService.computePrice(foodOrderService.findFirstByUser(userService.findById(id)))).
                                departure(LocalTime.now()).
                                arrival(LocalTime.now().plusMinutes(15)).
                                user(userService.findById(id)).
                                foodOrder(foodOrderService.findFirstByUser(userService.findById(id))).
                                build();
                foodTransportService.addFoodTransport(aux);


                String[] tableCols2 = {
                        "Location","Price","Departure","Arrival","Food ordered"
                };
                DefaultTableModel defaultTableModel1 = new DefaultTableModel(tableCols2,0);
                JTable onTheWayTable = new JTable(defaultTableModel1);
                scrollPane_1.setViewportView(onTheWayTable);
                String[] vals2= new String[5];
                for(FoodTransport i : foodTransportService.findByUser(userService.findById(id))){
                    vals2[0] = i.getLocation();
                    vals2[1] = i.getPrice() + "";
                    vals2[2] = i.getDeparture().toString();
                    vals2[3] = i.getArrival().toString();
                    vals2[4] = i.getFoodOrder().getFoodList().toString();
                    defaultTableModel1.addRow(vals2);
                }


                PrintWriter writer = null;
                try {
                    writer = new PrintWriter("receipt.txt", "UTF-8");
                } catch (FileNotFoundException fileNotFoundException) {
                    fileNotFoundException.printStackTrace();
                } catch (UnsupportedEncodingException unsupportedEncodingException) {
                    unsupportedEncodingException.printStackTrace();
                }
                writer.println("Placed at : " + LocalTime.now());
                double price = foodOrderService.computePrice(foodOrderService.findFirstByUser(userService.findById(id)));
                //Offer auxOffer = offerService.findFirstByUser(userService.findById(id));
                //price = price - auxOffer.getReduction()/100*price;
                writer.println("Price : " + price);
                writer.close();


                foodOrderService.deleteByUser(userService.findById(id));


            }
        });
        btnAdd.setBounds(174, 117, 89, 23);
        frame.getContentPane().add(btnAdd);



        JButton btnAddFood = new JButton("Add");
        btnAddFood.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                int selectedRow = foodsTable.getSelectedRow();
                String auxres = foodsTable.getModel().getValueAt(selectedRow,0).toString();
                Food aux = foodService.findFirstByName(auxres);

                try {
                    foodOrderService.addFood(
                            foodOrderService.findFirstByUser(userService.findById(id)),
                            aux
                    );
                }


                catch(NullPointerException ex){
                    List<Food> f = new ArrayList<Food>();
                    f.add(aux);
                    FoodOrder fo = FoodOrder.builder().
                            user(userService.findById(id)).
                            foodList(f).build();
                    foodOrderService.save(fo);
                }
                foodService.decrementStock(aux);

            }
        });
        btnAddFood.setBounds(345, 267, 89, 23);
        frame.getContentPane().add(btnAddFood);

        JButton removeBtn = new JButton("Remove");
        removeBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                int selectedRow = yourOrderTable.getSelectedRow();
                String auxres = yourOrderTable.getModel().getValueAt(selectedRow,0).toString();
                Food aux = foodService.findFirstByName(auxres);

                foodOrderService.removeFood(
                        foodOrderService.findFirstByUser(userService.findById(id)),
                        aux
                );
                foodService.incrementStock(aux);


            }
        });
        removeBtn.setBounds(345, 224, 89, 23);
        frame.getContentPane().add(removeBtn);

    }



}
