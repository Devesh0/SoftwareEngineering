package bookingsystem;

public class Maintenance{
         private int ref = -1;
         private String date="";
         private String type="";
        
        public int getRef(){
             return ref;
       }
       public void setRef(int aRef){
            ref = aRef;
        }
       
       public String getDate(){
             return date;
        }
       
       public void setDate(String aDate){
             date = aDate;
        }
       
         public String getType(){
             return type;
         }
         public void setType(String typ){
             type = typ;
         }     
}