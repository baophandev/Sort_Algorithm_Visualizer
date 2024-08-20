
package view;
import java.awt.Color;
import config.Configuration;
import javax.swing.JButton;
/**
 *
 * @author GIA BAO
 */
public class ControlPanel extends javax.swing.JPanel {

    private JButton selectedBtn;
    
    public ControlPanel() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        selectionSortBtn = new javax.swing.JButton();
        insectionSortBtn = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();

        jLabel1.setText("jLabel1");

        setBackground(new java.awt.Color(31, 92, 169));

        jLabel2.setFont(new java.awt.Font("K2D", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
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

        jButton3.setBackground(new java.awt.Color(31, 92, 169));
        jButton3.setFont(new java.awt.Font("K2D", 1, 12)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Bubble Sort");

        jButton4.setBackground(new java.awt.Color(31, 92, 169));
        jButton4.setFont(new java.awt.Font("K2D", 1, 12)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("Merge Sort");

        jButton5.setBackground(new java.awt.Color(31, 92, 169));
        jButton5.setFont(new java.awt.Font("K2D", 1, 12)); // NOI18N
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setText("Quick Sort");

        jButton6.setBackground(new java.awt.Color(0, 204, 102));
        jButton6.setFont(new java.awt.Font("K2D", 1, 12)); // NOI18N
        jButton6.setForeground(new java.awt.Color(255, 255, 255));
        jButton6.setText("History");

        jButton7.setBackground(new java.awt.Color(0, 204, 102));
        jButton7.setFont(new java.awt.Font("K2D", 1, 12)); // NOI18N
        jButton7.setForeground(new java.awt.Color(255, 255, 255));
        jButton7.setText("?");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(selectionSortBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(insectionSortBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 139, Short.MAX_VALUE)
                .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(selectionSortBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
            .addComponent(insectionSortBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jButton7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void selectionSortBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectionSortBtnActionPerformed
        selectionSortBtn.setBackground(Color.white);
        selectionSortBtn.setForeground(Configuration.COLOR_HEADER);   
    }//GEN-LAST:event_selectionSortBtnActionPerformed

    private void insectionSortBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insectionSortBtnActionPerformed
        insectionSortBtn.setBackground(Color.white);
        insectionSortBtn.setForeground(Configuration.COLOR_HEADER);
    }//GEN-LAST:event_insectionSortBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton insectionSortBtn;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton selectionSortBtn;
    // End of variables declaration//GEN-END:variables
}
