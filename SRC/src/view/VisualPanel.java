/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view;

import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.Random;
import java.awt.Point;
import java.util.ArrayList;
import javax.swing.SwingUtilities;
import java.util.List;
import config.Configuration;
import java.awt.Dimension;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author GIA BAO
 */
public class VisualPanel extends javax.swing.JPanel {

    public static int initNumber;
    private int FPS = 60;
    private GridBagLayout layout; // Lưu layout để cập nhật dễ dàng hơn
    private GridBagConstraints gbc; // Lưu cấu hình layout

    public VisualPanel() {
        initComponents();
        initLayout(); // Khởi tạo layout tại đây
    }

    public void initVisualPanel() {
        Random random = new Random();
        initNumber = random.nextInt(20) + 1;

    }

    private void initLayout() {
        layout = new GridBagLayout();
        gbc = new GridBagConstraints();
        
        gbc.anchor = GridBagConstraints.SOUTH;  // Đặt thẻ dính vào đáy của ô chứa chúng
        this.setLayout(layout); // Áp dụng layout
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setBackground(new java.awt.Color(255, 255, 255));
        setForeground(new java.awt.Color(102, 102, 0));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 639, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 432, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    public void setNodes(List<Integer> data) {
        
        GridBagConstraints gbc = new GridBagConstraints();
//        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.SOUTH;

        for (int i = 0; i < data.size(); i++) {
            int value = data.get(i);
            int height = (value + 2) * 8;
            CardNumberComponent card = new CardNumberComponent(height, value);
            card.setPreferredSize(new Dimension(60, 500));
            card.setHeight(height);

            // Set initial position (left to right)
            gbc.gridx = i;
            gbc.gridy = 0;

            add(card, gbc);
        }

        revalidate();
        repaint();
    }
    
    private void swapComponents(int index1, int index2) {
        // Thay đổi vị trí của các node trong layout
        Component temp = getComponent(index1);
        remove(index1);
        add(temp, index2);

        temp = getComponent(index2 - 1);  // Sau khi remove, index sẽ thay đổi
        remove(index2 - 1);
        add(temp, index1);
        
        
    }

    public List<Integer> getNodes() {
        List<Integer> nodes = new ArrayList<>();
        for (Component cmp : getComponents()) {
            if (cmp instanceof CardNumberComponent node) {
                nodes.add(Integer.valueOf(node.getNumber()));
            }
        }

        return nodes;
    }
    
    public void highlightNode(int index1, int index2){
        CardNumberComponent comp1 = (CardNumberComponent) getComponent(index1);
        CardNumberComponent comp2 = (CardNumberComponent) getComponent(index2);
        
        comp1.highColor();
        comp2.highColor();
    }

    public void defaultNode(int index1, int index2){
        CardNumberComponent comp1 = (CardNumberComponent) getComponent(index1);
        CardNumberComponent comp2 = (CardNumberComponent) getComponent(index2);
        
        comp1.defaultColor();
        comp2.defaultColor();
    }
    
    public void swapNodes(int index1, int index2) {
        if (index1 == index2) {
            return; // Không cần hoán đổi nếu chỉ số trùng nhau
        }

        // Lấy các thành phần tại vị trí index1 và index2
        CardNumberComponent comp1 = (CardNumberComponent) getComponent(index1);
        CardNumberComponent comp2 = (CardNumberComponent) getComponent(index2);

        // Đặt màu cho hai node đang được so sánh
        comp1.highColor();
        comp2.highColor();

        final Point start1 = comp1.getLocation();
        final Point start2 = comp2.getLocation();
        final int distance = start2.x - start1.x;

        // Tạo hiệu ứng di chuyển node comp1 sang phải và comp2 sang trái
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            int step = 0;
            int totalSteps = 50;  // Số bước di chuyển để có hiệu ứng mượt

            @Override
            public void run() {
                step++;

                // Tính vị trí mới của từng node dựa trên số bước
                int newX1 = start1.x + (distance * step) / totalSteps;
                int newX2 = start2.x - (distance * step) / totalSteps;

                comp1.setLocation(newX1, start1.y);
                comp2.setLocation(newX2, start2.y);

                revalidate();
                repaint();

                // Dừng khi đã hoàn thành bước cuối
                if (step >= totalSteps) {
                    // Đổi chỗ các node trên giao diện
                    swapComponents(index1, index2);

                    // Reset màu sau khi hoàn thành hoán đổi
                    comp1.defaultColor();
                    comp2.defaultColor();

                    revalidate();
                    repaint();

                    this.cancel(); // Hủy timer sau khi hoàn thành
                }
            }
        };

        timer.schedule(task, 0, 15);  // Chạy task mỗi 10ms để tạo hiệu ứng hoạt hình
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
