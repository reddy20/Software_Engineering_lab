/*
 * This has the implementation of the abstract class USER
*/

package JISS;

import static JISS.Main.conn;
import static JISS.Main.prepSt;
import static JISS.Main.rSet;
import static JISS.Main.st;
import Panels.LoginPanel;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;

public abstract class User {
    public final static int REGISTRAR = 0;
    public final static int LAWYER = 1;
    public final static int JUDGE = 2;
    
    final static int LOGGED_IN = 3;
    final static int LOGGED_OUT = 4;
    
    private int ID;
    private int userType;
    private int status;
    private String name;
    private String password;
    
    // For login purposes
    public User(int type, int id) {
        this.userType = type;
        this.ID = id;
        this.status = User.LOGGED_OUT;
        try {
            st = conn.createStatement();
            rSet = st.executeQuery("SELECT * FROM JISS.User WHERE type = " + type + " AND id = " + id + ";");
            if(rSet.next()) {
                System.err.println("User Found");
                this.name = rSet.getString("name");
                this.password = rSet.getString("password");
            } else {
                System.err.println("No user found");
            }
        } catch(SQLException e) {
            System.err.println("Error loading data of User.");
        }
    }
    
    // For creating new user 
    public User(int type, char[] passwd,String _name) {
        this.userType = type;
        this.password = new String(passwd);
        this.name = _name ;
        this.status = LOGGED_OUT;
        try {
            st = conn.createStatement();
            rSet = st.executeQuery("SELECT * FROM JISS.User WHERE type = " + userType + " ORDER BY id;");
            this.ID = 0;
            while (rSet.next()) {
                if (rSet.getInt("id") != this.ID) {
                    break;
                } else {
                    this.ID += 1;
                }
            }
            prepSt = conn.prepareStatement("INSERT INTO JISS.User VALUES ( ?, ?, ?, ?);");
            prepSt.setString(1, Integer.toString(this.getID()));
            prepSt.setString(2, Integer.toString(this.getType()));
            prepSt.setString(3, this.getName());
            prepSt.setString(4, new String(passwd));
            prepSt.executeUpdate();
        } catch (SQLException sq) {
            System.err.println("Unable to generate id for user");
            throw new Error(sq);
        }
    }
    
    public int getID() {
        return this.ID;
    }
    
    public String getName() {
        return this.name;
    }
    
    public int getType() {
        return this.userType;
    }
    
