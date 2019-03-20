/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package JISS;

import static JISS.Main.prepSt;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;
import java.util.Objects;
import static JISS.Main.conn;
import static JISS.Main.rSet;
import static JISS.Main.st;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Case {
    
    // No of cases in the court 
    static private int _noc = 0;
    
    public static Integer getNoC(){
        return _noc ;
    }
    
    public static void setNoC(int _noc_i){
        _noc = _noc_i;
    }
    
    public class Crime {
        
        // Date of Arrest
        private Date _doa ;
        // Date of Commision of Crime
        private Date _coc ;
        // Name of Arresting Officer
        private String _naf ;
        // Crime Type
        private String _ct ;
        // Location of Crime Comission
        private String _loc ;

        public Crime(Date _doa_i, Date _coc_i, String _naf_i, String _ct_i , String _loc_i) {
            _doa = _doa_i ;
            _coc = _coc_i ;
            _naf = _naf_i ;
            _ct = _ct_i ;
            _loc = _loc_i ;            
        }
        
        public Date getDoA(){
            return _doa;
        }
        
        public Date getCoC(){
            return _coc;
        }
        
        public String getNoO(){
            return _naf;
        }
        
        public String getCT(){
            return _ct;
        }
        
        public String getLoC(){
            return _loc;
        }
        
        public void setDoA(Date _doa_n){
            _doa = _doa_n ;                               
        }
        
        public void setCoC(Date _coc_n){
            _coc = _coc_n ;
        }
        
        public void setNoO(String _naf_n){
            _naf = _naf_n ;
        }
        
        public void setCT(String _ct_n){
            _ct = _ct_n ;
        }
        
        public void setLoC(String _loc_n){
            _loc = _loc_n ;
        }
        
        Crime getCrime(){
            return this;
        }
        
        String getCrimeDetails(){
            String _cdt = "" ;
            _cdt = _cdt.concat("CRIME DETAILS\n-------------\n");
            _cdt = _cdt.concat("Date of Arrest : " + this._doa.toString()+"\n");
            _cdt = _cdt.concat("Name of Arresting Officer : " + this._naf+"\n");
            _cdt = _cdt.concat("Crime Type : " + this._ct+"\n");
            _cdt = _cdt.concat("Date of Crime : " + this._coc.toString()+"\n");
            _cdt = _cdt.concat("Location of Crime : " + this._loc+"\n");
            return _cdt;
        }
}
    
    // Crime Details belonging to this court case
    private Crime _cd  = null;
    
    public Crime getCrime(){
            return _cd.getCrime() ;
    }
    
    public String getCrimeDetails(){
            return _cd.getCrimeDetails() ;
    }
    
    // No of hearings asscoiated with this Court Case
    private Integer _noh ;
    
    public class Hearing{
        
        // Hearing number
        private final int _hn ;
        // Date of Hearing
        private Date  _doh ;
        // Result of Hearing
        private String _roh ;
        // Reason for the result of the Hearing (for when adjourned)
        private String _ror ;
        // Summary of Hearing 
        private String _soh ;
        //Slot no
        private int _slot;
        
        //Scheduling a new Hearing w/o much details
        public Hearing(Date _doh_i,int _slot_i) {
            _hn = (_noh++) ;
            _doh = _doh_i ;
            _roh = "" ;
            _soh = "" ;
            _ror = "" ;
            _slot = _slot_i;
        }
        
        //Adding a new successfull Hearing with all details
        public Hearing(Date _doh_i,int _slot_i,String _roh_i,String _soh_i) {
            _hn = (_noh++) ;
            _doh = _doh_i ;
            _roh = _roh_i ;
            _soh = _soh_i ;
            _ror = "" ;
            _slot = _slot_i;
        }
        
        //Adding an adjourned Hearing with all details
        public Hearing(Date _doh_i,int _slot_i,String _roh_i,String _soh_i,String _ror_i) {
            _hn = (_noh++) ;
            _doh = _doh_i ;
            _roh = _roh_i ;
            _soh = _soh_i ;
            _ror = _ror_i ;
            _slot = _slot_i;
        }
        
        public Hearing(int id, Date _doh_i,int _slot_i,String _roh_i,String _soh_i,String _ror_i) {
            _hn = id;
            _doh = _doh_i ;
            _roh = _roh_i ;
            _soh = _soh_i ;
            _ror = _ror_i ;
            _slot = _slot_i;
        }
        
        public Integer getHN(){
            return _hn ;
        }
        
        public Date getDoH(){
            return _doh ;
        }
        
        public String getResult(){
            return _roh ;
        }
        
        public String getReason(){
            return _ror ;
        }
        
        public String getSummary(){
            return _soh ;
        }
        
        public Integer getSlot(){
            return _slot ;
        }
        
        public void setDoH(Date _doh_n){
            _doh = _doh_n ;
        }
        
        public void setResult(String _roh_n){
            _roh = _roh_n ;
        }
        
        public void setReason(String _ror_n){
            _ror = _ror_n ;
        }
        
        public void setSummary(String _soh_n){
            _soh = _soh_n ;
        }
        
        public void setSlot(int _slot_n){
            _slot = _slot_n;
        }
        
        public Hearing getHearing(){
            return this ;
        }
        
        public String getHearingDetails(){
            String _hdt = "";
            _hdt = _hdt.concat("Hearing No : "+this._hn+"\n");
            _hdt = _hdt.concat("Date of Hearing : "+this._doh.toString()+"\n");
            _hdt = _hdt.concat("Slot No : "+this._slot+"\n");
            _hdt = _hdt.concat("Result of Hearing : "+this._roh+"\n");
            _hdt = _hdt.concat("Summary of Hearing : "+this._soh+"\n");
            if(!"".equals(this._ror)) _hdt = _hdt.concat("Reason for Adjournment : "+this._roh+"\n");
            return _hdt;
        }
        
    }
    
    // List of Hearings 
    private ArrayList<Hearing> _loh ;
    
    // Get no of hearings alloted for the current case 
    public Integer getNoH(){
        return _loh.size() ;
    }
    
    public Hearing getHearing(Integer _hn) throws ArrayIndexOutOfBoundsException{
            if(_loh.size()>_hn) return _loh.get(_hn).getHearing() ;
            else throw new ArrayIndexOutOfBoundsException("Exception in accessing the List of Hearings") ;
    }
    
    public String getHearingDetails(Integer _hn) throws ArrayIndexOutOfBoundsException{
            System.err.println("actual size " + _loh.size() + " asked " + _hn);
            if(_loh.size()>_hn && _hn>=0) return _loh.get(_hn).getHearingDetails() ;
            else throw new ArrayIndexOutOfBoundsException("Exception in accessing the List of Hearings") ;
    }
    
    // Case Identification Number
    private int _cin ;
    // Date of Start 
    private java.sql.Date _dos ;
    // Defendant's name ;
    private String _dn ;
    // Defendant's address ;
    private String _da ;
    // Lawyers's name ;
    private String _ln ;
    // Public Prosecutor's name ;
    private String _ppn ;
    // Judge's name ;
    private String _jn ;
    // Court Case Status 
    private Integer _status ;
    // Case Summary 
    private String _cs ;
    
    // Case has been closed
    public static final int CASE_CLOSED = 19989 ;
    public static final String _closed = "CLOSED" ;
    // Case is pending to be completed 
    public static final int CASE_PENDING = 11199 ;
    public static final String _pending = "PENDING" ;
    
    public String getStatusString(){
        if(_status==CASE_CLOSED) return _closed;
        return _pending;
    }
    
    public Integer getCIN(){
        return _cin ;
    }
    
    public Date getDoS(){
        return _dos ;
    }
    
    public String getDN(){
        return _dn ;
    }
    
    public String getDA(){
        return _da ;
    }
    
    public String getLN(){
        return _ln ;
    }
    
    public String getPPN(){
        return _ppn ;
    }
    
    public String getJN(){
        return _jn ;
    }
    
    public int getStatus(){
        return _status ;
    }
    
    public String getCaseSummary(){
        return _cs ;
    }
    
    public void setDoS(Date _dos_n){
        try {
            _dos = _dos_n;
            st = conn.createStatement();
            st.executeUpdate("UPDATE JISS.case "
                    + "SET start_date='" + _dos_n.toString() + "' "
                    + "WHERE cin=" + this._cin + " "
                    + ";");
        } catch (SQLException ex) {
            Logger.getLogger(Case.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void setDN(String _dn_n){
        try {
            _dn = _dn_n;
            st = conn.createStatement();
            st.executeUpdate("UPDATE JISS.case "
                    + "SET defender_name='" + _dn_n + "' "
                    + "WHERE cin=" + this._cin + " "
                    + ";");
        } catch (SQLException ex) {
            Logger.getLogger(Case.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void setDA(String _da_n){
        try {
            _da = _da_n;
            st = conn.createStatement();
            st.executeUpdate("UPDATE JISS.case "
                    + "SET defender_address='" + _da_n + "' "
                    + "WHERE cin=" + this._cin + " "
                    + ";");
        } catch (SQLException ex) {
            Logger.getLogger(Case.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void setLN(String _ln_n){
        try {
            _ln = _ln_n ;
            st = conn.createStatement();
            st.executeUpdate("UPDATE JISS.case "
                    + "SET lawyer='" + _ln_n + "' "
                    + "WHERE cin=" + this._cin + " "
                    + ";");
        } catch (SQLException ex) {
            Logger.getLogger(Case.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void setPPN(String _ppn_n){
        try {
            _ppn = _ppn_n ;
            st = conn.createStatement();
            st.executeUpdate("UPDATE JISS.case "
                    + "SET public_prosecutor='" + _ppn_n + "' "
                    + "WHERE cin=" + this._cin + " "
                    + ";");
        } catch (SQLException ex) {
            Logger.getLogger(Case.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void setJN(String _jn_n){
        try {
            _jn = _jn_n ;
            st = conn.createStatement();
            st.executeUpdate("UPDATE JISS.case "
                    + "SET judge='" + _jn_n + "' "
                    + "WHERE cin=" + this._cin + " "
                    + ";");
        } catch (SQLException ex) {
            Logger.getLogger(Case.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void setStatus(Integer _s_n){
        try {
            _status = _s_n ;
            st = conn.createStatement();
            st.executeUpdate("UPDATE JISS.case "
                    + "SET status=" + _s_n + " "
                    + "WHERE cin=" + this._cin + " "
                    + ";");
        } catch (SQLException ex) {
            Logger.getLogger(Case.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void setCaseSummary(String _cs_n){
        try {
            _cs = _cs_n ;
            st = conn.createStatement();
            st.executeUpdate("UPDATE JISS.case "
                    + "SET summary='" + _cs_n + "' "
                    + "WHERE cin=" + this._cin + " "
                    + ";");
        } catch (SQLException ex) {
            Logger.getLogger(Case.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void updateDoS(Date _dos_n){
            _dos = _dos_n;
        
    }
    
    public void updateDN(String _dn_n){
            _dn = _dn_n;
    }
    
    public void updateDA(String _da_n){
            _da = _da_n;
    }
    
    public void updateLN(String _ln_n){
            _ln = _ln_n ;
    }
    
    public void updatePPN(String _ppn_n){
            _ppn = _ppn_n ;
    }
    
    public void updateJN(String _jn_n){
            _jn = _jn_n ;
    }
    
    public void updateStatus(Integer _s_n){
            _status = _s_n ;
    }
    
    public void updateCaseSummary(String _cs_n){
            _cs = _cs_n ;            
    }
    
    public Integer addHearing(Date _doh_i,int _slot_i) throws Exception {
        System.err.println("Hearing no + " + this.getNoH() + " added to case no " + this.getCIN());
        System.err.println(_doh_i.toString() + " H " + _slot_i);
       if(Objects.equals(_status, CASE_CLOSED)) throw new Exception("Error : Adding new hearing to a closed case .");
       _loh.add(new Hearing(_doh_i,_slot_i));
        st = conn.createStatement();
        System.err.println("Here:" + _loh.get(_loh.size()-1).getHN());
        st.executeUpdate("INSERT INTO JISS.hearing "
                + "(id,case_id,summary,date,slot)"
                + "values( " + _loh.get(_loh.size()-1).getHN() + ", " + this._cin +", '', '" + _doh_i.toString() + "' , " + _slot_i + ") "
                + ";");
       return _loh.get(_loh.size()-1).getHN() ;
    }
    
//    public Integer addHearing(Date _doh_i,int _slot_i,String _roh_i,String _soh_i) throws Exception{
//        if(Objects.equals(_status, CASE_CLOSED)) throw new Exception("Error : Adding new hearing to a closed case .");
//        _loh.add(new Hearing(_doh_i,_slot_i, _roh_i, _soh_i));
//        return _loh.get(_loh.size()-1).getHN() ;
//    }
//
//    public Integer addHearing(Date _doh_i,int _slot_i,String _roh_i,String _soh_i,String _ror_i) throws Exception{
//        if(Objects.equals(_status, CASE_CLOSED)) throw new Exception("Error : Adding new hearing to a closed case .");
//        _loh.add(new Hearing(_doh_i,_slot_i, _roh_i, _soh_i, _ror_i));
//        return _loh.get(_loh.size()-1).getHN() ;
//    }
    
    public void updateHearingResult(Integer _hn,String _roh_n) throws ArrayIndexOutOfBoundsException{
        if(_loh.size()>_hn) {
            try {
                _loh.get(_hn).setResult(_roh_n);
                st = conn.createStatement();
                st.executeUpdate("UPDATE JISS.hearing " +
                                        "SET result='"+_roh_n+"' "+
                                        "WHERE case_id="+this._cin+" "+
                                        "AND date='"+this._loh.get(_hn).getDoH().toString()+"' "+
                                        "AND slot="+this._loh.get(_hn).getSlot()+" "+
                                        ";");
            } catch (SQLException ex) {
                Logger.getLogger(Case.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        else throw new ArrayIndexOutOfBoundsException("Error in Updating Hearing Result");
    }
    
    public void updateHearingReason(Integer _hn,String _ror_n) throws ArrayIndexOutOfBoundsException{
        if(_loh.size()>_hn) {
            try {
                _loh.get(_hn).setReason(_ror_n);
                st = conn.createStatement();
                st.executeUpdate("UPDATE JISS.hearing "
                        + "SET reason='" + _ror_n + "' "
                        + "WHERE case_id=" + this._cin + " "
                        + "AND date='" + this._loh.get(_hn).getDoH().toString() + "' "
                        + "AND slot=" + this._loh.get(_hn).getSlot() + " "
                        + ";");
            } catch (SQLException ex) {
                Logger.getLogger(Case.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else throw new ArrayIndexOutOfBoundsException("Error in Updating Hearing Reason");
    }
    
    public void updateHearingSummary(Integer _hn,String _soh_n) throws ArrayIndexOutOfBoundsException{
        if(_loh.size()>_hn) {
            try {
                _loh.get(_hn).setSummary(_soh_n);
                st = conn.createStatement();
                st.executeUpdate("UPDATE JISS.hearing "
                        + "SET summary='" + _soh_n + "' "
                        + "WHERE case_id=" + this._cin + " "
                        + "AND date='" + this._loh.get(_hn).getDoH().toString() + "' "
                        + "AND slot=" + this._loh.get(_hn).getSlot() + " "
                        + ";");
            } catch (SQLException ex) {
                Logger.getLogger(Case.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else throw new ArrayIndexOutOfBoundsException("Error in Updating Hearing Summary");
    }
    
    public Date getEndDate() throws ArrayIndexOutOfBoundsException,Exception{
        if(!_loh.isEmpty()) {
            if(Objects.equals(_status, CASE_CLOSED)) return _loh.get(_loh.size()-1).getDoH() ;
            else throw new Exception("Error : Trying to access end date of an un-closed case .") ;
        }else throw new ArrayIndexOutOfBoundsException("Error in getting end date (no hearings scheduled)");
    }

    public Case(Date _doa_i, Date _coc_i, String _naf_i, String _ct_i, String _loc_i,
                     Date _dos_i, String _dn_i, String _da_i, String _ln_i, String _ppn_i, String _jn_i) {
        
        _loh = new ArrayList<>();
        
        this._noh = 0;
        this._cin = _noc++ ;
        this._cd = new Crime(_doa_i, _coc_i, _naf_i, _ct_i, _loc_i);
        
        this._dos = _dos_i;
        this._dn = _dn_i;
        this._da = _da_i;
        this._ln = _ln_i;
        this._ppn = _ppn_i;
        this._jn = _jn_i;
        this._status = CASE_PENDING;
        this._cs = "" ;
        
        try {
            //crime
            prepSt = conn.prepareStatement("INSERT INTO JISS.Crime (crime_date,officer,type,location,arrest_date) VALUES(?, ?, ?, ?, ?);",Statement.RETURN_GENERATED_KEYS);
            prepSt.setDate(1,this._cd._coc);
            prepSt.setString(2,this._cd._naf);
            prepSt.setString(3,this._cd._ct);
            prepSt.setString(4,this._cd._loc);
            prepSt.setDate(5,this._cd._doa);
            prepSt.executeUpdate();
            rSet = prepSt.getGeneratedKeys(); int id = 0;
            if(rSet!=null && rSet.next()) id = rSet.getInt(1);
            //case
            prepSt = conn.prepareStatement("INSERT INTO JISS.Case "
                                         + " (cin, start_date,defender_name,defender_address,lawyer,public_prosecutor,judge,status,summary,resolve_date,crime_detail) "
                                         + " VALUES(? ,?, ?, ?, ?, ?, ?, ?, ?, null , ?);");
            prepSt.setInt(1,this._cin);
            prepSt.setDate(2,this._dos);
            prepSt.setString(3,this._dn);
            prepSt.setString(4,this._da);
            prepSt.setString(5,this._ln);
            prepSt.setString(6,this._ppn);
            prepSt.setString(7,this._jn);
            prepSt.setInt(8,this._status);
            prepSt.setString(9,this._cs);
            prepSt.setInt(10,id);
            prepSt.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(Case.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Case(Case _tcase) {
        
        _loh = null ;
        
        this._noh = _tcase._noh ;
        this._cin = _tcase._cin ;
        this._cd = new Crime(_tcase._cd._doa, _tcase._cd._coc, _tcase._cd._naf, _tcase._cd._ct, _tcase._cd._loc);
                
        this._dos = _tcase._dos;
        this._dn = _tcase._dn;
        this._da = _tcase._da;
        this._ln = _tcase._ln;
        this._ppn = _tcase._ppn;
        this._jn = _tcase._jn;
        this._status = _tcase._status;
        this._cs = _tcase._cs;
        
    }
    
    public Case(int cin) {
        try {
            st = conn.createStatement();
            rSet = st.executeQuery("SELECT * FROM JISS.Case WHERE cin = " + cin + ";");
            rSet.next();
            this._noh = 0;
            this._cin = rSet.getInt("cin");
            this._dos = rSet.getDate("start_date");
            this._dn = rSet.getString("defender_name");
            this._da = rSet.getString("defender_address");
            this._ln = rSet.getString("lawyer");
            this._jn = rSet.getString("judge");
            this._ppn = rSet.getString("public_prosecutor");
            this._status = rSet.getInt("status");
            this._cs = "";
            
            int _cdt = rSet.getInt("crime_detail");
            
            // Loading crime details
            st = conn.createStatement();
            rSet = st.executeQuery("SELECT * FROM JISS.Crime WHERE id = " + _cdt + ";");
            rSet.next();
            Date arrest_date = rSet.getDate("arrest_date");
            Date crime_date = rSet.getDate("crime_date");
            String officer = rSet.getString("officer");
            String type = rSet.getString("type");
            String loc = rSet.getString("location");
            this._cd = new Crime(arrest_date, crime_date, officer, type, loc);
            
            this._loh = new ArrayList<>();
            
            // Loading hearing details
            st = conn.createStatement();
            rSet = st.executeQuery("SELECT * FROM JISS.Hearing WHERE case_id = " + cin + ";");
            while(rSet.next()) {
                //int id, Date _doh_i,String _roh_i,String _soh_i,String _ror_i
                Hearing cur = new Hearing(rSet.getInt("id"), rSet.getDate("date"), rSet.getInt("slot"),rSet.getString("result"), rSet.getString("summary"), rSet.getString("reason"));
                this._loh.add(cur);
                _noh++;
            }
        } catch(SQLException ex) {   
            Logger.getLogger(Case.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public String getCaseDetails(){
        String _cdt = "";
        _cdt = _cdt.concat("CIN : "+this._cin+"\n");
        _cdt = _cdt.concat("Date of Start : "+this._dos.toString()+"\n");
        _cdt = _cdt.concat("Defendant's Name : "+this._dn+"\n");
        _cdt = _cdt.concat("Defendant's Address : "+this._da+"\n");
        _cdt = _cdt.concat("Lawyer's Name : "+this._ln+"\n");
        _cdt = _cdt.concat("Public Prosecutor's Name : "+this._dn+"\n");
        _cdt = _cdt.concat("Judge's Name : "+this._dn+"\n\n");
        _cdt = _cdt.concat(this.getCrimeDetails()+"\n");
        _cdt = _cdt.concat("Case Status : "+getStatusString()+"\n");
        _cdt = _cdt.concat("Case Summary : "+getCaseSummary()+"\n");
        return _cdt;
    }
    
    public void updateCD(Case _tcase){
        try {
            this._cd._doa = _tcase._cd._doa ;
            this._cd._coc = _tcase._cd._coc ;
            this._cd._naf = _tcase._cd._naf ;
            this._cd._ct = _tcase._cd._ct ;
            this._cd._loc = _tcase._cd._loc ;
            
            //this._dos = _tcase._dos;
            this._dn = _tcase._dn;
            this._da = _tcase._da;
            this._ln = _tcase._ln;
            this._ppn = _tcase._ppn;
            this._jn = _tcase._jn;
            //this._status = _tcase._status;
            this._cs = _tcase._cs;
            
            prepSt = conn.prepareStatement("UPDATE JISS.case SET defender_name = ? , "
                    + "defender_address = ? , lawyer = ? , public_prosecutor = ? , "
                    + "judge = ? , summary = ? "
                    + "WHERE cin = ? ;");
            prepSt.setString(1,_dn);
            prepSt.setString(2,_da);
            prepSt.setString(3,_ln);
            prepSt.setString(4,_ppn);
            prepSt.setString(5,_jn);
            prepSt.setString(6,_cs);
            prepSt.setInt(7,_cin);
            prepSt.executeUpdate();
            
            int _cdfk ;
            st = conn.createStatement();
            rSet = st.executeQuery("SELECT crime_detail from JISS.case where cin = " + this._cin + " ;");
            if(rSet.next()) _cdfk = rSet.getInt("crime_detail");
            else throw new Exception("Error : Unable to access crime_detail at updateCD");
            
            prepSt = conn.prepareStatement("UPDATE JISS.crime SET crime_date = ? , "
                    + "officer = ? , type = ? , location = ? , "
                    + "arrest_date = ? "
                    + "WHERE id = ? ;");
            prepSt.setDate(1,_cd._coc);
            prepSt.setString(2,_cd._naf);
            prepSt.setString(3,_cd._ct);
            prepSt.setString(4,_cd._loc);
            prepSt.setDate(5,_cd._doa);
            prepSt.setInt(6,_cdfk);
            prepSt.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(Case.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
        
    }
    
//    public static String getHDF(int _mode){
//        String _hdt = "";
//        _hdt = _hdt.concat("Hearing No : "+"\n");
//        _hdt = _hdt.concat("Date of Hearing : "+"\n");
//        _hdt = _hdt.concat("Result of Hearing : "+"\n");
//        _hdt = _hdt.concat("Summary of Hearing : "+"\n");
//        if(_mode==UpdateHearing.M_AA) _hdt = _hdt.concat("Reason for Adjournment : "+"\n");
//        return _hdt;
//    }
    
    public static String getStatusStr(int _tstat){
        String _tmp = "The Case is ";
        if(_tstat==CASE_CLOSED) _tmp+=_closed;
        else _tmp+=_pending;
        return _tmp;
    }
    
    public static int getCaseStatus(int _tcin) throws Exception{
        int _tstat = -1;
        try {    
            st = conn.createStatement();
            rSet = st.executeQuery("SELECT status FROM JISS.Case WHERE cin = " + _tcin + ";");
            if(rSet.next()) _tstat = rSet.getInt("status");
        } catch (SQLException ex) {
            Logger.getLogger(Case.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(_tstat!=-1) return _tstat;
        else throw new Exception("Invalid Input");
    }
    
    public void setED(Date _ed){
        try {
            Statement st = conn.createStatement();
            st.executeUpdate("UPDATE JISS.CASE SET resolve_date = "+ _ed + " WHERE CIN = " + this._cin + " ;");
        } catch (SQLException ex) {
            Logger.getLogger(Case.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
