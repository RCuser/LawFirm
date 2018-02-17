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
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.export.ExporterInput;
import net.sf.jasperreports.export.OutputStreamExporterOutput;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import net.sf.jasperreports.export.SimplePdfExporterConfiguration;
import net.sf.jasperreports.view.JRDesignViewer.*;
import net.sf.jasperreports.view.JasperViewer;
import net.sf.jasperreports.engine.data.JRTableModelDataSource;


public class AddCase extends javax.swing.JFrame {

    /**
     * Creates new form AddCase
     */
    
    Connection cnn;
    Statement stmt;
    Statement stmt2;
    Statement stmt3;
    Statement stmt4;
    ResultSet rs;
    ResultSet rs2;
    ResultSet rs3;
    ResultSet rs4;
    int pickAttorneyClicked;
    String fN;
    String lN;
    String sN;
    int iClient;
    int iJudge;
    int iOpposing;
    int iAppearance;
    String appName;
    String appStreet;
    String appCity;
    String appState;
    String appZip;
    
    public AddCase() {
        initComponents();
        CurrentAttorney();
        setDefaultCloseOperation(AddCase.DISPOSE_ON_CLOSE);
    }
    
    
    
    
    
    
    public void CurrentAttorney() {
                String  url = "jdbc:oracle:thin:@delphi.cs.csubak.edu:1521:dbs01",
                user="winter342", passwd="c3m4p2s";
        try {
                DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
                cnn = DriverManager.getConnection(url, user, passwd);
                cnn.setAutoCommit(true);
                

                stmt = cnn.createStatement( ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE );
                
                String sql = "select * from crak_attorney where edate is null";
                rs = stmt.executeQuery(sql);
                
                //rs.next();
                while(rs.next()) {

                String aFirst = rs.getString("Fname");
                String aLast = rs.getString("Lname");
                int assN = rs.getInt("Ssn");
                String aSocial = Integer.toString(assN);


                DefaultTableModel model = (DefaultTableModel) pickAttorney.getModel();
                model.addRow(new Object[]{aFirst, aLast, aSocial}); 
                }
                
                 String sql1 = "select * from crak_client order by clientID asc";
                rs = stmt.executeQuery(sql1);
                
                //rs.next();
                while(rs.next()) {

                String aFirst = rs.getString("Fname");
                String aLast = rs.getString("Lname");
                int assN = rs.getInt("Ssn");
                String aSocial = Integer.toString(assN);


                DefaultTableModel model = (DefaultTableModel) pickClient.getModel();
                model.addRow(new Object[]{aFirst, aLast, aSocial}); 
                }
                
                String sql2 = "select * from crak_judge order by judgeID asc";
                rs = stmt.executeQuery(sql2);
                
                //rs.next();
                while(rs.next()) {

                String aFirst = rs.getString("Fname");
                String aLast = rs.getString("Lname");
                int assN = rs.getInt("Ssn");
                String aSocial = Integer.toString(assN);


                DefaultTableModel model = (DefaultTableModel) pickJudge.getModel();
                model.addRow(new Object[]{aFirst, aLast, aSocial}); 
                }
                
                String sql3 = "select * from crak_opposingattorney order by opposingID asc";
                rs = stmt.executeQuery(sql3);
                
                //rs.next();
                while(rs.next()) {

                String aFirst = rs.getString("Fname");
                String aLast = rs.getString("Lname");
                int assN = rs.getInt("Ssn");
                String aSocial = Integer.toString(assN);


                DefaultTableModel model = (DefaultTableModel) pickOpposing.getModel();
                model.addRow(new Object[]{aFirst, aLast, aSocial}); 
                }
                
                String sql4 = "select * from crak_appearance order by appearID asc";
                rs = stmt.executeQuery(sql4);
                
                //rs.next();
                while(rs.next()) {

                String aFirst = rs.getString("Name");
                String aLast = rs.getString("City");
                String aState = rs.getString("State");


                DefaultTableModel model = (DefaultTableModel) pickAppearance.getModel();
                model.addRow(new Object[]{aFirst, aLast, aState}); 
                }

        } catch (SQLException e ) { e.printStackTrace(); System.exit(-1); }
    }
    
