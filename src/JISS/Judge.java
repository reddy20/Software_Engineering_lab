
package JISS;

public class Judge extends User {
    
    public Judge(int id) {
        super(User.JUDGE, id);
    }
    
    public Judge(String _name,char[] passwd) {
        super(User.JUDGE, passwd,_name);
    }
    
}
