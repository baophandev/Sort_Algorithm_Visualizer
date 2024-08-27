/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import view.MainFrame;
import model.Sort;
/**
 *
 * @author GIA BAO
 */
public class Controller {
    public static void main(String args[]){
       new Controller().runFrame();
    }
    
    private final int MAX_NODES = 20;
    
    private final MainFrame frm;
    private Sort algorithm;
    private int sortType, speed;
    
    
    
    public Controller(){
        frm = MainFrame.getInstance();
        speed = 1;
        initListeners();
    }
    
    private void initListeners(){
        
    }
    
    public void runFrame(){
        java.awt.EventQueue.invokeLater(() -> {
            frm.setVisible(true);
        });
    }
}
