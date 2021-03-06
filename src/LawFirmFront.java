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
import java.util.Map;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;
import net.sf.jasperreports.engine.JasperPrintManager;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;



public class LawFirmFront extends javax.swing.JFrame {

    
    Connection cnn;
    Statement stmt;
    ResultSet rs;
    static int indexClicked; // Made static so updated indexClicked from function below gets passed to other classes
    /**
     * Creates new form LawFirmFront
     */
    public LawFirmFront() {
        initComponents();
        ConnectData();
    }
    
    public void ConnectData() {

            String  url = "jdbc:oracle:thin:@delphi.cs.csubak.edu:1521:dbs01",
                user="winter342", passwd="c3m4p2s";
        try {
                DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
                cnn = DriverManager.getConnection(url, user, passwd);
                cnn.setAutoCommit(true);
                

                    stmt = cnn.createStatement( ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE );

                String sql = "select * from crak_attorney order by attorneyID asc";
                rs = stmt.executeQuery(sql);
                
                //rs.next();
                while(rs.next()) {

                String firstn = rs.getString("Fname");
                String lastn = rs.getString("Lname");
                int assN = rs.getInt("Ssn");
                String ASocial = Integer.toString(assN);
                String AStreet = rs.getString("Street");
                String ACity = rs.getString("City"); 
                String AState = rs.getString("State"); 
                int att_zip = rs.getInt("ZIP");
                String AZip = Integer.toString(att_zip);
                int att_phone = rs.getInt("Phone");
                String APhone = Integer.toString(att_phone);
                String AEmail = rs.getString("Email");
                int att_salary = rs.getInt("Salary");
                String ASalary = Integer.toString(att_salary);
                String ASDate = rs.getString("SDate");
                String AEDate = rs.getString("EDate");
                
                DefaultTableModel model = (DefaultTableModel) AttorneyTable.getModel();
                
                model.addRow(new Object[]{firstn, lastn, ASocial, /*aBirth,*/ AStreet, ACity, AState, AZip,
                APhone, AEmail, ASalary, ASDate, AEDate});
                
                
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

        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        AttorneyTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        AttorneyReport = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        ResetButton = new javax.swing.JButton();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jPanel3 = new javax.swing.JPanel();
        ClientButton = new javax.swing.JButton();
        CaseButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        AttorneyTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "First Name", "Last Name", "SSN", "Street", "City", "State", "Zip", "Phone", "Email", "Salary", "Start Date", "End Date"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        AttorneyTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                AttorneyTableMousePressed(evt);
            }
        });
        AttorneyTable.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                AttorneyTableKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                AttorneyTableKeyReleased(evt);
            }
        });
        jScrollPane2.setViewportView(AttorneyTable);
        if (AttorneyTable.getColumnModel().getColumnCount() > 0) {
            AttorneyTable.getColumnModel().getColumn(0).setMaxWidth(70);
            AttorneyTable.getColumnModel().getColumn(1).setMaxWidth(70);
            AttorneyTable.getColumnModel().getColumn(2).setMaxWidth(90);
            AttorneyTable.getColumnModel().getColumn(3).setMaxWidth(70);
            AttorneyTable.getColumnModel().getColumn(4).setMaxWidth(70);
            AttorneyTable.getColumnModel().getColumn(5).setMaxWidth(50);
            AttorneyTable.getColumnModel().getColumn(6).setMaxWidth(60);
            AttorneyTable.getColumnModel().getColumn(7).setMaxWidth(70);
            AttorneyTable.getColumnModel().getColumn(8).setMaxWidth(70);
            AttorneyTable.getColumnModel().getColumn(9).setMaxWidth(70);
            AttorneyTable.getColumnModel().getColumn(10).setMaxWidth(100);
            AttorneyTable.getColumnModel().getColumn(11).setMaxWidth(100);
        }

        jLabel1.setFont(new java.awt.Font("Ubuntu", 1, 36)); // NOI18N
        jLabel1.setText("Attorney");

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jButton1.setText("Add");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Update");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        AttorneyReport.setText("Attorney Report");
        AttorneyReport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AttorneyReportActionPerformed(evt);
            }
        });

        jLabel2.setText("From:");

        ResetButton.setText("Reset");
        ResetButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ResetButtonActionPerformed(evt);
            }
        });

        jDateChooser1.setDateFormatString("dd-MMM-yy");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jLabel2)
                    .addComponent(AttorneyReport)
                    .addComponent(ResetButton)
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton2)
                .addGap(15, 15, 15)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(AttorneyReport)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ResetButton)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        ClientButton.setText("Client");
        ClientButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClientButtonActionPerformed(evt);
            }
        });

        CaseButton.setText("Case");
        CaseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CaseButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ClientButton)
                .addGap(18, 18, 18)
                .addComponent(CaseButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ClientButton)
                    .addComponent(CaseButton))
                .addGap(0, 15, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 80, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1243, 1243, 1243))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 898, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 441, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked

    }//GEN-LAST:event_jButton1MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        new AddAttorney().setVisible(true);

        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void AttorneyTableMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AttorneyTableMousePressed
        // Supposedly this can isolate selection on table rows
        indexClicked = AttorneyTable.getSelectedRow();

        indexClicked = indexClicked + 1;

    }//GEN-LAST:event_AttorneyTableMousePressed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        if(indexClicked > 0) {
            new UpdateAttorney().setVisible(true);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void CaseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CaseButtonActionPerformed
        // TODO add your handling code here:
        this.setVisible(false); //This is to close Attorney so Case can be only open
        new CaseFront().setVisible(true);
    }//GEN-LAST:event_CaseButtonActionPerformed

    private void AttorneyTableKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_AttorneyTableKeyPressed
        // TODO add your handling code here:
                indexClicked = AttorneyTable.getSelectedRow();

        indexClicked = indexClicked + 1;

    }//GEN-LAST:event_AttorneyTableKeyPressed

    private void ClientButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClientButtonActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        new ClientFront().setVisible(true);
    }//GEN-LAST:event_ClientButtonActionPerformed

    private void AttorneyTableKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_AttorneyTableKeyReleased
        // TODO add your handling code here:
        indexClicked = AttorneyTable.getSelectedRow();
        indexClicked = indexClicked + 1;
    }//GEN-LAST:event_AttorneyTableKeyReleased

    private void AttorneyReportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AttorneyReportActionPerformed
        // TODO add your handling code here:

                         try {
            
            JasperReport ra = JasperCompileManager.compileReport("report5.jrxml");
            Map parametersMap = new HashMap();
            Date date = jDateChooser1.getDate();
            String strDate = DateFormat.getDateInstance().format(date);
            final String calendarF = "MMM dd, yyyy";
            final String dataF = "dd-MMM-yy";
            SimpleDateFormat formatDate = new SimpleDateFormat(calendarF);
            formatDate.applyPattern(dataF);
            String sssDate = formatDate.format(date);
            parametersMap.put("attorneyNUM", indexClicked);
            parametersMap.put("sNUM", sssDate);
            int  pickAttorneyClicked = AttorneyTable.getSelectedRow();
            Object firstName = AttorneyTable.getModel().getValueAt(pickAttorneyClicked,0);
        
            Object lastName = AttorneyTable.getModel().getValueAt(pickAttorneyClicked,1);
        
            String FullName = lastName + ", " +firstName;
            
            parametersMap.put("attorneyName", FullName);
            

            JasperPrint rb = JasperFillManager.fillReport(ra, parametersMap, cnn);
            
            
            JasperViewer.viewReport(rb,false);
            
            

        } catch (JRException ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_AttorneyReportActionPerformed

    private void ResetButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ResetButtonActionPerformed
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) AttorneyTable.getModel();
        model.setRowCount(0);
        ConnectData();
    }//GEN-LAST:event_ResetButtonActionPerformed

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
            java.util.logging.Logger.getLogger(LawFirmFront.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LawFirmFront.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LawFirmFront.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LawFirmFront.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LawFirmFront().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AttorneyReport;
    private javax.swing.JTable AttorneyTable;
    private javax.swing.JButton CaseButton;
    private javax.swing.JButton ClientButton;
    private javax.swing.JButton ResetButton;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
