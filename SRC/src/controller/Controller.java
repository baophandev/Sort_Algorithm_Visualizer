/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.io.File;
import java.io.FileNotFoundException;
import view.MainFrame;
import model.Sort;
import view.ControlPanel;
import view.VisualPanel;
import view.HeaderPanel;
import java.util.Random;
import java.util.List;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Arrays;
import javax.swing.JOptionPane;
import config.Configuration;
import java.util.stream.Collectors;
import model.BubbleSort;
import model.SelectionSort;
import model.InsertionSort;
import view.CodeVisual;

/**
 *
 * @author GIA BAO
 */
public class Controller {
    
    public static void main(String args[]) {
        new Controller().runFrame();
    }
    
    private final int MAX_NODES = 20;
    
    private final MainFrame frm;
    private Sort algorithm;
    private int sortType, speed;
    
    public Controller() {
        frm = MainFrame.getInstance();
        speed = 1;
        initListeners();
    }
    
    private void initListeners() {
        initSortArigthmListener();
        initArrayListener();
        initRandomListener();
        initVisualPanel();
        initReadFileListener();
        initSortBtnASC();
        initSortBtnDESC();
        initStopBtnListener();
    }
    
    private void initSortArigthmListener() {
        ControlPanel controlPanel = frm.getControlPanel();
        view.VisualPanel visualPanel = frm.getVisualPanel();
       
        CodeVisual codeVisual = frm.getCodeVisual();
        view.InfomationPanel infomationPanel = frm.getInfomationPanel();
        
        
        HeaderPanel headerPanel = frm.getHeaderPanel();
        headerPanel.addSortBtnListener((e) -> {
             controlPanel.enableBtn();
            int alg = headerPanel.getAlgorithm();
            algorithm = switch (alg) {
                case Configuration.BUBBLE_SORT ->
                    new BubbleSort(visualPanel, codeVisual, infomationPanel);
                case Configuration.INSERTION_SORT -> 
                    new InsertionSort(visualPanel, codeVisual, infomationPanel);
                default ->
                    new SelectionSort(visualPanel, codeVisual, infomationPanel);
            };
            codeVisual.addCode(algorithm.getCode(sortType));
        });
        
    }
    
    private void initSortBtnASC() {
        ControlPanel controlPanel = frm.getControlPanel();
        CodeVisual codeVisual = frm.getCodeVisual();
        
        controlPanel.addAscBtnListener((e) -> {
            int[] arrayToSort = getSortData();
            for (int i = 0; i < arrayToSort.length; i++) {
                System.out.print(arrayToSort[i] + ", ");
            }
            frm.getControlPanel().enableStopBtn();
            algorithm.setStop(false);
            
            final int[] orginArray = Arrays.copyOf(arrayToSort, arrayToSort.length);
            sortType = Configuration.ASC;
            algorithm.sort(arrayToSort, sortType);
            codeVisual.addCode(algorithm.getCode(sortType));
            codeVisual.setVisible(true);
            for (int i = 0; i < arrayToSort.length; i++) {
                System.err.print(arrayToSort[i] + ", ");
            }
            System.out.println("\n");
            frm.getVisualPanel().removeAll();
            // Chuyển đổi mảng int[] thành List<Integer>
            List<Integer> listToSort = Arrays.stream(arrayToSort)
                    .boxed()
                    .collect(Collectors.toList());
            
            frm.getVisualPanel().setNodes(listToSort); // Truyền danh sách vào setNodes

        });
    }
    
    private void initSortBtnDESC(){
        ControlPanel contraPanel = frm.getControlPanel();
        CodeVisual codeVisual = frm.getCodeVisual();
        
        contraPanel.addDESCBtnListener((e) -> {
            int[] arrayToSort = getSortData();
            for (int i = 0; i < arrayToSort.length; i++) {
                System.out.print(arrayToSort[i] + ", ");
            }
            frm.getControlPanel().enableStopBtn();
            algorithm.setStop(false);
            
            final int[] orginArray = Arrays.copyOf(arrayToSort, arrayToSort.length);
            sortType = Configuration.DESC;
            algorithm.sort(arrayToSort, sortType);
            codeVisual.addCode(algorithm.getCode(sortType));
            codeVisual.setVisible(true);
            for (int i = 0; i < arrayToSort.length; i++) {
                System.err.print(arrayToSort[i] + ", ");
            }
            System.out.println("\n");
            frm.getVisualPanel().removeAll();
            // Chuyển đổi mảng int[] thành List<Integer>
            List<Integer> listToSort = Arrays.stream(arrayToSort)
                    .boxed()
                    .collect(Collectors.toList());
            
            frm.getVisualPanel().setNodes(listToSort); // Truyền danh sách vào setNodes
            
        });
    }
    
    private void initArrayListener() {
        ControlPanel controlPanel = frm.getControlPanel();
        controlPanel.addInitArrayListenter((e) -> {
            System.out.print("Yes");
            try {
                List<Integer> initData = controlPanel.getInitArray();
                if (initData != null) {
                    frm.getVisualPanel().removeAll();
                    frm.getVisualPanel().setNodes(initData);
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frm,
                        "Số lượng phần tử không hợp lệ. Vui lòng nhập số từ 2 đến " + MAX_NODES + ".",
                        "Lỗi Nhập Liệu",
                        JOptionPane.ERROR_MESSAGE);
            }
        });
    }
    
    private void initVisualPanel() {
        VisualPanel visualPanel = frm.getVisualPanel();
        visualPanel.initVisualPanel();
        Random rdSize = new Random();
        Random rdValue = new Random();
        int randomSize = rdSize.nextInt(10, 20);
        List<Integer> initData = new ArrayList<>();
        for (int i = 0; i < randomSize; i++) {
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
                System.out.print(value + ", ");
            }
            frm.getVisualPanel().removeAll();
            frm.getVisualPanel().setNodes(initData);
        });
    }
    
    private void initReadFileListener() {
        ControlPanel controlPanel = frm.getControlPanel();
        controlPanel.addFileBtnListener((e) -> {
            File f = frm.getFileToRead();
            if (f == null) {
                return;
            }
            
            List<Integer> initData = new ArrayList<>();
            try {
                Scanner sc = new Scanner(f);
                int size = sc.nextInt();
                for (int i = 0; i < size && i < MAX_NODES && sc.hasNextInt(); i++) {
                    initData.add(sc.nextInt());
                }
            } catch (FileNotFoundException | NoSuchElementException ex) {
                Logger.getLogger(Controller.class.getName()).log(Level.WARNING, "IOFile", ex);
            }
            
            frm.getVisualPanel().removeAll();
            frm.getVisualPanel().setNodes(initData);
        });
    }
    
    private void initStopBtnListener(){
        
        frm.getControlPanel().addStopBtnListener((e) -> {
            if( algorithm != null && !algorithm.isStop()){
                algorithm.setStop(true);
                frm.getControlPanel().enableBtn();
                frm.getCodeVisual().setVisible(false);
            }
        });
    }
    
    private int[] getSortData() {
        List<Integer> nodes = frm.getVisualPanel().getNodes();
        return nodes.stream().mapToInt((val) -> val).toArray();
    }
    
    public void runFrame() {
        java.awt.EventQueue.invokeLater(() -> {
            frm.setVisible(true);
        });
    }
}
