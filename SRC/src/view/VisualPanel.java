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
import java.awt.Color;
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
            int height = (value + 3) * 8;
            CardNumberComponent card = new CardNumberComponent(value, height);
            card.setlabel(" ");
            card.setlabel1(" ");

            // Set initial position (left to right)
            gbc.gridx = i;
            gbc.gridy = 0;

            add(card, gbc);
        }

        revalidate();
        repaint();
    }

    public List<Integer> getNodes() {
        List<Integer> nodes = new ArrayList<>();
        for (Component cmp : getComponents()) {
            if (cmp instanceof CardNumberComponent node) {
                nodes.add(Integer.valueOf(node.getVolumeNumber()));
            }
        }
        return nodes;
    }

    public void setNodeColor(int idx, Color color) {
        // Lấy đối tượng CardNumberComponent tại vị trí idx
        Component cmp = getComponent(idx);
        if (cmp instanceof CardNumberComponent) {
            CardNumberComponent node = (CardNumberComponent) cmp;

            // Đặt màu mới cho volume của node
            node.setVolumeColor(color);

            // Cập nhật lại giao diện
            revalidate();
            repaint();
        }
    }
    
    public void setNodeLabel(int idx, String text) {
        // Lấy đối tượng CardNumberComponent tại vị trí idx
        Component cmp = getComponent(idx);
        if (cmp instanceof CardNumberComponent) {
            CardNumberComponent node = (CardNumberComponent) cmp;

            // Đặt màu mới cho volume của node
            node.setlabel(text);

            // Cập nhật lại giao diện
            revalidate();
            repaint();
        }
    }
    
    public void setNodeLabel1(int idx, String text) {
        // Lấy đối tượng CardNumberComponent tại vị trí idx
        Component cmp = getComponent(idx);
        if (cmp instanceof CardNumberComponent) {
            CardNumberComponent node = (CardNumberComponent) cmp;

            // Đặt màu mới cho volume của node
            node.setlabel1(text);

            // Cập nhật lại giao diện
            revalidate();
            repaint();
        }
    }

// Phương thức đổi màu với thời gian delay
    public void swapNodes(int index1, int index2) {
        if (index1 == index2) {
            return; // Không cần hoán đổi nếu chỉ số trùng nhau
        }

        // Lấy các thành phần tại vị trí index1 và index2
        CardNumberComponent comp1 = (CardNumberComponent) getComponent(index1);
        CardNumberComponent comp2 = (CardNumberComponent) getComponent(index2);

        // Lưu tạm giá trị text và volume của node 1
        String tempText = comp1.getVolumeNumber();
        int tempVolume = comp1.getheight();

        // Hoán đổi text và volume giữa hai node
        comp1.setVolumeNumber(comp2.getVolumeNumber());
        comp1.setHeight(comp2.getheight());

        comp2.setVolumeNumber(tempText);
        comp2.setHeight(tempVolume);

        comp1.setVolumeColor(config.Configuration.COLOR_HEADER);
        comp2.setVolumeColor(config.Configuration.COLOR_HEADER);
        revalidate();
        repaint();

    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
