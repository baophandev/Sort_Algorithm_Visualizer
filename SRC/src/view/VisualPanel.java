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
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author GIA BAO
 */

abstract class CustomTimerTask extends TimerTask {

    private boolean isAlive = true;
    

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean isAlive) {
        this.isAlive = isAlive;
    }
}

public class VisualPanel extends javax.swing.JPanel {

    public static int initNumber;
    private int FPS = 60;

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

    public List<Integer> getNodes() {
        List<Integer> nodes = new ArrayList<>();
        for (Component cmp : getComponents()) {
            if (cmp instanceof CardNumberComponent node) {
                nodes.add(Integer.valueOf(node.getNumber()));
            }
        }

        return nodes;
    }

    public void swapNodes(int beginIdx, int endIdx) {
    if (beginIdx >= endIdx) {
        return;
    }

    if (getComponent(beginIdx) instanceof CardNumberComponent beginNode
            && getComponent(endIdx) instanceof CardNumberComponent endNode) {
        beginNode.setBackground(Configuration.HIGHLIGHT_NODE);
        endNode.setBackground(Configuration.HIGHLIGHT_NODE);

        final Point beginRes = beginNode.getLocation(),
                    endRes = endNode.getLocation();

        CustomTimerTask task = new CustomTimerTask() {
            @Override
            public void run() {
                Point curBeginRes = beginNode.getLocation(),
                      curEndRes = endNode.getLocation();

                // Di chuyển Node sang phải
                if (curBeginRes.x != endRes.x) {
                    beginNode.setLocation(new Point(
                            Math.min(curBeginRes.x + 5, endRes.x),
                            curBeginRes.y));
                }

                // Di chuyển node kết thúc sang trái
                if (curEndRes.x != beginRes.x) {
                    endNode.setLocation(new Point(
                            Math.max(curEndRes.x - 5, beginRes.x),
                            curEndRes.y));
                }

                // Kiểm tra nếu đã đến vị trí mong muốn
                if (Math.abs(curBeginRes.x - endRes.x) < 5 && Math.abs(curEndRes.x - beginRes.x) < 5) {
                    this.setAlive(false);
                    this.cancel();
                }
            }
        };

        redrawing(task);

        // Sau khi di chuyển xong, hoán đổi giá trị
        String tmp = beginNode.getText();
        beginNode.setText(endNode.getText());
        endNode.setText(tmp);

        beginNode.setLocation(beginRes);
        endNode.setLocation(endRes);
        beginNode.setBackground(Configuration.COLOR_HEADER);
        endNode.setBackground(Configuration.COLOR_HEADER);
        
        revalidate();
        repaint();
    }
}


    private void redrawing(CustomTimerTask task) {
        final long periodTime = 1000 / FPS;
        final Timer timer = new Timer("Animation Thread");
        timer.scheduleAtFixedRate(task, 0, periodTime);
        // waiting for animation has done
        while (true) {
            if (!task.isAlive()) {
                timer.cancel();
                break;
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(VisualPanel.class.getName())
                        .log(Level.SEVERE, null, ex);
            }
        }
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
