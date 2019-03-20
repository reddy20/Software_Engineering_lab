/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package JISS;

import Panels.CaseInfo;
import Panels.LoginPanel;
import Panels.NewCase;
import Panels.RegView;
import Panels.SearchPanel;
import Panels.SlotView;
import Panels.TableView;
import Panels.UpdateHearing;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author 
 */
public class Main extends JFrame {
    
    public CaseInfo _caseinfo;
    public LoginPanel _loginpanel ;
    public RegView _regview ;
    public SearchPanel _searchpanel ;
    public TableView _tableview ;
    public UpdateHearing _updatehearing;
    public NewCase _newcase;
    public SlotView _slotview;
    public CardLayout _sideview ;
    public CardLayout _mainview ;
    public JPanel _sv_p ;
    public JPanel _mv_p ;
    
    public static String S_LOGIN = "card2";
    public static String S_USER = "card3";
    
    public static String M_CASEINFO = "mainview_login";
    public static String M_REGVIEW = "mainview_reg";
    public static String M_SEARCH = "mainview_search";
    public static String M_UPDATEH = "mainview_update";
    public static String M_TABVIEW = "mainview_table";
    public static String M_BLANK = "card2";
    public static String M_SLOTVIEW = "mainview_slots";
    public static String M_NEWCASE = "mainview_newcase";
    
    public static Connection conn = null;
    public static Statement st = null;
    public static PreparedStatement prepSt = null;
    public static ResultSet rSet = null;
    
    
    /**
     * Initialization method that will be called after the applet is loaded into
     * the browser.
     */
    Main () {
            super("JISS");
            try {
                try {
                    for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                        if ("Nimbus".equals(info.getName())) {
                            javax.swing.UIManager.setLookAndFeel(info.getClassName());
                            break;
                        }
                    }
                } catch (ClassNotFoundException ex) {
                    java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                } catch (InstantiationException ex) {
                    java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                } catch (IllegalAccessException ex) {
                    java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                } catch (javax.swing.UnsupportedLookAndFeelException ex) {
                    java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                }
                
            this.setLayout(new BorderLayout());
            JLabel back = new JLabel();
                System.err.println(getClass());
            back.setIcon(new javax.swing.ImageIcon(getClass().getResource("/JISS/backgrnd4.JPG"))); // NOI18N
//            JLabel back = new JLabel(new ImageIcon(ImageIO.read(getClass().getResource("/icons/backgrnd4.JPG")).getScaledInstance(880, 540, java.awt.Image.SCALE_SMOOTH)));
            this.setContentPane(back);
            this.setLayout(new FlowLayout());
            
            // TODO start asynchronous download of heavy resources
            _caseinfo = new CaseInfo();
            _loginpanel = new LoginPanel();
            _regview = new RegView();
            _searchpanel = new SearchPanel();
            _tableview = new TableView();
            _updatehearing = new UpdateHearing();
            _newcase = new NewCase();
            _slotview = new SlotView();
            
            _caseinfo.setRA(this);
            _loginpanel.setRA(this);
            _regview.setRA(this);
            _searchpanel.setRA(this);
            _tableview.setRA(this);
            _updatehearing.setRA(this);
            _newcase.setRA(this);
            _slotview.setRA(this);
            
            _caseinfo.setBackground(new Color(255,255,255,100));
            _regview.setBackground(new Color(255,255,255,100));
            _searchpanel.setBackground(new Color(255,255,255,100));
            _tableview.setBackground(new Color(255,255,255,100));
            _updatehearing.setBackground(new Color(255,255,255,100));
            _newcase.setBackground(new Color(255,255,255,100));
            _slotview.setBackground(new Color(255,255,255,100));
            
            try {
                Class.forName("com.mysql.jdbc.Driver");
                conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql","root", "mysql");
            } catch (SQLException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                st = conn.createStatement();
                rSet = st.executeQuery("SELECT MAX(cin) FROM JISS.Case;");
                if(rSet.next()) Case.setNoC(rSet.getInt("MAX(cin)") + 1);
            } catch(SQLException e) {
                Case.setNoC(0);
                System.err.println("Error setting id for case");
            }          
              
            this.add(_loginpanel);
            this.setVisible(true);
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.pack();
            
        } catch (Exception ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
              
    }
    
    public void reset(){
        _regview.resetCaseLabel();
//        this.setSize(950, 650);
//        this.setSize(900, 600);
        this.repaint();
        this.pack();
        //this.setResizable(false);
    }    
    
    public static void main(String[] args) {
        new Main();
    }
    
}
