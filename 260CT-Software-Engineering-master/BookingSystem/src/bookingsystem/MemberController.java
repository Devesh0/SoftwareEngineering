package bookingsystem;

import java.sql.*;
import java.util.*;

public class MemberController {
    SkierRepoImpl skiRepo = new SkierRepoImpl();
         public void register(int skierID, String name, String membership, Connection conn){
             
             Skier skier = new Skier();
             skier.setRef(skierID);
             skier.setName(name);
             skier.setMembership(membership); 
             
             skiRepo.addSkier(skier, conn);
         }
         
         public void register(int skierID, String name, String membership, Session sess, Connection conn){
             
             Skier skier = new Skier();
             skier.setRef(skierID);
             skier.setName(name);
             skier.setMembership(membership);
             skier.addBooked(sess);
             int sessId = sess.getId();
             
             
             skiRepo.addSkierBook(skier, sessId, conn);
         } 
         
	public void updateDetails(int ref, String memtyp, Connection conn){ 
         
            ArrayList list = skiRepo.getAllSkier();
            boolean found  = false;
            int i = 0;
            while (i<list.size() && !found){
                Skier temp = (Skier)list.get(i);
                if (ref == temp.getRef()){
                    temp.setMembership(memtyp);
                    skiRepo.updateSkier(temp, conn);
                    found = true;
                }
            i++;
            }               
         }
		 
	public void viewDetails(int ref){
             ArrayList list = skiRepo.getAllSkier();
         
            boolean found  = false;
            int i = 0;
            while (i<list.size() && !found){
		Skier temp = (Skier)list.get(i);
                if (ref == temp.getRef()){
                    System.out.print("Skier details: \n name: " + temp.getName() + 
                     "\n membership: " +  temp.getMembership() + "\n"); 
                    
                    found = true;
                }
            i++;
            }  
         }
		 
	public void viewAll(){
            ArrayList list = skiRepo.getAllSkier();
            for (int i = 0; i<list.size(); i++){
		Skier temp = (Skier)list.get(i);
                
                    System.out.print("Skier details: \n ref: " + temp.getRef() + 
                            "\n name: " + temp.getName() + 
                     "\n membership: " +  temp.getMembership() + "\n");
            }              
         }
		  
	public void setSkierList(ArrayList list){
              skiRepo.setSkiers(list);
         }
		 
	public void deleteDetails(int ref, Connection conn){
         
            Skier skier = new Skier();
            skier.setRef(ref);
            skiRepo.deleteSkier(skier, conn);
         }
}