
package Sygma.LoginPage;

import Sygma.LoginPage.log;
import Sygma.LoginPage.signUp;
import java.awt.Component;
import javax.swing.JFrame;


public class Login extends javax.swing.JFrame {
  
    
     
    public Login() {
        initComponents();
        
   
         showForm(new log());

    }
    
         private void showForm(Component com) {
        changeform.removeAll();
        changeform.setLayout(new java.awt.BorderLayout());  // Ensuring a proper layout manager
        changeform.add(com);
        changeform.revalidate();
        changeform.repaint();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        JLabel7 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        changeform = new javax.swing.JPanel();
        gate = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("SYGMA");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 310, 130, 40));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Made by TEAM");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 380, 120, 30));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("The Smart Expense Tracker");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 350, 240, 30));

        JLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/picwall2.png"))); // NOI18N
        JLabel7.setText("jLabel3");
        jPanel1.add(JLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 60, 250, 250));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/w22.png"))); // NOI18N
        jLabel2.setText("jLabel2");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 380, 460));

        changeform.setBackground(new java.awt.Color(255, 255, 255));

        gate.setText("jLabel1");

        jButton1.setText("jButton1");

        javax.swing.GroupLayout changeformLayout = new javax.swing.GroupLayout(changeform);
        changeform.setLayout(changeformLayout);
        changeformLayout.setHorizontalGroup(
            changeformLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(changeformLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(gate)
                .addGap(28, 28, 28)
                .addComponent(jButton1)
                .addContainerGap(213, Short.MAX_VALUE))
        );
        changeformLayout.setVerticalGroup(
            changeformLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(changeformLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(changeformLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(gate)
                    .addComponent(jButton1))
                .addContainerGap(419, Short.MAX_VALUE))
        );

        jPanel1.add(changeform, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 0, 380, 460));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel JLabel7;
    private javax.swing.JPanel changeform;
    public javax.swing.JLabel gate;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
