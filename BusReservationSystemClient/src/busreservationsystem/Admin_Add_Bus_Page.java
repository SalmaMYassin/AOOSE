/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package busreservationsystem;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JToggleButton;

/**
 *
 * @author Roofie6
 */
public class Admin_Add_Bus_Page extends javax.swing.JFrame {

    /**
     * Creates new form addBusPage
     */
    public Admin_Add_Bus_Page() {
        initComponents();
    }

    public JComboBox<String> getBusDriverComboBox() {
        return busDriverComboBox;
    }

    public void setBusDriverComboBox(JComboBox<String> busDriverComboBox) {
        this.busDriverComboBox = busDriverComboBox;
    }

    public JToggleButton getAddBusButton() {
        return addBusButton;
    }

    public JToggleButton getCancelButton() {
        return cancelButton;
    }

    public void setDriverNameLabel(JLabel driverNameLabel) {
        this.driverNameLabel = driverNameLabel;
    }

    public void setDriverRatingLabel(JLabel driverRatingLabel) {
        this.driverRatingLabel = driverRatingLabel;
    }

    public JLabel getDriverNameLabel() {
        return driverNameLabel;
    }

    public JLabel getDriverRatingLabel() {
        return driverRatingLabel;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        busDriverNameLabelLeftTop = new javax.swing.JLabel();
        busDriverComboBox = new javax.swing.JComboBox<>();
        driverNameLabel = new javax.swing.JLabel();
        dnLabel = new javax.swing.JLabel();
        driverRatingLabel = new javax.swing.JLabel();
        drLabel = new javax.swing.JLabel();
        addBusButton = new javax.swing.JToggleButton();
        cancelButton = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        busDriverNameLabelLeftTop.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        busDriverNameLabelLeftTop.setText("Bus Driver ID:");

        busDriverComboBox.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        busDriverComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                busDriverComboBoxActionPerformed(evt);
            }
        });

        driverNameLabel.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        dnLabel.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        dnLabel.setText("Driver's Name:");

        driverRatingLabel.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        drLabel.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        drLabel.setText("Driver's Rating:");

        addBusButton.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        addBusButton.setText("Add Bus");
        addBusButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBusButtonActionPerformed(evt);
            }
        });

        cancelButton.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        cancelButton.setText("Cancel");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(164, 164, 164)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(addBusButton, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(busDriverNameLabelLeftTop, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(dnLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(drLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(137, 137, 137)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(driverRatingLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(driverNameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(busDriverComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(177, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(93, 93, 93)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(busDriverNameLabelLeftTop)
                    .addComponent(busDriverComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(driverNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dnLabel))
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(driverRatingLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(drLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 290, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addBusButton)
                    .addComponent(cancelButton))
                .addGap(79, 79, 79))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addBusButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBusButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addBusButtonActionPerformed

    private void busDriverComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_busDriverComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_busDriverComboBoxActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Admin_Add_Bus_Page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Admin_Add_Bus_Page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Admin_Add_Bus_Page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Admin_Add_Bus_Page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Admin_Add_Bus_Page().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton addBusButton;
    private javax.swing.JComboBox<String> busDriverComboBox;
    private javax.swing.JLabel busDriverNameLabelLeftTop;
    private javax.swing.JToggleButton cancelButton;
    private javax.swing.JLabel dnLabel;
    private javax.swing.JLabel drLabel;
    private javax.swing.JLabel driverNameLabel;
    private javax.swing.JLabel driverRatingLabel;
    // End of variables declaration//GEN-END:variables
}
