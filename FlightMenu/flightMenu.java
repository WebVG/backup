
//core Java packages
import java.util.*;
import java.io.*;

// start of class definition

public class flightMenu //extends mainSystem
{
	static Vector fDetails = new Vector();	// creating a vector names as fDetails

	static ManageVector  manage = new ManageVector("sample.txt");	// creating object of ManageVector class

	static Vector fResDetails = new Vector();	// creating another vector named as fResDetails

	static ManageVector res = new ManageVector("res.txt");	// creating another object of ManageVector class

	// start of method AddDetails

	private static void AddDetails(String flightnum,String flightdate,String flighttime,int numseats,String flightsource, String flightdest)	
	
	{
		FlightDetails temp = new FlightDetails(flightnum,flightdate,flighttime,numseats,flightsource,flightdest);
		fDetails.addElement(temp);
		System.out.println("Entry Has Been Made");

	}	//end of method


	public static void displayAllPass()	// start of method
	{
		flightResDetails temp2;	//declaring object for flightResDetails class

		fResDetails = res.loadVector();	// loading vector of fResDetails

		System.out.println("--Flight No.--Name--Address--Phone No.--Email Add--Resv Type--Seats Reserved");
		System.out.println("");
		for(int i = 0; i<fResDetails.size();i++)	// start of for loop
		{
			temp2 =(flightResDetails)fResDetails.elementAt(i);
			System.out.println(temp2.Flight_Num+"--"+temp2.Name+"--"+temp2.Address+"--"+temp2.phone+"--"+temp2.Email+"--"+temp2.Res+"--"+temp2.Num_OfResSeats);
		}	// end of for loop
	}   // end of method


	public static void AddMenu() throws java.io.IOException	// start of method
	{
		// declaring variables
		
		String fn;
		String fd;
		String ft;
		int ns;
		String s;
		String d;
		
		System.out.println("    Please Enter The Following Information ?  ");	// message asking manager to enter information
		System.out.println("");
		System.out.print("        Enter Flight Number  :  ");	// asking for flight number
		fn = read.GetString();	// prompt for flight number

		System.out.print("	Enter Flight Date  :  ");	// asking for flight date
		fd = read.GetString();	// prompt for flight date

		System.out.print("	Enter Flight Time  :  ");	// asking for flight time
		ft = read.GetString();	// prompt for flight time

		System.out.print("	Enter Number of Seats On Flight  :  ");	// asking for seats on flight
		ns = read.GetInt();	// prompt for seats on flight

		System.out.print("	Enter The Source Of the Flight  :  ");	// asking for flight source
		s = read.GetString();	// prompt for flight source

		System.out.print("	Enter the Destination of the Flight  :  ");	// asking for flight destination
		d = read.GetString();	// prompt for flight destination
		AddDetails(fn,fd,ft,ns,s,d);

	}	// end of method

	// start of method displayAll that display all the flight information

	public static void displayAll()	
	{
		FlightDetails temp;	// declaring object of class FlightDetails

		System.out.println("-- Flight No.-- Flight Date -- Flight Time -- Seats Resv -- Source -- Dest");	// displaying heading for flight information menu
		System.out.println("");
		for(int i = 0; i<fDetails.size();i++)	// start of for loop
		{
		temp =(FlightDetails)fDetails.elementAt(i);
		System.out.println("--  "+temp.Flight_Num+"    --  "+temp.FlightDate+" --  "+temp.Time+"     --    "+temp.Num_Of_Seats+"   --  "+temp.Source+"  --  "+temp.Destination);	// display menu information
		}	// end of for loop
	}	// end of method

	// method to delete the flight details

	private static void delDetails(int index)		// start of method
	{
		fDetails.removeElementAt(index);	// deleting elements from the index 
		System.out.print("Entry Deleted");	// message that entry has been deleted
	}	// end of method
	
