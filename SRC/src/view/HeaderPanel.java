
package view;
import java.awt.Color;
import config.Configuration;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import view.UserGuide;

/**
 *
 * @author GIA BAO
 */
public class HeaderPanel extends javax.swing.JPanel {

    private int  algorithm = 0;
    
    private JButton selectedBtn;
    
    public HeaderPanel() {
        initComponents();
    }
    
    public int getAlgorithm(){
        return algorithm;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        selectionSortBtn = new javax.swing.JButton();
        insectionSortBtn = new javax.swing.JButton();
        bubbleSortBtn = new javax.swing.JButton();
        quickSortBtn = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        heapSortBtn = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        swapValue = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        jLabel1.setText("jLabel1");

        setBackground(new java.awt.Color(31, 92, 169));

        jLabel2.setFont(new java.awt.Font("K2D", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(251, 210, 0));
        jLabel2.setText("Sort Visualize");

        selectionSortBtn.setBackground(new java.awt.Color(31, 92, 169));
        selectionSortBtn.setFont(new java.awt.Font("K2D", 1, 12)); // NOI18N
        selectionSortBtn.setForeground(new java.awt.Color(255, 255, 255));
        selectionSortBtn.setText("Selection Sort");
        selectionSortBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectionSortBtnActionPerformed(evt);
            }
        });

        insectionSortBtn.setBackground(new java.awt.Color(31, 92, 169));
        insectionSortBtn.setFont(new java.awt.Font("K2D", 1, 12)); // NOI18N
        insectionSortBtn.setForeground(new java.awt.Color(255, 255, 255));
        insectionSortBtn.setText("Insection Sort");
        insectionSortBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insectionSortBtnActionPerformed(evt);
            }
        });

        bubbleSortBtn.setBackground(new java.awt.Color(31, 92, 169));
        bubbleSortBtn.setFont(new java.awt.Font("K2D", 1, 12)); // NOI18N
        bubbleSortBtn.setForeground(new java.awt.Color(255, 255, 255));
        bubbleSortBtn.setText("Bubble Sort");
        bubbleSortBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bubbleSortBtnActionPerformed(evt);
            }
        });

        quickSortBtn.setBackground(new java.awt.Color(31, 92, 169));
        quickSortBtn.setFont(new java.awt.Font("K2D", 1, 12)); // NOI18N
        quickSortBtn.setForeground(new java.awt.Color(255, 255, 255));
        quickSortBtn.setText("Quick Sort");
        quickSortBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quickSortBtnActionPerformed(evt);
            }
        });

        jButton7.setBackground(new java.awt.Color(0, 204, 102));
        jButton7.setFont(new java.awt.Font("K2D", 1, 12)); // NOI18N
        jButton7.setForeground(new java.awt.Color(255, 255, 255));
        jButton7.setText("?");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        heapSortBtn.setBackground(new java.awt.Color(31, 92, 169));
        heapSortBtn.setFont(new java.awt.Font("K2D", 1, 12)); // NOI18N
        heapSortBtn.setForeground(new java.awt.Color(255, 255, 255));
        heapSortBtn.setText("Heap Sort");
        heapSortBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                heapSortBtnActionPerformed(evt);
            }
        });

        swapValue.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        swapValue.setText("0");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(swapValue, javax.swing.GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(swapValue)
                .addContainerGap())
        );

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Số lần swap:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(selectionSortBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(insectionSortBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bubbleSortBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(quickSortBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(heapSortBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 287, Short.MAX_VALUE)
                .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jButton7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(heapSortBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(quickSortBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(bubbleSortBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(insectionSortBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(selectionSortBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    public void addSortBtnListener(ActionListener listener){
        selectionSortBtn.addActionListener(listener);
        insectionSortBtn.addActionListener(listener);
        bubbleSortBtn.addActionListener(listener);
        quickSortBtn.addActionListener(listener);
        heapSortBtn.addActionListener(listener);
    }
    
    
    private void selectionSortBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectionSortBtnActionPerformed
        selectionSortBtn.setBackground(Color.white);
        selectionSortBtn.setForeground(Configuration.COLOR_HEADER);   
        
        insectionSortBtn.setForeground(Color.white);
        insectionSortBtn.setBackground(Configuration.COLOR_HEADER);
        
        bubbleSortBtn.setForeground(Color.white);
        bubbleSortBtn.setBackground(Configuration.COLOR_HEADER);
        
        quickSortBtn.setForeground(Color.white);
        quickSortBtn.setBackground(Configuration.COLOR_HEADER);
        
        heapSortBtn.setForeground(Color.white);
        heapSortBtn.setBackground(Configuration.COLOR_HEADER);
        
        algorithm = Configuration.SELECTION_SORT;
    }//GEN-LAST:event_selectionSortBtnActionPerformed

    private void insectionSortBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insectionSortBtnActionPerformed
        insectionSortBtn.setBackground(Color.white);
        insectionSortBtn.setForeground(Configuration.COLOR_HEADER);
        
        selectionSortBtn.setForeground(Color.white);
        selectionSortBtn.setBackground(Configuration.COLOR_HEADER);   
        
        bubbleSortBtn.setForeground(Color.white);
        bubbleSortBtn.setBackground(Configuration.COLOR_HEADER);
        
        quickSortBtn.setForeground(Color.white);
        quickSortBtn.setBackground(Configuration.COLOR_HEADER);
        
        heapSortBtn.setForeground(Color.white);
        heapSortBtn.setBackground(Configuration.COLOR_HEADER);
        
        algorithm = Configuration.INSERTION_SORT;
    }//GEN-LAST:event_insectionSortBtnActionPerformed

    private void bubbleSortBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bubbleSortBtnActionPerformed
        bubbleSortBtn.setBackground(Color.white);
        bubbleSortBtn.setForeground(Configuration.COLOR_HEADER);
        
        selectionSortBtn.setForeground(Color.white);
        selectionSortBtn.setBackground(Configuration.COLOR_HEADER);
        
        insectionSortBtn.setForeground(Color.white);
        insectionSortBtn.setBackground(Configuration.COLOR_HEADER);
        
        quickSortBtn.setForeground(Color.white);
        quickSortBtn.setBackground(Configuration.COLOR_HEADER);
        
        heapSortBtn.setForeground(Color.white);
        heapSortBtn.setBackground(Configuration.COLOR_HEADER);
        
        algorithm = Configuration.BUBBLE_SORT;
    }//GEN-LAST:event_bubbleSortBtnActionPerformed

    private void quickSortBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quickSortBtnActionPerformed
        // TODO add your handling code here:
        quickSortBtn.setBackground(Color.white);
        quickSortBtn.setForeground(Configuration.COLOR_HEADER);
        
        selectionSortBtn.setForeground(Color.white);
        selectionSortBtn.setBackground(Configuration.COLOR_HEADER);
        
        insectionSortBtn.setForeground(Color.white);
        insectionSortBtn.setBackground(Configuration.COLOR_HEADER);
        
        bubbleSortBtn.setForeground(Color.white);
        bubbleSortBtn.setBackground(Configuration.COLOR_HEADER);
        
        heapSortBtn.setForeground(Color.white);
        heapSortBtn.setBackground(Configuration.COLOR_HEADER);
        
        algorithm = Configuration.QUICK_SORT;
    }//GEN-LAST:event_quickSortBtnActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        UserGuide userGuide = new UserGuide();
        userGuide.setVisible(true);
        userGuide.setLocationRelativeTo(null);
    }//GEN-LAST:event_jButton7ActionPerformed

    private void heapSortBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_heapSortBtnActionPerformed

        heapSortBtn.setBackground(Color.white);
        heapSortBtn.setForeground(Configuration.COLOR_HEADER);
        
        selectionSortBtn.setForeground(Color.white);
        selectionSortBtn.setBackground(Configuration.COLOR_HEADER);
        
        insectionSortBtn.setForeground(Color.white);
        insectionSortBtn.setBackground(Configuration.COLOR_HEADER);
        
        bubbleSortBtn.setForeground(Color.white);
        bubbleSortBtn.setBackground(Configuration.COLOR_HEADER);
        
        quickSortBtn.setForeground(Color.white);
        quickSortBtn.setBackground(Configuration.COLOR_HEADER);
        
        algorithm = Configuration.HEAP_SORT;
    }//GEN-LAST:event_heapSortBtnActionPerformed

    public void disableBtn(){
        bubbleSortBtn.setEnabled(false);
        insectionSortBtn.setEnabled(false);
        selectionSortBtn.setEnabled(false);
        quickSortBtn.setEnabled(false);
        heapSortBtn.setEnabled(false);
    }
    
    public void enableBtn(){
        bubbleSortBtn.setEnabled(true);
        insectionSortBtn.setEnabled(true);
        selectionSortBtn.setEnabled(true);
        quickSortBtn.setEnabled(true);
        heapSortBtn.setEnabled(true);
    }
    
    public void setLabelSwapCount(int a){
        swapValue.setText(String.valueOf(a));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bubbleSortBtn;
    private javax.swing.JButton heapSortBtn;
    private javax.swing.JButton insectionSortBtn;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton quickSortBtn;
    private javax.swing.JButton selectionSortBtn;
    private javax.swing.JLabel swapValue;
    // End of variables declaration//GEN-END:variables
}
