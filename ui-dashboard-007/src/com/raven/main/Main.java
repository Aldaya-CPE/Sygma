package com.raven.main;

import Sygma.Database.Database;
import Sygma.Login.login;
import com.raven.event.EventMenu;
import com.raven.form.Form5;
import com.raven.form.Form3;
import com.raven.form.Form2;
import com.raven.form.Form4;
import com.raven.form.Form_1;
import com.raven.form.Add;
import com.raven.swing.DataSearch;
import com.raven.swing.EventClick;
import com.raven.swing.PanelSearch;
import com.sun.jdi.connect.spi.Connection;
import java.awt.CardLayout;
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

public class Main extends javax.swing.JFrame {
      private JPopupMenu menu;
    private PanelSearch search;
     Connection MyCon;
    PreparedStatement ps;
    ResultSet rs;
    private CardLayout cardLayout;
    private Form2 form2;
    private Form_1 form_1;
    private Form4 form4;
    private Form5 form5;
    private Form3 form3;
    private Add add;


    public Main() {
        initComponents();
       MainID.setVisible(false);
         String userId = MainID.getText(); 
          GlassPanePopup.install(this);
                


    
        setBackground(new Color(0, 0, 0, 0));
        
           EventMenu event = new EventMenu() {
            @Override
            public void selected(int index) {
                switch (index) {
                    case 0:
                         if (form_1 == null) { 
                            form_1 = new Form_1(); 
                        }
                        showForm(form_1);
                        idtext(); 
                        break;
                    case 1:
                         if (form2 == null) { 
                            form2 = new Form2(); 
                        }
                        showForm(form2);
                        idtext(); 
                        break;
                     case 2:
                       if (form3 == null) { 
                            form3 = new Form3(); 
                        }
                        showForm(form3);
                        idtext(); 
                        break;
                     case 3:
                        if (form4 == null) { 
                            form4 = new Form4(); 
                        }
                        showForm(form4);
                        idtext(); 
                        break;
                     case 4:
                        if (form5 == null) { 
                            form5 = new Form5(); 
                        }
                        showForm(form5);
                        idtext(); 
                        break;
                    case 5:
                        logout();
                        break;
                    default:
                        break;
                }
            }
            public void onMenuSelected(EventListener listener) {
            }
        };
        menu1.initMenu(event);
        showForm(new Form_1()); 
        idtext(); 

    }
    
   public void idtext() {
    String userId = MainID.getText(); 
    SwingUtilities.invokeLater(() -> {
        if (form_1 != null) {
            form_1.pn.setText(userId); 
        }
        if (form2 != null) {
            form2.ex.setText(userId);
            form2.ad.setText(userId); 
        }
        if (form3 != null) {
            form3.cat.setText(userId); 
        }
         if (form4 != null) {
            form4.ed.setText(userId); 
        }
          if (form5 != null) {
            form5.ec.setText(userId); 
        }
      
    });
}
    
//    public void idtext() {
////    String userId = MainID.getText(); 
//
////    SwingUtilities.invokeLater(() -> {
////        form2.ex.setText(MainID.getText());
////    });
////}
     private void switchToNextForm() {
        cardLayout.next(body); 
    }

    private void showForm(Component com) {
        body.removeAll();
        body.add(com);
        body.revalidate();
        body.repaint();
    }
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
        body.setLayout(new java.awt.CardLayout());

        MainID.setText("jLabel1");
        body.add(MainID, "card2");

        javax.swing.GroupLayout roundPanel1Layout = new javax.swing.GroupLayout(roundPanel1);
        roundPanel1.setLayout(roundPanel1Layout);
        roundPanel1Layout.setHorizontalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(header2, javax.swing.GroupLayout.PREFERRED_SIZE, 1371, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(roundPanel1Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(menu1, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addComponent(body, javax.swing.GroupLayout.PREFERRED_SIZE, 1121, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        roundPanel1Layout.setVerticalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel1Layout.createSequentialGroup()
                .addComponent(header2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(roundPanel1Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(menu1, javax.swing.GroupLayout.PREFERRED_SIZE, 675, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(roundPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(body, javax.swing.GroupLayout.PREFERRED_SIZE, 672, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
      
    private List<search.DataSearch1> search(String search) {
    List<search.DataSearch1> list = new ArrayList<>();
    try {
       String sql = "SELECT DISTINCT category FROM expenses WHERE userId = ? AND category LIKE ? ORDER BY category LIMIT 7";
        ps = Database.getInstance().getConnection().prepareStatement(sql); 
        ps.setString(1, MainID.getText());
        ps.setString(2, "%" + search + "%");
        
        ResultSet r = ps.executeQuery(); 
        while (r.next()) {
            String text = r.getString(1);
            boolean story = false;
            list.add(new search.DataSearch1(text, story));
        }
        r.close();
        ps.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return list;
}
    

    private void removeHistory(String text) {
    try {
       String sql ="DELETE FROM expenses WHERE category = ? LIMIT 1";
        ps = Database.getInstance().getConnection().prepareStatement(sql); 
        ps.setString(1, text);
        ps.execute();
        ps.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }
}
     private void addStory(String text) {
   
}
     
     
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
    private com.raven.component.Menu menu1;
    private com.raven.swing.RoundPanel roundPanel1;
    // End of variables declaration//GEN-END:variables
}
