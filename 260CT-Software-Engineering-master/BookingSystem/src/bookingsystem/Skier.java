package bookingsystem;

import java.util.ArrayList;

public class Skier {
    private int ref = -1;
    private String name="";
    private String membership="";
    private ArrayList<Session> booked = new ArrayList(); //The sessions the skier is booked on - Arraylist.
        
    public int getRef(){
        return ref;
    }
    public void setRef(int aRef){
        ref = aRef;
    }
    public String getName(){
        return name;
    }
    public void setName(String aName){
        name = aName;
    }
    
    public String getMembership(){
	return membership;
    }
		
    public void setMembership(String memtyp){
	membership = memtyp;
    }
    public ArrayList getBooked(){
        return booked;
    }
    public void addBooked(Session sess){
        booked.add(sess);
    }
    
}
