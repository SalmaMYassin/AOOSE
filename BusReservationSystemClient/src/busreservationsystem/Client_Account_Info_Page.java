package busreservationsystem;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Sarah
 */
public class Client_Account_Info_Page extends javax.swing.JFrame {

    /**
     * Creates new form AccountInfo
     */
    public Client_Account_Info_Page() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        SSN = new javax.swing.JLabel();
        Age = new javax.swing.JLabel();
        Username = new javax.swing.JLabel();
        Email = new javax.swing.JLabel();
        backButton = new javax.swing.JButton();
        usernameLabel = new javax.swing.JLabel();
        ssnLabel = new javax.swing.JLabel();
        ageLabel = new javax.swing.JLabel();
        emailLabel = new javax.swing.JLabel();
        Username1 = new javax.swing.JLabel();
        changeButton = new javax.swing.JButton();
        SSN1 = new javax.swing.JLabel();
        SSN2 = new javax.swing.JLabel();
        rePasswordField = new javax.swing.JPasswordField();
        passwordField = new javax.swing.JPasswordField();
        clientNameLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        SSN.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        SSN.setText("SSN:");

        Age.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        Age.setText("Age:");

        Username.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        Username.setText("Rewrite Password:");

        Email.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        Email.setText("E-Mail:");

        backButton.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        backButton.setText("Back");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        usernameLabel.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        usernameLabel.setText("Username");

        ssnLabel.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        ssnLabel.setText("SSN Number");

        ageLabel.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        ageLabel.setText("Age");

        emailLabel.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        emailLabel.setText("E-Mail");

        Username1.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        Username1.setText("Username:");

        changeButton.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        changeButton.setText("Change");

        SSN1.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        SSN1.setText("Name:");

        SSN2.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        SSN2.setText("Password:");

        rePasswordField.setPreferredSize(new java.awt.Dimension(4, 36));

        passwordField.setPreferredSize(new java.awt.Dimension(4, 36));
        passwordField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordFieldActionPerformed(evt);
            }
        });

        clientNameLabel.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        clientNameLabel.setText("Client Name");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(changeButton))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Email)
                            .addComponent(Username)
                            .addComponent(SSN)
                            .addComponent(Age)
                            .addComponent(Username1)
                            .addComponent(SSN1)
                            .addComponent(SSN2))
                        .addGap(140, 140, 140)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(backButton))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(emailLabel)
                                    .addComponent(ageLabel)
                                    .addComponent(ssnLabel)
                                    .addComponent(usernameLabel)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(rePasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(clientNameLabel))
                                .addGap(0, 236, Short.MAX_VALUE)))))
                .addGap(23, 23, 23))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(53, 53, 53)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(SSN1)
                                    .addComponent(clientNameLabel)))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(backButton)))
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(SSN)
                            .addComponent(ssnLabel))
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Age)
                            .addComponent(ageLabel))
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Email)
                            .addComponent(emailLabel))
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(usernameLabel)
                            .addComponent(Username1))
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(SSN2)
                            .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(40, 40, 40)
                        .addComponent(Username))
                    .addComponent(rePasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addComponent(changeButton)
                .addGap(39, 39, 39))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_backButtonActionPerformed

    private void passwordFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passwordFieldActionPerformed

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
            java.util.logging.Logger.getLogger(Client_Account_Info_Page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Client_Account_Info_Page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Client_Account_Info_Page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Client_Account_Info_Page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Client_Account_Info_Page().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Age;
    private javax.swing.JLabel Email;
    private javax.swing.JLabel SSN;
    private javax.swing.JLabel SSN1;
    private javax.swing.JLabel SSN2;
    private javax.swing.JLabel Username;
    private javax.swing.JLabel Username1;
    private javax.swing.JLabel ageLabel;
    private javax.swing.JButton backButton;
    private javax.swing.JButton changeButton;
    private javax.swing.JLabel clientNameLabel;
    private javax.swing.JLabel emailLabel;
    private javax.swing.JPasswordField passwordField;
    private javax.swing.JPasswordField rePasswordField;
    private javax.swing.JLabel ssnLabel;
    private javax.swing.JLabel usernameLabel;
    // End of variables declaration//GEN-END:variables
}
