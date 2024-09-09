/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view;

import java.awt.Dimension;

public class CardNumberComponent extends javax.swing.JPanel {

   private int height;  // Biến lưu chiều cao của panel
   private int number;

    public CardNumberComponent(int height, int number) {
        this.height = height;  // Thiết lập chiều cao dựa trên giá trị đầu vào
        this.number = number;
        initComponents();
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText(String.valueOf(number));
        updatePanelHeight();  // Cập nhật chiều cao cho CardNumberComponent
        volume.setBackground(config.Configuration.COLOR_HEADER);
    }

    public int getNumber(){
        return number;
    }
    
    // Phương thức cập nhật chiều cao của chính CardNumberComponent
    private void updatePanelHeight() {
        // Set kích thước cho chính JPanel (CardNumberComponent)
        this.setPreferredSize(new java.awt.Dimension(this.getPreferredSize().width, height));
        this.setSize(this.getPreferredSize());
        this.revalidate();  // Cập nhật lại layout
        this.repaint();     // Vẽ lại giao diện
    }
    
    public String getText(){
        return jLabel2.getText();
    }
    
    public void setText(String text){
        jLabel2.setText(text);
    }

    public void setHeight(int height){
        volume.setPreferredSize(new Dimension(40, height));
    }
    
    public void highColor(){
        volume.setBackground(config.Configuration.HIGHLIGHT_NODE);
    }
    
    public void defaultColor(){
        volume.setBackground(config.Configuration.COLOR_HEADER);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        volume = new javax.swing.JPanel();

        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setBackground(new java.awt.Color(31, 92, 169));
        jLabel2.setFont(new java.awt.Font("K2D", 1, 12)); // NOI18N
        jLabel2.setText("1");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 61, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel2))
        );

        volume.setBackground(new java.awt.Color(51, 0, 153));

        javax.swing.GroupLayout volumeLayout = new javax.swing.GroupLayout(volume);
        volume.setLayout(volumeLayout);
        volumeLayout.setHorizontalGroup(
            volumeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        volumeLayout.setVerticalGroup(
            volumeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel volume;
    // End of variables declaration//GEN-END:variables
}
