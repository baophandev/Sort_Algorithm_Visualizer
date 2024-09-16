/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view;

import java.awt.Color;
import java.awt.Dimension;

public class CardNumberComponent extends javax.swing.JPanel {

    private int volumeNumber = 0; // số của volume
    private int height = 0; //chiều cao của volume

    public CardNumberComponent(int volumeNumber, int height) {
        this.volumeNumber = volumeNumber;
        this.height = height;
        initComponents();
        setPreferredSize(new Dimension(60, 500));
        textLabel.setText("");
        volume.setPreferredSize(new Dimension(volume.getWidth(), height));
        volumeLabel.setText(String.valueOf(volumeNumber));
        volume.setBackground(config.Configuration.COLOR_HEADER);
        volumeLabel.setForeground(Color.WHITE);
    }

    public String getVolumeNumber() {
        return volumeLabel.getText();
    }

    public void setVolumeNumber(String volume) {
        volumeLabel.setText(volume);
        revalidate();
        repaint();
    }
    
    public int getheight(){
        return volume.getHeight();
    }
    
    public void setHeight(int height){
        volume.setPreferredSize(new Dimension(volume.getWidth(), height));
        revalidate();
        repaint();
    }

    public void setlabel(String str){
        textLabel.setText(str);
    }
    
    public void setVolumeColor(Color color){
        volume.setBackground(color);
    }
    
    public void setLabel(String str){
        textLabel.setText(str);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        textPanel = new javax.swing.JPanel();
        textLabel = new javax.swing.JLabel();
        volume = new javax.swing.JPanel();
        volumeLabel = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        textPanel.setBackground(new java.awt.Color(255, 255, 255));

        textLabel.setBackground(new java.awt.Color(31, 92, 169));
        textLabel.setFont(new java.awt.Font("K2D", 1, 12)); // NOI18N
        textLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        textLabel.setText("1");

        javax.swing.GroupLayout textPanelLayout = new javax.swing.GroupLayout(textPanel);
        textPanel.setLayout(textPanelLayout);
        textPanelLayout.setHorizontalGroup(
            textPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(textLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 61, Short.MAX_VALUE)
        );
        textPanelLayout.setVerticalGroup(
            textPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, textPanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(textLabel))
        );

        volume.setBackground(new java.awt.Color(51, 0, 153));

        volumeLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        volumeLabel.setText("000");

        javax.swing.GroupLayout volumeLayout = new javax.swing.GroupLayout(volume);
        volume.setLayout(volumeLayout);
        volumeLayout.setHorizontalGroup(
            volumeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(volumeLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        volumeLayout.setVerticalGroup(
            volumeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, volumeLayout.createSequentialGroup()
                .addContainerGap(78, Short.MAX_VALUE)
                .addComponent(volumeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(textPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addComponent(volume, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(3, 3, 3))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 371, Short.MAX_VALUE)
                .addComponent(volume, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(textPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel textLabel;
    private javax.swing.JPanel textPanel;
    private javax.swing.JPanel volume;
    private javax.swing.JLabel volumeLabel;
    // End of variables declaration//GEN-END:variables
}
