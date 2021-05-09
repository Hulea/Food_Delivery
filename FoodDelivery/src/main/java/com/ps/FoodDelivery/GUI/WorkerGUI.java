package com.ps.FoodDelivery.GUI;


import java.awt.EventQueue;

import javax.swing.JFrame;

public class WorkerGUI {

    private JFrame frame;


    public WorkerGUI() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setVisible(true);
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

}
