
package Sygma.LoginPage;

import Sygma.LoginPage.log;
import Sygma.LoginPage.signUp;
import java.awt.CardLayout;
import java.awt.Component;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JPanel;
import Sygma.Controller.userController;
import Sygma.Model.ModelUser;
import Sygma.main; 
import java.util.Arrays;
import java.util.prefs.Preferences;
import javax.swing.JOptionPane;

public class Login extends javax.swing.JFrame {

    public Login() {
        initComponents();
        gate.setVisible(false);
        genId.setVisible(false);
        loging.setVisible(false);
          username.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    jButton2ActionPerformed(null);
                }
            }
        });

        password.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    jButton2ActionPerformed(null);
                }
            }
        });
    }
         
  private static String generateUID(){
        int userId = 6;
        Random random = new Random();
        StringBuilder userBuilder = new StringBuilder();
        for (int i = 0; i < userId; i++) {
            userBuilder.append(random.nextInt(10));
        }
        String uID = userBuilder.toString();
        return uID;
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        JLabel7 = new javax.swing.JLabel();
        gate = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jButton9 = new javax.swing.JButton();
        changeform = new javax.swing.JPanel();
        login = new javax.swing.JPanel();
        loging = new javax.swing.JLabel();
        p2 = new Sygma.Components.PanelBar();
        password = new javax.swing.JPasswordField();
        p1 = new Sygma.Components.PanelBar();
        username = new javax.swing.JTextField();
        panelBar3 = new Sygma.Components.PanelBar();
        jButton3 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        signup = new javax.swing.JPanel();
        genId = new javax.swing.JLabel();
        panelBar1 = new Sygma.Components.PanelBar();
        panelBar2 = new Sygma.Components.PanelBar();
        panelBar4 = new Sygma.Components.PanelBar();
        panelRound02 = new Sygma.Components.PanelRound0();
        jButton5 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();

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

        gate.setText("jLabel1");
        jPanel1.add(gate, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/w22.png"))); // NOI18N
        jLabel2.setText("jLabel2");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -10, 380, 470));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jButton9.setBackground(new java.awt.Color(253, 253, 253));
        jButton9.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jButton9.setForeground(new java.awt.Color(255, 255, 255));
        jButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/close.png"))); // NOI18N
        jButton9.setBorder(null);
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 352, Short.MAX_VALUE)
                .addComponent(jButton9))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jButton9)
                .addGap(0, 13, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 0, 380, 40));

        changeform.setBackground(new java.awt.Color(255, 255, 255));
        changeform.setLayout(new java.awt.CardLayout());

        login.setBackground(new java.awt.Color(255, 255, 255));
        login.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        loging.setFont(new java.awt.Font("Segoe UI", 0, 8)); // NOI18N
        loging.setText("lable");
        login.add(loging, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 60, 30));

        p2.setBackground(new java.awt.Color(255, 255, 255));
        p2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        password.setForeground(new java.awt.Color(153, 153, 153));
        password.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        p2.add(password, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 160, 10));

        login.add(p2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 220, 200, 30));

        p1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        username.setBackground(new java.awt.Color(242, 242, 242));
        username.setForeground(new java.awt.Color(153, 153, 153));
        username.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        p1.add(username, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 8, 180, 20));

        login.add(p1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 180, 200, 30));

        panelBar3.setBackground(new java.awt.Color(150, 233, 198));

        jButton3.setBackground(new java.awt.Color(150, 233, 198));
        jButton3.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Sign-up");
        jButton3.setBorder(null);
        jButton3.setIconTextGap(5);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelBar3Layout = new javax.swing.GroupLayout(panelBar3);
        panelBar3.setLayout(panelBar3Layout);
        panelBar3Layout.setHorizontalGroup(
            panelBar3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBar3Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );
        panelBar3Layout.setVerticalGroup(
            panelBar3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jButton3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        login.add(panelBar3, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 280, 120, 30));

        jLabel1.setForeground(new java.awt.Color(172, 172, 172));
        jLabel1.setText("You don't have an account?");
        login.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 310, 160, 20));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-sensor-50.png"))); // NOI18N
        login.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 50, 50, 60));

        jButton2.setBackground(new java.awt.Color(253, 253, 253));
        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 32)); // NOI18N
        jButton2.setText("Login");
        jButton2.setBorder(null);
        jButton2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton2.setIconTextGap(5);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        login.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 120, -1, -1));

        changeform.add(login, "card2");

        signup.setBackground(new java.awt.Color(255, 255, 255));
        signup.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        genId.setText("jLabel1");
        signup.add(genId, new org.netbeans.lib.awtextra.AbsoluteConstraints(14, 25, -1, -1));

        panelBar1.setBackground(new java.awt.Color(255, 255, 255));
        panelBar1.setForeground(new java.awt.Color(153, 153, 153));

        javax.swing.GroupLayout panelBar1Layout = new javax.swing.GroupLayout(panelBar1);
        panelBar1.setLayout(panelBar1Layout);
        panelBar1Layout.setHorizontalGroup(
            panelBar1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 200, Short.MAX_VALUE)
        );
        panelBar1Layout.setVerticalGroup(
            panelBar1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        signup.add(panelBar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 170, -1, -1));

        panelBar2.setForeground(new java.awt.Color(153, 153, 153));

        javax.swing.GroupLayout panelBar2Layout = new javax.swing.GroupLayout(panelBar2);
        panelBar2.setLayout(panelBar2Layout);
        panelBar2Layout.setHorizontalGroup(
            panelBar2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 200, Short.MAX_VALUE)
        );
        panelBar2Layout.setVerticalGroup(
            panelBar2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        signup.add(panelBar2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 210, 200, -1));

        panelBar4.setBackground(new java.awt.Color(255, 255, 255));
        panelBar4.setForeground(new java.awt.Color(153, 153, 153));

        javax.swing.GroupLayout panelBar4Layout = new javax.swing.GroupLayout(panelBar4);
        panelBar4.setLayout(panelBar4Layout);
        panelBar4Layout.setHorizontalGroup(
            panelBar4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 200, Short.MAX_VALUE)
        );
        panelBar4Layout.setVerticalGroup(
            panelBar4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        signup.add(panelBar4, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 130, -1, -1));

        javax.swing.GroupLayout panelRound02Layout = new javax.swing.GroupLayout(panelRound02);
        panelRound02.setLayout(panelRound02Layout);
        panelRound02Layout.setHorizontalGroup(
            panelRound02Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        panelRound02Layout.setVerticalGroup(
            panelRound02Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        signup.add(panelRound02, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 290, -1, -1));

        jButton5.setBackground(new java.awt.Color(253, 253, 253));
        jButton5.setForeground(new java.awt.Color(153, 153, 153));
        jButton5.setText("Back");
        jButton5.setBorder(null);
        jButton5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton5.setIconTextGap(5);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        signup.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 390, 30, 30));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 32)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(65, 176, 110));
        jLabel7.setText("Sign up");
        signup.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 70, 120, 40));

        jButton6.setBackground(new java.awt.Color(253, 253, 253));
        jButton6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton6.setForeground(new java.awt.Color(153, 153, 153));
        jButton6.setText("Sign up");
        jButton6.setBorder(null);
        jButton6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton6.setIconTextGap(5);
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        signup.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 260, -1, -1));

        changeform.add(signup, "card3");

        jPanel1.add(changeform, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 40, 380, 420));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       String adminUsername = "admin";
        String adminPassword = "admin"; 

        String enteredUsername = username.getText();
        char[] enteredPassword = password.getPassword();
        if (enteredUsername.equals(adminUsername) && Arrays.equals(enteredPassword, adminPassword.toCharArray())) {
           Preferences prefs = Preferences.userNodeForPackage(Login.class);
            prefs.putBoolean("isLoggedIn", true);
            JOptionPane.showMessageDialog(this, "Admin login successful!");

            main m = new main();
            m.MainID.setText("Admin"); 
            m.setExtendedState(JFrame.MAXIMIZED_BOTH); 
            m.setVisible(true);
            setVisible(false);
        } else {

            main m = new main();
            userController controller = new userController();
            ModelUser login = new ModelUser();


            if (enteredUsername != null && enteredPassword != null) {
                login.setUserName(enteredUsername);
                login.setPassWord(enteredPassword);

                ModelUser result = controller.Login(login);
                if (result != null) {
                    Preferences prefs = Preferences.userNodeForPackage(Login.class);
                    prefs.putBoolean("isLoggedIn", true);
                    
                    m.MainID.setText(result.getUserId());
                    m.setExtendedState(JFrame.MAXIMIZED_BOTH); 
                    m.setVisible(true);
                    setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(this, "Incorrect Username or Password, please Try again!");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Username or Password cannot be empty!");
            }
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
      changeform.removeAll();
        changeform.add(login);
        changeform.revalidate();
        changeform.repaint();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        changeform.removeAll();
        changeform.add(signup);
        changeform.revalidate();
        changeform.repaint();
    }//GEN-LAST:event_jButton3ActionPerformed

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
    public javax.swing.JLabel genId;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel login;
    public javax.swing.JLabel loging;
    private Sygma.Components.PanelBar p1;
    private Sygma.Components.PanelBar p2;
    private Sygma.Components.PanelBar panelBar1;
    private Sygma.Components.PanelBar panelBar2;
    private Sygma.Components.PanelBar panelBar3;
    private Sygma.Components.PanelBar panelBar4;
    private Sygma.Components.PanelRound0 panelRound02;
    private javax.swing.JPasswordField password;
    private javax.swing.JPanel signup;
    private javax.swing.JTextField username;
    // End of variables declaration//GEN-END:variables
}
