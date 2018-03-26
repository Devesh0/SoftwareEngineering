package bookingsystem;

import java.sql.*;
import java.util.*;

public class AddInstructorController {
         private Instructor list;
         sessionRepo InstRepo = new InstructorRepoImpl();
         
         public void register(int ref, String name, String spec, Connection conn){
             
             Instructor dent = new Instructor();
             dent.setId(ref);
             dent.setName(name);
             dent.setLevel(spec); 
             
             InstRepo.addInstructor(dent, conn);
         }  
         public void setInstructorList(ArrayList list){             
              InstRepo.setInstructors(list);
         }
         public void viewDetails(int id){
         ArrayList list = InstRepo.getAllInstructor();
         System.out.println(list.size());
         boolean found  = false;
         int i = 0;
         while (i<list.size() && !found){
                Instructor temp = (Instructor)list.get(i);
                if (id == temp.getId()){
                    System.out.print("Instructor details: \n name: " + temp.getName() + 
                     "\n speciality: " +  temp.getLevel() + "\n");
                    found = true;
                }
            i++;
            }  
         }    
         
}   