        public void CurrentClient() {
                String  url = "jdbc:oracle:thin:@delphi.cs.csubak.edu:1521:dbs01",
                user="winter342", passwd="c3m4p2s";
        try {
                DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
                cnn = DriverManager.getConnection(url, user, passwd);
                cnn.setAutoCommit(true);
                

                stmt = cnn.createStatement( ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE );
                
                String sql = "select * from crak_client";
                rs = stmt.executeQuery(sql);
                
                //rs.next();
                while(rs.next()) {

                String aFirst = rs.getString("Fname");
                String aLast = rs.getString("Lname");
                int assN = rs.getInt("Ssn");
                String aSocial = Integer.toString(assN);


                DefaultTableModel model = (DefaultTableModel) pickClient.getModel();
                model.addRow(new Object[]{aFirst, aLast, aSocial}); 
                }

        } catch (SQLException e ) { e.printStackTrace(); System.exit(-1); }
    }
    
    public void CurrentJudge() {
                String  url = "jdbc:oracle:thin:@delphi.cs.csubak.edu:1521:dbs01",
                user="winter342", passwd="c3m4p2s";
        try {
                DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
                cnn = DriverManager.getConnection(url, user, passwd);
                cnn.setAutoCommit(true);
                

                stmt = cnn.createStatement( ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE );
                
                String sql = "select * from crak_judge order by judgeID asc";
                rs = stmt.executeQuery(sql);
                
                //rs.next();
                while(rs.next()) {

                String aFirst = rs.getString("Fname");
                String aLast = rs.getString("Lname");
                int assN = rs.getInt("Ssn");
                String aSocial = Integer.toString(assN);


                DefaultTableModel model = (DefaultTableModel) pickJudge.getModel();
                model.addRow(new Object[]{aFirst, aLast, aSocial}); 
                }

        } catch (SQLException e ) { e.printStackTrace(); System.exit(-1); }
    }

