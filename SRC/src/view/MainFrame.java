/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JFrame;

/**
 *
 * @author GIA BAO
 */
public class MainFrame extends javax.swing.JFrame {

    private HeaderPanel headerPanel;
    private ControlPanel controlPanel;
    private VisualPanel visualPanel;
    
    
    public MainFrame() {
        initComponents();
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        getContentPane().setBackground(Color.white);
        setupUi();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("MÔ PHỎNG CÁC THUẬT TOÁN SẮP XẾP");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void setupUi(){
        setLayout(new BorderLayout());
        headerPanel = new HeaderPanel();
        controlPanel = new ControlPanel();
        visualPanel = new VisualPanel();
        
        add(headerPanel, BorderLayout.NORTH);
        add(controlPanel, BorderLayout.WEST);
        add(visualPanel, BorderLayout.CENTER);
        
    }
    
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            new MainFrame().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
