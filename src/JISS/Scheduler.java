
package JISS;

import static JISS.Main.conn;
import static JISS.Main.rSet;
import static JISS.Main.st;
import java.sql.Date;
import java.sql.SQLException;
import java.util.Calendar;


/*
 * Slots and Time
 * 0 ->  9:00 - 10:00 
 * 1 -> 10:00 - 11:00
 * 2 -> 14:00 - 15:00
 * 3 -> 15:00 - 16:00
 * 4 -> 16:00 - 17:00
*/

public class Scheduler {
    
    public static final int[] getStartingTime = {9, 10, 14, 15, 16};
    
    public static Slots[] getSlots() {
        Slots[] ret = new Slots[5];
        try {
            Calendar cal = Calendar.getInstance();
            Date strt = new Date(cal.getTime().getTime());
            int size =0;
            
            String date = "'" + strt.toString() + "'";
            st = conn.createStatement();
            rSet = st.executeQuery("SELECT * FROM JISS.Hearing WHERE date >= " + date + " ORDER BY date;");
            System.err.println("SELECT * FROM JISS.Hearing WHERE date >= " + date + " ORDER BY date;");
            Calendar tmp = Calendar.getInstance();
            Date cur = new Date(tmp.getTime().getTime());
            Slots curSlot = new Slots(new Date(cur.getTime()));
            
            boolean b = rSet.next();
            if(b!=false) System.err.println(rSet.getDate("date").toString());
            while(size<5){
                if(b==false){
                    System.err.println("False?");
                    if(curSlot.getNumFreeSlots()>0) { 
                        System.err.println("Added1! "+ curSlot.getDate());
                        ret[size++] = new Slots(curSlot);
                    }
                    tmp.roll(Calendar.DATE, true); cur = new Date(tmp.getTime().getTime());
                    while(size<5){
                        System.err.println("Added2! "+ cur);
                        ret[size++] = new Slots(cur);
                        tmp.roll(Calendar.DATE, true); cur = new Date(tmp.getTime().getTime());
                    }
                }else{
                    Date tp = rSet.getDate("date"); 
                    int slot = rSet.getInt("slot"); slot--;
                    System.err.println("tp = " + tp + " cur = "+ cur );
                    System.err.println(tp.getTime() + " MC " + cur.getTime());
                    if(tp.toString().equals(cur.toString())) {
                        System.err.println("In : tp = cur = " + cur + " b = " + curSlot.available[slot] );
                        curSlot.available[slot]=false;
                        b = rSet.next();
                    }else {
                        if(curSlot.getNumFreeSlots()>0){
                            System.err.println("Added3! "+ curSlot.getDate());
                            ret[size++] = new Slots(curSlot);
                        }
                        tmp.roll(Calendar.DATE, true); cur = new Date(tmp.getTime().getTime());
                        curSlot = new Slots(cur);
                    }
                }
            }
            
        } catch(SQLException e) {
            System.err.println("Error getting list of hearings");
        }  
        return ret;
    }
}
