package bookingsystem;

import java.util.ArrayList;
import java.sql.*;

public class SkierRepoImpl implements sessionRepo {
	
	private ArrayList<Skier> skiers;
	
	public SkierRepoImpl(){
        skiers = new ArrayList<Skier>();
    }
        
	public SkierRepoImpl(ArrayList list){
        skiers = list;
    }
	
        public void addSkier(Skier skier, Connection conn){      
        skiers.add(skier); 
        write(conn,  "add",  skier);

    }
        public void addSkierBook(Skier skier, int sessId, Connection conn){      
        skiers.add(skier); 
        write(conn,  sessId,  skier); // For adding a skier with a booking attached.

    }
	
	public Skier getSkier(Skier skier){
        return skiers.get(skier.getRef()); 
    }
	
	public ArrayList<Skier> getAllSkier(){
        return skiers; 
    }
        
	public void setSkiers(ArrayList list){
        skiers = list; 
    }
	
	public void updateSkier(Skier skier, Connection conn){
            ArrayList skiers = getAllSkier();
            boolean found = false;
            int i = 0;
  
            while ((!found) && (i < skiers.size())) {
                		
		Skier temp = (Skier)skiers.get(i);
                if (skier.getRef() == temp.getRef()){
                    temp.setName(skier.getName());
                    temp.setMembership(skier.getMembership());
                    System.out.println("skier Ref: "+ skier.getRef()+ " updated");
				
                    found = true;
                }
                i++;
            }
            write(conn,  "update",  skier);
    }
        
	public void deleteSkier(Skier skier, Connection conn){ 
	
            ArrayList skiers = getAllSkier();
            ArrayList tempList = new ArrayList();
            
            for (int i = 0; i < skiers.size(); i++) {
                Skier temp = (Skier)skiers.get(i);
                if (skier.getRef() != temp.getRef()){
                    tempList.add(temp);    
                }
            }
            setSkiers(tempList);
            System.out.println("skier Ref: "+ skier.getRef()+ " deleted");
            write(conn,  "delete",  skier);
    }
	
	public ArrayList read(Connection conn){
            System.out.println("Reading from the database... ");
            ArrayList list = new ArrayList();
            try {   
                Statement st = conn.createStatement();
                
                ResultSet rs=null;
				//String sql = "SELECT * FROM DENTIST";
                String sql = "SELECT * FROM SKIER";
                rs=st.executeQuery(sql);

                while(rs.next()){ 
                    Skier ski = new Skier();
                   
                    ski.setRef(rs.getInt("REF"));
                    
                    ski.setName(rs.getString("NAME"));
                    
                    ski.setMembership(rs.getString("MEMBERSHIP"));
                   
                    list.add(ski);
                    
                    System.out.println(rs.getInt("REF")+"\t"+rs.getString("NAME")+
                            "\t"+rs.getString("MEMBERSHIP"));
                }
                    rs.close();
                    st.close();

        } catch (SQLException ex) {
                    System.out.println("SQLException failed ! ");
        } 
        
	skiers = list;
        
	System.out.println("skiers..." + list.size());
	return skiers;
    }
	
	public void write(Connection conn, String str, Skier skier){
        
	ArrayList list = getAllSkier();
        System.out.println("Writing to the database... Skier");

                if (str.equals("add")){

            try {   
                Statement st = conn.createStatement();
                int def = 0;
                String sql = "INSERT INTO SKIER VALUES (" + skier.getRef() + ", '" + skier.getName() + "' , '" + skier.getMembership() + "' , " + def + ")";
                System.out.println(sql);
                st.executeUpdate(sql);
                st.close();
            }
            catch (SQLException ex) {
                    System.out.println("SQLException error");
            }         
        }
        
        else if (str.equals("update")) {
            try {   
                Statement st = conn.createStatement();
             
		String sql = "UPDATE SKIER SET membership = '" + skier.getMembership() + "' WHERE ref =" + skier.getRef() + ""; 
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
          
		String sql = "DELETE FROM SKIER WHERE REF = " + skier.getRef()+ " ";
                st.executeUpdate(sql);

                st.close();
            }
            catch (SQLException ex) {
                    System.out.println("SQLException error ");
            }                             
        }
    }
        public void write(Connection conn, int sessId, Skier skier){
        
        System.out.println("Writing to the database... ");

        try {   
            Statement st = conn.createStatement();
            String sql = "INSERT INTO SKIER VALUES (" + skier.getRef() + ", '" + skier.getName() + "' , '" + skier.getMembership() + "' , " + sessId + ")";
            st.executeUpdate(sql);
            st.close();
        }
        catch (SQLException ex) {
                System.out.println("SQLException error");
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
    public void write(Connection conn, Instructor instructor) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    //@Override
    //public ArrayList readSession(Connection conn) {
    //    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    //}

    //@Override
    //public ArrayList readInstructor(Connection conn) {
    //    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    //}

    @Override
    public void setSessions(ArrayList list) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setInstructors(ArrayList list) {
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
