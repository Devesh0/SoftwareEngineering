package bookingsystem;

import java.sql.*;
import java.util.*;

public class CheckInController {
  
         BookingRepoImpl dentRepo = new BookingRepoImpl();
         
         public void register(int UserID, String Surname, int BookingID, String FirstName, Connection conn){
             
             Booking dent = new Booking();
             dent.setUserID(UserID);
             dent.setSurname(Surname);
             dent.setBookingID(BookingID);
             dent.setFirstName(FirstName);
             
             
             dentRepo.addBooking(dent, conn);
         }          

         public void viewDetails(int UserID,int BookingID){
         ArrayList list = dentRepo.getAllBooking();
         
         boolean found  = false;
         int i = 0;
         while (i<list.size() && !found){
      
                Booking temp = (Booking)list.get(i);
                if (UserID == temp.getUserID() && BookingID == temp.getBookingID()  ){
                    System.out.print(temp.getFirstName() + 
                     " you are now checked in " + "\n");
                    
                    found = true;
                } else if (UserID != temp.getUserID() ) {
                    
                    //System.out.print("You have entered an incorrect UserID \n");
                    
                    //found = true;
                
                }  else if (BookingID != temp.getBookingID() ) {
                    //System.out.print("You have entered an incorrect BookingID \n");
                    //found = true;
                
                } 
            i++;
            }  
         if (found == false){
             System.out.print("You have entered an incorrect UserID or BookingID \n");
         }
         }    
         
         public void setBookingList(ArrayList list){
             
              dentRepo.setBooking(list);
         } 
         public void updateDetails(int UserID,String Surname, Connection conn){
         ArrayList list = dentRepo.getAllBooking();
         boolean found  = false;
         int i = 0;
         while (i<list.size() && !found){
                Booking temp = (Booking)list.get(i);
                //if (UserID == temp.getUserID()){
                    temp.setSurname(Surname);
                    dentRepo.updateBooking(temp, conn);
                    found = true;
                //}
            i++;
            }               
         } 
}   

