//using for importing the date class.
import java.util.*;
import java.io.*;
 public class FlightDetails implements Serializable
  {
		public String Flight_Num;
		public String FlightDate;
		public String Time;
		public int Num_Of_Seats;
		public String Source;
		public String Destination;
	
            public FlightDetails()
		{
	 	         super();
		}

   //constructor for the flightDetails class
	public FlightDetails(String fn,String fd, String t, int ns,String s,String d)
	{
		this.Flight_Num = fn;
		this.FlightDate = fd;
		this.Time = t;
		this.Num_Of_Seats = ns;
		this.Source = s;
		this.Destination =d;
	}

	public void setFlightNum(String flightNum)
	{
		this.Flight_Num = flightNum;
	}

	public void setFlightDate(String FDate)
	{	
		this.FlightDate = FDate;
	}

	public void setTime(String time)
	{
		this.Time = time;
	}

	public void setNumSeats(int seats)
	{
		this.Num_Of_Seats = seats;
	}

	public void setSource(String SSource)
	{
		this.Source = SSource;
	}

	public void setDestination(String Des)
	{
		this.Destination = Des;
	}

	public void booked(int n)
	{
		this.Num_Of_Seats = this.Num_Of_Seats - n;
	}

}//end of class
