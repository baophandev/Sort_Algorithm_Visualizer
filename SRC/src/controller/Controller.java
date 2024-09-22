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
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.stream.Collectors;
import javax.swing.SwingWorker;
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
    private File saveFile;

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
        initSpeedChangeListener();
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

            final int[] originArray = Arrays.copyOf(arrayToSort, arrayToSort.length);
            sortType = Configuration.ASC;
            codeVisual.addCode(algorithm.getCode(sortType));
            codeVisual.setVisible(true);
            algorithm.resetSwapCount();
            algorithm.setSpeed(speed);

            SwingWorker<Void, Void> worker = new SwingWorker<>() {
                @Override
                protected Void doInBackground() {
                    algorithm.sort(arrayToSort, sortType);
                    return null;
                }

                @Override
                protected void done() {
                    if (!algorithm.isStop()) {
                        controlPanel.enableBtn();
                        frm.getCodeVisual().setVisible(false);
                        System.out.println("Sorting completed.");
                        frm.getInfomationPanel().setText("Hoàn thành sắp xếp");
                        frm.getVisualPanel().removeAll();
                        // Chuyển đổi mảng int[] thành List<Integer>
                        List<Integer> listToSort = Arrays.stream(arrayToSort)
                                .boxed()
                                .collect(Collectors.toList());

                        frm.getVisualPanel().setNodes(listToSort); // Truyền danh sách vào setNodes
                        String res = "Kết quả sắp xếp tăng dần:" 
                                +"\nMảng gốc: " + Arrays.toString(originArray)
                                + "\nKết quả sắp xếp: " + Arrays.toString(arrayToSort)
                                +"\nSố lần hoán đổi: " + algorithm.getSwapCount();
                        if (frm.showConfirmMessage(res + "\nBạn có muốn xuất kết quả ra file không?")) {
                            saveSortingResultToFile(res);
                        }
                    }else{
                        frm.getInfomationPanel().setText("Đã dừng sắp xếp");
                    }
                }
            };

            worker.execute();
            
            for (int i = 0; i < arrayToSort.length; i++) {
                System.err.print(arrayToSort[i] + ", ");
            }
            System.out.println("\n");

        });
    }

    private void initSortBtnDESC() {
        ControlPanel controlPanel = frm.getControlPanel();
        CodeVisual codeVisual = frm.getCodeVisual();

        controlPanel.addDESCBtnListener((e) -> {
            int[] arrayToSort = getSortData();
            for (int i = 0; i < arrayToSort.length; i++) {
                System.out.print(arrayToSort[i] + ", ");
            }
            frm.getControlPanel().enableStopBtn();
            algorithm.setStop(false);

            final int[] originArray = Arrays.copyOf(arrayToSort, arrayToSort.length);
            sortType = Configuration.DESC;
            codeVisual.addCode(algorithm.getCode(sortType));
            codeVisual.setVisible(true);
            algorithm.resetSwapCount();
            algorithm.setSpeed(speed);

            SwingWorker<Void, Void> worker = new SwingWorker<>() {
                @Override
                protected Void doInBackground() {
                    algorithm.sort(arrayToSort, sortType);
                    return null;
                }

                @Override
                protected void done() {
                    if (!algorithm.isStop()) {
                        controlPanel.enableBtn();
                        frm.getCodeVisual().setVisible(false);
                        System.out.println("Sorting completed.");
                        frm.getInfomationPanel().setText("Hoàn thành sắp xếp");
                        frm.getVisualPanel().removeAll();
                        // Chuyển đổi mảng int[] thành List<Integer>
                        List<Integer> listToSort = Arrays.stream(arrayToSort)
                                .boxed()
                                .collect(Collectors.toList());

                        frm.getVisualPanel().setNodes(listToSort); // Truyền danh sách vào setNodes
                        String res = "Kết quả sắp xếp giảm dần:\n" + "Mảng gốc: " + Arrays.toString(originArray)
                                + "\nKết quả sắp xếp: " + Arrays.toString(arrayToSort);
                        if (frm.showConfirmMessage(res + "\nBạn có muốn xuất kết quả ra file không?")) {
                            saveSortingResultToFile(res);
                            
                        }
                    }else{
                        frm.getInfomationPanel().setText("Đã dừng sắp xếp");
                    }
                }
            };

            worker.execute();
            
            for (int i = 0; i < arrayToSort.length; i++) {
                System.err.print(arrayToSort[i] + ", ");
            }
            System.out.println("\n");

        });
    }
    
    private void initSpeedChangeListener() {
        ControlPanel controlPanel = frm.getControlPanel();
        controlPanel.addSpeedSliderChangeState((e) -> {
            speed = controlPanel.getSpeed();
            algorithm.setSpeed(speed);
            frm.getVisualPanel().setSpeed(speed);
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

    private void initStopBtnListener() {

        frm.getControlPanel().addStopBtnListener((e) -> {
            if (algorithm != null && !algorithm.isStop()) {
                algorithm.setStop(true);
                frm.getControlPanel().enableBtn();
                frm.getCodeVisual().setVisible(false);
            }
        });
    }

    private void saveSortingResultToFile(String resultToSave) {
        saveFile = frm.getSavingFile();
        if (saveFile == null) {
            return;
        }

        try (FileOutputStream fos = new FileOutputStream(saveFile)) {
            fos.write(resultToSave.getBytes());
            frm.showAlert("Hoàn tất!", "Thông báo");
        } catch (IOException | IllegalArgumentException ex) {
            Logger.getLogger(Controller.class.getName())
                    .log(Level.SEVERE, null, ex);
            frm.showAlert("Thất bại!", "Thông báo");
        }
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
