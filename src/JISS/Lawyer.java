package JISS;

import static JISS.Main.conn;
import static JISS.Main.prepSt;
import static JISS.Main.st;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Lawyer extends User {
    
    private double charges;
    private HashSet <Integer> listOfCases;
    
    public Lawyer(String _name,char[] passwd) {
        super(User.LAWYER, passwd,_name);
    }
    
    public Lawyer(int id) {
        super(User.LAWYER, id);
        try {
            this.charges = 0.0;
            this.listOfCases = new HashSet<>();
            
            Statement st2 = conn.createStatement() ;
            ResultSet rSet2 = st.executeQuery("SELECT * from JISS.lawyerscases where lawyer = "+id+" ;");
            while(rSet2.next()){
                addToCharge(250.00);
                listOfCases.add(rSet2.getInt("courtcase"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Lawyer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public boolean searchInList(int _cin){
        if(listOfCases.contains(_cin)) return true;
        return false;
    }
    
    public double getCharges() {
        return this.charges;
    }
    
    public void addToCharge(double amount) {
        this.charges += amount;
    }
    
    public int[] getListOfCases() {
        int ret[] = new int[listOfCases.size()];
        int sz = 0;
        for(int caseid : listOfCases)
            ret[sz++] = caseid;
        return ret;            
    }
    
    public int getLOCSize(){
        return listOfCases.size();
    }
    
    public void addToList(int caseID) {
        this.listOfCases.add(caseID);
        try {
            prepSt = conn.prepareStatement("INSERT INTO JISS.LawyersCases (lawyer,courtcase) VALUES ( ? , ?);");
            prepSt.setInt(1, this.getID());
            prepSt.setInt(2, caseID);
            prepSt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Lawyer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
}
