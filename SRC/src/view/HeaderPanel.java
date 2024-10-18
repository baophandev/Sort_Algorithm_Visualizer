
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
        mergeSortBtn = new javax.swing.JButton();
        quickSortBtn = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        heapSortBtn = new javax.swing.JButton();

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

        mergeSortBtn.setBackground(new java.awt.Color(31, 92, 169));
        mergeSortBtn.setFont(new java.awt.Font("K2D", 1, 12)); // NOI18N
        mergeSortBtn.setForeground(new java.awt.Color(255, 255, 255));
        mergeSortBtn.setText("Merge Sort");
        mergeSortBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mergeSortBtnActionPerformed(evt);
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(selectionSortBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(insectionSortBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bubbleSortBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mergeSortBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(quickSortBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(heapSortBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 118, Short.MAX_VALUE)
                .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(selectionSortBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(insectionSortBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(bubbleSortBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(mergeSortBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(quickSortBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jButton7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(heapSortBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    public void addSortBtnListener(ActionListener listener){
        selectionSortBtn.addActionListener(listener);
        insectionSortBtn.addActionListener(listener);
        bubbleSortBtn.addActionListener(listener);
        quickSortBtn.addActionListener(listener);
        mergeSortBtn.addActionListener(listener);
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
        
        mergeSortBtn.setForeground(Color.white);
        mergeSortBtn.setBackground(Configuration.COLOR_HEADER);
        
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
        
        mergeSortBtn.setForeground(Color.white);
        mergeSortBtn.setBackground(Configuration.COLOR_HEADER);
        
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
        
        mergeSortBtn.setForeground(Color.white);
        mergeSortBtn.setBackground(Configuration.COLOR_HEADER);
        
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
        
        mergeSortBtn.setForeground(Color.white);
        mergeSortBtn.setBackground(Configuration.COLOR_HEADER);
        
        algorithm = Configuration.QUICK_SORT;
    }//GEN-LAST:event_quickSortBtnActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        UserGuide userGuide = new UserGuide();
        userGuide.setVisible(true);
        userGuide.setLocationRelativeTo(null);
    }//GEN-LAST:event_jButton7ActionPerformed

    private void mergeSortBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mergeSortBtnActionPerformed
        mergeSortBtn.setBackground(Color.white);
        mergeSortBtn.setForeground(Configuration.COLOR_HEADER);
        
        selectionSortBtn.setForeground(Color.white);
        selectionSortBtn.setBackground(Configuration.COLOR_HEADER);
        
        insectionSortBtn.setForeground(Color.white);
        insectionSortBtn.setBackground(Configuration.COLOR_HEADER);
        
        bubbleSortBtn.setForeground(Color.white);
        bubbleSortBtn.setBackground(Configuration.COLOR_HEADER);
        
        quickSortBtn.setForeground(Color.white);
        quickSortBtn.setBackground(Configuration.COLOR_HEADER);
        
        algorithm = Configuration.MERGE_SORT;
    }//GEN-LAST:event_mergeSortBtnActionPerformed

    public void disableBtn(){
        bubbleSortBtn.setEnabled(false);
        insectionSortBtn.setEnabled(false);
        selectionSortBtn.setEnabled(false);
        quickSortBtn.setEnabled(false);
        mergeSortBtn.setEnabled(false);
        heapSortBtn.setEnabled(false);
    }
    
    public void enableBtn(){
        bubbleSortBtn.setEnabled(true);
        insectionSortBtn.setEnabled(true);
        selectionSortBtn.setEnabled(true);
        quickSortBtn.setEnabled(true);
        mergeSortBtn.setEnabled(true);
        heapSortBtn.setEnabled(true);
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bubbleSortBtn;
    private javax.swing.JButton heapSortBtn;
    private javax.swing.JButton insectionSortBtn;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton mergeSortBtn;
    private javax.swing.JButton quickSortBtn;
    private javax.swing.JButton selectionSortBtn;
    // End of variables declaration//GEN-END:variables
}
