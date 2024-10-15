
package com.raven.form;

import Sygma.Controller.userController;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import Sygma.Database.Database;
import com.formdev.flatlaf.FlatLightLaf;
import com.sun.jdi.connect.spi.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;
import javax.swing.BorderFactory;
import javax.swing.JPopupMenu;
import javax.swing.Timer;
import com.raven.swing.EventClick;
import com.raven.swing.DataSearch;
import com.raven.swing.PanelSearch;
import com.raven.swing.Search_Item;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.SwingUtilities;
import com.raven.main.Main;
import Sygma.Model.UserSession;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import raven.glasspanepopup.GlassPanePopup;
import javax.swing.SwingConstants;



public class Form2 extends javax.swing.JPanel {
    Connection MyCon;
    PreparedStatement ps;
    ResultSet rs;
    private DefaultTableCellRenderer centerRenderer;;
    private Timer timer;
    private userController controller;
    private double totalBalance = 0.0;
    private JPopupMenu menu;
    
    private PanelSearch search;
    private String userId = "yourUserId";
    public Add add;
    private GlassPanePopup glassPanePopup;
     private adding ding;
     private ArrayList<String> ids = new ArrayList<>();

  
    
    public Form2() {
        initComponents();
        try {
            Database.getInstance().ConnectToDatabase();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        setOpaque(false);
          ad.setVisible(false);

       ad.setText(userId);

        centerRenderer = new DefaultTableCellRenderer();
//        tableTextCenter();
         populateTable();
          loadBalance();
          saveBalance();
//          
//           timer = new Timer(5000, (e) -> {
//            populateTable();
//        });
//        timer.start();
 
    
        menu = new JPopupMenu();
        search = new PanelSearch();
        menu.setBorder(BorderFactory.createLineBorder(new Color(164, 164, 164)));
        menu.add(search);
        menu.setFocusable(false);
        search.addEventClick(new EventClick() {
            @Override
            public void itemClick(DataSearch data) {
                menu.setVisible(false);
                addStory(data.getText());
                System.out.println("Click Item : " + data.getText());
            }

            @Override
            public void itemRemove(Component com, DataSearch data) {
                search.remove(com);
                removeHistory(data.getText());
                menu.setPopupSize(menu.getWidth(), (search.getItemSize() * 35) + 2);
                if (search.getItemSize() == 0) {
                    menu.setVisible(false);
                }
                System.out.println("Remove Item : " + data.getText());
            }
        });
             
    }
    
  public void updateform(){
      saveBalance();
      loadBalance();
      populateTable();
  }
    private void tableTextCenter() {
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        for (int i = 0; i < jTable1.getColumnCount(); i++) {
            jTable1.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }
    }
  
      private void saveBalance() {
    try {
        String sql = "UPDATE expenses SET balance = ? WHERE userId = ?";
        ps = Database.getInstance().getConnection().prepareStatement(sql);
        ps.setDouble(1, totalBalance);
        ps.setString(2, ad.getText());

ps.execute();
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Error saving balance: " + e.getMessage());
    }
}

private void loadBalance() {
    try {
        String sql = "SELECT balance FROM expenses WHERE userId = ?";
        ps = Database.getInstance().getConnection().prepareStatement(sql);
        ps.setString(1, ad.getText());
        rs = ps.executeQuery();
        if (rs.next()) {
            totalBalance = rs.getDouble("balance");
            balance.setText("Balance: " + totalBalance);
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Error loading balance: " + e.getMessage());
    }
}
     public void username() {
    try {
        String sql = "SELECT userName FROM userdata WHERE userId = ?";
        ps = Database.getInstance().getConnection().prepareStatement(sql);
        ps.setString(1, ad.getText());
         ResultSet rsUsername = ps.executeQuery();

        
        if (rsUsername.next()) {
            String username = rsUsername.getString("userName");
            name.setText(username);
        } else {
            name.setText("User  not found");
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
}
   


  public void populateTable() {
    DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
    model.setRowCount(0); 
    totalBalance = 0.0;  
    ids.clear();
    try {
        String sql = "SELECT id, category, amount, date, type FROM expenses WHERE userId = ?";
        ps = Database.getInstance().getConnection().prepareStatement(sql);
        ps.setString(1, ad.getText());
        rs = ps.executeQuery();
        while (rs.next()) {
            String id = rs.getString("id");
            String category = rs.getString("category");
            double amount = rs.getDouble("amount");
            Date date = rs.getDate("date");
            String type = rs.getString("type");
            ids.add(id);
            if (type.equalsIgnoreCase("Badget")) {
                totalBalance += amount;
            } else if (type.equalsIgnoreCase("expense")) {
                totalBalance -= amount;
            }
            model.addRow(new Object[]{category, amount, date, type});
        }
        balance.setText("Balance: " + totalBalance);
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Error loading data: " + e.getMessage());
    }
    saveBalance();
}
    
    
 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jButton10 = new javax.swing.JButton();
        ad = new javax.swing.JLabel();
        panelRound1 = new Sygma.Component.PanelRound();
        jLabel7 = new javax.swing.JLabel();
        balance = new javax.swing.JLabel();
        jButton13 = new javax.swing.JButton();
        name = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Category", "Amount", "Date", "Type"
            }
        ));
        jTable1.setSelectionForeground(new java.awt.Color(117, 118, 116));
        jScrollPane1.setViewportView(jTable1);

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/icons8-add-properties-100.png"))); // NOI18N

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(102, 102, 102));
        jLabel6.setText("Add Expense");

