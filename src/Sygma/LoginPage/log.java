
package Sygma.LoginPage;

import java.util.Arrays;
import java.util.prefs.Preferences;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import Sygma.Controller.userController;
import Sygma.Model.ModelUser;
import Sygma.main; 
import Sygma.LoginPage.signUp;


import com.formdev.flatlaf.FlatLightLaf;
import java.awt.CardLayout;
import java.awt.Color;
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
import javax.swing.JPanel;


public class log extends javax.swing.JPanel {
    
    
    public log() {
        initComponents();
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

        loging = new javax.swing.JLabel();
        p2 = new Sygma.Components.PanelBar();
        password = new javax.swing.JPasswordField();
        p1 = new Sygma.Components.PanelBar();
        username = new javax.swing.JTextField();
        panelBar3 = new Sygma.Components.PanelBar();
        jButton3 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        loging.setFont(new java.awt.Font("Segoe UI", 0, 8)); // NOI18N
        loging.setText("lable");
        add(loging, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 60, 30));

        p2.setBackground(new java.awt.Color(255, 255, 255));
        p2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        password.setForeground(new java.awt.Color(153, 153, 153));
        password.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        p2.add(password, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 180, 10));

        add(p2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 220, 200, 30));

        p1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        username.setBackground(new java.awt.Color(242, 242, 242));
        username.setForeground(new java.awt.Color(153, 153, 153));
        username.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        p1.add(username, new org.netbeans.lib.awtextra.AbsoluteConstraints(14, 6, 180, -1));

        add(p1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 180, 200, 30));

        panelBar3.setBackground(new java.awt.Color(110, 206, 209));

        jButton3.setBackground(new java.awt.Color(110, 206, 209));
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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBar3Layout.createSequentialGroup()
                .addContainerGap(26, Short.MAX_VALUE)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );
        panelBar3Layout.setVerticalGroup(
            panelBar3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jButton3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        add(panelBar3, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 280, 120, 30));

        jLabel1.setForeground(new java.awt.Color(172, 172, 172));
        jLabel1.setText("You don't have an account?");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 310, 160, 20));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-sensor-50.png"))); // NOI18N
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 60, 50, 60));

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
        add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 120, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
//      JFrame parentFrame = (JFrame) javax.swing.SwingUtilities.getWindowAncestor(this);
//    
//    if (parentFrame instanceof Login) {
//        ((Login) parentFrame).switchToSignUp();
//    }
    }//GEN-LAST:event_jButton3ActionPerformed

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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    public javax.swing.JLabel loging;
    private Sygma.Components.PanelBar p1;
    private Sygma.Components.PanelBar p2;
    private Sygma.Components.PanelBar panelBar3;
    private javax.swing.JPasswordField password;
    private javax.swing.JTextField username;
    // End of variables declaration//GEN-END:variables
}
