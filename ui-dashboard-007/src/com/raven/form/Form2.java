
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
import com.raven.swing.DataSearch;
import com.raven.swing.EventClick;
import com.raven.swing.PanelSearch;
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


public class Form2 extends javax.swing.JPanel {
    private String userId = "yourUserId";
    private DefaultTableCellRenderer centerRenderer;;
    private Timer timer;
    private userController controller;
    private double totalBalance = 0.0;
    private JPopupMenu menu;
    private PanelSearch search;
    Connection MyCon;
    PreparedStatement ps;
    ResultSet rs;
    
    
    public Form2() {
        initComponents();
        setOpaque(false);
    
        ex.setVisible(false);
        panelRound2.setVisible(false);
        centerRenderer = new DefaultTableCellRenderer();
        tableTextCenter();
         populateTable();
//         displayCategory();
//          populateCategory();
         
       
        timer = new Timer(3000, (e) -> {
            populateTable();
            
        });
        timer.start();
        
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
   
      private void tableTextCenter() {
    for (int i = 0; i < jTable1.getColumnCount(); i++) {
        jTable1.getColumnModel().getColumn(i).setCellRenderer(new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                Component rendererComponent = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                ((JLabel) rendererComponent).setHorizontalAlignment(SwingConstants.CENTER); 
                if (isSelected) {
                    rendererComponent.setForeground(Color.WHITE); 
                } else {
                    rendererComponent.setForeground(table.getForeground());
                }
                return rendererComponent;
            }
        });
    }
    }
      
