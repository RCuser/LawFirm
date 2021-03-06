/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author skeith
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.*;
import java.sql.PreparedStatement;
import java.util.HashMap;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;
import java.util.Map;


public class CaseFront extends javax.swing.JFrame {

    /**
     * Creates new form CaseFront
     */
    
    Connection cnn;
    Statement stmt;
    ResultSet rs;
    ResultSet rsA;
    ResultSet rs2;
    static int indexCaseClicked;
    int count;
    
    public CaseFront() {
        initComponents();
        ConnCaseData();
        setDefaultCloseOperation(CaseFront.EXIT_ON_CLOSE);
    }
    
    public void ConnCaseData() {

            String  url = "jdbc:oracle:thin:@delphi.cs.csubak.edu:1521:dbs01",
                user="winter342", passwd="c3m4p2s";
        try {
                DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
                cnn = DriverManager.getConnection(url, user, passwd);
                cnn.setAutoCommit(true);
                

                    stmt = cnn.createStatement( ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE );

                String sql = "select * from crak_case order by caseID asc";
                rs = stmt.executeQuery(sql);
                
                //rs.next();
                while(rs.next()) {

                String Cname = rs.getString("Name");
                String Csdate = rs.getString("SDate");
                String Cedate = rs.getString("EDate");


                
                DefaultTableModel model = (DefaultTableModel) CaseTable.getModel();
                model.addRow(new Object[]{Cname, Csdate, Cedate});
                }
                

        } catch (SQLException e ) { e.printStackTrace(); System.exit(-1); }
    }
    
