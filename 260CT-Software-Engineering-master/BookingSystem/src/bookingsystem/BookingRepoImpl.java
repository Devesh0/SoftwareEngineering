package bookingsystem;

import java.util.ArrayList;
import java.sql.*;

public class BookingRepoImpl implements sessionRepo { 
    
    private ArrayList<Booking> Bookings;
        
    public BookingRepoImpl(){
        Bookings = new ArrayList<Booking>();
    }        

    public BookingRepoImpl(ArrayList list){
        Bookings = list;
    } 

    public void addBooking(Booking Booking, Connection conn){
        
        Bookings.add(Booking); 
        write(conn,  "add",  Booking);

    }
        
    public Booking getBooking(Booking Booking){
        return Bookings.get(Booking.getUserID()); 
    }
    
    public ArrayList<Booking> getAllBooking(){
        return Bookings; 
    } 
    
    public void setBooking(ArrayList list){
        Bookings = list; 
    }

    public void updateBooking(Booking Booking , Connection conn){
            ArrayList Bookings = getAllBooking();
            boolean found = false;
            int i = 0;
            while ((!found) && (i<Bookings.size())) {
                Booking temp = (Booking)Bookings.get(i);
                if (Booking.getUserID() == temp.getUserID()){
                    temp.setSurname(Booking.getSurname());
                    temp.setBookingID(Booking.getBookingID());
                    System.out.println("Instructor Ref: "+ Booking.getUserID()+ " updated");
                    
                    found = true;
                }
                i++;
            }
            
            write(conn,  "update",  Booking);

    }
    
    public void deleteBooking(Booking Booking, Connection conn){ 

            ArrayList Bookings = getAllBooking(); 
            ArrayList tempList = new ArrayList();
            
            for (int i = 0; i<Bookings.size(); i++) {
                Booking temp = (Booking)Bookings.get(i);
                if (Booking.getUserID() != temp.getUserID()){
                    tempList.add(temp);    
                }
            }
            setBooking(tempList);

            System.out.println("Instructor Ref: "+ Booking.getUserID()+ " deleted");
            
            write(conn,  "delete",  Booking);

    }
  
   
    public ArrayList read(Connection conn){
        System.out.println("Reading from the database... ");
        ArrayList list = new ArrayList();
        try {   
                Statement st = conn.createStatement();
                
                ResultSet rs=null;
                String sql = "SELECT * FROM BOOKING";
                rs=st.executeQuery(sql);

                while(rs.next()){ 
                    Booking ski = new Booking();
                    ski.setUserID(rs.getInt("USERID"));
                    ski.setSurname(rs.getString("SURNAME"));
                     ski.setFirstName(rs.getString("FirstName"));
                    ski.setBookingID(rs.getInt("BOOKINGID"));
                    list.add(ski);
                    System.out.println(rs.getInt("USERID")+"\t"+rs.getString("SURNAME")+
                            "\t"+rs.getInt("BOOKINGID"));
                }
                    rs.close();
                    st.close();

        } catch (SQLException ex) {
                    System.out.println("SQLException failed ! ");
        } 
        
        Bookings = list;
        
        System.out.println("Instructors..." + list.size());
        return Bookings;
    }
    
    public void write(Connection conn, String str, Booking Booking ){
        
        ArrayList list = getAllBooking();
        System.out.println("Writing to the database... ");
        
        if (str.equals("add")){

            try {   
                Statement st = conn.createStatement();
              
                String sql = "INSERT INTO BOOKING VALUES (" + Booking.getUserID() + ", '" + Booking.getSurname() + "' , '" + Booking.getBookingID() + "')";
                st.executeUpdate(sql);

                st.close();
            }
            catch (SQLException ex) {
                    System.out.println("SQLException error (1)");
            }         
        
        }
        else if (str.equals("update")) {
            try {   
                System.out.println("MyTable has ");
                    Statement st = conn.createStatement();
                    
                    String sql2 = "SELECT * FROM DENTIST2 ";
                    //String sql = "UPDATE SKIERS SET Surname = '" + Skier.getSurname() + "' WHERE UserID =" + Skier.getUserID() + ""; 
                   // st.executeUpdate(sql);
                    st.executeQuery(sql2);
                    
                    //ResultSet rs = null;
                     
                    
                    
                   
                   //rs=st.executeQuery(sql);
                    // rs = 
                    
                     System.out.println("testing 1");
                    //rs.next();
                    
                    //rs.close() ;
                    //System.out.println("MyTable has " + count + " row(s).");
                    //

                    st.close();                    
            }
            catch (SQLException ex) {
                    System.out.println("SQLException error !(2)");
            }                                  
        }
        else if (str.equals("delete")) {
            try {   
                    Statement st = conn.createStatement();
              
                    String sql = "DELETE FROM BOOKING WHERE ID = " + Booking.getUserID()+ " ";
                    st.executeUpdate(sql);

                    st.close();
            }
            catch (SQLException ex) {
                    System.out.println("SQLException error (3)");
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
    public void addDate(Maintenance dat, Connection conn) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Maintenance getDate(Maintenance date) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Maintenance> getAllDate() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setDate(ArrayList list) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateDate(Maintenance dat, Connection conn) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void write(Connection conn, String str, Maintenance date) {
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
}  