	public static void delMenu() throws java.io.IOException	// start of method
	{
		String num;	// declaring variable
		FlightDetails temp = new FlightDetails();	// creating object of class FlightDetails

		System.out.println("Please Enter Flight Number To Delete");	// message to enter flight number
		num = read.GetString();	// prompt for flight number

		for(int i = 0; i<fDetails.size();i++)	// start of for loop
		{
			temp =(FlightDetails)fDetails.elementAt(i);	
				if(temp.Flight_Num.equals(num))	// if flight number is found
					{
						 delDetails(fDetails.indexOf(temp));	// calling method delDetails
					}	// end of if statement
		}	// end of for loop

		if(temp == null)	// if the input given is emtpy, then
		{
			System.out.println("Entry Not Found");	// message that entry has not been found
			System.out.println("");
		}
			
		else	
		{
			System.out.print("Entry Found");	// message that entry has not been found
		}



	}//end of method


	public static void saveEntry()		// method to save the entries
	{
		manage.saveVector(fDetails);		// saving flight details
		System.out.println();
		System.out.println();
		System.out.println("               Your Entries For Today Have Been Saved!");	// display message that the entries has been saved uptill now.

	}	// end of method

	public static void loadEntry()		// method to load the flight entries
	{
		fDetails = manage.loadVector();	// loading flight details
		System.out.println();
		System.out.println();
		System.out.println("Your Entries Been Loaded!");		// display message that the entries has been loaded
	}	// end of method


	public static void updateEntry(String flightnum)throws java.io.IOException	// method to update the flight number
	{
		FlightDetails temp = new FlightDetails();	// creating object for Flight Details
		FlightDetails temp2;	// declaring another object of class Flight Details

		int input;	// declaring variable

		for(int i=0;i<fDetails.size();i++)	// start of for loop
		{
			temp = (FlightDetails)fDetails.elementAt(i);	
				if(temp.Flight_Num.equals(flightnum))	// start of if statement
				{	
					temp =(FlightDetails)fDetails.elementAt(i); 
					temp2 =(FlightDetails)fDetails.elementAt(i);
				}
		}

		System.out.println("\n  	  ...  Please Choose The Attribute You want to Change ?   ");		// message for manager to enter relevant  attribute that he wants to change
		System.out.println("\n  		1.  Flight Number");		// message to press 1 for flight number
		System.out.println("  		2.  Flight Date");		// message to press 2 for flight date
		System.out.println("  		3.  Flight Time");		//  message to press 3 for flight time
		System.out.println("  		4.  Number Of Seats");	// message  to press 4 for number of seats
		System.out.println("  		5.  Flight Source");		//  message to press 5 for flight source
		System.out.println("  		6.  Flight Destination");	//  message press 6 for flight destination
	
		input = read.GetInt();	// prompt for input
		switch(input)		// start of switch case with parameter as input
		{
			
			case 1:			
			System.out.print("Please Enter the Flight Number:");	// display message to enter the flight number
			String tempstring1 = read.GetString();			// prompt for the flight number
			temp.setFlightNum(tempstring1);
			break;

			case 2:
			System.out.print("Please Enter the Flight Date:");	// display message to enter the flight date
			String tempstring2 = read.GetString();			// prompt for the flight date
			temp.setFlightDate(tempstring2);
			break;

			case 3:
			System.out.print("Please Enter the Flight Time:");	// display message to enter the flight time
			String tempstring3 = read.GetString();			// prompt for the flight time
			temp.setTime(tempstring3);
			break;

			case 4:
			System.out.print("Please Enter the Number of seats:");	// display message to enter the seats on flight
			int tempstring4 = read.GetInt();			// prompt for the seats on flight
			temp.setNumSeats(tempstring4);
			break;

			case 5:
			System.out.print("Please Enter the Source Of the Flight:");	// display message to enter the flight source
			String tempstring5 = read.GetString();			// prompt for the flight source
			temp.setSource(tempstring5);
			break;

			case 6:
			System.out.print("Please Enter the Destination Of the Flight:");	// display message to enter the flight destination
			String tempstring6 = read.GetString();			// prompt for the flight destination
			temp.setDestination(tempstring6);
			break;

			default:	// this is the default case which will implemented when no other condition will be true

			for(int j=0;j<fDetails.size();j++)	// start of for loop
			{
				temp2 = (FlightDetails)fDetails.elementAt(j);
					if(temp2.Flight_Num.equals(flightnum))		// comparing if flight number entered got equals to flight number in the record
						{
							fDetails.insertElementAt(temp,j);	
						}
					else
						{
							//do nothing
						}
			}//end of FOR -LOOP

		}//end of switchcase

	}


