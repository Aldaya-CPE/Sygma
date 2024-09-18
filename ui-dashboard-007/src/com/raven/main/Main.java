package com.raven.main;

import Sygma.Login.login;
import com.raven.event.EventMenu;
import com.raven.form.Form;
import com.raven.form.Form3;
import com.raven.form.Form2;
import com.raven.form.Form4;
import com.raven.form.Form_1;
import com.raven.form.Add;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.util.EventListener;
import javax.swing.SwingUtilities;
import raven.glasspanepopup.GlassPanePopup;

public class Main extends javax.swing.JFrame {
    private CardLayout cardLayout;
    private Form2 form2;
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
                        showForm(new Form_1());
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
                        showForm(new Form4());
                        break;
                    case 4:
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
    }
    
    public void idtext() {
        String userId = MainID.getText(); 

        SwingUtilities.invokeLater(() -> {
            if (form2 != null) {
                form2.ex.setText(userId);
                form2.ad.setText(userId); 
            }
        });
        SwingUtilities.invokeLater(() -> {
            if (form3 != null) {
                form3.cat.setText(userId); 
            }
        });
        SwingUtilities.invokeLater(() -> {
        if (add == null) {
        add = new Add(userId);
       
       } else {
//        add.se.setText(userId);
             add.updateUserId(userId); 
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

        javax.swing.GroupLayout roundPanel1Layout = new javax.swing.GroupLayout(roundPanel1);
        roundPanel1.setLayout(roundPanel1Layout);
        roundPanel1Layout.setHorizontalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(header2, javax.swing.GroupLayout.DEFAULT_SIZE, 1371, Short.MAX_VALUE)
            .addGroup(roundPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(menu1, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(roundPanel1Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(body, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(10, 10, 10))
                    .addGroup(roundPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(MainID)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        roundPanel1Layout.setVerticalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel1Layout.createSequentialGroup()
                .addComponent(header2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(roundPanel1Layout.createSequentialGroup()
                        .addComponent(MainID)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(body, javax.swing.GroupLayout.PREFERRED_SIZE, 639, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(menu1, javax.swing.GroupLayout.DEFAULT_SIZE, 666, Short.MAX_VALUE))
                .addGap(10, 10, 10))
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
