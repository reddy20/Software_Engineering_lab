/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package JISS;

import java.sql.Date;
import java.util.Arrays;

/**
 *
 * @author root
 */
public class Slots {
    Date day;
    boolean[] available = new boolean[5];
    
    Slots(Slots s) {
        this.day = new Date(s.day.getTime());
        for(int i = 0; i < 5; i++)
            this.available[i] = s.available[i];
    }
    
    Slots(Date d) {
        this.day = new Date(d.getTime());
        Arrays.fill(available, true);
    }
    
    public String getDate(){
        return day.toString();
    }
    
    public boolean getAC(int j){
        return available[j];
    }
    
    public int getNumFreeSlots() {
        int free = 0;
        for(boolean b : available) {
            if(b)
                free++;
        }
        return free;
    }
}
