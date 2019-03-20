
package JISS;

import static JISS.Main.conn;
import static JISS.Main.prepSt;
import java.sql.SQLException;

public class Registrar extends User {
    final static int USER_ID = 0;
    
    public Registrar() {
        super(User.REGISTRAR, USER_ID);
    }
    
    public void createAccount(int userType, int id, String name, char[] passwd) {
        User u = null;
        switch(userType) {
            case User.JUDGE:
                u = new Judge(name,passwd);
                break;
            case User.LAWYER:
                u = new Lawyer(name,passwd);
                break;
        }
        if(u != null) {
            u.setName(name);
            try {
                prepSt = conn.prepareStatement("INSERT INTO JISS.User VALUES (?, ?, ?, ?)");
                prepSt.setInt(1, u.getID());
                prepSt.setInt(2, u.getType());
                prepSt.setString(3, name);
                prepSt.setString(4, new String(passwd));
                prepSt.executeUpdate();
            } catch(SQLException e) {
                System.err.println("Unable to create new User");
            }
        }
    }
    
    public void deleteAccount(User u) {
        try {
            System.err.println("Trying to delete type " + u.getStrType() + " id " + u.getID());
            if(u.getID() == User.LAWYER) {
                prepSt = conn.prepareStatement("DELETE FROM JISS.LawyersCases WHERE lawyer = " + u.getID() + ";");
                prepSt.executeUpdate();
            }
            prepSt = conn.prepareStatement("DELETE FROM JISS.User WHERE type = " + u.getType() + " AND id = " + u.getID() + " ;");
            prepSt.executeUpdate();
        } catch(SQLException e) {
            System.err.println("Unable to delete the user");
        }
    }
    
//    public void updateCaseInfo(Case updated) {
//        //change in the table
//    }
    
//    public int checkCaseStatus(int caseID) {
//        return 0;
//    }
}
