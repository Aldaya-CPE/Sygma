
package Sygma.LoginPage;
import java.awt.CardLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 *
 * @author Vea
 */
public class signUp extends javax.swing.JPanel {
   
    
    public signUp() {
        
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        genId = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        panelBar1 = new Sygma.Components.PanelBar();
        panelBar2 = new Sygma.Components.PanelBar();
        panelBar3 = new Sygma.Components.PanelBar();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        genId.setText("jLabel1");
        add(genId, new org.netbeans.lib.awtextra.AbsoluteConstraints(14, 25, -1, -1));

        jButton1.setText("jButton1");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 260, -1, -1));

        panelBar1.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout panelBar1Layout = new javax.swing.GroupLayout(panelBar1);
        panelBar1.setLayout(panelBar1Layout);
        panelBar1Layout.setHorizontalGroup(
            panelBar1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 200, Short.MAX_VALUE)
        );
        panelBar1Layout.setVerticalGroup(
            panelBar1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        add(panelBar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 170, -1, -1));

        javax.swing.GroupLayout panelBar2Layout = new javax.swing.GroupLayout(panelBar2);
        panelBar2.setLayout(panelBar2Layout);
        panelBar2Layout.setHorizontalGroup(
            panelBar2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 200, Short.MAX_VALUE)
        );
        panelBar2Layout.setVerticalGroup(
            panelBar2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        add(panelBar2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 210, 200, -1));

        panelBar3.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout panelBar3Layout = new javax.swing.GroupLayout(panelBar3);
        panelBar3.setLayout(panelBar3Layout);
        panelBar3Layout.setHorizontalGroup(
            panelBar3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 200, Short.MAX_VALUE)
        );
        panelBar3Layout.setVerticalGroup(
            panelBar3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        add(panelBar3, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 130, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
//        JFrame parentFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
//        
//        if (parentFrame instanceof Login) {
//            ((Login) parentFrame).switchToLogin(); // Call a method in Login to switch to the login screen
//        }
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JLabel genId;
    private javax.swing.JButton jButton1;
    private Sygma.Components.PanelBar panelBar1;
    private Sygma.Components.PanelBar panelBar2;
    private Sygma.Components.PanelBar panelBar3;
    // End of variables declaration//GEN-END:variables
}
