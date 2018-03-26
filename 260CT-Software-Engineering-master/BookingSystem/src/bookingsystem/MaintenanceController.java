package bookingsystem;

import java.sql.*;
import java.util.*;

public class MaintenanceController {
    MaintenanceRepoImpl datRepo = new MaintenanceRepoImpl();//Object of dateRepoImpl
         
         public void register(int ref, String date, String typ, Connection conn){
             Maintenance dat = new Maintenance();
             dat.setRef(ref);
             dat.setDate(date);
             dat.setType(typ); 
             
             datRepo.addDate(dat, conn);
         }          

         public void updateDetails(int ref, String typ, Connection conn){
         ArrayList list = datRepo.getAllDate();
         boolean found  = false;
         int i = 0;
         while (i<list.size() && !found){
                Maintenance temp = (Maintenance)list.get(i);
                if (ref == temp.getRef()){
                    temp.setType(typ);
                    datRepo.updateDate(temp, conn);
                    found = true;
                }
            i++;
            }               
         }              
         
         public void viewDetails(int ref){
         ArrayList list = datRepo.getAllDate();
         
         boolean found  = false;
         int i = 0;
         while (i<list.size() && !found){
                Maintenance temp = (Maintenance)list.get(i);
                if (ref == temp.getRef()){
                    System.out.print("date details: \n date: " + temp.getDate() + 
                     "\n type: " +  temp.getType() + "\n");
                    
                    found = true;
                }
            i++;
            }  
         }    
         
        public void viewAll(){
        ArrayList list = datRepo.getAllDate();
        for (int i = 0; i<list.size(); i++){
                Maintenance temp = (Maintenance)list.get(i);
                    System.out.print("date details: \n ref: " + temp.getRef() + 
                            "\n date: " + temp.getDate() + 
                     "\n type: " +  temp.getType() + "\n");
            }              
         }
         
         public void setDateList(ArrayList list){
             
              datRepo.setDate(list);
         } 
}