//    private List<String> displayCategory() {
//    List<String> categories = new ArrayList<>();
//    try {
//        ResultSet rs = Database.getInstance().getConnection().createStatement().executeQuery("SELECT DISTINCT category FROM expenses");
//        while (rs.next()) {
//            categories.add(rs.getString("category"));
//        }
//    } catch (SQLException ex) {
//        JOptionPane.showMessageDialog(this, "Error loading categories: " + ex.getMessage());
//    }
//    return categories;
//}private void populateCategory() {
//        List<String> categories = displayCategory();
//        DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
//        for (String category : categories) {
//            model.addElement(category);
//        }
//        category.setModel(model);
//    }
    
   
    private void populateTable() {
    DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
    model.setRowCount(0); 

    try {
        String sql = "SELECT category, amount, date, type FROM expenses WHERE addid = ?";
        ps = Database.getInstance().getConnection().prepareStatement(sql);
        ps.setString(1, ex.getText());  
        rs = ps.executeQuery();

        while (rs.next()) {
            String category = rs.getString("category");
            double amount = rs.getDouble("amount");
            Date date = rs.getDate("date");
            String type = rs.getString("type");

            model.addRow(new Object[]{category, amount, date, type});
        }

    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Error loading data: " + e.getMessage());
    }
}
    
       
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        ex = new javax.swing.JLabel();
        panelRound1 = new Sygma.Component.PanelRound();
        jLabel7 = new javax.swing.JLabel();
        balance = new javax.swing.JLabel();
        panelRound2 = new Sygma.Component.PanelRound();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        amount = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        date = new com.toedter.calendar.JDateChooser();
        jLabel4 = new javax.swing.JLabel();
        type = new javax.swing.JComboBox<>();
        jButton11 = new javax.swing.JButton();
        txtSearch = new com.raven.swing.search();

        setBackground(new java.awt.Color(255, 255, 255));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Category", "Amount", "Date", "Type"
            }
        ));
        jTable1.setSelectionBackground(new java.awt.Color(255, 255, 255));
        jTable1.setSelectionForeground(new java.awt.Color(255, 255, 255));
        jTable1.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                jTable1ComponentShown(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/icons8-add-properties-100.png"))); // NOI18N

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(102, 102, 102));
        jLabel6.setText("Add Amount");

        jButton9.setBackground(new java.awt.Color(253, 253, 253));
        jButton9.setFont(new java.awt.Font("Segoe UI", 1, 32)); // NOI18N
        jButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/icons8-add-40.png"))); // NOI18N
        jButton9.setBorder(null);
        jButton9.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton9.setIconTextGap(5);
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

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

        ex.setText("lol");

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

        panelRound2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel3.setForeground(new java.awt.Color(102, 102, 102));
        jLabel3.setText("Category");

        jLabel2.setForeground(new java.awt.Color(102, 102, 102));
        jLabel2.setText("Amount");

        amount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                amountActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 102));
        jLabel1.setText("Date");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(102, 102, 102));
        jLabel4.setText("Type");

        type.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Expense", "Income" }));
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

        txtSearch.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
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

        javax.swing.GroupLayout panelRound2Layout = new javax.swing.GroupLayout(panelRound2);
        panelRound2.setLayout(panelRound2Layout);
        panelRound2Layout.setHorizontalGroup(
            panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound2Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(amount, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(date, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(type, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(jButton11)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelRound2Layout.setVerticalGroup(
            panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound2Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(jLabel2)
                        .addComponent(amount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jButton11)
                        .addGroup(panelRound2Layout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addGap(4, 4, 4)))
                    .addGroup(panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(date, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(type, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))))
                .addContainerGap(40, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addComponent(panelRound1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(251, 251, 251)
                        .addComponent(ex, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(panelRound2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 960, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton9)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jButton10)))))
                .addContainerGap(32, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(112, 112, 112)
                        .addComponent(ex, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(panelRound1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(10, 10, 10)
                                .addComponent(jLabel6)))))
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 296, Short.MAX_VALUE)
                        .addGap(31, 31, 31)
                        .addComponent(panelRound2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(jButton9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton10)
                        .addContainerGap(363, Short.MAX_VALUE))))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
         jButton9.addMouseListener(new java.awt.event.MouseAdapter() {
        private long lastClickTime = 0; 
        private final int doubleClickInterval = 500; 
        @Override
        public void mouseClicked(java.awt.event.MouseEvent e) {
            long currentClickTime = System.currentTimeMillis();
            long timeDifference = currentClickTime - lastClickTime;
            if (timeDifference < doubleClickInterval && e.getClickCount() == 2) {
                panelRound2.setVisible(false);
            } else if (e.getClickCount() == 1) {
                panelRound2.setVisible(!panelRound2.isVisible());
            }
            lastClickTime = currentClickTime; 
        }
    });
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
    try {
        String selectedType = type.getSelectedItem().toString();
        double amountValue = Double.parseDouble(amount.getText());

        if (selectedType.equals("Income")) {
            totalBalance += amountValue; 
        } else if (selectedType.equals("Expense")) {
            totalBalance -= amountValue;  
        }
        balance.setText("Balance: " + totalBalance);
        String sql = "INSERT INTO expenses (addid, category, date, amount, Type, timestamp) VALUES (?, ?, ?, ?, ?, ?)";
        ps = Database.getInstance().getConnection().prepareStatement(sql);
        ps.setString(1, ex.getText());
        ps.setString(2, txtSearch.getText());
        Date selectedDate = date.getDate();
        if (selectedDate != null) {
            ps.setDate(3, new java.sql.Date(selectedDate.getTime()));
        } else {
            ps.setNull(3, java.sql.Types.DATE);
        }
        ps.setDouble(4, amountValue);  
        ps.setString(5, selectedType);  
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        ps.setTimestamp(6, timestamp);
        ps.execute();
        populateTable();  
    } catch (SQLException e) { 
        JOptionPane.showMessageDialog(this, e, "Error", JOptionPane.ERROR_MESSAGE);
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "Invalid amount entered. Please enter a valid number.", "Error", JOptionPane.ERROR_MESSAGE);
    }

    }//GEN-LAST:event_jButton11ActionPerformed

    private void amountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_amountActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_amountActionPerformed

    private void typeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_typeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_typeActionPerformed

    private void jTable1ComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jTable1ComponentShown
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable1ComponentShown

    private void txtSearchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtSearchMouseClicked
        if (search.getItemSize() > 0) {
            menu.show(txtSearch, 0, txtSearch.getHeight());
            search.clearSelected();
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

       private List<DataSearch> search(String search) {
    List<DataSearch> list = new ArrayList<>();
    try {
       String sql = "SELECT DISTINCT category FROM expenses WHERE addid = ? AND category LIKE ? ORDER BY category LIMIT 7";
        ps = Database.getInstance().getConnection().prepareStatement(sql); 
        ps.setString(1, ex.getText());  
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
    private javax.swing.JLabel balance;
    private com.toedter.calendar.JDateChooser date;
    public javax.swing.JLabel ex;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private Sygma.Component.PanelRound panelRound1;
    private Sygma.Component.PanelRound panelRound2;
    private com.raven.swing.search txtSearch;
    private javax.swing.JComboBox<String> type;
    // End of variables declaration//GEN-END:variables
}
