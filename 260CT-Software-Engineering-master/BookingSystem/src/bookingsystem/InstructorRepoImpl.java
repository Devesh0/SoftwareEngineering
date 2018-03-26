package bookingsystem;

import java.util.ArrayList;
import java.sql.*;

public class InstructorRepoImpl implements sessionRepo { 
    
    private ArrayList<Instructor> instructors;
        
    public InstructorRepoImpl(){
        instructors = new ArrayList<Instructor>();
    }        

    public InstructorRepoImpl(ArrayList list){
        instructors = list;
    } 
    public void setInstructors(ArrayList list){
            instructors = list; 
        }
    public void addInstructor(Instructor instructor, Connection conn){        
        instructors.add(instructor); 
        write(conn,  "add",  instructor);
    }
    public Instructor getInstructor(Instructor instructor){
        return instructors.get(instructor.getId()); 
    }
    
    public ArrayList<Instructor> getAllInstructor(){
        return instructors; 
    }   
    public void write(Connection conn, String str, Instructor instructor){
        ArrayList list = getAllInstructor();
        System.out.println("Writing to the database... ");
        try {   
            Statement st = conn.createStatement();

            String sql = "INSERT INTO INSTRUCTOR VALUES (" + instructor.getId() + ", '" + instructor.getName() + "' , '" + instructor.getLevel() + "')";
            st.executeUpdate(sql);

            st.close();
        }
        catch (SQLException ex) {
                System.out.println("SQLException error (1)");
        }         
    } 
    public ArrayList read(Connection conn){
        System.out.println("Reading from the database... ");
        ArrayList list = new ArrayList();
        try {   
                Statement st = conn.createStatement();
                
                ResultSet rs=null;
                String sql = "SELECT * FROM INSTRUCTOR";
                rs=st.executeQuery(sql);

                while(rs.next()){ 
                    Instructor instruc = new Instructor();
                    instruc.setId(rs.getInt("ID"));
                    instruc.setName(rs.getString("NAME"));
                    instruc.setLevel(rs.getString("LEVEL"));
                    list.add(instruc);
                    System.out.println(rs.getInt("ID")+"\t"+rs.getString("NAME")+
                            "\t"+rs.getString("LEVEL"));
                }
                    rs.close();
                    st.close();

        } catch (SQLException ex) {
                    System.out.println("SQLException failed ! ");
        } 
        
        instructors = list;
        
        System.out.println("Instructors..." + list.size());
        return instructors;
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
    public void write(Connection conn, Session session) {
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

    //@Override
    //public ArrayList readSession(Connection conn) {
    //    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    //}

    //@Override
    //public ArrayList readSkier(Connection conn) {
    //    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    //}

    @Override
    public void setSessions(ArrayList list) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addSkier(Skier skier, Connection conn) {
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

