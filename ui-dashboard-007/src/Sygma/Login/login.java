
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

public class login extends javax.swing.JFrame {

    Connection MyCon;
    PreparedStatement ps;
    ResultSet rs;
    private userController controller;
    ModelUser userData;
    public login() {
        initComponents();
        controller = new userController();
        gate.setVisible(false);
        genId.setVisible(false);
        
          username.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    jButton8ActionPerformed(null);
                }
            }
        });

        password.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    jButton8ActionPerformed(null);
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
        gate = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jButton7 = new javax.swing.JButton();
        changeform = new javax.swing.JPanel();
        login = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        q = new Sygma.Component.PanelBar();
        username = new javax.swing.JTextField();
        p = new Sygma.Component.PanelBar();
        password = new javax.swing.JPasswordField();
        panelBar3 = new Sygma.Component.PanelBar();
        jButton3 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jButton8 = new javax.swing.JButton();
        signup = new javax.swing.JPanel();
        s = new javax.swing.JLabel();
        f = new Sygma.Component.PanelBar();
        susername = new javax.swing.JTextField();
        panelBar5 = new Sygma.Component.PanelBar();
        d = new Sygma.Component.PanelBar();
        spassword = new javax.swing.JPasswordField();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        genId = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setPreferredSize(new java.awt.Dimension(760, 460));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/picwall2.png"))); // NOI18N
        jPanel1.add(pc, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 60, -1, -1));

        gate.setText("jLabel7");
        jPanel1.add(gate, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 40, -1, -1));

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

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/w2.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 370, 460));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jButton7.setBackground(new java.awt.Color(253, 253, 253));
        jButton7.setFont(new java.awt.Font("Segoe UI", 1, 32)); // NOI18N
        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/close.png"))); // NOI18N
        jButton7.setBorder(null);
        jButton7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton7.setIconTextGap(5);
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 362, Short.MAX_VALUE)
                .addComponent(jButton7))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jButton7)
                .addGap(0, 13, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 0, 390, 40));

        changeform.setBackground(new java.awt.Color(255, 255, 255));
        changeform.setLayout(new java.awt.CardLayout());

        login.setBackground(new java.awt.Color(255, 255, 255));
        login.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/icons8-sensor-50.png"))); // NOI18N
        login.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 50, -1, -1));

        username.setBackground(new java.awt.Color(242, 242, 242));
        username.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        javax.swing.GroupLayout qLayout = new javax.swing.GroupLayout(q);
        q.setLayout(qLayout);
        qLayout.setHorizontalGroup(
            qLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, qLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(username, javax.swing.GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE)
                .addContainerGap())
        );
        qLayout.setVerticalGroup(
            qLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(qLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(username)
                .addContainerGap())
        );

        login.add(q, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 180, 230, 30));

        p.setBackground(new java.awt.Color(255, 255, 255));

        password.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        javax.swing.GroupLayout pLayout = new javax.swing.GroupLayout(p);
        p.setLayout(pLayout);
        pLayout.setHorizontalGroup(
            pLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );
        pLayout.setVerticalGroup(
            pLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(8, Short.MAX_VALUE))
        );

        login.add(p, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 220, 230, 30));

        panelBar3.setBackground(new java.awt.Color(150, 233, 198));

        jButton3.setBackground(new java.awt.Color(150, 233, 198));
        jButton3.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Sign-up");
        jButton3.setBorder(null);
        jButton3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
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
                .addGap(17, 17, 17)
                .addComponent(jButton3)
                .addContainerGap(21, Short.MAX_VALUE))
        );
        panelBar3Layout.setVerticalGroup(
            panelBar3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBar3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                .addContainerGap())
        );

        login.add(panelBar3, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 280, 90, 40));

        jLabel3.setForeground(new java.awt.Color(172, 172, 172));
        jLabel3.setText("You don't have an account?");
        login.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 320, 160, 20));

        jButton8.setBackground(new java.awt.Color(253, 253, 253));
        jButton8.setFont(new java.awt.Font("Segoe UI", 1, 32)); // NOI18N
        jButton8.setText("Login");
        jButton8.setBorder(null);
        jButton8.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton8.setIconTextGap(5);
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        login.add(jButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 130, -1, -1));

        changeform.add(login, "card2");

        signup.setBackground(new java.awt.Color(255, 255, 255));
        signup.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        s.setFont(new java.awt.Font("Segoe UI", 1, 32)); // NOI18N
        s.setForeground(new java.awt.Color(65, 176, 110));
        s.setText("Sign up");
        signup.add(s, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 70, 120, 40));

        f.setBackground(new java.awt.Color(255, 255, 255));

        susername.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        javax.swing.GroupLayout fLayout = new javax.swing.GroupLayout(f);
        f.setLayout(fLayout);
        fLayout.setHorizontalGroup(
            fLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(fLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(susername, javax.swing.GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE)
                .addContainerGap())
        );
        fLayout.setVerticalGroup(
            fLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(fLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(susername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        signup.add(f, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 140, 220, 30));

        javax.swing.GroupLayout panelBar5Layout = new javax.swing.GroupLayout(panelBar5);
        panelBar5.setLayout(panelBar5Layout);
        panelBar5Layout.setHorizontalGroup(
            panelBar5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 220, Short.MAX_VALUE)
        );
        panelBar5Layout.setVerticalGroup(
            panelBar5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        signup.add(panelBar5, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 220, 220, 30));

        d.setBackground(new java.awt.Color(255, 255, 255));

        spassword.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        javax.swing.GroupLayout dLayout = new javax.swing.GroupLayout(d);
        d.setLayout(dLayout);
        dLayout.setHorizontalGroup(
            dLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(spassword, javax.swing.GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE)
                .addContainerGap())
        );
        dLayout.setVerticalGroup(
            dLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(spassword)
                .addContainerGap())
        );

        signup.add(d, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 180, 220, 30));

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
        String gId = genId.getText();
        
        if (this.controller != null) {
            boolean registered = controller.registerUser(new ModelUser(gId, userName, passWord));
            
            if (registered) {
                JOptionPane.showMessageDialog(this, "Thank You!");
                Main m = new Main();
                m.MainID.setText(gId); 
                m.setExtendedState(JFrame.MAXIMIZED_BOTH); 
                m.setVisible(true); 
            }
        } else {
            JOptionPane.showMessageDialog(this, "Controller is not initialized. Please try again later.");
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
     System.exit(0);          
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
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
            m.setVisible(true);
            setVisible(false);
        } else {

            Main m = new Main();
            userController controller = new userController();
            ModelUser login = new ModelUser();


            if (enteredUsername != null && enteredPassword != null) {
                login.setUserName(enteredUsername);
                login.setPassWord(enteredPassword);

                ModelUser result = controller.Login(login);
                if (result != null) {
                    Preferences prefs = Preferences.userNodeForPackage(login.class);
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
    }//GEN-LAST:event_jButton8ActionPerformed

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
    private Sygma.Component.PanelBar d;
    private Sygma.Component.PanelBar f;
    public javax.swing.JLabel gate;
    public javax.swing.JLabel genId;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel login;
    private Sygma.Component.PanelBar p;
    private Sygma.Component.PanelBar panelBar3;
    private Sygma.Component.PanelBar panelBar5;
    private javax.swing.JPasswordField password;
    private javax.swing.JLabel pc;
    private Sygma.Component.PanelBar q;
    private javax.swing.JLabel s;
    private javax.swing.JPanel signup;
    private javax.swing.JPasswordField spassword;
    private javax.swing.JTextField susername;
    private javax.swing.JTextField username;
    // End of variables declaration//GEN-END:variables
}