        jButton10.setBackground(new java.awt.Color(253, 253, 253));
        jButton10.setFont(new java.awt.Font("Segoe UI", 1, 32)); // NOI18N
        jButton10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/icons8-delete-30.png"))); // NOI18N
        jButton10.setBorder(null);
        jButton10.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton10.setIconTextGap(5);
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        ad.setText("lol");

        panelRound1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel7.setForeground(new java.awt.Color(102, 102, 102));
        jLabel7.setText("Avaible Balance");

        balance.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        balance.setText("jLabel8");

        javax.swing.GroupLayout panelRound1Layout = new javax.swing.GroupLayout(panelRound1);
        panelRound1.setLayout(panelRound1Layout);
        panelRound1Layout.setHorizontalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(balance, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        panelRound1Layout.setVerticalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel7)
                .addGap(26, 26, 26)
                .addComponent(balance)
                .addContainerGap(34, Short.MAX_VALUE))
        );

        jButton13.setBackground(new java.awt.Color(253, 253, 253));
        jButton13.setFont(new java.awt.Font("Segoe UI", 1, 32)); // NOI18N
        jButton13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/icons8-add-40.png"))); // NOI18N
        jButton13.setBorder(null);
        jButton13.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton13.setIconTextGap(5);
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });

        name.setText("jLabel12");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 920, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jButton10))
                            .addComponent(jButton13)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addComponent(panelRound1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(135, 135, 135)
                        .addComponent(name)
                        .addGap(73, 73, 73)
                        .addComponent(ad, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(46, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(panelRound1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addGap(10, 10, 10)
                                        .addComponent(jLabel6))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(112, 112, 112)
                                .addComponent(ad, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(40, 40, 40))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(name)
                        .addGap(97, 97, 97)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton10))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(23, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        int selectedRow = jTable1.getSelectedRow();
    String id = ids.get(selectedRow);

    try {
        String sql = "DELETE FROM expenses WHERE id = ?";
        ps = Database.getInstance().getConnection().prepareStatement(sql);
        ps.setString(1, id);
        int rowsAffected = ps.executeUpdate();

        if (rowsAffected > 0) {
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            model.removeRow(selectedRow);
            jTable1.setModel(model);
            ids.remove(selectedRow);
            populateTable();
            JOptionPane.showMessageDialog(this, "Success");
        } else {
            JOptionPane.showMessageDialog(this, "Failed to delete the row from the database", "Error", JOptionPane.ERROR_MESSAGE);
        }
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(this, "Error closing connection: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed

             if (ding == null) {
        ding = new adding(); 
    }
    ding.setVisible(true); 
    }//GEN-LAST:event_jButton13ActionPerformed

       private List<DataSearch> search(String search) {
    List<DataSearch> list = new ArrayList<>();
    try {
       String sql = "SELECT DISTINCT category FROM expenses WHERE userId = ? AND category LIKE ? ORDER BY category LIMIT 7";
        ps = Database.getInstance().getConnection().prepareStatement(sql); 
        ps.setString(1, ad.getText());
        ps.setString(2, "%" + search + "%");
        
        ResultSet r = ps.executeQuery(); 
        while (r.next()) {
            String text = r.getString(1);
            boolean story = false;
            list.add(new DataSearch(text, story));
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
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JLabel ad;
    private javax.swing.JLabel balance;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton13;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTable jTable1;
    private javax.swing.JLabel name;
    private Sygma.Component.PanelRound panelRound1;
    // End of variables declaration//GEN-END:variables
}