    public void setID(int id) {
        this.ID = id;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public boolean validateLogin(char[] password) {
        String passwd = new String(password);
        System.err.println("Actual password = " + this.password + " entered " + passwd);
        if(passwd.compareTo(this.password) == 0) {
            this.status = User.LOGGED_IN;
            return true;
        }
        return false;
    }
    
    public int getLoginStatus() {
        return this.status;
    }
    
    public void setLoginStatus(int status) {
        this.status = status;
    }
    public String getStrType() {
        switch(this.userType) {
            case 0:
                return "R";
            case 1:
                return "L";
            case 2:
                return "J";
        }
        return "";
    }
    
    public static int parse(String str) {
        if(str.equals("R") || str.equals("r"))
            return 0;
        if(str.equals("L") || str.equals("l"))
            return 1;
        if(str.equals("J") || str.equals("j"))
            return 2;
        return 5;
    }

    public static ArrayList<Case> searchCase(ArrayList<String> AL_keyWord) {
        ArrayList<Case> listCases = new ArrayList<>();
        String _str = "SELECT cin,status FROM JISS.Case WHERE ";
        HashSet<Integer> hs = new HashSet<>();

        if (AL_keyWord.size() < 1) {
            return listCases;
        }

        for (int i = 0; i < AL_keyWord.size(); i++) {
            String keyWord = "'%" + AL_keyWord.get(i) + "%'";
            System.err.println("Search " + keyWord);
            _str += "( ";

            _str += "cin LIKE " + keyWord
                    + " OR CONVERT(start_date using utf8) LIKE " + keyWord
                    + " OR defender_name LIKE " + keyWord
                    + " OR defender_address LIKE " + keyWord
                    + " OR lawyer LIKE " + keyWord
                    + " OR public_prosecutor LIKE " + keyWord
                    + " OR judge LIKE " + keyWord
                    + " OR summary LIKE " + keyWord
                    + " OR CONVERT(resolve_date using utf8) LIKE " + keyWord;

            _str += " )";
            if (i != AL_keyWord.size() - 1) {
                _str += " AND ";
            } else {
                _str += ";";
            }
        }

        System.err.println("Query " + _str);
        try {
            st = conn.createStatement();
            rSet = st.executeQuery(_str);

            while (rSet.next()) {
                if (LoginPanel.getCUT() == REGISTRAR) {
                    hs.add(rSet.getInt("cin"));
                } else {
                    if (rSet.getInt("status") == Case.CASE_CLOSED) {
                        hs.add(rSet.getInt("cin"));
                    }
                }
            }

        } catch (SQLException e) {
            System.err.println("Error in searching case");
            throw new Error(e);
        }

        _str = "SELECT id FROM JISS.Crime WHERE ";
        for (int i = 0; i < AL_keyWord.size(); i++) {
            String keyWord = "'%" + AL_keyWord.get(i) + "%'";
            System.err.println("Search " + keyWord);
            _str += "( ";

            _str += "CONVERT(crime_date using utf8) LIKE " + keyWord
                    + " OR officer LIKE " + keyWord
                    + " OR type LIKE " + keyWord
                    + " OR location LIKE " + keyWord
                    + " OR CONVERT(crime_date using utf8) LIKE " + keyWord;

            _str += " )";
            if (i != AL_keyWord.size() - 1) {
                _str += " AND ";
            } else {
                _str += ";";
            }
        }

        System.err.println("Query " + _str);
        try {
            st = conn.createStatement();
            rSet = st.executeQuery(_str);

            while (rSet.next()) {
                int _id = rSet.getInt("id");
                Statement tst = conn.createStatement();
                ResultSet trSet = tst.executeQuery("SELECT cin,status from JISS.case where crime_detail = " + _id + " ;");
                System.err.println("Query " + "SELECT cin,status from JISS.case where crime_detail = " + _id + " ;");
                trSet.next();
                if (LoginPanel.getCUT() == REGISTRAR) {
                    hs.add(trSet.getInt("cin"));
                } else {
                    if (trSet.getInt("status") == Case.CASE_CLOSED) {
                        hs.add(trSet.getInt("cin"));
                    }
                }
            }

        } catch (SQLException e) {
            System.err.println("Error in searching case");
            throw new Error(e);
        }

        System.err.println(listCases.size());
        for (Integer _it : hs) {
            System.err.println("Case found : " + _it);
            listCases.add(new Case(_it));
        }
        System.err.println(listCases.size());
        return listCases;
    }   
    
    public static ArrayList <Case> searchCase(int _status) {
        ArrayList <Case> listCases = new ArrayList<>();
        try {
            st = conn.createStatement();
            rSet = st.executeQuery("SELECT * FROM JISS.Case WHERE status = " + _status + ";");
            
            while(rSet.next()){
                listCases.add(new Case(rSet.getInt("cin")));
            }

        } catch(SQLException e) {
            System.err.println("Error in searching case");
        }
        return listCases;
    } 
    
    public static ArrayList <Case> searchCase(Date _strt , Date _end) {
        ArrayList <Case> listCases = new ArrayList<>();
        try {
            st = conn.createStatement();
            rSet = st.executeQuery("SELECT * FROM JISS.Hearing WHERE date  >= '" + _strt.toString() + "' "
                                    + " AND  date  <= '" + _end.toString() + "' ;");
            
            while(rSet.next()){
                listCases.add(new Case(rSet.getInt("case_id")));
            }

        } catch(SQLException e) {
            throw new Error(e);
        }
        return listCases;
    } 
}