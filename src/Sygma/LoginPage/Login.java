
package Sygma.LoginPage;

import Sygma.LoginPage.log;
import com.raven.event.EventMenu;
import Sygma.LoginPage.signUp;

import Sygma.Controller.userController;
import Sygma.main;
import Sygma.Model.ModelUser;
import com.formdev.flatlaf.FlatLightLaf;
import com.mysql.cj.log.Log;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.Arrays;
import java.util.Random;
import java.util.UUID;
import java.util.prefs.Preferences;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class Login extends javax.swing.JFrame {
    private log Log;
    private signUp SignUp;
    
     
    public Login() {
        initComponents();
        
        Log = new log();
        SignUp = new signUp();
        
        
    
        showForm(Log);
         idtext();
        gate.setVisible(false);
        initMoving(this);
    }
     private int x;
     private int y;
       public void idtext(){
         SwingUtilities.invokeLater(() -> {
         Log.loging.removeAll();
         Log.loging.repaint();
         Log.loging.revalidate();
         Log.loging.setText(gate.getText());         
        });
         SwingUtilities.invokeLater(() -> {
         SignUp.genId.removeAll();
         SignUp.genId.repaint();
         SignUp.genId.revalidate();
         SignUp.genId.setText(gate.getText());         
        }); 
       }
       
         public void initMoving(JFrame frame){
        changeform.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                
                x = e.getX();
                y = e.getY();
            }
            
        });
        changeform.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
             frame.setLocation(e.getXOnScreen()-x, e.getYOnScreen()-y);
                
                
            }
        });
    }
 private void showForm(Component com){
        changeform.removeAll();
        changeform.add(com);
        repaint();
        revalidate();
    }
//    private static String generateUID(){
//        int userId = 6;
//        Random random = new Random();
//        StringBuilder userBuilder = new StringBuilder();
//        for (int i = 0; i < userId; i++) {
//            userBuilder.append(random.nextInt(10));
//        }
//        String uID = userBuilder.toString();
//        return uID;
//    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        gate = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        changeform = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        gate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/picwall2.png"))); // NOI18N
        gate.setText("jLabel3");
        getContentPane().add(gate, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 60, 250, 250));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("SYGMA");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 310, 130, 40));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("The Smart Expense Tracker");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 350, 240, 30));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Made by TEAM");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 380, 120, 30));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/w22.png"))); // NOI18N
        jLabel2.setText("jLabel2");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 380, 460));

        changeform.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout changeformLayout = new javax.swing.GroupLayout(changeform);
        changeform.setLayout(changeformLayout);
        changeformLayout.setHorizontalGroup(
            changeformLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 380, Short.MAX_VALUE)
        );
        changeformLayout.setVerticalGroup(
            changeformLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 460, Short.MAX_VALUE)
        );

        getContentPane().add(changeform, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 0, 380, 460));

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
    private javax.swing.JPanel changeform;
    public javax.swing.JLabel gate;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    // End of variables declaration//GEN-END:variables
}
