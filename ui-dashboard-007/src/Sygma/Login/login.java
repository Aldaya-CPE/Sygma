
package Sygma.Login;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;
import javax.swing.JFrame;
import Sygma.Controller.userController;
import Sygma.Model.ModelUser;
import com.raven.main.Main;
import com.sun.jdi.connect.spi.Connection;
import java.util.Arrays;
import java.util.prefs.Preferences;
import javax.swing.JOptionPane;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import Sygma.Model.UserSession;
import com.raven.component.Menu;
import com.raven.swing.handCursor;
import java.awt.Component;
import java.awt.Cursor;
import javax.swing.JButton;
import Sygma.Model.NameManager;


public class login extends javax.swing.JFrame {

    Connection MyCon;
    PreparedStatement ps;
    ResultSet rs;
    private userController controller;
    private String userId;
    ModelUser userData;
    private Main main;
    private NameManager nameManager;
    public login() {
        initComponents();
         userData = new ModelUser();
        controller = new userController();
        String userId = "yourUserId"; 
        gate.setText(userId);
        gate.setVisible(false);
        genId.setVisible(false);
        nameManager = new NameManager( new Menu());

          username.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                      jLabel7MouseClicked(null);

                }
            }
        });

        password.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                      jLabel7MouseClicked(null);

                }
            }
        });
        
        susername.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    jButton5ActionPerformed(null);
                }
            }
        });

        spassword.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    jButton5ActionPerformed(null);
                }
            }
        });

        genId.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    jButton5ActionPerformed(null);
                }
            }
        });
        
       Component[] componentsToApplyHandCursor = { jButton5, jLabel7, imageAvatar2, jButton3, jButton4};

       for (Component component : componentsToApplyHandCursor) {
        component.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
}
        jLabel7.setToolTipText("login");
        imageAvatar2.setToolTipText("Close");
        jButton5.setToolTipText("Sign up");
        jButton4.setToolTipText("Back to login");
        jButton3.setToolTipText("Go to Sign up");

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
        pc = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        imageAvatar2 = new com.raven.swing.ImageAvatar();
        changeform = new javax.swing.JPanel();
        login = new javax.swing.JPanel();
        panelBar3 = new Sygma.Component.PanelBar();
        jButton3 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        gate = new javax.swing.JLabel();
        username = new javax.swing.JTextField();
        password = new javax.swing.JPasswordField();
        imageAvatar3 = new com.raven.swing.ImageAvatar();
        jLabel2 = new javax.swing.JLabel();
        imageAvatar5 = new com.raven.swing.ImageAvatar();
        imageAvatar6 = new com.raven.swing.ImageAvatar();
        jLabel7 = new javax.swing.JLabel();
        signup = new javax.swing.JPanel();
        s = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        genId = new javax.swing.JLabel();
        spassword = new javax.swing.JPasswordField();
        susername = new javax.swing.JTextField();
        imageAvatar1 = new com.raven.swing.ImageAvatar();
        imageAvatar4 = new com.raven.swing.ImageAvatar();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setPreferredSize(new java.awt.Dimension(760, 460));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/picwall2.png"))); // NOI18N
        jPanel1.add(pc, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 60, -1, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("SYGMA");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 310, 130, 40));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("The Smart Expense Tracker");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 350, 240, 30));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Made by TEAM");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 380, 120, 30));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/blue.jpg"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 370, 460));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        imageAvatar2.setBackground(new java.awt.Color(0, 78, 100));
        imageAvatar2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/close.png"))); // NOI18N
        imageAvatar2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                imageAvatar2MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 364, Short.MAX_VALUE)
                .addComponent(imageAvatar2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(imageAvatar2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 17, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 0, 390, 40));

        changeform.setBackground(new java.awt.Color(255, 255, 255));
        changeform.setLayout(new java.awt.CardLayout());

        login.setBackground(new java.awt.Color(255, 255, 255));
        login.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelBar3.setBackground(new java.awt.Color(150, 233, 198));

        jButton3.setBackground(new java.awt.Color(150, 233, 198));
        jButton3.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Sign-up");
        jButton3.setBorder(null);
        jButton3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
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
                .addContainerGap()
                .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, 68, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelBar3Layout.setVerticalGroup(
            panelBar3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBar3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                .addContainerGap())
        );

        login.add(panelBar3, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 280, 80, 40));

        jLabel3.setForeground(new java.awt.Color(172, 172, 172));
        jLabel3.setText("You don't have an account?");
        login.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 320, 160, 20));

        gate.setText("jLabel7");
        login.add(gate, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, -1, -1));

        username.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(204, 204, 204)));
        username.setPreferredSize(new java.awt.Dimension(64, 19));
        username.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usernameActionPerformed(evt);
            }
        });
        login.add(username, new org.netbeans.lib.awtextra.AbsoluteConstraints(98, 190, 210, 18));

        password.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(204, 204, 204)));
        password.setPreferredSize(new java.awt.Dimension(64, 20));
        login.add(password, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 230, 210, 18));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/sym2.png"))); // NOI18N
        imageAvatar3.add(jLabel2);
        jLabel2.setBounds(40, 40, 40, 50);

        login.add(imageAvatar3, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 20, 110, 100));

        imageAvatar5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/icons8-user-30.png"))); // NOI18N
        login.add(imageAvatar5, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 190, 20, 20));

        imageAvatar6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/icons8-lock-30.png"))); // NOI18N
        login.add(imageAvatar6, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 230, 20, 20));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 32)); // NOI18N
        jLabel7.setText("Login");
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel7MouseClicked(evt);
            }
        });
        login.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 120, -1, -1));

        changeform.add(login, "card2");

        signup.setBackground(new java.awt.Color(255, 255, 255));
        signup.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        s.setFont(new java.awt.Font("Segoe UI", 1, 32)); // NOI18N
        s.setForeground(new java.awt.Color(65, 176, 110));
        s.setText("Sign up");
        signup.add(s, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 80, 120, 40));

        jButton4.setBackground(new java.awt.Color(253, 253, 253));
        jButton4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton4.setForeground(new java.awt.Color(153, 153, 153));
        jButton4.setText("Back");
        jButton4.setBorder(null);
        jButton4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton4.setIconTextGap(5);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        signup.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 390, 40, 30));

        jButton5.setBackground(new java.awt.Color(253, 253, 253));
        jButton5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton5.setForeground(new java.awt.Color(153, 153, 153));
        jButton5.setText("sign up");
        jButton5.setBorder(null);
        jButton5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton5.setIconTextGap(5);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        signup.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(254, 260, 50, 30));

        genId.setText("jLabel7");
        signup.add(genId, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 20, -1, -1));

        spassword.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(204, 204, 204)));
        spassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                spasswordActionPerformed(evt);
            }
        });
        signup.add(spassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(102, 210, 200, -1));

        susername.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(204, 204, 204)));
        susername.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                susernameActionPerformed(evt);
            }
        });
        signup.add(susername, new org.netbeans.lib.awtextra.AbsoluteConstraints(102, 170, 200, -1));

        imageAvatar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/icons8-lock-30.png"))); // NOI18N
        signup.add(imageAvatar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 210, 20, 20));

        imageAvatar4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/icons8-user-30.png"))); // NOI18N
        signup.add(imageAvatar4, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 170, 20, 20));

        changeform.add(signup, "card3");

        jPanel1.add(changeform, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 40, 390, 420));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
         changeform.removeAll();
        changeform.add(signup);
        changeform.revalidate();
        changeform.repaint();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
       changeform.removeAll();
        changeform.add(login);
        changeform.revalidate();
        changeform.repaint();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        try {
        String userName = susername.getText();
        char[] passWord = spassword.getPassword();
        String gId = generateUID(); 

        if (this.controller != null) {
             ModelUser newUser = new ModelUser(gId, userName, passWord);
            boolean registered = controller.registerUser(newUser);
            if (registered) {
                JOptionPane.showMessageDialog(this, "Thank You!");
                Main m = new Main();
                UserSession.setCurrentUser(newUser); 
                m.MainID.setText(gId); 
                m.setExtendedState(JFrame.MAXIMIZED_BOTH); 
                m.setVisible(true); 

                gate.setText(gId); 
            }
        } else {
            JOptionPane.showMessageDialog(this, "Controller is not initialized. Please try again later.");
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void imageAvatar2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_imageAvatar2MouseClicked
         System.exit(0);
    }//GEN-LAST:event_imageAvatar2MouseClicked

    private void usernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usernameActionPerformed

    private void spasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_spasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_spasswordActionPerformed

    private void susernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_susernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_susernameActionPerformed

    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseClicked
        String adminUsername = "admin";
        String adminPassword = "admin"; 

        String enteredUsername = username.getText();
        char[] enteredPassword = password.getPassword();
        if (enteredUsername.equals(adminUsername) && Arrays.equals(enteredPassword, adminPassword.toCharArray())) {
           Preferences prefs = Preferences.userNodeForPackage(login.class);
            prefs.putBoolean("isLoggedIn", true);
            JOptionPane.showMessageDialog(this, "Admin login successful!");

            Main m = new Main();
            
            m.MainID.setText("Admin"); 
            m.setExtendedState(JFrame.MAXIMIZED_BOTH); 
            
            m.idtext();
            m.setVisible(true);
            setVisible(false);
        } else {

            Main m = new Main();
            Menu men = new Menu();
//            m.updateuser();
//            Menu menu = new Menu();
//                 menu.username();
//             nameManager.updateUsername(UserSession.getCurrentUserId());
//            m.updateUsername();
            userController controller = new userController();
            ModelUser login = new ModelUser();


            if (enteredUsername != null && enteredPassword != null) {
                login.setUserName(enteredUsername);
                login.setPassWord(enteredPassword);

                ModelUser result = controller.Login(login);
                if (result != null) {
                    UserSession.setCurrentUser(result);
                    Preferences prefs = Preferences.userNodeForPackage(login.class);
                    prefs.putBoolean("isLoggedIn", true);
                  
                    m.MainID.setText(result.getUserId());
                     m.name.setText(result.getUserName());
                     m.men.usern.setText(result.getUserId());
                m.men.user.setText(result.getUserName());
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
    }//GEN-LAST:event_jLabel7MouseClicked

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
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel changeform;
    public javax.swing.JLabel gate;
    public javax.swing.JLabel genId;
    private com.raven.swing.ImageAvatar imageAvatar1;
    private com.raven.swing.ImageAvatar imageAvatar2;
    private com.raven.swing.ImageAvatar imageAvatar3;
    private com.raven.swing.ImageAvatar imageAvatar4;
    private com.raven.swing.ImageAvatar imageAvatar5;
    private com.raven.swing.ImageAvatar imageAvatar6;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
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
    private Sygma.Component.PanelBar panelBar3;
    private javax.swing.JPasswordField password;
    private javax.swing.JLabel pc;
    private javax.swing.JLabel s;
    private javax.swing.JPanel signup;
    private javax.swing.JPasswordField spassword;
    private javax.swing.JTextField susername;
    private javax.swing.JTextField username;
    // End of variables declaration//GEN-END:variables
}