    public void CurrentOpposing() {
                String  url = "jdbc:oracle:thin:@delphi.cs.csubak.edu:1521:dbs01",
                user="winter342", passwd="c3m4p2s";
        try {
                DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
                cnn = DriverManager.getConnection(url, user, passwd);
                cnn.setAutoCommit(true);
                

                stmt = cnn.createStatement( ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE );
                
                String sql = "select * from crak_opposingattorney";
                rs = stmt.executeQuery(sql);
                
                //rs.next();
                while(rs.next()) {

                String aFirst = rs.getString("Fname");
                String aLast = rs.getString("Lname");
                int assN = rs.getInt("Ssn");
                String aSocial = Integer.toString(assN);


                DefaultTableModel model = (DefaultTableModel) pickOpposing.getModel();
                model.addRow(new Object[]{aFirst, aLast, aSocial}); 
                }
                
                String sql2 = "select * from crak_appearance";
                rs = stmt.executeQuery(sql2);
                
                //rs.next();
                while(rs.next()) {

                String aFirst = rs.getString("Name");
                String aLast = rs.getString("City");
                String aState = rs.getString("State");


                DefaultTableModel model = (DefaultTableModel) pickAppearance.getModel();
                model.addRow(new Object[]{aFirst, aLast, aState}); 
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
        pickAttorney = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        pickClient = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        pickJudge = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        pickOpposing = new javax.swing.JTable();
        jScrollPane5 = new javax.swing.JScrollPane();
        pickAppearance = new javax.swing.JTable();
        newCaseName = new javax.swing.JTextField();
        jScrollPane6 = new javax.swing.JScrollPane();
        newCaseDescription = new javax.swing.JTextArea();
        newCaseCity = new javax.swing.JTextField();
        newCaseStart = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        AddNewCase = new javax.swing.JButton();
        CancelAddCase = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pickAttorney.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "First Name", "Last Name", "SSN"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class
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
        pickAttorney.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pickAttorneyMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(pickAttorney);
        if (pickAttorney.getColumnModel().getColumnCount() > 0) {
            pickAttorney.getColumnModel().getColumn(0).setResizable(false);
            pickAttorney.getColumnModel().getColumn(1).setResizable(false);
            pickAttorney.getColumnModel().getColumn(2).setResizable(false);
        }

        pickClient.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "First Name", "Last Name", "SSN"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class
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
        pickClient.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pickClientMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(pickClient);
        if (pickClient.getColumnModel().getColumnCount() > 0) {
            pickClient.getColumnModel().getColumn(0).setResizable(false);
            pickClient.getColumnModel().getColumn(1).setResizable(false);
            pickClient.getColumnModel().getColumn(2).setResizable(false);
        }

        pickJudge.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "First Name", "Last Name", "SSN"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class
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
        pickJudge.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pickJudgeMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(pickJudge);
        if (pickJudge.getColumnModel().getColumnCount() > 0) {
            pickJudge.getColumnModel().getColumn(0).setResizable(false);
            pickJudge.getColumnModel().getColumn(1).setResizable(false);
            pickJudge.getColumnModel().getColumn(2).setResizable(false);
        }

        pickOpposing.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "First Name", "Last Name", "SSN"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class
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
        pickOpposing.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pickOpposingMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(pickOpposing);
        if (pickOpposing.getColumnModel().getColumnCount() > 0) {
            pickOpposing.getColumnModel().getColumn(0).setResizable(false);
            pickOpposing.getColumnModel().getColumn(1).setResizable(false);
            pickOpposing.getColumnModel().getColumn(2).setResizable(false);
        }

        pickAppearance.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "City", "State"
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
        pickAppearance.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pickAppearanceMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(pickAppearance);
        if (pickAppearance.getColumnModel().getColumnCount() > 0) {
            pickAppearance.getColumnModel().getColumn(0).setResizable(false);
            pickAppearance.getColumnModel().getColumn(1).setResizable(false);
            pickAppearance.getColumnModel().getColumn(2).setResizable(false);
        }

        newCaseName.setText("Name");

        newCaseDescription.setColumns(20);
        newCaseDescription.setRows(5);
        newCaseDescription.setText("Description");
        jScrollPane6.setViewportView(newCaseDescription);

        newCaseCity.setText("City");

        newCaseStart.setText("01-Jan-00");

        jLabel1.setText("Attorney");

        jLabel2.setText("Client");

        jLabel3.setText("Judge");

        jLabel4.setText("Opposing Attorney");

        jLabel5.setText("Courthouse");

        jLabel6.setText("Case Name");

        jLabel7.setText("Case Description");

        jLabel8.setText("City");

        jLabel9.setText("Court Date");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 167, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 45, Short.MAX_VALUE)
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        AddNewCase.setText("Add");
        AddNewCase.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddNewCaseActionPerformed(evt);
            }
        });

        CancelAddCase.setText("Cancel");
        CancelAddCase.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelAddCaseActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(AddNewCase)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(CancelAddCase)
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AddNewCase)
                    .addComponent(CancelAddCase)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 358, Short.MAX_VALUE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel5))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(83, 83, 83)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(newCaseName, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(newCaseStart, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)
                                        .addComponent(newCaseCity, javax.swing.GroupLayout.Alignment.LEADING))
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel9)
                                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(202, 202, 202)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jLabel1)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addContainerGap(101, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel6))
                .addGap(2, 2, 2)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(newCaseName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel7)
                        .addGap(2, 2, 2)
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(newCaseCity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(newCaseStart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(13, 13, 13)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)
                        .addGap(4, 4, 4)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(71, 71, 71)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(51, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void pickAttorneyMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pickAttorneyMouseClicked
        // TODO add your handling code here:
        pickAttorneyClicked = pickAttorney.getSelectedRow();
        Object firstName = pickAttorney.getModel().getValueAt(pickAttorneyClicked,0);
        Object lastName = pickAttorney.getModel().getValueAt(pickAttorneyClicked,1);
        Object Ssn = pickAttorney.getModel().getValueAt(pickAttorneyClicked, 2);
        fN = firstName.toString();
        lN = lastName.toString();
        sN = Ssn.toString();
    }//GEN-LAST:event_pickAttorneyMouseClicked

    private void pickClientMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pickClientMouseClicked
        // TODO add your handling code here:
        iClient = pickClient.getSelectedRow();
        iClient = iClient + 1;
    }//GEN-LAST:event_pickClientMouseClicked

    private void pickJudgeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pickJudgeMouseClicked
        // TODO add your handling code here:
        iJudge = pickJudge.getSelectedRow();
        iJudge = iJudge + 1;
    }//GEN-LAST:event_pickJudgeMouseClicked

    private void pickOpposingMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pickOpposingMouseClicked
        // TODO add your handling code here:
        iOpposing = pickOpposing.getSelectedRow();
        iOpposing = iOpposing + 1;
    }//GEN-LAST:event_pickOpposingMouseClicked

    private void pickAppearanceMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pickAppearanceMouseClicked
        // TODO add your handling code here:
        iAppearance = pickAppearance.getSelectedRow();
        iAppearance = iAppearance + 1;
    }//GEN-LAST:event_pickAppearanceMouseClicked

    private void AddNewCaseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddNewCaseActionPerformed
        // TODO add your handling code here:
        String  url = "jdbc:oracle:thin:@delphi.cs.csubak.edu:1521:dbs01",
                user="winter342", passwd="c3m4p2s";
        try {
                DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
                cnn = DriverManager.getConnection(url, user, passwd);
                cnn.setAutoCommit(true);
                

                stmt = cnn.createStatement( ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE );
                stmt2 = cnn.createStatement( ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE );
                stmt3 = cnn.createStatement( ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE );
                stmt4 = cnn.createStatement( ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE );
                String appQuery = "select * from crak_appearance where appearID = " +iAppearance;
                rs = stmt.executeQuery(appQuery);
                while(rs.next()) {
                    appName = rs.getString("Name");
                    appStreet = rs.getString("Street");
                    appCity = rs.getString("City");
                    appState = rs.getString("State");
                    int azip = rs.getInt("Zip");
                    appZip = Integer.toString(azip);
                }
                String upApp = "call crak_insappear('" +appName+ "', '" +appStreet+ "', '" +appCity+"', '" +appState+ "', "+appZip+ ", " +iOpposing+", " +iJudge+ ")";
                rs = stmt.executeQuery(upApp);
                
                
                String nCaseName = newCaseName.getText();
                String nCaseDescription = newCaseDescription.getText();
                String nCaseCity = newCaseCity.getText();
                String nCaseStart = newCaseStart.getText();
                String caseQuery = "call crak_inscase('" +nCaseName+ "', '" +nCaseDescription+ "', '" +nCaseCity+ "', '" +nCaseStart+ "', NULL, " +iClient+ ", " +iAppearance+ ")";
                rs = stmt.executeQuery(caseQuery);
 
                
                String caseIDQuery = "select caseID from crak_case where  ClientID = " +iClient+ " AND AppearID = " +iAppearance;
                
                rs2 = stmt2.executeQuery(caseIDQuery);
                rs2.next();
                int indexCas = rs2.getInt("caseID");
                String indexCase = Integer.toString(indexCas);
                String attorneyQuery = "select attorneyID from crak_attorney where Fname = '" +fN+ "'AND Lname = '" +lN+ "'AND Ssn = " +sN + "";
                rs3 = stmt3.executeQuery(attorneyQuery);
                rs3.next();
                int indexAtt = rs3.getInt("attorneyID");
                String indexAttorney = Integer.toString(indexAtt);
                String assignQuery = "insert into crak_isassigned(attorneyID, caseID, sDate, eDate) values (" +indexAttorney+ ", " +indexCase+", '" +nCaseStart+ "', NULL)";
                rs4 = stmt4.executeQuery(assignQuery); 
                this.setVisible(false);

        } catch (SQLException e ) { e.printStackTrace(); System.exit(-1); }
    
    }//GEN-LAST:event_AddNewCaseActionPerformed

    private void CancelAddCaseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelAddCaseActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
    }//GEN-LAST:event_CancelAddCaseActionPerformed

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
            java.util.logging.Logger.getLogger(AddCase.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddCase.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddCase.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddCase.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddCase().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddNewCase;
    private javax.swing.JButton CancelAddCase;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTextField newCaseCity;
    private javax.swing.JTextArea newCaseDescription;
    private javax.swing.JTextField newCaseName;
    private javax.swing.JTextField newCaseStart;
    private javax.swing.JTable pickAppearance;
    private javax.swing.JTable pickAttorney;
    private javax.swing.JTable pickClient;
    private javax.swing.JTable pickJudge;
    private javax.swing.JTable pickOpposing;
    // End of variables declaration//GEN-END:variables
}