	// main method to execute the application
	public static void showMenu() throws java.io.IOException
	{
		int myInput;	// declaring variable
	
		do{	// start of do-while loop

			System.out.println("	***********************************************************");	// line just to beautify our menu
			System.out.println("	||           Welcome to Flight Reservation System	 ||");	// line just to give heading to our menu
			System.out.println("	***********************************************************");	// line just to beautify our menu
			System.out.println("        	||                                           ||");
			System.out.println("          	 --------------  MainMenu --------------------");
			System.out.println("");
			System.out.println("		------     1.  Add New Flight Details   ------     ");	// message to press1  to add flight details
			System.out.println("		------     2.  View Flight Details      ------     ");	// message to press2  to view the flight details
			System.out.println("		------     3.  Save Flight Details      ------     ");	// message to press3  to save the flight entries
			System.out.println("		------     4.  Load Flight Details      ------     ");	// message to press4  to load the flight details
			System.out.println("		------     5.  Edit Flight Details      ------     ");	// message to press5  to edit the flight details
			System.out.println("          	------     6.  View Reservation Record  ------     ");		// message to press6  to view reservation record
			System.out.println("		------     7.  Delete A Flight Record   ------     ");	// message to press7  to delete a flight record
			System.out.println("		------     8.  Exit System    	        ------     ");	// message to press8  to exit the system
			System.out.println("");
			System.out.println("  ::::::     Enter The Number Of The Menu You Wish To Follow!  :::::::");

			myInput=read.GetInt();
		
			if(myInput == 1)	// if input given is 1, then
			{
				AddMenu();	// call AddEntry method and add all the entries
			}	
	
			if(myInput == 2)	// if input given is 2, then
			{
				displayAll();	// call displayAll  method and display all the entries
			}

			if(myInput == 3)	// if input given is 3, then
			{
				saveEntry();	// call saveEntry method and save all the entries
			}

			if(myInput == 4)	// if input given is 4, then
			{
				loadEntry();	// call loadEntry method and load all the entries
			}

			if(myInput == 5)	// if input given is 5, then
			{
				System.out.print("	  ---  Please Enter Flight Number to Update:   --- ");	// display message to enter the flight number to update
				String update = read.GetString();	// prompt for flight update
				updateEntry(update);	// calling method updateEntry
			}

			if(myInput == 6)	// if input given is 6, then
			{
			        displayAllPass();	// call displayAllPass method and display all the entries
			}

			if(myInput == 7)	// if input given is 7, then
			{
				delMenu();	// call delMenu method and delete the entry.
			}

			   else
			{
				//do nothing	
			}

		} 	while(myInput !=8);	// if input given is 8 , then 
			saveEntry();	// call saveEntry method and save all the entries
			System.out.print("		Thank you for Using The System!	");	// message to thank for using the system, means ended
	}


	/*
	public static void main(String args[]) throws java.io.IOException 
	{
		loadEntry();	// calling method to load the entry
		
		// the lines below are just for the sake of making our code beautiful
		// or to give a professional touch.

		System.out.println("loading......");
		System.out.println("loading......");
		System.out.println("loading......");
		System.out.println("loading......");
		System.out.println("loading......");
		System.out.println("loading......");
		System.out.println("loading......");
		System.out.println("loading......");
		System.out.println("loading......");
		System.out.println("loading......");
		System.out.println("loading......");
		System.out.println("loading......");
		System.out.println("loading......");
		System.out.println("loading......");
		System.out.println("loading......");
		System.out.println("loading......");
		System.out.println("loading......");
		System.out.println("loading......");
		System.out.println("loading......");
		System.out.println("loading......");
		System.out.println("loading......");
		System.out.println("loading......");
		System.out.println("loading......");
		System.out.println("loading......");
		System.out.println("loading......");
		System.out.println("loading......");
		System.out.println("loading......");
		System.out.println("loading......");
		System.out.println("Loading Complete");	// ending message showing that all the entries have been loaded
		

		showMenu();	// calling method showMenu

	}//end of Main Method
	
	*/
}//end of class flightMenu
