/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import view.MainFrame;
import model.Sort;
import view.ControlPanel;
import view.VisualPanel;
import view.HeaderPanel;
<<<<<<< HEAD

=======
import view.CardNumberComponent;
import java.awt.Point;
        
>>>>>>> feb0ffbcdd2574ce09459e029de5c1061008f731
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
        initSortButtonListener();
    }
    
    private void initSortButtonListener(){
        ControlPanel controlPanel = frm.getControlPanel();
        controlPanel.disableBtn();
        VisualPanel visualPanel = frm.getVisualPanel();
        visualPanel.initVisualPanel();
        HeaderPanel headerPanel = frm.getHeaderPanel();
        headerPanel.addSortBtnListener((e) -> {
            controlPanel.enableBtn();
        });
       
    }
    
    public void runFrame(){
        java.awt.EventQueue.invokeLater(() -> {
            frm.setVisible(true);
        });
    }
}
