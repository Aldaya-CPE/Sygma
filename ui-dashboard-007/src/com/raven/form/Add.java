
package com.raven.form;

import Sygma.Database.Database;
import com.raven.swing.DataSearch;
import com.raven.swing.EventClick;
import com.raven.swing.PanelSearch;
import com.raven.swing.search;
import com.sun.jdi.connect.spi.Connection;
import java.awt.Color;
import java.awt.Component;
import static java.awt.SystemColor.menu;
import java.awt.event.KeyEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JLayeredPane;
import javax.swing.JComboBox;

public class Add extends javax.swing.JPanel {
      Connection MyCon;
    PreparedStatement ps;
    ResultSet rs;
//     private String userId = "yourUserId";
    private String userId;
    private Form2 form2;
     private JPopupMenu menu;
    private PanelSearch search;
      

    public Add(String userId) {
        initComponents();
 try {
            Database.getInstance().ConnectToDatabase();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
//        date.toFront();
//        type.toFront();
        this.userId = userId;
        se.setText(userId);
        this.form2= form2;
       
        menu = new JPopupMenu();
        search = new PanelSearch();
        menu.setBorder(BorderFactory.createLineBorder(new Color(164, 164, 164)));
        menu.add(search);
        menu.setFocusable(false);
        search.addEventClick(new EventClick() {
            @Override
            public void itemClick(DataSearch data) {
                menu.setVisible(false);
                txtSearch.setText(data.getText());
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
    public void updateUserId(String userId) {
      this.userId = userId;
       se.setText(userId);
    
}
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLayeredPane1 = new javax.swing.JLayeredPane();
        jLabel3 = new javax.swing.JLabel();
        txtSearch = new com.raven.swing.search();
        jLabel2 = new javax.swing.JLabel();
        amount = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        date = new com.toedter.calendar.JDateChooser();
        jLabel4 = new javax.swing.JLabel();
        type = new javax.swing.JComboBox<>();
        jButton11 = new javax.swing.JButton();
        se = new javax.swing.JLabel();
        datePicker1 = new com.github.lgooddatepicker.components.DatePicker();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel3.setForeground(new java.awt.Color(102, 102, 102));
        jLabel3.setText("Category");

        txtSearch.setBackground(new java.awt.Color(239, 239, 239));
        txtSearch.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
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

        jLabel2.setForeground(new java.awt.Color(102, 102, 102));
        jLabel2.setText("Amount");

        amount.setBackground(new java.awt.Color(239, 239, 239));
        amount.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 102));
        jLabel1.setText("Date");

        date.setBackground(new java.awt.Color(239, 239, 239));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(102, 102, 102));
        jLabel4.setText("Type");

        type.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Expense", "Badget" }));
        type.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                typeActionPerformed(evt);
            }
        });

        jButton11.setBackground(new java.awt.Color(253, 253, 253));
        jButton11.setFont(new java.awt.Font("Segoe UI", 1, 32)); // NOI18N
        jButton11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/add1 (2).png"))); // NOI18N
        jButton11.setBorder(null);
        jButton11.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton11.setIconTextGap(5);
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        jLayeredPane1.setLayer(jLabel3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(txtSearch, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(amount, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(date, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jLabel4, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(type, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jButton11, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(se, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(datePicker1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addContainerGap(63, Short.MAX_VALUE)
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane1Layout.createSequentialGroup()
                        .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2)
                            .addComponent(amount)
                            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(date, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(type, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel3)
                            .addComponent(txtSearch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                                .addComponent(datePicker1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton11)))
                        .addGap(57, 57, 57))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane1Layout.createSequentialGroup()
                        .addComponent(se)
                        .addGap(34, 34, 34))))
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(se)
                .addGap(93, 93, 93)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(amount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jLayeredPane1Layout.createSequentialGroup()
                        .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(date, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(type, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jLayeredPane1Layout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addComponent(datePicker1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jLayeredPane1Layout.createSequentialGroup()
                        .addGap(75, 75, 75)
                        .addComponent(jButton11)))
                .addContainerGap(93, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtSearchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtSearchMouseClicked
//        if (search.getItemSize() > 0) {
//            menu.show(txtSearch, 0, txtSearch.getHeight());
//            search.clearSelected();
//        }
      if (search.getItemSize() > 0) {
        menu.show(txtSearch, 0, txtSearch.getHeight());
        search.clearSelected();
        txtSearch.getParent().setComponentZOrder(txtSearch, 0); // Bring the search panel to the front
        txtSearch.repaint();
    }
    }//GEN-LAST:event_txtSearchMouseClicked

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
                //  * 2 top and bot border
                menu.show(txtSearch, 0, txtSearch.getHeight());
                menu.setPopupSize(menu.getWidth(), (search.getItemSize() * 35) + 2);
            } else {
                menu.setVisible(false);
            }
        }
    }//GEN-LAST:event_txtSearchKeyReleased

    private void typeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_typeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_typeActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
//        try {
//            String selectedType = type.getSelectedItem().toString();
//            double amountValue = Double.parseDouble(amount.getText());
//
//            if (selectedType.equals("Badget")) {
//                totalBalance += amountValue;
//            } else if (selectedType.equals("Expense")) {
//                totalBalance -= amountValue;
//            }
//            balance.setText("Balance: " + totalBalance);
//            String sql = "INSERT INTO expenses (userId, category, date, amount, Type, timestamp) VALUES (?, ?, ?, ?, ?, ?)";
//            ps = Database.getInstance().getConnection().prepareStatement(sql);
//            ps.setString(1, ex.getText());
//            ps.setString(2, txtSearch.getText());
//            Date selectedDate = date.getDate();
//            if (selectedDate != null) {
//                ps.setDate(3, new java.sql.Date(selectedDate.getTime()));
//            } else {
//                ps.setNull(3, java.sql.Types.DATE);
//            }
//            ps.setDouble(4, amountValue);
//            ps.setString(5, selectedType);
//            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
//            ps.setTimestamp(6, timestamp);
//            ps.execute();
//            populateTable();
//        } catch (SQLException e) {
//            JOptionPane.showMessageDialog(this, e, "Error", JOptionPane.ERROR_MESSAGE);
//        } catch (NumberFormatException e) {
//            JOptionPane.showMessageDialog(this, "Invalid amount entered. Please enter a valid number.", "Error", JOptionPane.ERROR_MESSAGE);
//        }
    }//GEN-LAST:event_jButton11ActionPerformed
 private List<DataSearch> search(String search) {
    List<DataSearch> list = new ArrayList<>();
    try {
       String sql = "SELECT DISTINCT category FROM expenses WHERE userId = ? AND category LIKE ? ORDER BY category LIMIT 7";
        ps = Database.getInstance().getConnection().prepareStatement(sql); 
        ps.setString(1, se.getText());
//        ps.setString(1, userId);
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
    private javax.swing.JTextField amount;
    private com.toedter.calendar.JDateChooser date;
    private com.github.lgooddatepicker.components.DatePicker datePicker1;
    private javax.swing.JButton jButton11;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLayeredPane jLayeredPane1;
    public javax.swing.JLabel se;
    private com.raven.swing.search txtSearch;
    private javax.swing.JComboBox<String> type;
    // End of variables declaration//GEN-END:variables
}
