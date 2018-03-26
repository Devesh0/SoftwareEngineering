package bookingsystem;


// Defines the class for instructor, and it's data points
// ID, Name, and Level.
public class Booking{
         
        private String FirstName="";
	private int UserID = 0;
	private Integer BookingID=-1;
	private String Email="";
	private Integer TelephoneNumber=-1 ;
	private String Surname = "";
        
         public String getFirstName() {
	return FirstName;
	}
	
	public int getUserID() {
	return UserID;
	}
	
	public Integer getBookingID() {
	return BookingID;
	}
	
	public String getEmail() {
	return Email;
	}
	
	public Integer getTelephoneNumber() {
	return TelephoneNumber;
	}
	
	public String getSurname() {
	return Surname;
	}
	
	public void setFirstName(String aName) {
            FirstName = aName;
	}
	
	public void setUserID(int aUser) {
            UserID = aUser;
	}
	
	public void setBookingID(Integer aBooking) {
	BookingID = aBooking;
	}
	
	public void setEmail(String aEmail) {
            Email = aEmail;
	}
	
	public void setTelephoneNumber(Integer aTelephoneNumber) {
            TelephoneNumber = aTelephoneNumber;
	}
	
	public void setSurname(String aSurname) {
            Surname = aSurname;
	}
}
