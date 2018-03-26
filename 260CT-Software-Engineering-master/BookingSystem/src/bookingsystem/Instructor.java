package bookingsystem;


// Defines the class for instructor, and it's data points
// ID, Name, and Level.
public class Instructor{
         
         private int id = -1;
         private String name="";
         private String level="";
        
         public int getId(){
             return id;
         }
         public void setId(Integer aRef){
             id = aRef;
         }
         public String getName(){
             return name;
         }
         public void setName(String aName){
             name = aName;
         }
         public String getLevel(){
             return level;
         }
         public void setLevel(String spec){
             level = spec;
         }     
}
