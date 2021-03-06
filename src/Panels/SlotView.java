/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Panels;

import JISS.Case;
import JISS.Main;
import JISS.Scheduler;
import JISS.Slots;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.sql.Date;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author Sandesh
 */
public class SlotView extends javax.swing.JPanel {

    JLabel _lref[][] ;
    JLabel _ldref[];
    
    /**
     * Creates new form SlotView
     */
    public SlotView() {
        initComponents();
        _lref = new JLabel[5][5];
        _ldref = new JLabel[5];
        
        _lref[0][0] = l_1s1;
        _lref[0][1] = l_1s2;
        _lref[0][2] = l_1s3;
        _lref[0][3] = l_1s4;
        _lref[0][4] = l_1s5;

        _lref[1][0] = l_2s1;
        _lref[1][1] = l_2s2;
        _lref[1][2] = l_2s3;
        _lref[1][3] = l_2s4;
        _lref[1][4] = l_2s5;

        _lref[2][0] = l_3s1;
        _lref[2][1] = l_3s2;
        _lref[2][2] = l_3s3;
        _lref[2][3] = l_3s4;
        _lref[2][4] = l_3s5;

        _lref[3][0] = l_4s1;
        _lref[3][1] = l_4s2;
        _lref[3][2] = l_4s3;
        _lref[3][3] = l_4s4;
        _lref[3][4] = l_4s5;

        _lref[4][0] = l_5s1;
        _lref[4][1] = l_5s2;
        _lref[4][2] = l_5s3;
        _lref[4][3] = l_5s4;
        _lref[4][4] = l_5s5;
        
        _ldref[0] = l_d1;
        _ldref[1] = l_d2;
        _ldref[2] = l_d3;
        _ldref[3] = l_d4;
        _ldref[4] = l_d5;
        
        
        rapplet = null;
        _prev = null;
        _sval = new SVAL();
        
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                _lref[i][j].addMouseListener(_sval);
            }
        }
    }
    
    SVAL _sval ;
    
    public class SVAL extends MouseAdapter {

        public void mouseReleased(java.awt.event.MouseEvent evt) {
               String _prs = ((JLabel)evt.getSource()).getToolTipText();
               String _txt = ((JLabel)evt.getSource()).getText();
               
               if(_txt.equals("NA")) {
                   JOptionPane.showMessageDialog(rapplet._mv_p, "Sorry! the slot is Not Availabe(NA).");
                   return;
               }
               
                int i,j,k;
                k = _prs.indexOf("s");
                i = Integer.parseInt(_prs.substring(0, k));
                j = Integer.parseInt(_prs.substring(k+1));
                
                //System.err.println("H1 i : "+i+" j: "+j);
                
                Date _dos_n ;
                try{
                    _dos_n = Date.valueOf(_ldref[i].getText());
                }catch(Exception ex){
                    System.err.println(ex.getMessage());
                    return; 
                }

                //System.err.println("H2");
                
                if(_mode.equals(M_NC)){
                    Case _cref = rapplet._newcase.createCase(_dos_n);
                   try {
                       _cref.addHearing(_dos_n,j+1);
                       //System.err.println("Hearing no + " + _cref.getNoH() + " added to case no " + _cref.getCIN());
                   } catch (Exception ex) {
                       System.err.println(ex.getMessage());
                   }
                    String _str;
                    _str = "New Case Succesfully created\nCase CIN : "+_cref.getCIN() +"\nDate of Start : "+_dos_n.toString() ;
                    JOptionPane.showMessageDialog(rapplet._mv_p,_str);
                    rapplet.reset();
                    rapplet._mainview.show(rapplet._mv_p, Main.M_REGVIEW);
                }else if(_mode.equals(M_NH)){
                    try {
                        rapplet._updatehearing._cref.addHearing(_dos_n,j+1);
                    } catch (Exception ex) {
                        System.err.println(ex.getMessage());
                    }
                    JOptionPane.showMessageDialog(rapplet._mv_p,"Successfully Scheeduled NEW Hearing");
                    rapplet._updatehearing.setLSnh(UpdateHearing._csdone);
                    rapplet.reset();
                    rapplet._mainview.show(rapplet._mv_p, Main.M_UPDATEH);
                }
                
               // System.err.println("H3");
        }
        
    }
    
    String _mode;
    
    public static final String M_NC = "new_case";
    public static final String M_NH = "new_hearing";
    
    public void setMode(String _m_n){
        _mode = _m_n;
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
        b_close = new javax.swing.JButton();
        b_back = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        l_d1 = new javax.swing.JLabel();
        l_d2 = new javax.swing.JLabel();
        l_d3 = new javax.swing.JLabel();
        l_d4 = new javax.swing.JLabel();
        l_d5 = new javax.swing.JLabel();
        l_1s1 = new javax.swing.JLabel();
        l_1s2 = new javax.swing.JLabel();
        l_1s3 = new javax.swing.JLabel();
        l_1s4 = new javax.swing.JLabel();
        l_1s5 = new javax.swing.JLabel();
        l_2s1 = new javax.swing.JLabel();
        l_2s2 = new javax.swing.JLabel();
        l_2s3 = new javax.swing.JLabel();
        l_2s4 = new javax.swing.JLabel();
        l_2s5 = new javax.swing.JLabel();
        l_3s1 = new javax.swing.JLabel();
        l_3s2 = new javax.swing.JLabel();
        l_3s3 = new javax.swing.JLabel();
        l_3s4 = new javax.swing.JLabel();
        l_3s5 = new javax.swing.JLabel();
        l_4s1 = new javax.swing.JLabel();
        l_4s2 = new javax.swing.JLabel();
        l_4s3 = new javax.swing.JLabel();
        l_4s4 = new javax.swing.JLabel();
        l_4s5 = new javax.swing.JLabel();
        l_5s1 = new javax.swing.JLabel();
        l_5s2 = new javax.swing.JLabel();
        l_5s3 = new javax.swing.JLabel();
        l_5s4 = new javax.swing.JLabel();
        l_5s5 = new javax.swing.JLabel();

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 153, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Schedule a Hearing for the Case");

        b_close.setText("x");
        b_close.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_closeActionPerformed(evt);
            }
        });

        b_back.setText("<");
        b_back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_backActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Dates");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Slots");

        l_1s1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        l_1s1.setToolTipText("0s0");
        l_1s1.setOpaque(true);

        l_1s2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        l_1s2.setToolTipText("0s1");
        l_1s2.setOpaque(true);

        l_1s3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        l_1s3.setToolTipText("0s2");
        l_1s3.setOpaque(true);

        l_1s4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        l_1s4.setToolTipText("0s3");
        l_1s4.setOpaque(true);

        l_1s5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        l_1s5.setToolTipText("0s4");
        l_1s5.setOpaque(true);

        l_2s1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        l_2s1.setToolTipText("1s0");
        l_2s1.setOpaque(true);

        l_2s2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        l_2s2.setToolTipText("1s1");
        l_2s2.setOpaque(true);

        l_2s3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        l_2s3.setToolTipText("1s2");
        l_2s3.setOpaque(true);

        l_2s4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        l_2s4.setToolTipText("1s3");
        l_2s4.setOpaque(true);

        l_2s5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        l_2s5.setToolTipText("1s4");
        l_2s5.setOpaque(true);

        l_3s1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        l_3s1.setToolTipText("2s0");
        l_3s1.setOpaque(true);

        l_3s2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        l_3s2.setToolTipText("2s1");
        l_3s2.setOpaque(true);

        l_3s3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        l_3s3.setToolTipText("2s2");
        l_3s3.setOpaque(true);

        l_3s4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        l_3s4.setToolTipText("2s3");
        l_3s4.setOpaque(true);

        l_3s5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        l_3s5.setToolTipText("2s4");
        l_3s5.setOpaque(true);

        l_4s1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        l_4s1.setToolTipText("3s0");
        l_4s1.setOpaque(true);

        l_4s2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        l_4s2.setToolTipText("3s1");
        l_4s2.setOpaque(true);

        l_4s3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        l_4s3.setToolTipText("3s2");
        l_4s3.setOpaque(true);

        l_4s4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        l_4s4.setToolTipText("3s3");
        l_4s4.setOpaque(true);

        l_4s5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        l_4s5.setToolTipText("3s4");
        l_4s5.setOpaque(true);

        l_5s1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        l_5s1.setToolTipText("4s0");
        l_5s1.setOpaque(true);

        l_5s2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        l_5s2.setToolTipText("4s1");
        l_5s2.setOpaque(true);

        l_5s3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        l_5s3.setToolTipText("4s2");
        l_5s3.setOpaque(true);

        l_5s4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        l_5s4.setToolTipText("4s3");
        l_5s4.setOpaque(true);

        l_5s5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        l_5s5.setToolTipText("4s4");
        l_5s5.setOpaque(true);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(b_back)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(b_close, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(l_d5, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(l_5s1, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(l_5s2, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(l_5s3, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(l_5s4, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(l_5s5, javax.swing.GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(l_d1, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(l_1s1, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(l_1s2, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(l_1s3, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(l_1s4, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(l_1s5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(l_d2, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(l_2s1, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(l_2s2, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(l_2s3, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(l_2s4, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(l_2s5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(l_d3, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(l_3s1, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(l_3s2, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(l_3s3, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(l_3s4, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(l_3s5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(l_d4, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(l_4s1, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(l_4s2, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(l_4s3, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(l_4s4, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(l_4s5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(b_close)
                        .addComponent(b_back)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(l_1s5, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                    .addComponent(l_d1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(l_1s3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(l_1s4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(l_1s1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(l_1s2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(l_d2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(l_2s5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(l_2s1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(l_2s2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(l_2s3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(l_2s4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addComponent(l_d3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(l_3s5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(l_3s1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(l_3s2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(l_3s3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(l_3s4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(l_d4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(l_4s5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(l_4s1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(l_4s2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(l_4s3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(l_4s4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(l_d5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(l_5s5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(l_5s1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(l_5s2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(l_5s3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(l_5s4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(88, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void b_backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_backActionPerformed
        // TODO add your handling code here:
        rapplet.reset();
        rapplet._mainview.show(rapplet._mv_p, _prev);
    }//GEN-LAST:event_b_backActionPerformed

    private void b_closeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_closeActionPerformed
        // TODO add your handling code here:
        rapplet.reset();
        rapplet._mainview.show(rapplet._mv_p, Main.M_REGVIEW);
    }//GEN-LAST:event_b_closeActionPerformed
    

    Main rapplet;
    public void setRA(Main _ra) {
        rapplet = _ra;
    }
    
    public void upSlots(){
        Slots[] _slots = Scheduler.getSlots();
        
        for(int i=0;i<5;i++){
            _ldref[i].setText(_slots[i].getDate());
            for(int j=0;j<5;j++){
                _lref[i][j].setText(getAC(_slots[i].getAC(j)));
                _lref[i][j].setBackground(getColor(_slots[i].getAC(j)));
            }
        }
    }
    
    public String getAC(boolean b){
        if(b) return "AV";
        else return "NA";
    }
    
    public Color getColor(boolean b){
        if(b) return Color.GREEN;
        else return Color.RED;
    }
    
    private String _prev;
    
    public void setPrev(String _prev_i){
        _prev = _prev_i ;
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton b_back;
    private javax.swing.JButton b_close;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel l_1s1;
    private javax.swing.JLabel l_1s2;
    private javax.swing.JLabel l_1s3;
    private javax.swing.JLabel l_1s4;
    private javax.swing.JLabel l_1s5;
    private javax.swing.JLabel l_2s1;
    private javax.swing.JLabel l_2s2;
    private javax.swing.JLabel l_2s3;
    private javax.swing.JLabel l_2s4;
    private javax.swing.JLabel l_2s5;
    private javax.swing.JLabel l_3s1;
    private javax.swing.JLabel l_3s2;
    private javax.swing.JLabel l_3s3;
    private javax.swing.JLabel l_3s4;
    private javax.swing.JLabel l_3s5;
    private javax.swing.JLabel l_4s1;
    private javax.swing.JLabel l_4s2;
    private javax.swing.JLabel l_4s3;
    private javax.swing.JLabel l_4s4;
    private javax.swing.JLabel l_4s5;
    private javax.swing.JLabel l_5s1;
    private javax.swing.JLabel l_5s2;
    private javax.swing.JLabel l_5s3;
    private javax.swing.JLabel l_5s4;
    private javax.swing.JLabel l_5s5;
    private javax.swing.JLabel l_d1;
    private javax.swing.JLabel l_d2;
    private javax.swing.JLabel l_d3;
    private javax.swing.JLabel l_d4;
    private javax.swing.JLabel l_d5;
    // End of variables declaration//GEN-END:variables
}
