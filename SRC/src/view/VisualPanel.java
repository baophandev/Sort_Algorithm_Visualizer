/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.Random;
import java.awt.Point;
import javax.swing.SwingUtilities;

/**
 *
 * @author GIA BAO
 */
public class VisualPanel extends javax.swing.JPanel {

    public static int initNumber;
    
    public VisualPanel() {
        initComponents();
       
    }

    public void initVisualPanel(){
        Random random = new Random();
        initNumber = random.nextInt(20) + 1;
        setupUi();
    }
    
    //Phan Gia Bảo test
    
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

     // Sử dụng GridBagLayout để hiển thị các thẻ như biểu đồ cột nhưng cách đáy một khoảng
    public void setupUi() {
        setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(2, 2, 2, 2);  // Khoảng cách giữa các thẻ
//        gbc.fill = GridBagConstraints.VERTICAL; // Đảm bảo các thẻ chiếm hết chiều dọc của ô
        gbc.anchor = GridBagConstraints.SOUTH;  // Đặt thẻ dính vào đáy của ô chứa chúng

        // Thêm khoảng trống phía dưới để cách đáy
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.weighty = 0.5;  // Trọng số nhỏ hơn để không chiếm quá nhiều không gian
        add(new javax.swing.JPanel(), gbc);  // Thêm một panel trống để tạo khoảng cách với đáy

        // Thêm các thẻ vào panel
        gbc.weighty = 1.0;  // Trọng số y để các thẻ bị đẩy lên
        for (int i = 0; i < initNumber; i++) {
            gbc.gridx = i;  // Đặt các thẻ theo thứ tự ngang
            gbc.gridy = 1;  // Chỉ định hàng thứ nhất (ở trên hàng trống)

            Random random = new Random();
            int value = random.nextInt(50) + 1;
            
            int height = (value + 2) * 8;  // Chiều cao mỗi thẻ
            CardNumberComponent card = new CardNumberComponent(height, value);
            card.setPreferredSize(new java.awt.Dimension(40, height));  // Đặt kích thước của thẻ

            add(card, gbc);  // Thêm thẻ vào panel
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
