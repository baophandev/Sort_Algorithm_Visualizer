/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.lang.reflect.Array;
import view.MainFrame;
import model.Sort;
import view.ControlPanel;
import view.VisualPanel;
import view.HeaderPanel;
import java.util.Random;
import java.util.List;
import java.util.ArrayList;
import javax.swing.JOptionPane;

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
        initArrayListener();
        initRandomListener();
        initVisualPanel();
    }
    
    private void initSortButtonListener(){
        ControlPanel controlPanel = frm.getControlPanel();
        controlPanel.disableBtn();
        
        HeaderPanel headerPanel = frm.getHeaderPanel();
        headerPanel.addSortBtnListener((e) -> {
            controlPanel.enableBtn();
        });
       
    }
    
    
    private void initArrayListener(){
        ControlPanel controlPanel = frm.getControlPanel();
        
    }
    
    private void initVisualPanel(){
        VisualPanel visualPanel = frm.getVisualPanel();
        visualPanel.initVisualPanel();
        Random rdSize = new Random();
        Random rdValue = new Random();
        int randomSize = rdSize.nextInt(10, 20);
        List<Integer> initData = new ArrayList<>();
        for(int i = 0; i < randomSize; i++){
            int value = rdValue.nextInt(50);
            initData.add(value);
        }
        
        frm.getVisualPanel().removeAll();
        frm.getVisualPanel().setNodes(initData);
    }
    
    private void initRandomListener() {
    frm.getControlPanel().addRandomBtnListener((e) -> {
        Random random = new Random(System.currentTimeMillis());
        int size = frm.getControlPanel().getRandomSize();
        
        // Kiểm tra giá trị của size
            if (size <= 1 || size > MAX_NODES) {
                JOptionPane.showMessageDialog(frm, 
                    "Số lượng phần tử không hợp lệ. Vui lòng nhập số từ 2 đến " + MAX_NODES + ".",
                    "Lỗi Nhập Liệu", 
                    JOptionPane.ERROR_MESSAGE);
                return;
            }
        
        List<Integer> initData = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            int value = random.nextInt(50); // Giới hạn giá trị từ 0 tới 50
            initData.add(value);
            System.out.println("Giá trị ngẫu nhiên " + (i + 1) + ": " + value);
        }
        frm.getVisualPanel().removeAll();
        frm.getVisualPanel().setNodes(initData);
    });
}

    
    public void runFrame(){
        java.awt.EventQueue.invokeLater(() -> {
            frm.setVisible(true);
        });
    }
}
