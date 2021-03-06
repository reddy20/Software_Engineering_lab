/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Panels;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableModel;
import JISS.Case;
import JISS.Lawyer;
import JISS.Main;
import JISS.User;
import java.awt.Color;
import java.awt.Dimension;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;

/**
 *
 * @author Sandesh
 */
public class SearchPanel extends javax.swing.JPanel {
    
    private ArrayList<String> _lok ;
    private ArrayList<Case> _rloc;
    /**
     * Creates new form SearchPanel
     */
    public SearchPanel() {
        initComponents();
        _lok = new ArrayList<>();
        _rloc = null ;
        sp_losk.setPreferredSize(new Dimension(580,44));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        l_heading = new javax.swing.JLabel();
        b_close = new javax.swing.JButton();
        sp_losk = new javax.swing.JScrollPane();
        sp_losk_p = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        tf_keyword = new javax.swing.JTextField();
        b_search = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        t_search_results = new javax.swing.JTable();

        l_heading.setFont(new java.awt.Font("Times New Roman", 0, 36)); // NOI18N
        l_heading.setForeground(new java.awt.Color(51, 153, 255));
        l_heading.setText("Search_Heading");

        b_close.setText("x");
        b_close.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_closeActionPerformed(evt);
            }
        });

        sp_losk.setBackground(new Color(255,255,255,100));
        sp_losk.setBorder(null);
        sp_losk.setMaximumSize(new java.awt.Dimension(580, 44));
        sp_losk.addMouseWheelListener(new java.awt.event.MouseWheelListener() {
            public void mouseWheelMoved(java.awt.event.MouseWheelEvent evt) {
                sp_loskMouseWheelMoved(evt);
            }
        });

        sp_losk_p.setBackground(new Color(255,255,255,100));
        sp_losk_p.setAutoscrolls(true);
        sp_losk_p.setMaximumSize(new java.awt.Dimension(580, 44));
        sp_losk_p.addHierarchyBoundsListener(new java.awt.event.HierarchyBoundsListener() {
            public void ancestorMoved(java.awt.event.HierarchyEvent evt) {
                sp_losk_pAncestorMoved1(evt);
            }
            public void ancestorResized(java.awt.event.HierarchyEvent evt) {
            }
        });
        sp_losk_p.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
                sp_losk_pAncestorMoved(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
            }
        });
        sp_losk_p.setLayout(new javax.swing.BoxLayout(sp_losk_p, javax.swing.BoxLayout.LINE_AXIS));
        sp_losk.setViewportView(sp_losk_p);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Search For :");

        tf_keyword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_keywordActionPerformed(evt);
            }
        });

        b_search.setText("Search");
        b_search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_searchActionPerformed(evt);
            }
        });

        jScrollPane2.setBackground(new Color(255,255,255,100));

        t_search_results.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CIN", "Date of Start", "Description", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                true, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        t_search_results.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                t_search_resultsMouseReleased(evt);
            }
        });
        jScrollPane2.setViewportView(t_search_results);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(sp_losk, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(l_heading, javax.swing.GroupLayout.PREFERRED_SIZE, 367, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tf_keyword, javax.swing.GroupLayout.DEFAULT_SIZE, 393, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(b_search, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(51, 51, 51)
                                .addComponent(b_close)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(b_close)
                    .addComponent(l_heading, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(b_search, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_keyword, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sp_losk, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 335, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void t_search_resultsMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t_search_resultsMouseReleased
        // TODO add your handling code here:
        Case _ref = null ;
        DefaultTableModel dm = (DefaultTableModel) t_search_results.getModel() ;
        int _tcin = (Integer) dm.getValueAt(t_search_results.getSelectedRow(),0);
        for(Case _tref : _rloc) if(_tref.getCIN()==_tcin) { _ref = _tref; break; }
        
        rapplet._caseinfo.setPrev(Main.M_SEARCH);
        rapplet._caseinfo.setMode(CaseInfo.M_VC);
        rapplet._caseinfo.populateInfo(_ref);
        if(rapplet._loginpanel.getCUT()==User.LAWYER) {
            
            try {
                Lawyer _cu = (Lawyer) rapplet._loginpanel.getCU();
                if(!_cu.searchInList(_ref.getCIN())){
                    double _chrg = _cu.getCharges() ;
                    int _ret = JOptionPane.showConfirmDialog(rapplet._mv_p,"Your current charges are "
                            + _chrg + "\nAfter viewing this case " + (_chrg+250.00) + 
                             "\n Do you want to proceed ? ");
                    if(_ret==JOptionPane.YES_OPTION){
                        _cu.addToCharge(250.00);
                        _cu.addToList(_ref.getCIN());
                    }
                }
            } catch (Exception ex) {
                System.err.println(ex.getMessage());
            }
            
            rapplet.reset();
            rapplet._mainview.show(rapplet._mv_p, Main.M_CASEINFO);
            
        }else {
            rapplet.reset();
            rapplet._mainview.show(rapplet._mv_p, Main.M_CASEINFO);
        }
    }//GEN-LAST:event_t_search_resultsMouseReleased

    private void b_closeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_closeActionPerformed
        // TODO add your handling code here:
        rapplet.reset();
        if(rapplet._loginpanel.getCUT()==User.JUDGE || rapplet._loginpanel.getCUT()==User.LAWYER) 
            rapplet._mainview.show(rapplet._mv_p, Main.M_BLANK);
        else rapplet._mainview.show(rapplet._mv_p, Main.M_REGVIEW);
    }//GEN-LAST:event_b_closeActionPerformed

    private void b_searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_searchActionPerformed
        // TODO add your handling code here:
        String _tmp = getKeyword() ; 
        tf_keyword.setText("");
        if(!_tmp.equals("")) { addKeyword(_tmp); }
        else JOptionPane.showMessageDialog(rapplet._mv_p, "Please enter a keyword to search.");
    }//GEN-LAST:event_b_searchActionPerformed

    private void tf_keywordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_keywordActionPerformed
        // TODO add your handling code here:
        b_searchActionPerformed(evt);
    }//GEN-LAST:event_tf_keywordActionPerformed

    private void sp_loskMouseWheelMoved(java.awt.event.MouseWheelEvent evt) {//GEN-FIRST:event_sp_loskMouseWheelMoved
        // TODO add your handling code here:
        rapplet.reset();
        sp_losk_p.repaint();
        sp_losk.repaint();
    }//GEN-LAST:event_sp_loskMouseWheelMoved

    private void sp_losk_pAncestorMoved(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_sp_losk_pAncestorMoved
        // TODO add your handling code here:
        rapplet.reset();
        sp_losk_p.repaint();
        sp_losk.repaint();
    }//GEN-LAST:event_sp_losk_pAncestorMoved

    private void sp_losk_pAncestorMoved1(java.awt.event.HierarchyEvent evt) {//GEN-FIRST:event_sp_losk_pAncestorMoved1
        // TODO add your handling code here:
        rapplet.reset();
        sp_losk_p.repaint();
        sp_losk.repaint();
    }//GEN-LAST:event_sp_losk_pAncestorMoved1

    private Main rapplet;

    public void setRA(Main _ra) {
        rapplet = _ra;
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton b_close;
    private javax.swing.JButton b_search;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel l_heading;
    private javax.swing.JScrollPane sp_losk;
    private javax.swing.JPanel sp_losk_p;
    private javax.swing.JTable t_search_results;
    private javax.swing.JTextField tf_keyword;
    // End of variables declaration//GEN-END:variables
    
    public void setHeading(String _h){
        l_heading.setText(_h);
    }
    
    public void clearTable(){
        DefaultTableModel dm = (DefaultTableModel) t_search_results.getModel();
        dm.setRowCount(0);
        rapplet.reset();
    }
    
    public void populateTable(ArrayList<Case> _loc){
        clearTable();
        _rloc = _loc ;
        DefaultTableModel _dtm = (DefaultTableModel) t_search_results.getModel();
        for (Case _ctmp : _loc) {
            Case.Crime _cdtmp = _ctmp.getCrime();
            _dtm.addRow(new Object[]{_ctmp.getCIN(),_ctmp.getDoS().toString(),
                _cdtmp.getCT()+","+_cdtmp.getLoC()+","+_cdtmp.getCoC().toString(),
                _ctmp.getStatusString()});
        }
        rapplet.reset();
    }
    
    
    public String getKeyword(){
        String _tmp = tf_keyword.getText() ;
        return _tmp;
    }
    
    public void addKeyword(String _kw){
        
        if(!_lok.contains(_kw)){
            _lok.add(_kw);

            JLabel _l = new JLabel(_kw) ;
            _l.setHorizontalAlignment(JLabel.CENTER); _l.setSize(35, 35); _l.setOpaque(true);
            _l.setBackground(new Color(51,153,255,100));
            JButton _b = new JButton("x") ;
            sp_losk_p.add(_l);
            sp_losk_p.add(_b);
            sp_losk.repaint();
            
            _b.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    JButton _b = (JButton) e.getSource();
                    Component[] _cmp = sp_losk_p.getComponents();
                    
                    int i = 0;
                    for(i=0;i<_cmp.length;i++) if(_cmp[i].equals(_b)) break;
                    
                    JLabel _l = (JLabel) _cmp[i-1];
                    _lok.remove(_l.getText());
                    sp_losk_p.remove(_l);
                    sp_losk_p.remove(_b);
                    populateTable(User.searchCase(_lok));
                    rapplet.reset();
                }
            });
           
            populateTable(User.searchCase(_lok));
        }
    }
    
    public void clearSearchPane(){
        Component[] comp = sp_losk_p.getComponents() ;
        for(Component _ctmp : comp){
            sp_losk_p.remove(_ctmp);
        }
    }
    
    public void initialize(String _hd){
        setHeading(_hd);
        clearTable();
        clearSearchPane();
        _lok.clear();
    }
    
}
