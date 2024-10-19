
package com.raven.form;

import Sygma.Database.Database;
import Sygma.Model.ModelUser;
import Sygma.Model.UserSession;
import com.sun.jdi.connect.spi.Connection;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.Vector;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.SwingWorker;
import javax.swing.Timer;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;


public class Form3 extends javax.swing.JPanel {
    Connection MyCon;
    PreparedStatement ps;
    ResultSet rs;
    private DefaultTableCellRenderer centerRenderer;



    public Form3() {
        initComponents();
         try {
            Database.getInstance().ConnectToDatabase();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        cat.setText(UserSession.getCurrentUserId());
          cat.setVisible(false);
        centerRenderer = new DefaultTableCellRenderer();
         tableTextCenter();

      setBackground(new Color(0, 0, 0, 0));
          populateTable();

    
    }
    

     private void tableTextCenter() {
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        for (int i = 0; i < jTable2.getColumnCount(); i++) {
            jTable2.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }
    }
   
    public void populateTable() {
    DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
    model.setRowCount(0); 
   
    try {
        String sql = "SELECT * FROM expenses WHERE userId = ?";
        ps = Database.getInstance().getConnection().prepareStatement(sql);
        ps.setString(1, cat.getText());
        rs = ps.executeQuery();
        while (rs.next()) {
            String id = rs.getString("id");
            String category = rs.getString("category");
           
            
            model.addRow(new Object[]{id, category});
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Error loading data: " + e.getMessage());
    }

           }
        
  

    
    
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton10 = new javax.swing.JButton();
        cat = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/icons8-category-100.png"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 102, 102));
        jLabel2.setText("Category");

        jButton10.setBackground(new java.awt.Color(253, 253, 253));
        jButton10.setFont(new java.awt.Font("Segoe UI", 1, 32)); // NOI18N
        jButton10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/icons8-delete-30.png"))); // NOI18N
        jButton10.setToolTipText("Delete");
        jButton10.setBorder(null);
        jButton10.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton10.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton10.setIconTextGap(5);
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        cat.setText("jLabel3");

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "id", "category"
            }
        ));
        jScrollPane2.setViewportView(jTable2);
        if (jTable2.getColumnModel().getColumnCount() > 0) {
            jTable2.getColumnModel().getColumn(1).setResizable(false);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 943, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton10))
                    .addComponent(jLabel2)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(159, 159, 159)
                        .addComponent(cat)))
                .addContainerGap(39, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jLabel1)
                        .addGap(10, 10, 10))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(cat)
                        .addGap(25, 25, 25)))
                .addComponent(jLabel2)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addComponent(jButton10)))
                .addContainerGap(38, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
    int selectedRow = jTable2.getSelectedRow();
    String id = jTable2.getValueAt(selectedRow, 0).toString(); 
    try {
        String sql = "DELETE FROM expenses WHERE id = ? AND userId = ?"; 
        ps = Database.getInstance().getConnection().prepareStatement(sql);
        ps.setString(1, id); 
        ps.setString(2, cat.getText()); 
        int rowsAffected = ps.executeUpdate();
        if (rowsAffected > 0) {
            DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
            model.removeRow(selectedRow); 
        } else {
            JOptionPane.showMessageDialog(this, "Failed to delete the row from the database", "Error", JOptionPane.ERROR_MESSAGE);
        }
   
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(this, "Error closing connection: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_jButton10ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JLabel cat;
    private javax.swing.JButton jButton10;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane2;
    public javax.swing.JTable jTable2;
    // End of variables declaration//GEN-END:variables
}
