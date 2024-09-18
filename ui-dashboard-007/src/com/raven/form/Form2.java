
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
import javax.swing.SwingUtilities;
import com.raven.main.Main;
import Sygma.Model.UserSession;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import raven.glasspanepopup.GlassPanePopup;


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
       private Add add;
       private GlassPanePopup glassPanePopup;



  
    
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
//        ex.setVisible(false); 
    adding.setVisible(false);
       ad.setText(userId);
        ex.setText(userId);
         add = new Add(userId);
       this.add(add);
        panelRound2.setVisible(false);
        centerRenderer = new DefaultTableCellRenderer();
//        tableTextCenter();
         populateTable();
          loadBalance();
          saveBalance();
          
          
         
       
        timer = new Timer(1000, (e) -> {
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
  
   
//      private void tableTextCenter() {
//    for (int i = 0; i < jTable1.getColumnCount(); i++) {
//        jTable1.getColumnModel().getColumn(i).setCellRenderer(new DefaultTableCellRenderer() {
//            @Override
//            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
//                Component rendererComponent = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
//                ((JLabel) rendererComponent).setHorizontalAlignment(SwingConstants.CENTER); 
//                if (isSelected) {
//                    rendererComponent.setForeground(Color.WHITE); 
//                } else {
//                    rendererComponent.setForeground(table.getForeground());
//                }
//                return rendererComponent;
//            }
//        });
//    }
//    }
      
      private void saveBalance() {
    try {
        String sql = "UPDATE expenses SET balance = ? WHERE userId = ?";
        ps = Database.getInstance().getConnection().prepareStatement(sql);
        ps.setDouble(1, totalBalance);
        ps.setString(2, ex.getText());

ps.execute();
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Error saving balance: " + e.getMessage());
    }
}

private void loadBalance() {
    try {
        String sql = "SELECT balance FROM expenses WHERE userId = ?";
        ps = Database.getInstance().getConnection().prepareStatement(sql);
        ps.setString(1, ex.getText());
        rs = ps.executeQuery();
        if (rs.next()) {
            totalBalance = rs.getDouble("balance");
            balance.setText("Balance: " + totalBalance);
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Error loading balance: " + e.getMessage());
    }
}
    
   


    private void populateTable() {
    DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
    model.setRowCount(0); 
    totalBalance = 0.0;  
    try {
        String sql = "SELECT category, amount, date, type FROM expenses WHERE userId = ?";
        ps = Database.getInstance().getConnection().prepareStatement(sql);
        ps.setString(1, ad.getText());
        rs = ps.executeQuery();
        while (rs.next()) {
            String category = rs.getString("category");
            double amount = rs.getDouble("amount");
            Date date = rs.getDate("date");
            String type = rs.getString("type");
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

        pop = new javax.swing.JPanel();
        txtSearch1 = new com.raven.swing.search();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        amount1 = new javax.swing.JTextField();
        date1 = new com.toedter.calendar.JDateChooser();
        jLabel10 = new javax.swing.JLabel();
        type1 = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        datePicker1 = new com.github.lgooddatepicker.components.DatePicker();
        jButton12 = new javax.swing.JButton();
        ex = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        ad = new javax.swing.JLabel();
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
        adding = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        pop.setBackground(new java.awt.Color(255, 255, 255));
        pop.setInheritsPopupMenu(true);

        txtSearch1.setBackground(new java.awt.Color(239, 239, 239));
        txtSearch1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        txtSearch1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtSearch1MouseClicked(evt);
            }
        });
        txtSearch1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtSearch1KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearch1KeyReleased(evt);
            }
        });

        jLabel8.setText("Category");
        jLabel8.setForeground(new java.awt.Color(102, 102, 102));

        jLabel9.setText("Amount");
        jLabel9.setForeground(new java.awt.Color(102, 102, 102));

        amount1.setBackground(new java.awt.Color(239, 239, 239));
        amount1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        date1.setBackground(new java.awt.Color(239, 239, 239));

        jLabel10.setText("Date");
        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(102, 102, 102));

        type1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Expense", "Badget" }));
        type1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                type1ActionPerformed(evt);
            }
        });

        jLabel11.setText("Type");
        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(102, 102, 102));

        jButton12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/add1 (2).png"))); // NOI18N
        jButton12.setBackground(new java.awt.Color(253, 253, 253));
        jButton12.setBorder(null);
        jButton12.setFont(new java.awt.Font("Segoe UI", 1, 32)); // NOI18N
        jButton12.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton12.setIconTextGap(5);
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        ex.setText("jLabel12");

        javax.swing.GroupLayout popLayout = new javax.swing.GroupLayout(pop);
        pop.setLayout(popLayout);
        popLayout.setHorizontalGroup(
            popLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(popLayout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addGroup(popLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel9)
                    .addComponent(amount1)
                    .addGroup(popLayout.createSequentialGroup()
                        .addGroup(popLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(date1, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(popLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(type1, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel8)
                    .addComponent(txtSearch1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(popLayout.createSequentialGroup()
                        .addComponent(datePicker1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton12)))
                .addContainerGap(63, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, popLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(ex)
                .addGap(79, 79, 79))
        );
        popLayout.setVerticalGroup(
            popLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, popLayout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(ex)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtSearch1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(amount1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(popLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(popLayout.createSequentialGroup()
                        .addGroup(popLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(jLabel11))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(date1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(type1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(popLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(popLayout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addComponent(datePicker1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(popLayout.createSequentialGroup()
                        .addGap(75, 75, 75)
                        .addComponent(jButton12)))
                .addGap(106, 106, 106))
        );

        setBackground(new java.awt.Color(255, 255, 255));

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
        jTable1.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                jTable1ComponentShown(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/icons8-add-properties-100.png"))); // NOI18N

        jLabel6.setText("Add Amount");
        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(102, 102, 102));

        jButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/icons8-add-40.png"))); // NOI18N
        jButton9.setBackground(new java.awt.Color(253, 253, 253));
        jButton9.setBorder(null);
        jButton9.setFont(new java.awt.Font("Segoe UI", 1, 32)); // NOI18N
        jButton9.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton9.setIconTextGap(5);
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jButton10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/icons8-delete-30.png"))); // NOI18N
        jButton10.setBackground(new java.awt.Color(253, 253, 253));
        jButton10.setBorder(null);
        jButton10.setFont(new java.awt.Font("Segoe UI", 1, 32)); // NOI18N
        jButton10.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton10.setIconTextGap(5);
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        ad.setText("lol");

        panelRound1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel7.setText("Avaible Balance");
        jLabel7.setForeground(new java.awt.Color(102, 102, 102));

        balance.setText("jLabel8");
        balance.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

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

        jLabel3.setText("Category");
        jLabel3.setForeground(new java.awt.Color(102, 102, 102));

        jLabel2.setText("Amount");
        jLabel2.setForeground(new java.awt.Color(102, 102, 102));

        amount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                amountActionPerformed(evt);
            }
        });

        jLabel1.setText("Date");
        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 102));

        jLabel4.setText("Type");
        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(102, 102, 102));

        type.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Expense", "Badget" }));
        type.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                typeActionPerformed(evt);
            }
        });

        jButton11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/add1 (2).png"))); // NOI18N
        jButton11.setBackground(new java.awt.Color(253, 253, 253));
        jButton11.setBorder(null);
        jButton11.setFont(new java.awt.Font("Segoe UI", 1, 32)); // NOI18N
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
                .addContainerGap(39, Short.MAX_VALUE))
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

        javax.swing.GroupLayout addingLayout = new javax.swing.GroupLayout(adding);
        adding.setLayout(addingLayout);
        addingLayout.setHorizontalGroup(
            addingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 228, Short.MAX_VALUE)
        );
        addingLayout.setVerticalGroup(
            addingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jButton1.setText("jButton1");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("jButton2");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("jButton3");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 792, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(adding, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(panelRound2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addComponent(panelRound1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(191, 191, 191)
                                .addComponent(jButton3)
                                .addGap(48, 48, 48)
                                .addComponent(jButton9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton1))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(251, 251, 251)
                                        .addComponent(ad, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(49, 49, 49)
                                        .addComponent(jButton10))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(88, 88, 88)
                                        .addComponent(jButton2)))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addGap(6, 6, 6))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(panelRound1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(10, 10, 10)
                                .addComponent(jLabel6)))
                        .addGap(37, 37, 37))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jButton1))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(103, 103, 103)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(ad, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton10))
                                .addGap(4, 4, 4)
                                .addComponent(jButton2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton9)
                                    .addComponent(jButton3))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 293, Short.MAX_VALUE)
                    .addComponent(adding, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(31, 31, 31)
                .addComponent(panelRound2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
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
        
//         add.setVisible(true);
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
    try {
        String selectedType = type.getSelectedItem().toString();
        double amountValue = Double.parseDouble(amount.getText());

        if (selectedType.equals("Badget")) {
            totalBalance += amountValue; 
        } else if (selectedType.equals("Expense")) {
            totalBalance -= amountValue;  
        }
        balance.setText("Balance: " + totalBalance);
        String sql = "INSERT INTO expenses (userId, category, date, amount, Type, timestamp) VALUES (?, ?, ?, ?, ?, ?)";
        ps = Database.getInstance().getConnection().prepareStatement(sql);
        ps.setString(1, ad.getText());
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

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
         if (adding.isVisible()) {
        // Hide the panel
        Timer timer = new Timer(10, new ActionListener() {
            int x = adding.getX();

            @Override
            public void actionPerformed(ActionEvent e) {
                x -= 10;
                adding.setLocation(x, adding.getY());
                if (x <= -adding.getWidth()) {
                    adding.setVisible(false);
                    ((Timer) e.getSource()).stop();
                }
            }
        });
        timer.start();
    } else {
        // Show the panel
        adding.setVisible(true);
        adding.setLocation(-adding.getWidth(), adding.getY());
        Timer timer = new Timer(10, new ActionListener() {
            int x = -adding.getWidth();

            @Override
            public void actionPerformed(ActionEvent e) {
                x += 10;
                adding.setLocation(x, adding.getY());
                if (x >= adding.getParent().getWidth() - adding.getWidth()) {
                    ((Timer) e.getSource()).stop();
                }
            }
        });
        timer.start();
    } 
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
      
        GlassPanePopup.showPopup(pop);
    
    }//GEN-LAST:event_jButton2ActionPerformed

    private void txtSearch1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtSearch1MouseClicked
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
    }//GEN-LAST:event_txtSearch1MouseClicked

    private void txtSearch1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearch1KeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_UP) {
            search.keyUp();
        } else if (evt.getKeyCode() == KeyEvent.VK_DOWN) {
            search.keyDown();
        } else if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            String text = search.getSelectedText();
            txtSearch.setText(text);
            menu.setVisible(false);
        }
    }//GEN-LAST:event_txtSearch1KeyPressed

    private void txtSearch1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearch1KeyReleased
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
    }//GEN-LAST:event_txtSearch1KeyReleased

    private void type1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_type1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_type1ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
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
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
           GlassPanePopup.showPopup(add);
    }//GEN-LAST:event_jButton3ActionPerformed

       private List<DataSearch> search(String search) {
    List<DataSearch> list = new ArrayList<>();
    try {
       String sql = "SELECT DISTINCT category FROM expenses WHERE userId = ? AND category LIKE ? ORDER BY category LIMIT 7";
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
    public javax.swing.JLabel ad;
    private javax.swing.JPanel adding;
    private javax.swing.JTextField amount;
    private javax.swing.JTextField amount1;
    private javax.swing.JLabel balance;
    private com.toedter.calendar.JDateChooser date;
    private com.toedter.calendar.JDateChooser date1;
    private com.github.lgooddatepicker.components.DatePicker datePicker1;
    public javax.swing.JLabel ex;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTable jTable1;
    private Sygma.Component.PanelRound panelRound1;
    private Sygma.Component.PanelRound panelRound2;
    private javax.swing.JPanel pop;
    private com.raven.swing.search txtSearch;
    private com.raven.swing.search txtSearch1;
    private javax.swing.JComboBox<String> type;
    private javax.swing.JComboBox<String> type1;
    // End of variables declaration//GEN-END:variables
}
