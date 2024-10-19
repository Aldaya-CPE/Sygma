
package com.raven.form;

import Sygma.Database.Database;
import com.mysql.cj.jdbc.result.ResultSetMetaData;
import search.DataSearch1;
import search.EventClick1;
import search.PanelSearch1;
import com.sun.jdi.connect.spi.Connection;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.KeyEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.lang.model.util.Types;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;


public class Form4 extends javax.swing.JPanel {
    Connection MyCon;
    PreparedStatement ps;
    ResultSet rs;
    private JPopupMenu menu;
    private PanelSearch1 search;
    private String userId = "yourUserId";
    private DefaultTableCellRenderer centerRenderer;;

    
    public Form4() {
        initComponents();
        try {
            Database.getInstance().ConnectToDatabase();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        ed.setText(userId);
        ed.setVisible(false); 
        setBackground(new Color(0, 0, 0, 0));

         centerRenderer = new DefaultTableCellRenderer();
         tableTextCenter();
        
        menu = new JPopupMenu();
        search = new PanelSearch1();
        menu.setBorder(BorderFactory.createLineBorder(new Color(164, 164, 164)));
        menu.add(search);
        menu.setFocusable(false);
        search.addEventClick1(new EventClick1() {
            @Override
            public void itemClick(DataSearch1 data) {
                menu.setVisible(false);
                txtSearch.setText(data.getText());
                addStory(data.getText());
                System.out.println("Click Item : " + data.getText());
            }

            @Override
            public void itemRemove(Component com, DataSearch1 data) {
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
    
         private void tableTextCenter() {
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        for (int i = 0; i < jTable1.getColumnCount(); i++) {
            jTable1.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }
    }
         
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        panelBar1 = new Sygma.Component.PanelBar();
        jButton1 = new javax.swing.JButton();
        txtSearch = new com.raven.swing.search();
        jLabel8 = new javax.swing.JLabel();
        from = new com.github.lgooddatepicker.components.DatePicker();
        to = new com.github.lgooddatepicker.components.DatePicker();
        jLabel9 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        panelRound1 = new Sygma.Component.PanelRound();
        jLabel7 = new javax.swing.JLabel();
        balance = new javax.swing.JLabel();
        ed = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Date", "Amount"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        panelBar1.setBackground(new java.awt.Color(255, 255, 255));
        panelBar1.setPreferredSize(new java.awt.Dimension(960, 39));
        panelBar1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/search_1.png"))); // NOI18N
        jButton1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.setToolTipText("Search");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        panelBar1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(927, 6, -1, -1));

        txtSearch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtSearchMouseClicked(evt);
            }
        });
        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtSearchKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchKeyReleased(evt);
            }
        });
        panelBar1.add(txtSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(556, 6, 353, 24));

        jLabel8.setText("From:");
        jLabel8.setForeground(new java.awt.Color(102, 102, 102));
        panelBar1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 42, -1));
        panelBar1.add(from, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, 188, -1));
        panelBar1.add(to, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 10, 184, -1));

        jLabel9.setText("To:");
        jLabel9.setForeground(new java.awt.Color(102, 102, 102));
        panelBar1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 10, 30, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/icons8-calendar-100.png"))); // NOI18N

        jLabel2.setText("View Expense Date");
        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 102, 102));

        panelRound1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel7.setText("Avaible Balance");
        jLabel7.setForeground(new java.awt.Color(102, 102, 102));

        javax.swing.GroupLayout panelRound1Layout = new javax.swing.GroupLayout(panelRound1);
        panelRound1.setLayout(panelRound1Layout);
        panelRound1Layout.setHorizontalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(balance, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(54, Short.MAX_VALUE))
        );
        panelRound1Layout.setVerticalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(balance, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        ed.setText("jLabel3");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel2)))
                        .addGap(20, 20, 20)
                        .addComponent(panelRound1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(80, 80, 80)
                        .addComponent(ed))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 960, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(12, 12, 12)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(panelRound1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(ed)))
                .addGap(33, 33, 33)
                .addComponent(panelBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 393, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtSearchKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyPressed
         if (evt.getKeyCode() == KeyEvent.VK_UP) {
            search.keyUp();
        } else if (evt.getKeyCode() == KeyEvent.VK_DOWN) {
            search.keyDown();
        } else if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            String text = search.getSelectedText();
            txtSearch.setText(text);
            menu.setVisible(false);
        }
    }//GEN-LAST:event_txtSearchKeyPressed

    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyReleased
        if (evt.getKeyCode() != KeyEvent.VK_UP && evt.getKeyCode() != KeyEvent.VK_DOWN && evt.getKeyCode() != KeyEvent.VK_ENTER) {
            String text = txtSearch.getText().trim().toLowerCase();
            search.setData(search(text));
            if (search.getItemSize() > 0) {
                menu.show(txtSearch, 0, txtSearch.getHeight());
                menu.setPopupSize(menu.getWidth(), (search.getItemSize() * 35) + 2);
            } else {
                menu.setVisible(false);
            }
        }
    }//GEN-LAST:event_txtSearchKeyReleased

    private void txtSearchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtSearchMouseClicked
         if (search.getItemSize() > 0) {
            menu.show(txtSearch, 0, txtSearch.getHeight());
            search.clearSelected();
        }
    }//GEN-LAST:event_txtSearchMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
   java.sql.Date fromDate = java.sql.Date.valueOf(from.getDate());
    java.sql.Date toDate = java.sql.Date.valueOf(to.getDate());

    String sql = "SELECT Date, Amount FROM expenses WHERE userId = ? AND date BETWEEN ? AND ?";

    try {
        ps = Database.getInstance().getConnection().prepareStatement(sql);
        ps.setString(1, ed.getText());
        ps.setDate(2, fromDate);
        ps.setDate(3, toDate);

        ResultSet rs = ps.executeQuery();

        jTable1.setModel(buildTableModel(rs));
         tableTextCenter();
        System.out.println(jTable1.getRowCount()); 
        jTable1.repaint(); 
        
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        double totalAmount = 0;
        for (int i = 0; i < model.getRowCount(); i++) {
            totalAmount += (double) (int) model.getValueAt(i, 1);
        }
        balance.setText(String.format("%.2f", totalAmount));

        rs.close();
        ps.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }
    }//GEN-LAST:event_jButton1ActionPerformed
     
    
    
    private DefaultTableModel buildTableModel(ResultSet rs) throws SQLException {
    ResultSetMetaData metaData = (ResultSetMetaData) rs.getMetaData(); 
    int columnCount = metaData.getColumnCount();
    String[] columnNames = new String[columnCount];

    for (int i = 1; i <= columnCount; i++) {
        columnNames[i - 1] = metaData.getColumnName(i);
    }
    DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);

    while (rs.next()) {
        Object[] row = new Object[columnCount];

        for (int i = 1; i <= columnCount; i++) {
            row[i - 1] = rs.getObject(i);
            System.out.println(rs.getObject(i)); 
        }

        tableModel.addRow(row);
    }

    return tableModel;
}
    
    private List<DataSearch1> search(String search) {
    List<DataSearch1> list = new ArrayList<>();
    try {
       String sql = "SELECT DISTINCT category FROM expenses WHERE userId = ? AND category LIKE ? ORDER BY category LIMIT 7";
        ps = Database.getInstance().getConnection().prepareStatement(sql); 
        ps.setString(1, ed.getText());
        ps.setString(2, "%" + search + "%");
        
        ResultSet r = ps.executeQuery(); 
        while (r.next()) {
            String text = r.getString(1);
            boolean story = false;
            list.add(new DataSearch1(text, story));
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
    private javax.swing.JLabel balance;
    public javax.swing.JLabel ed;
    private com.github.lgooddatepicker.components.DatePicker from;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private Sygma.Component.PanelBar panelBar1;
    private Sygma.Component.PanelRound panelRound1;
    private com.github.lgooddatepicker.components.DatePicker to;
    private com.raven.swing.search txtSearch;
    // End of variables declaration//GEN-END:variables
}
