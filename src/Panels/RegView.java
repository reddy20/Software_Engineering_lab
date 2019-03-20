/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Panels;

import JISS.Case;
import JISS.Judge;
import JISS.Lawyer;
import JISS.Main;
import static JISS.Main.conn;
import static JISS.Main.st;
import JISS.Registrar;
import JISS.User;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Calendar;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author Sandesh
 */
public class RegView extends javax.swing.JPanel {

    /**
     * Creates new form RegView
     */
    public RegView() {
        initComponents();
        
        b_new_acc.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                JPanel inputPanel = new JPanel();
                GridBagLayout gbag = new GridBagLayout();
                GridBagConstraints gbc = new GridBagConstraints();
                inputPanel.setLayout(gbag);
                
                JTextField nameField = new JTextField(15);
                JLabel nameLabel = new JLabel("Enter Name          ");
                JLabel passwdLabel = new JLabel("Enter Password    ");
                JLabel typeLabel =   new JLabel("User Type ");
                JPasswordField passwdField = new JPasswordField(15);
                JLabel heading = new JLabel("Enter User Details");
                JComboBox type = new JComboBox();
                type.addItem("Lawyer");
                type.addItem("Judge");
                type.setSelectedIndex(0);
                
                gbc.weighty = 5.0;
                gbc.insets = new Insets(15,0,15,0);
                
                
                gbc.gridwidth = GridBagConstraints.REMAINDER;
                gbc.anchor = GridBagConstraints.NORTH;
                gbag.setConstraints(heading, gbc);
                
                gbc.gridwidth = GridBagConstraints.RELATIVE;
                gbag.setConstraints(typeLabel, gbc);
                gbc.gridwidth = GridBagConstraints.REMAINDER;
                gbag.setConstraints(type, gbc);
                
                gbc.gridwidth = GridBagConstraints.RELATIVE;
                gbag.setConstraints(nameLabel, gbc);
                gbc.gridwidth = GridBagConstraints.REMAINDER;
                gbag.setConstraints(nameField, gbc);

                gbc.gridwidth = GridBagConstraints.RELATIVE;
                gbag.setConstraints(passwdLabel, gbc);
                gbc.gridwidth = GridBagConstraints.REMAINDER;
                gbag.setConstraints(passwdField, gbc);
                
                inputPanel.add(heading);
                inputPanel.add(typeLabel);
                inputPanel.add(type);
                inputPanel.add(nameLabel);
                inputPanel.add(nameField);
                inputPanel.add(passwdLabel);
                inputPanel.add(passwdField);
                
                int result = JOptionPane.showConfirmDialog(null, inputPanel, "Create New User", JOptionPane.OK_CANCEL_OPTION);
                
                if(result == JOptionPane.OK_OPTION) { 
                    if (nameField.getText().length() <= 0 || passwdField.getPassword().length <= 0) {
                        JOptionPane.showMessageDialog(null, "Invalid Entry !");
                        return;
                    }
                    User u = null;
                    System.err.println("Selected index " + type.getSelectedIndex());
                    switch(type.getSelectedIndex()) {
                        case 0:
                            u = new Lawyer(nameField.getText(), passwdField.getPassword());
                            break;
                        case 1:
                            u = new Judge(nameField.getText(), passwdField.getPassword());
                            break;
                    }
                    
                    if(u != null) {
                        JOptionPane.showMessageDialog(null, "Successfully Registered !\nUser Id - " + u.getStrType() + u.getID());
                    } else {
                        JOptionPane.showMessageDialog(null, "Registration Failed !");
                    }
                }
                
            }
        });
        
        b_del_acc.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                JPanel inputPanel = new JPanel();
                GridBagLayout gbag = new GridBagLayout();
                GridBagConstraints gbc = new GridBagConstraints();
                inputPanel.setLayout(gbag);
                
                JTextField idField = new JTextField(15);
                JLabel idLabel = new JLabel("Enter User Id      ");
                JLabel typeLabel = new JLabel("User Type ");
                JLabel heading = new JLabel("Enter User Details");
               
                gbc.weighty = 5.0;
                gbc.insets = new Insets(15, 0, 15, 0);
                
                gbc.gridwidth = GridBagConstraints.REMAINDER;
                gbc.anchor = GridBagConstraints.NORTH;
                gbag.setConstraints(heading, gbc);
                
                gbc.gridwidth = GridBagConstraints.RELATIVE;
                gbag.setConstraints(idLabel, gbc);
                gbc.gridwidth = GridBagConstraints.REMAINDER;
                gbag.setConstraints(idField, gbc);
                
                
                inputPanel.add(heading);
                inputPanel.add(idLabel);
                inputPanel.add(idField);
                
                int result = JOptionPane.showConfirmDialog(null, inputPanel, "Delete User", JOptionPane.OK_CANCEL_OPTION);
                
                if (result == JOptionPane.OK_OPTION) {
                    try {
                        int id = Integer.parseInt(idField.getText().substring(1));
                        User u = null;
                        switch(User.parse(idField.getText().substring(0, 1))) {
                            case 1:
                                u = new Lawyer(id);
                                break;
                            case 2:
                                u = new Judge(id);
                                break;
                        }
                        Registrar r = new Registrar();
                        if(u != null) {
                            r.deleteAccount(u);
                            JOptionPane.showMessageDialog(rapplet._mv_p, "Account Deleted !");
                        } else {
                            JOptionPane.showMessageDialog(rapplet._mv_p, "This account can not be deleted !");
                        }
                        
                        
                    } catch(Exception ex) {
                        JOptionPane.showMessageDialog(null, "Invalid User");
                    }
                }
                
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        b_new_acc = new javax.swing.JButton();
        b_del_acc = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        b_up_cd = new javax.swing.JButton();
        b_up_ca = new javax.swing.JButton();
        b_up_cc = new javax.swing.JButton();
        b_up_nh = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        b_nc = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        b_lc_p = new javax.swing.JButton();
        b_lc_c = new javax.swing.JButton();
        b_lc_u = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        b_ccs = new javax.swing.JButton();
        tf_ccs_cin = new javax.swing.JTextField();
        tf_uci_cin = new javax.swing.JTextField();

        jLabel1.setText("Manage Accounts");

        b_new_acc.setText("New Account");

        b_del_acc.setText("Delete Account");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 153, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Registrar's Panel");

        jLabel3.setText("Update Case Info");

        b_up_cd.setText("Update Case Details");
        b_up_cd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_up_cdActionPerformed(evt);
            }
        });

        b_up_ca.setText("Case Adjourned");
        b_up_ca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_up_caActionPerformed(evt);
            }
        });

        b_up_cc.setText("Case Closed");
        b_up_cc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_up_ccActionPerformed(evt);
            }
        });

        b_up_nh.setText("Add Case-Hearing Details");
        b_up_nh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_up_nhActionPerformed(evt);
            }
        });

        jLabel4.setText("Schedule New Case");

        b_nc.setText("Schedule a New Case");
        b_nc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_ncActionPerformed(evt);
            }
        });

        jLabel5.setText("List Cases");

        b_lc_p.setText("List Pending Cases");
        b_lc_p.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_lc_pActionPerformed(evt);
            }
        });

        b_lc_c.setText("List Closed Cases");
        b_lc_c.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_lc_cActionPerformed(evt);
            }
        });

        b_lc_u.setText("List Upcoming Cases");
        b_lc_u.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_lc_uActionPerformed(evt);
            }
        });

        jLabel6.setText("Check Status");

        b_ccs.setText("Check Case Status");
        b_ccs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_ccsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(b_lc_u, javax.swing.GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE)
                                    .addComponent(b_lc_p, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addComponent(b_lc_c, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(tf_ccs_cin, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(b_ccs, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(b_nc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(tf_uci_cin, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(b_up_ca, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(b_up_cd, javax.swing.GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(b_new_acc, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(b_up_cc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(b_up_nh, javax.swing.GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE)
                                    .addComponent(b_del_acc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(0, 95, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b_new_acc)
                    .addComponent(b_del_acc))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b_nc))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(b_up_cd)
                            .addComponent(b_up_nh))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(b_up_ca)
                            .addComponent(b_up_cc)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(tf_uci_cin, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(b_lc_p)
                            .addComponent(b_lc_c))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(b_lc_u))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(b_ccs)
                        .addComponent(tf_ccs_cin, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(71, 71, 71))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void b_up_cdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_up_cdActionPerformed
        // TODO add your handling code here:
        int _cin;
        try {
            _cin = getUCI_CIN();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(rapplet._mv_p, ex.getMessage());
            return ;
        }
        Case _ref = new Case(_cin);
        rapplet._newcase.setMode(NewCase.M_UC);
        rapplet._newcase.setHeading("Update Case Details");
        rapplet._newcase.populateInfo(_ref);
        rapplet.reset();
        rapplet._mainview.show(rapplet._mv_p, Main.M_NEWCASE);
    }//GEN-LAST:event_b_up_cdActionPerformed

    private void b_up_nhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_up_nhActionPerformed
        // TODO add your handling code here:
        int _cin ;
        try {
            _cin = getUCI_CIN();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(rapplet._mv_p, ex.getMessage());
            return ;
        }
        Case _ref = new Case(_cin);
        Calendar cal = Calendar.getInstance();
        Date today = new Date(cal.getTime().getTime());
        if(_ref.getHearing(_ref.getNoH()-1).getDoH().compareTo(today)>0) {
            JOptionPane.showMessageDialog(rapplet._mv_p, "The hearing has not yet been started!");
            return;
        }
        rapplet._updatehearing.setPrev(Main.M_REGVIEW);
        rapplet._updatehearing.setMode(UpdateHearing.M_ASP);
        rapplet._updatehearing.populateInfo(_ref);
        rapplet.reset();
        rapplet._mainview.show(rapplet._mv_p, Main.M_UPDATEH);
    }//GEN-LAST:event_b_up_nhActionPerformed

    private void b_up_caActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_up_caActionPerformed
        // TODO add your handling code here:
        int _cin ;
        try {
            _cin = getUCI_CIN();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(rapplet._mv_p, ex.getMessage());
            return ;
        }
        Case _ref = new Case(_cin);
        Calendar cal = Calendar.getInstance();
        Date today = new Date(cal.getTime().getTime());
        if(_ref.getHearing(_ref.getNoH()-1).getDoH().compareTo(today)>0) {
            JOptionPane.showMessageDialog(rapplet._mv_p, "The hearing has not yet been started!");
            return;
        }
        rapplet._updatehearing.setPrev(Main.M_REGVIEW);
        rapplet._updatehearing.setMode(UpdateHearing.M_AA);
        rapplet._updatehearing.populateInfo(_ref);
        rapplet.reset();
        rapplet._mainview.show(rapplet._mv_p, Main.M_UPDATEH);
    }//GEN-LAST:event_b_up_caActionPerformed

    private void b_up_ccActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_up_ccActionPerformed
        // TODO add your handling code here:
        int _cin ;
        try {
            _cin = getUCI_CIN();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(rapplet._mv_p, ex.getMessage());
            return ;
        }
        Case _ref = new Case(_cin);
        Calendar cal = Calendar.getInstance();
        Date today = new Date(cal.getTime().getTime());
        if(_ref.getHearing(_ref.getNoH()-1).getDoH().compareTo(today)>0) {
            JOptionPane.showMessageDialog(rapplet._mv_p, "The hearing has not yet been started!");
            return;
        }
        rapplet._updatehearing.setPrev(Main.M_REGVIEW);
        rapplet._updatehearing.setMode(UpdateHearing.M_ASC);
        rapplet._updatehearing.populateInfo(_ref);
        rapplet.reset();
        rapplet._mainview.show(rapplet._mv_p, Main.M_UPDATEH);
    }//GEN-LAST:event_b_up_ccActionPerformed

    private void b_lc_pActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_lc_pActionPerformed
        // TODO add your handling code here:
        rapplet._tableview.populateTable(User.searchCase(Case.CASE_PENDING));
        rapplet._tableview.setHeading("List of Pending Cases");
        rapplet.reset();
        rapplet._mainview.show(rapplet._mv_p, Main.M_TABVIEW);
    }//GEN-LAST:event_b_lc_pActionPerformed

    private void b_lc_cActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_lc_cActionPerformed
        // TODO add your handling code here:
        rapplet._tableview.populateTable(User.searchCase(Case.CASE_CLOSED));
        rapplet._tableview.setHeading("List of Closed Cases");
        rapplet.reset();
        rapplet._mainview.show(rapplet._mv_p, Main.M_TABVIEW);
    }//GEN-LAST:event_b_lc_cActionPerformed

    private void b_lc_uActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_lc_uActionPerformed
        // TODO add your handling code here:
        Date _strt = null; Date _end = null;
        
        JPanel inputPanel = new JPanel();
        GridBagLayout gbag = new GridBagLayout();
        GridBagConstraints gbc = new GridBagConstraints();
        inputPanel.setLayout(gbag);

        JTextField d1Field = new JTextField(15);
        JTextField d2Field = new JTextField(15);
        JLabel d1Label = new JLabel("Enter Start Date (yyyy-mm-dd) ");
        JLabel d2Label = new JLabel("Enter End Date (yyyy-mm-dd) ");
        JLabel heading = new JLabel("Enter Dates to Search");

        gbc.weighty = 5.0;
        gbc.insets = new Insets(15, 0, 15, 0);

        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.anchor = GridBagConstraints.NORTH;
        gbag.setConstraints(heading, gbc);

        gbc.gridwidth = GridBagConstraints.RELATIVE;
        gbag.setConstraints(d1Label, gbc);
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbag.setConstraints(d1Field, gbc);

        gbc.gridwidth = GridBagConstraints.RELATIVE;
        gbag.setConstraints(d2Label, gbc);
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbag.setConstraints(d2Field, gbc);

        inputPanel.add(heading);
        inputPanel.add(d1Label);
        inputPanel.add(d1Field);
        inputPanel.add(d2Label);
        inputPanel.add(d2Field);;

        int result = JOptionPane.showConfirmDialog(null, inputPanel, "Search Pending Cases", JOptionPane.OK_CANCEL_OPTION);
        
        if(result != JOptionPane.OK_OPTION)
            return;
        
        try{
            _strt = Date.valueOf(d1Field.getText());
            _end = Date.valueOf(d2Field.getText());
        }catch(Exception ex){
            JOptionPane.showMessageDialog(rapplet._mv_p, "Incorrect Input Format");
            return ;
        }
        
        rapplet._tableview.populateTable(User.searchCase(_strt,_end));
        rapplet._tableview.setHeading("List of Upcoming Cases");
        rapplet.reset();
        rapplet._mainview.show(rapplet._mv_p, Main.M_TABVIEW);
    }//GEN-LAST:event_b_lc_uActionPerformed

    private void b_ccsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_ccsActionPerformed
        // TODO add your handling code here:
        int _tcin = -1;
        try{
            _tcin = getCCS_CIN();
            JOptionPane.showMessageDialog(rapplet._mv_p, Case.getStatusStr(Case.getCaseStatus(_tcin)));
        }catch(Exception ex){
            JOptionPane.showMessageDialog(rapplet._mv_p, ex.getMessage());
        }
    }//GEN-LAST:event_b_ccsActionPerformed

    private void b_ncActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_ncActionPerformed
        // TODO add your handling code here:
        rapplet._newcase.clearAll();
        rapplet._newcase.setMode(NewCase.M_NC);
        rapplet._newcase.setHeading("New Case Entry");
        rapplet.reset();
        rapplet._mainview.show(rapplet._mv_p, Main.M_NEWCASE);
    }//GEN-LAST:event_b_ncActionPerformed

    private Main rapplet;

    public void setRA(Main _ra) {
        rapplet = _ra;
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton b_ccs;
    private javax.swing.JButton b_del_acc;
    private javax.swing.JButton b_lc_c;
    private javax.swing.JButton b_lc_p;
    private javax.swing.JButton b_lc_u;
    private javax.swing.JButton b_nc;
    private javax.swing.JButton b_new_acc;
    private javax.swing.JButton b_up_ca;
    private javax.swing.JButton b_up_cc;
    private javax.swing.JButton b_up_cd;
    private javax.swing.JButton b_up_nh;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField tf_ccs_cin;
    private javax.swing.JTextField tf_uci_cin;
    // End of variables declaration//GEN-END:variables

    public Integer getUCI_CIN() throws Exception {
        if(checkNo(tf_uci_cin.getText())) {
            int _tcin = Integer.parseInt(tf_uci_cin.getText()) ;
            Statement st2 = conn.createStatement();
            ResultSet rSet2 = st.executeQuery("SELECT * FROM JISS.CASE WHERE CIN = " + _tcin + " ;");
            if(rSet2.next()) return _tcin ;
            else throw new Exception("Invald CIN");
        }
        else throw new Exception("Invald CIN");
    }
    
    public Integer getCCS_CIN() throws Exception {
        if(checkNo(tf_ccs_cin.getText())) {
            int _tcin = Integer.parseInt(tf_ccs_cin.getText()) ;
            Statement st2 = conn.createStatement();
            ResultSet rSet2 = st.executeQuery("SELECT * FROM JISS.CASE WHERE CIN = " + _tcin + " ;");
            if(rSet2.next()) return _tcin ;
            else throw new Exception("Invald CIN");
        }
        else throw new Exception("Invald CIN");
    }
    
    public boolean checkNo(String _str){
        if(_str.equals("")) { System.err.println(_str + " response false"); return false; }
        for(int i=0;i<_str.length();i++){
            if(_str.charAt(i)<'0' || _str.charAt(i)>'9') { System.err.println(_str + " response false");  return false; }
        }
        System.err.println(_str + " response true"); 
        return true;
    }
    
    public void resetCaseLabel(){
        tf_ccs_cin.setText("");
        tf_uci_cin.setText("");
    }
}   
