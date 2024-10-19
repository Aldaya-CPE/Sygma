package com.raven.form;

import Sygma.Database.Database;
import com.raven.chart.ModelChart;
import com.raven.swing.PanelSearch;
import com.sun.jdi.connect.spi.Connection;
import java.awt.Color;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;
import javax.swing.Timer;
import java.util.TimerTask;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class Form_1 extends javax.swing.JPanel {
     Connection MyCon;
    PreparedStatement ps;
    ResultSet rs;
    private DefaultTableCellRenderer centerRenderer;;
    private PanelSearch search;
    private Timer timer;
    private String userId = "yourUserId";
   
    private double[][] oldIncomeValues;
    private double[][] oldExpenseValues;
    private double[][] oldBalanceValues;
    public Form_1() {
        initComponents();
         try {
            Database.getInstance().ConnectToDatabase();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
      setBackground(new Color(0, 0, 0, 0));
         pn.setText(userId);
         pn.setVisible(false); 
        centerRenderer = new DefaultTableCellRenderer();
        tableTextCenter();
        populateTable();
        init();
         timer = new Timer(500, (e) -> {
            populateTable();
        });
        timer.start();
      
    }

    private void init() {
        lineChart.addLegend("Badget", new Color(0, 102, 120), new Color(0, 102, 120));
        lineChart.addLegend("Expense", new Color(90, 179, 220), new Color(90, 179, 220));
        lineChart.addLegend("Balance", new Color(127,201,170), new Color(127,201,170));

        progress1.start();
        progress2.start();
        progress3.start();
    }
    
    
    
    private void tableTextCenter() {
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        for (int i = 0; i < jTable1.getColumnCount(); i++) {
            jTable1.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }
    }
    public void populateTable() {
    DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
    model.setRowCount(0); 
    double totalIncome = 0;
    double totalExpenses = 0;
    double maxAmount = 10000; 
    try {
        String sql = "SELECT category, date, amount, type FROM expenses WHERE userId = ?";
        ps = Database.getInstance().getConnection().prepareStatement(sql);
        ps.setString(1, pn.getText());
        rs = ps.executeQuery();
        double[] incomeValues = new double[5]; 
        double[] expenseValues = new double[5]; 
        double[] balanceValues = new double[5]; 
        String[] months = {"January", "August", "September", "October", "November"};
        while (rs.next()) {
            String category = rs.getString("category");
            Date date = rs.getDate("date");
            double amount = rs.getDouble("amount");
            String type = rs.getString("type");
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            int month = calendar.get(Calendar.MONTH);
            String monthName;
            if (month == Calendar.JANUARY) {
                monthName = "January";
            } else if (month == Calendar.AUGUST) {
                monthName = "August";
            } else if (month == Calendar.SEPTEMBER) {
                monthName = "September";
            } else if (month == Calendar.OCTOBER) {
                monthName = "October";
            } else if (month == Calendar.NOVEMBER) {
                monthName = "November";
            } else {
                continue; 
            }
            int monthIndex = -1;
            for (int i = 0; i < months.length; i++) {
                if (months[i].equals(monthName)) {
                    monthIndex = i;
                    break;
                }
            }
            if (monthIndex != -1) {
                if (type.equals("Badget")) {
                    totalIncome += amount;
                    incomeValues[monthIndex] += amount;
                } else {
                    totalExpenses += amount;
                    expenseValues[monthIndex] += amount;
                }
            }
            model.addRow(new Object[]{category, date, amount, type});
        }
        double totalBalance = totalIncome - totalExpenses;
        double incomePercentage = (totalIncome / maxAmount) * 100;
        double expensesPercentage = (totalExpenses / maxAmount) * 100;
        double balancePercentage = (totalBalance / maxAmount) * 100;
        progress1.setValue((int) incomePercentage);
        progress2.setValue((int) expensesPercentage);
        progress3.setValue((int) balancePercentage);
        jLabel1.setText("Total Badget: " + totalIncome);
        jLabel3.setText("Total Expenses: " + totalExpenses);
        jLabel4.setText("Total Balance: " + totalBalance);
        
        for (int i = 0; i < 5; i++) {
            balanceValues[i] = incomeValues[i] - expenseValues[i];
        }
        
        double[][] incomeValues2D = new double[5][1];
        double[][] expenseValues2D = new double[5][1];
        double[][] balanceValues2D = new double[5][1];

        for (int i = 0; i < 5; i++) {
            
            incomeValues2D[i][0] = incomeValues[i];
            expenseValues2D[i][0] = expenseValues[i];
            balanceValues2D[i][0] = balanceValues[i];
        }
       if (hasDataChanged(incomeValues2D, expenseValues2D, balanceValues2D)) {
        lineChart.clear();
        for (int i = 0; i < 5; i++) {
            double incomeValue = incomeValues2D[i][0] < 0 ? 0 : incomeValues2D[i][0];
            double expenseValue = expenseValues2D[i][0] < 0 ? 0 : expenseValues2D[i][0];
            double balanceValue = balanceValues2D[i][0] < 0 ? 0 : balanceValues2D[i][0];
            lineChart.addData(new ModelChart(months[i], new double[]{incomeValues2D[i][0], expenseValues2D[i][0], balanceValues2D[i][0]}));
        }
        lineChart.start();
    }
        oldIncomeValues = incomeValues2D;
        oldExpenseValues = expenseValues2D;
        oldBalanceValues = balanceValues2D;
      
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Error loading data: " + e.getMessage());
    }
}
    
    private boolean hasDataChanged(double[][] newIncomeValues, double[][] newExpenseValues, double[][] newBalanceValues) {
    if (oldIncomeValues == null || oldExpenseValues == null || oldBalanceValues == null) {
        oldIncomeValues = newIncomeValues;
        oldExpenseValues = newExpenseValues;
        oldBalanceValues = newBalanceValues;
        return true;
    }
    for (int i = 0; i < 5; i++) {
        if (newIncomeValues[i][0] != oldIncomeValues[i][0] ||
            newExpenseValues[i][0] != oldExpenseValues[i][0] ||
            newBalanceValues[i][0] != oldBalanceValues[i][0]) {
            return true; 
        }
    }
    return false; 
}
 
   
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        roundPanel1 = new com.raven.swing.RoundPanel();
        jPanel1 = new javax.swing.JPanel();
        progress1 = new com.raven.swing.progress.Progress();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        progress2 = new com.raven.swing.progress.Progress();
        jLabel3 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        progress3 = new com.raven.swing.progress.Progress();
        jLabel4 = new javax.swing.JLabel();
        pn = new javax.swing.JLabel();
        roundPanel2 = new com.raven.swing.RoundPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        roundPanel3 = new com.raven.swing.RoundPanel();
        lineChart = new com.raven.chart.LineChart();

        setForeground(new java.awt.Color(255, 255, 255));

        roundPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setOpaque(false);

        progress1.setBackground(new java.awt.Color(150, 215, 180));
        progress1.setBorder(null);
        progress1.setForeground(new java.awt.Color(150, 215, 180));
        progress1.setValue(60);

        jLabel1.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Badget");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(progress1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(progress1, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jLabel2.setFont(new java.awt.Font("sansserif", 1, 15)); // NOI18N
        jLabel2.setText("Report Monthly");
        jLabel2.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));

        jPanel2.setOpaque(false);

        progress2.setBackground(new java.awt.Color(90, 179, 220));
        progress2.setBorder(null);
        progress2.setForeground(new java.awt.Color(90, 179, 220));
        progress2.setValue(70);

        jLabel3.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Expenses");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(progress2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(progress2, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel3.setOpaque(false);

        progress3.setBackground(new java.awt.Color(0, 102, 120));
        progress3.setBorder(null);
        progress3.setForeground(new java.awt.Color(0, 102, 120));
        progress3.setValue(85);
        progress3.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N

        jLabel4.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Balance");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(progress3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(progress3, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pn.setText("jLabel5");

        javax.swing.GroupLayout roundPanel1Layout = new javax.swing.GroupLayout(roundPanel1);
        roundPanel1.setLayout(roundPanel1Layout);
        roundPanel1Layout.setHorizontalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(roundPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(roundPanel1Layout.createSequentialGroup()
                        .addComponent(pn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        roundPanel1Layout.setVerticalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(pn))
                .addGap(20, 20, 20)
                .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        roundPanel2.setBackground(new java.awt.Color(255, 255, 255));
        roundPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Category", "Date", "Amount", "Type"
            }
        ));
        jTable1.setRowSelectionAllowed(false);
        jScrollPane2.setViewportView(jTable1);

        roundPanel2.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 10, 1090, 410));

        roundPanel3.setBackground(new java.awt.Color(255, 255, 255));

        lineChart.setBackground(new java.awt.Color(204, 255, 204));

        javax.swing.GroupLayout roundPanel3Layout = new javax.swing.GroupLayout(roundPanel3);
        roundPanel3.setLayout(roundPanel3Layout);
        roundPanel3Layout.setHorizontalGroup(
            roundPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lineChart, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        roundPanel3Layout.setVerticalGroup(
            roundPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lineChart, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(roundPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(roundPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(roundPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(roundPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(roundPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(10, 10, 10)
                .addComponent(roundPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private com.raven.chart.LineChart lineChart;
    public javax.swing.JLabel pn;
    private com.raven.swing.progress.Progress progress1;
    private com.raven.swing.progress.Progress progress2;
    private com.raven.swing.progress.Progress progress3;
    private com.raven.swing.RoundPanel roundPanel1;
    private com.raven.swing.RoundPanel roundPanel2;
    private com.raven.swing.RoundPanel roundPanel3;
    // End of variables declaration//GEN-END:variables
}
