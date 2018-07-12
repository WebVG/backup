//using for importing the date class.
import java.util.*;
import java.io.*;

//implements Serializable

  public class flightResDetails extends FlightDetails  
	{
		String Name;
		String Address;
		int phone;
		String Email;
		final String[] ReservationType = {"FirstClass","SecondClass","ThirdClass"};
		String Res;
		int Num_OfResSeats;

		public flightResDetails()
		{
			super();
		}

 	 public flightResDetails(String fNum,String name,String address,int ph,String email,int n,int nseats)
		{
			this.Flight_Num = fNum;
			this.Name = name;
			this.Address = address;
			this.phone = ph;
			this.Email = email;
			this.Res =ReservationType[n-1];
			this.Num_OfResSeats = nseats;
		}

	public void setFlightNum(String flightNum)
		{
			this.Flight_Num = flightNum;
		}
	public void setName(String Name1)
		{
			this.Name = Name1;
		}
	public void setAddress(String add)
		{
			this.Address = add;
		}

	public void setPhone(int ph)
		{
			this.phone = ph;
		}

	public void setEmail(String email)
		{
			this.Email = email;
		}

	public void setReservationType(int n)
		{
			this.Res = ReservationType[n-1];
		}

	public void setReserveSeats(int n)
		{
			this.Num_OfResSeats = n;
		}
 }//end of Class