    public void ViewShow() {

            String  url = "jdbc:oracle:thin:@delphi.cs.csubak.edu:1521:dbs01",
                user="winter342", passwd="c3m4p2s";
        try {
                DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
                cnn = DriverManager.getConnection(url, user, passwd);
                cnn.setAutoCommit(true);
                

                    stmt = cnn.createStatement( ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE );

                String sql = "select Fname, Lname, CFname, CLname, JFname, JLname, OFname, OLname, Description from crak_caseToAll where caseID = " + indexCaseClicked + " ";
                
                
                rs = stmt.executeQuery(sql);
                
                //rs.next();
                while(rs.next()) {
                


                String AFname = rs.getString("Fname");
                String ALname = rs.getString("Lname");
                String AFull = AFname + " " + ALname;
                String CFname = rs.getString("CFname");
                String CLname = rs.getString("CLname");
                String CFull = CFname + " " + CLname;
                String JFname = rs.getString("JFname");
                String JLname = rs.getString("JLname");
                String JFull = JFname + " " + JLname;
                String OFname = rs.getString("OFname");
                String OLname = rs.getString("OLname");
                String OFull = OFname + " " + OLname;
                String Descrip = rs.getString("Description");

                
                
                jTextField1.setText(AFull);
                jTextField2.setText(CFull);
                jTextField3.setText(JFull);
                jTextField4.setText(OFull);
                jTextArea1.setText(Descrip);
                }
                

        } catch (SQLException e ) { e.printStackTrace(); System.exit(-1); }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        CaseTable = new javax.swing.JTable();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jPanel1 = new javax.swing.JPanel();
        CaseAddButton = new javax.swing.JButton();
        CaseReport = new javax.swing.JButton();
        ResetCase = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        GoAttorney = new javax.swing.JButton();
        GoClient = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jDesktopPane1 = new javax.swing.JDesktopPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        CaseTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Start Date", "End Date"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        CaseTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CaseTableMouseClicked(evt);
            }
        });
        CaseTable.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                CaseTableKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                CaseTableKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(CaseTable);
        if (CaseTable.getColumnModel().getColumnCount() > 0) {
            CaseTable.getColumnModel().getColumn(0).setResizable(false);
            CaseTable.getColumnModel().getColumn(1).setResizable(false);
            CaseTable.getColumnModel().getColumn(2).setResizable(false);
        }

        jTextField1.setText("Attorney Name");

        jTextField2.setText("Client  Name");

        jTextField3.setText("Judge Name");
        jTextField3.setToolTipText(" ");

        jTextField4.setText("Opposing Attorney Name");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.setText("Description.");
        jScrollPane2.setViewportView(jTextArea1);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        CaseAddButton.setText("Add");
        CaseAddButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CaseAddButtonActionPerformed(evt);
            }
        });

        CaseReport.setText("CaseReport");
        CaseReport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CaseReportActionPerformed(evt);
            }
        });

        ResetCase.setText("Reset");
        ResetCase.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ResetCaseActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(CaseAddButton)
                    .addComponent(CaseReport)
                    .addComponent(ResetCase))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(CaseAddButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(CaseReport)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ResetCase)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        GoAttorney.setText("Attorney");
        GoAttorney.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GoAttorneyActionPerformed(evt);
            }
        });

        GoClient.setText("Client");
        GoClient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GoClientActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(GoAttorney)
                .addGap(18, 18, 18)
                .addComponent(GoClient)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(GoAttorney)
                    .addComponent(GoClient))
                .addGap(0, 16, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Ubuntu", 1, 36)); // NOI18N
        jLabel1.setText("Case");

        jLabel2.setText("Attorney");

        jLabel3.setText("Client");

        jLabel4.setText("Judge");

        jLabel5.setText("Opposing Attorney");

        jLabel6.setText("Description");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(jDesktopPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel1))
                .addGap(0, 131, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(6, 6, 6))
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(56, 56, 56)
                        .addComponent(jDesktopPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(3, 3, 3)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(2, 2, 2)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel4)
                                .addGap(1, 1, 1)
                                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel5)
                                .addGap(2, 2, 2)
                                .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel6)
                                .addGap(3, 3, 3)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(81, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CaseTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CaseTableMouseClicked
        // TODO add your handling code here:
        indexCaseClicked = CaseTable.getSelectedRow();
        indexCaseClicked = indexCaseClicked + 1;
        System.out.println(indexCaseClicked); //just to check if index is real
        ViewShow();
        
    }//GEN-LAST:event_CaseTableMouseClicked

    private void CaseTableKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CaseTableKeyPressed
        // TODO add your handling code here:
        indexCaseClicked = CaseTable.getSelectedRow();
        indexCaseClicked = indexCaseClicked + 1;
        System.out.println(indexCaseClicked); //just to check if index is real
        ViewShow();
    }//GEN-LAST:event_CaseTableKeyPressed

    private void CaseTableKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CaseTableKeyReleased
        // TODO add your handling code here:
        indexCaseClicked = CaseTable.getSelectedRow();
        indexCaseClicked = indexCaseClicked + 1;
        System.out.println(indexCaseClicked); //just to check if index is real
        ViewShow();
    }//GEN-LAST:event_CaseTableKeyReleased

    private void CaseAddButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CaseAddButtonActionPerformed
        // TODO add your handling code here:
        new AddCase().setVisible(true);
    }//GEN-LAST:event_CaseAddButtonActionPerformed

    private void CaseReportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CaseReportActionPerformed
        // TODO add your handling code here:
                try {
            
            JasperReport ra = JasperCompileManager.compileReport("report4.jrxml");
            Map parametersMap = new HashMap();
            parametersMap.put("caseNUM", indexCaseClicked);
            JasperPrint rb = JasperFillManager.fillReport(ra, parametersMap, cnn);
            JasperViewer.viewReport(rb,false);
        } catch (JRException ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_CaseReportActionPerformed

    private void GoAttorneyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GoAttorneyActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        new LawFirmFront().setVisible(true);
    }//GEN-LAST:event_GoAttorneyActionPerformed

    private void GoClientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GoClientActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        new ClientFront().setVisible(true);
    }//GEN-LAST:event_GoClientActionPerformed

    private void ResetCaseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ResetCaseActionPerformed
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) CaseTable.getModel();
        model.setRowCount(0);
        ConnCaseData();
    }//GEN-LAST:event_ResetCaseActionPerformed

    
    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(CaseFront.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CaseFront.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CaseFront.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CaseFront.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CaseFront().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CaseAddButton;
    private javax.swing.JButton CaseReport;
    private javax.swing.JTable CaseTable;
    private javax.swing.JButton GoAttorney;
    private javax.swing.JButton GoClient;
    private javax.swing.JButton ResetCase;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    // End of variables declaration//GEN-END:variables
}
