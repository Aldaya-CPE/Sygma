package com.raven.main;

import Sygma.Database.Database;
import Sygma.Login.login;
import Sygma.Model.UserSession;
import com.raven.event.EventMenu;
import com.raven.form.Form5;
import com.raven.form.Form3;
import com.raven.form.Form2;
import com.raven.form.Form4;
import com.raven.form.Form_1;
import com.raven.form.adding;
import com.raven.form.Add;
import com.raven.swing.DataSearch;
import com.raven.swing.EventClick;
import com.raven.swing.PanelSearch;
import com.sun.jdi.connect.spi.Connection;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.KeyEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.EventListener;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.SwingUtilities;
import raven.glasspanepopup.GlassPanePopup;
import com.raven.component.Menu;
import javax.swing.Timer;

public class Main extends javax.swing.JFrame {
    private JPopupMenu menu;
    private PanelSearch search;
     Connection MyCon;
    PreparedStatement ps;
    ResultSet rs;
    private Form2 form2;
    private Form_1 form_1;
    private Form4 form4;
    private Form5 form5;
    private Form3 form3;
    private adding Adding;
    public static  Menu men;
    private Timer timer;
    public Menu getMenuInstance() {
        return men; // assuming men is the Menu instance
    }

    public Main() {
        initComponents();
             try {
            Database.getInstance().ConnectToDatabase();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
      
//        String userId = "your_user_id";
//        MainID.setText(userId);   
         form_1 = new Form_1();
         form2 = new Form2();
         form3 = new Form3();
         form4 = new Form4();
         form5 = new Form5();
        Adding = new adding(); 
       men = new Menu();
       
         name.setText(UserSession.getCurrentUsername());
        MainID.setText(UserSession.getCurrentUserId());
      
//                timer = new Timer(300, (e) -> {
////            updateuser();
//            username();
//        });
        GlassPanePopup.install(this);
    
        
        setBackground(new Color(0, 0, 0, 0));
        
           EventMenu event = new EventMenu() {
            @Override
            public void selected(int index) {
                switch (index) {
                    case 0:
                        showForm(form_1);
                         break;
                    case 1:
                        showForm(form2);
                        break;
                     case 2:
                        showForm(form3);
                        break;
                     case 3:
                        showForm(form4);
                        break;
                     case 4:
                        showForm(form5);
                        break;
                    case 5:
                        logout();
                        break;
                    default:
                        break;
                }
                 idtext();

            }
            
            public void onMenuSelected(EventListener listener) 
            {
            }
        };
           form_1.populateTable(); 
            showForm(form_1); 
         idtext();
         menu1.initMenu(event);
         
    }
    
   public void idtext() {
       
//    String userId = MainID.getText(); 
    
SwingUtilities.invokeLater(() -> {
         form_1.pn.removeAll();
         form_1.pn.repaint();
         form_1.pn.revalidate();
         form_1.pn.setText(MainID.getText());         
        });

SwingUtilities.invokeLater(() -> {
         form2.ex.removeAll();
         form2.ex.repaint();
         form2.ex.revalidate();
         form2.ex.setText(MainID.getText());     
         
         form2.ad.removeAll();
         form2.ad.repaint();
         form2.ad.revalidate();
         form2.ad.setText(MainID.getText());
        });
SwingUtilities.invokeLater(() -> {
         form2.ad.setText(MainID.getText());
         Adding.userId = MainID.getText();
         Adding.der.removeAll();
         Adding.der.repaint();
         Adding.der.revalidate();
         Adding.der.setText(MainID.getText());         
        });
SwingUtilities.invokeLater(() -> {
         form3.cat.removeAll();
         form3.cat.repaint();
         form3.cat.revalidate();
         form3.cat.setText(MainID.getText());         
        });
SwingUtilities.invokeLater(() -> {
         form4.ed.removeAll();
         form4.ed.repaint();
         form4.ed.revalidate();
         form4.ed.setText(MainID.getText());         
        });
SwingUtilities.invokeLater(() -> {
         form5.ec.removeAll();
         form5.ec.repaint();
         form5.ec.revalidate();
         form5.ec.setText(MainID.getText());         
        });
//SwingUtilities.invokeLater(() -> {
//         men.usern.removeAll();
//         men.usern.repaint();
//         men.usern.revalidate();
//         men.usern.setText(MainID.getText());         
//        });
//    
}
   



    private void showForm(Component com) {
       body.removeAll();
       body.add(com);
       repaint();
       revalidate();
        if (com instanceof Form3) {
        ((Form3) com).populateTable();
    }
        if (com instanceof Form2) {
        ((Form2) com).populateTable();
        ((Form2) com).username();
    }
         if (com instanceof Form_1) {
        ((Form_1) com).populateTable();
    }
       
    
        
    }
    
//     public void username() {
//    try {
//        String sql = "SELECT userName FROM userdata WHERE userId = ?";
//        ps = Database.getInstance().getConnection().prepareStatement(sql);
//        ps.setString(1, MainID.getText());
//         ResultSet rsUsername = ps.executeQuery();
//
//        
//        if (rsUsername.next()) {
//            String username = rsUsername.getString("userName");
//            name.setText(username);
//        } else {
//            name.setText("User  not found");
//        }
//    } catch (Exception e) {
//        e.printStackTrace();
//    }
//}
    
//    public static void updateuser(){
//        men.username();
//    }
    
    private void logout() {
        dispose(); 
        login loginWindow = new login();
        loginWindow.setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        roundPanel1 = new com.raven.swing.RoundPanel();
        header2 = new com.raven.component.Header();
        menu1 = new com.raven.component.Menu();
        body = new javax.swing.JPanel();
        roundPanel2 = new com.raven.swing.RoundPanel();
        imageAvatar1 = new com.raven.swing.ImageAvatar();
        name = new javax.swing.JLabel();
        MainID = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        roundPanel1.setBackground(new java.awt.Color(255, 252, 250));

        header2.setBackground(new java.awt.Color(0, 78, 100));
        header2.setOpaque(true);

        menu1.setBackground(new java.awt.Color(255, 255, 255));

        body.setBackground(new java.awt.Color(204, 255, 255));
        body.setForeground(new java.awt.Color(204, 255, 204));
        body.setOpaque(false);
        body.setLayout(new java.awt.BorderLayout());

        roundPanel2.setBackground(new java.awt.Color(0, 78, 100));

        imageAvatar1.setForeground(new java.awt.Color(231, 231, 231));
        imageAvatar1.setBorderSize(2);
        imageAvatar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/icons8-user-50.png"))); // NOI18N

        name.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        name.setForeground(new java.awt.Color(224, 224, 224));
        name.setText("User Name");

        MainID.setText("jLabel1");

        javax.swing.GroupLayout roundPanel2Layout = new javax.swing.GroupLayout(roundPanel2);
        roundPanel2.setLayout(roundPanel2Layout);
        roundPanel2Layout.setHorizontalGroup(
            roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel2Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(imageAvatar1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(roundPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(name)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(MainID)
                        .addGap(23, 23, 23))))
        );
        roundPanel2Layout.setVerticalGroup(
            roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(name)
                .addGap(26, 26, 26))
            .addGroup(roundPanel2Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(MainID)
                    .addComponent(imageAvatar1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10))
        );

        javax.swing.GroupLayout roundPanel1Layout = new javax.swing.GroupLayout(roundPanel1);
        roundPanel1.setLayout(roundPanel1Layout);
        roundPanel1Layout.setHorizontalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(header2, javax.swing.GroupLayout.PREFERRED_SIZE, 1371, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(roundPanel1Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(menu1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(roundPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(body, javax.swing.GroupLayout.PREFERRED_SIZE, 1117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
        );
        roundPanel1Layout.setVerticalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel1Layout.createSequentialGroup()
                .addComponent(header2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(roundPanel1Layout.createSequentialGroup()
                        .addComponent(roundPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(3, 3, 3)
                        .addComponent(menu1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(body, javax.swing.GroupLayout.DEFAULT_SIZE, 672, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(roundPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(roundPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

     
     
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
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JLabel MainID;
    private javax.swing.JPanel body;
    private com.raven.component.Header header2;
    private com.raven.swing.ImageAvatar imageAvatar1;
    private com.raven.component.Menu menu1;
    public javax.swing.JLabel name;
    private com.raven.swing.RoundPanel roundPanel1;
    private com.raven.swing.RoundPanel roundPanel2;
    // End of variables declaration//GEN-END:variables
}
