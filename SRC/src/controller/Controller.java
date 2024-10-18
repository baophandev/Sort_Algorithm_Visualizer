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
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.Collectors;
import javax.swing.JFileChooser;
import javax.swing.SwingWorker;
import model.BubbleSort;
import model.SelectionSort;
import model.InsertionSort;
import model.MergeSort;
import model.HeapSort;
import model.QuickSort;
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
    private volatile boolean isComparing = false;

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
        initOptimalComparison();
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
                case Configuration.MERGE_SORT ->
                    new MergeSort(visualPanel, codeVisual, infomationPanel);
                case Configuration.HEAP_SORT ->
                    new HeapSort(visualPanel, codeVisual, infomationPanel);
                case Configuration.QUICK_SORT ->
                    new QuickSort(visualPanel, codeVisual, infomationPanel);
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
            frm.getHeaderPanel().disableBtn();
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
                        frm.getHeaderPanel().enableBtn();
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
                                + "\nMảng gốc: " + Arrays.toString(originArray)
                                + "\nKết quả sắp xếp: " + Arrays.toString(arrayToSort)
                                + "\nSố lần hoán đổi: " + algorithm.getSwapCount();
                        if (frm.showConfirmMessage(res + "\nBạn có muốn xuất kết quả ra file không?")) {
                            saveSortingResultToFile(res);
                        }
                    } else {
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
                        frm.getHeaderPanel().enableBtn();
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
                    } else {
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

    private void initOptimalComparison() {
        ControlPanel controlPanel = frm.getControlPanel();
        VisualPanel visualPanel = frm.getVisualPanel();

        controlPanel.addCompareBtnListener((e) -> {
            if (isComparing) {
                frm.showAlert("Đang thực hiện so sánh...", "Thông báo");
                return;
            }

            isComparing = true;

            List<Sort> algorithms = new ArrayList<>(Arrays.asList(
                    new SelectionSort(),
                    new InsertionSort(),
                    new BubbleSort(),
                    new QuickSort(),
                    new HeapSort(),
                    new MergeSort()
            ));

            int[] arrayforSortAsc = getSortData();
            if (arrayforSortAsc == null) {
                isComparing = false;
                return;
            }

            int[] arrayforSortDesc = Arrays.copyOf(arrayforSortAsc, arrayforSortAsc.length);
            final int[] originArray = Arrays.copyOf(arrayforSortAsc, arrayforSortAsc.length);

            // Khởi tạo các call back thực thi các thuật toán sắp xếp
            List<Callable<Integer>> ascTasks = new ArrayList<>();
            List<Callable<Integer>> descTasks = new ArrayList<>();

            for (int i = 0; i < algorithms.size(); i++) {
                final int index = i;
                ascTasks.add(() -> {
                    return algorithms.get(index).sortWithoutAnimation(Arrays.copyOf(originArray, originArray.length), Configuration.ASC);
                });

                descTasks.add(() -> {
                    return algorithms.get(index).sortWithoutAnimation(Arrays.copyOf(originArray, originArray.length), Configuration.DESC);
                });
            }

            // Sử dụng một mảng String để lưu trữ kết quả
            final List<String> res = new ArrayList<>();
            res.add("Mảng gốc: " + Arrays.toString(originArray));

            // Sử dụng ExecutorService để chạy các công việc không đồng bộ
            ExecutorService executor = Executors.newFixedThreadPool(algorithms.size());
            try {
                // Thực hiện các công việc ASC và thu thập kết quả
                List<Future<Integer>> ascResults = executor.invokeAll(ascTasks);

                // Chờ và lấy kết quả từ mỗi Future cho ASC
                int selectionAscSwapCount = ascResults.get(0).get();
                int insertionAscSwapCount = ascResults.get(1).get();
                int bubbleAscSwapCount = ascResults.get(2).get();
                int quickAscSwapCount = ascResults.get(3).get();
                int heapAscSwapCount = ascResults.get(4).get();
                int mergeAscSwapCount = ascResults.get(5).get();

                // Gọi hàm setOptimalASCResultValue để đặt giá trị lên giao diện cho ASC
                controlPanel.setOptimalASCResultPanel(selectionAscSwapCount, insertionAscSwapCount, bubbleAscSwapCount, quickAscSwapCount, heapAscSwapCount, mergeAscSwapCount);
                controlPanel.setOptimalASCResultLabel(selectionAscSwapCount, insertionAscSwapCount, bubbleAscSwapCount, quickAscSwapCount, heapAscSwapCount, mergeAscSwapCount);
                // Cập nhật chuỗi res
                res.add("\nSố lần hoán đổi - Sắp xếp tăng dần"+"\n   +Selection Sort: " + selectionAscSwapCount + "\n   +Insertion Sort" + insertionAscSwapCount 
                +"\n   +Bubble Sort: " + bubbleAscSwapCount + "\n   +Quick Sort: " + quickAscSwapCount + "\n   +Heap Sort: " + heapAscSwapCount + "\n    +Merge Sort: " + mergeAscSwapCount);

                // Thực hiện các công việc DESC và thu thập kết quả
                List<Future<Integer>> descResults = executor.invokeAll(descTasks);

                // Chờ và lấy kết quả từ mỗi Future cho DESC
                int selectionDescSwapCount = descResults.get(0).get();
                int insertionDescSwapCount = descResults.get(1).get();
                int bubbleDescSwapCount = descResults.get(2).get();
                int quickDescSwapCount = descResults.get(3).get();
                int heapDescSwapCount = descResults.get(4).get();
                int mergeDescSwapCount = descResults.get(5).get();
                
                res.add("\nSố lần hoán đổi - Sắp xếp tăng dần"+"\n   +Selection Sort: " + selectionDescSwapCount + "\n   +Insertion Sort" + insertionDescSwapCount 
                +"\n   +Bubble Sort: " + bubbleDescSwapCount + "\n   +Quick Sort: " + quickDescSwapCount + "\n   +Heap Sort: " + heapDescSwapCount + "\n    +Merge Sort: " + mergeDescSwapCount);

                // Gọi hàm setOptimalDESCResultValue để đặt giá trị lên giao diện cho DESC
                controlPanel.setOptimalDESCResultPanel(selectionDescSwapCount, insertionDescSwapCount, bubbleDescSwapCount, quickDescSwapCount, heapDescSwapCount, mergeDescSwapCount);
                controlPanel.setOptimalDESCResultLabel(selectionDescSwapCount, insertionDescSwapCount, bubbleDescSwapCount, quickDescSwapCount, heapDescSwapCount, mergeDescSwapCount);

                controlPanel.addExportCompareResultListner((event) -> {
                    saveSortingResultToFile(res.toString());
                });

            } catch (InterruptedException | ExecutionException ex) {
                ex.printStackTrace();
            } finally {
                executor.shutdown(); // Chỉ shutdown sau khi hoàn thành cả ASC và DESC
                isComparing = false; // Đặt lại trạng thái sau khi hoàn thành
            }
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
                frm.getHeaderPanel().enableBtn();
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
