package bookingsystem;

import java.util.ArrayList;
import java.sql.*;

public class MaintenanceRepoImpl implements sessionRepo { 
    
    private ArrayList<Maintenance> dates;
        
    public MaintenanceRepoImpl(){
        dates = new ArrayList<Maintenance>();
    }        

    public MaintenanceRepoImpl(ArrayList list){
        dates = list;
    } 

    public void addDate(Maintenance date, Connection conn){
        dates.add(date);
        write(conn,  "add",  date);
    }
        
    public Maintenance getDate(Maintenance date){
        return dates.get(date.getRef()); 
        }
    
    public ArrayList<Maintenance> getAllDate(){
        return dates; 
    } 
    
    public void setDate(ArrayList list){
        dates = list; 
    }

    public void updateDate(Maintenance date, Connection conn){
            ArrayList dates = getAllDate();
            boolean found = false;
            int i = 0;
            while ((!found) && (i<dates.size())) {
                Maintenance temp = (Maintenance)dates.get(i);
                if (date.getRef() == temp.getRef()){
                    temp.setDate(date.getDate());
                    temp.setType(date.getType());
                    System.out.println("date Ref: "+ date.getRef()+ " updated");
                    
                    found = true;
                }
                i++;
            }
            write(conn,  "update",  date);
    }
    

 
    public ArrayList read(Connection conn){
        System.out.println("Reading from the database... ");
        ArrayList list = new ArrayList();
        try {   
                Statement st = conn.createStatement();
                
                ResultSet rs=null;
                String sql = "SELECT * FROM DATE";
                rs=st.executeQuery(sql);

                while(rs.next()){ 
                    Maintenance dat = new Maintenance();
                    dat.setRef(rs.getInt("REF"));
                    dat.setDate(rs.getString("DATE"));
                    dat.setType(rs.getString("TYPE"));
                    list.add(dat);
                    System.out.println(rs.getInt("REF")+"\t"+rs.getString("DATE")+
                            "\t"+rs.getString("TYPE"));
                }
                    rs.close();
                    st.close();

        } catch (SQLException ex) {
                    System.out.println("SQLException failed ! ");
        } 
        
        dates = list;
        
        System.out.println("dates..." + list.size());
        return dates;
    }
    
    public void write(Connection conn, String str, Maintenance date){
        
        ArrayList list = getAllDate();
        System.out.println("Writing to the database... ");
        
        if (str.equals("add")){

            try {   
                Statement st = conn.createStatement();
              
                String sql = "INSERT INTO Maintenance VALUES (" + date.getRef() + ", '" + date.getDate() + "' , '" + date.getType() + "')";
                st.executeUpdate(sql);

                st.close();
            }
            catch (SQLException ex) {
                    System.out.println("SQLException error ");
            }         
        
        }
        else if (str.equals("update")) {
            try {   
                    Statement st = conn.createStatement();
              
                    String sql = "UPDATE date SET type = '" + date.getType() + "' WHERE ref =" + date.getRef() + ""; 
                    st.executeUpdate(sql);

                    st.close();                    
            }
            catch (SQLException ex) {
                    System.out.println("SQLException error ");
            }                                  
        }
        else if (str.equals("delete")) {
            try {   
                    Statement st = conn.createStatement();
              
                    String sql = "DELETE FROM date WHERE REF = " + date.getRef()+ " ";
                    st.executeUpdate(sql);

                    st.close();
            }
            catch (SQLException ex) {
                    System.out.println("SQLException error ");
            }                             
        }
    }    

    @Override
    public void addSession(Session sesh, Connection conn) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Session getSession(Session session) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Session> getAllSessions() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setSessions(ArrayList list) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void write(Connection conn, Session session) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addInstructor(Instructor instruc, Connection conn) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Instructor getInstructor(Instructor instructor) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Instructor> getAllInstructor() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setInstructors(ArrayList list) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void write(Connection conn, Instructor instructor) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Skier getSkier(Skier skier) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Skier> getAllSkier() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addSkier(Skier skier, Connection conn) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setSkiers(ArrayList list) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateSkier(Skier ski, Connection conn) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteSkier(Skier ski, Connection conn) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void write(Connection conn, String str, Skier skier) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addBooking(Booking Booking, Connection conn) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Booking getBooking(Booking Booking) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Booking> getAllBooking() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setBookings(ArrayList list) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateBookings(Booking Booking, Connection conn) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteBooking(Booking Booking, Connection conn) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void write(Connection conn, String str, Booking Booking) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
