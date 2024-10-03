package com.raven.main;

import Sygma.Database.Database;
import Sygma.Login.login;
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


    public Main() {
        initComponents();
        String userId = "your_user_id";
        MainID.setText(userId);   
         form_1 = new Form_1();
         form2 = new Form2();
         form3 = new Form3();
         form4 = new Form4();
         form5 = new Form5();
        Adding = new adding();         
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
            showForm(form_1); 
         idtext();
         menu1.initMenu(event);
         
    }
    
   public void idtext() {
    String userId = MainID.getText(); 
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

}
    



    private void showForm(Component com) {
       body.removeAll();
       body.add(com);
       repaint();
       revalidate();
     
    }
    private void logout() {
        dispose(); 
        login loginWindow = new login();
        loginWindow.setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        MainID = new javax.swing.JLabel();
        roundPanel1 = new com.raven.swing.RoundPanel();
        header2 = new com.raven.component.Header();
        menu1 = new com.raven.component.Menu();
        body = new javax.swing.JPanel();

        MainID.setText("jLabel1");

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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(menu1, javax.swing.GroupLayout.PREFERRED_SIZE, 675, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(body, javax.swing.GroupLayout.PREFERRED_SIZE, 672, javax.swing.GroupLayout.PREFERRED_SIZE))
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
    private com.raven.component.Menu menu1;
    private com.raven.swing.RoundPanel roundPanel1;
    // End of variables declaration//GEN-END:variables
}
