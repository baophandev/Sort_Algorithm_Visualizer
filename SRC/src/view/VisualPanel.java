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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.SwingUtilities;
import java.util.List;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.Timer;

/**
 *
 * @author GIA BAO
 */
public class VisualPanel extends javax.swing.JPanel {

    public static int initNumber;

    public VisualPanel() {
        initComponents();

    }

    public void initVisualPanel() {
        Random random = new Random();
        initNumber = random.nextInt(20) + 1;

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
        // Sử dụng GridBagLayout để sắp xếp các thành phần
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        // Cấu hình các tham số cho GridBagConstraints
        gbc.insets = new Insets(5, 5, 5, 5);  // Khoảng cách giữa các phần tử
        gbc.anchor = GridBagConstraints.SOUTH;  // Đặt thẻ dính vào đáy của ô chứa chúng

        // Thêm các thành phần số vào VisualPanel
        for (int i = 0; i < data.size(); i++) {
            int value = data.get(i);
            int height = (value + 2) * 8;  // Tính chiều cao của mỗi thẻ dựa trên giá trị

            // Tạo một CardNumberComponent với chiều cao và giá trị tương ứng
            CardNumberComponent card = new CardNumberComponent(height, value);
            card.setPreferredSize(new java.awt.Dimension(40, height));  // Đặt kích thước của thẻ

            gbc.gridx = i;  // Đặt vị trí theo trục X
            gbc.gridy = 1;  // Đặt vị trí theo trục Y

            add(card, gbc);  // Thêm thẻ vào VisualPanel
        }

        // Yêu cầu cập nhật lại giao diện
        revalidate();
        repaint();
    }
    
    public List<Integer> getNodes(){
        List<Integer> nodes = new ArrayList<>();
        for(Component cmp : getComponents()){
            if(cmp instanceof CardNumberComponent node){
                nodes.add(Integer.valueOf(node.getNumber()));
            }
        }
        
        return nodes;
    }
    
    public void swapNodes(JComponent node1, JComponent node2) {
        // Lấy vị trí ban đầu của hai node
        int x1 = node1.getX();
        int y1 = node1.getY();
        int x2 = node2.getX();
        int y2 = node2.getY();

        // Tính toán khoảng cách di chuyển
        int deltaX = x2 - x1;
        int deltaY = y2 - y1;

        // Thời gian để hoàn thành việc trao đổi
        int duration = 500; // 500 milliseconds
        int steps = 20; // Số lượng bước trong animation
        int delay = duration / steps;

        Timer timer = new Timer(delay, new ActionListener() {
            int step = 0;

            @Override
            public void actionPerformed(ActionEvent e) {
                step++;
                double progress = (double) step / steps;

                // Di chuyển node1 dần dần tới vị trí node2
                node1.setLocation(x1 + (int)(deltaX * progress), y1 + (int)(deltaY * progress));

                // Di chuyển node2 dần dần tới vị trí node1
                node2.setLocation(x2 - (int)(deltaX * progress), y2 - (int)(deltaY * progress));

                if (step >= steps) {
                    // Đảm bảo các node về đúng vị trí cuối cùng
                    node1.setLocation(x2, y2);
                    node2.setLocation(x1, y1);
                    ((Timer) e.getSource()).stop();
                }
            }
        });

        timer.start();
    }

    // Function để di chuyển CardNumberComponent đến vị trí mong muốn
    public void moveToPosition(CardNumberComponent card, Point destination) {
        SwingUtilities.invokeLater(() -> {
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.insets = new Insets(2, 2, 2, 2);
            gbc.anchor = GridBagConstraints.SOUTH;
            gbc.gridx = destination.x;
            gbc.gridy = destination.y;
            remove(card);
            add(card, gbc);
            revalidate();
            repaint();
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
