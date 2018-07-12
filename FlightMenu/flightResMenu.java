import java.util.*;
import java.io.*;

// start of class definition
public class flightResMenu	
{

	static Vector fResDetails = new Vector();	// making vector for class flight reservation details 

	static ManageVector fres = new ManageVector("res.txt"); 	// making an object for manager vector classand storing informatioin in the file 'res.txt'.

	static Vector fDetails = new Vector();	// making vector for class flight details
	
	static ManageVector manager = new ManageVector("sample.txt");	// making an object of manage vector class and storing informatioin in the file 'sample.txt'.


	private static void AddResDetails(String flightnum,String personName,String personAdd,int personPhone,String personEmail,int resvType,int numberSeats ) 	// start of method
	{
	                fDetails = manager.loadVector();	// loading manager file data
                
		flightResDetails temp2 = new flightResDetails(flightnum,personName,personAdd,personPhone,personEmail,resvType,numberSeats);	//creating object for class flight reservation details
		fResDetails.addElement(temp2);	// adding information to the flight resdetails class
	
	                saveEntry();	// saving the record
	
	                updateFDetails(flightnum,numberSeats);         	// updating flight details
		System.out.println("	Entry Has Been Made");	// displaying a message that entry has been made
	}	// end of method

	public static void AddResMenu() throws java.io.IOException	// start of method
	{
		// variable declarations
		String fnum;
		String pName;
		String pAdd;
		int pPhno;
		String pEmail;
		int resType;
		int noSeats;
	
		System.out.println("	Please Enter The Following Information");	// asking the user to enter the information

		System.out.print("	Enter Flight Number :   ");	// asking user to enter flght number
		fnum = read.GetString();	// prompt for flight number

		System.out.print("	Enter your name  :   ");	// asking user to enter name
		pName = read.GetString();	// prompt for name

		System.out.print("	Enter your completer address  :   ");	// asking user to enter address
		pAdd = read.GetString();	// prompt for address

		System.out.print("	Enter your phone number  :   ");	// asking user to enter phone number
		pPhno = read.GetInt();	// prompt	for phone number

		System.out.print("	Enter your email address  :   ");	// asking user to enter email addres
		pEmail = read.GetString();	// prompt for email address
	
		System.out.print("	Enter the reservation type  :   ");	// asking user to enter reservation type
		resType = read.GetInt();	// prompt for reservation type

		System.out.print("	How many seats you want to reserved  :   ");		// asking user to enter number of  seats required
		noSeats = read.GetInt();	// prompt for number of seats
		AddResDetails(fnum,pName,pAdd,pPhno,pEmail,resType,noSeats);	// 
	}

	public static void displayAllPass()	// start of method
	{
		flightResDetails temp2;	// declaring object for flight reservation details class

		System.out.println("--Flight No.--Name--Address--Phone No.--Email Add--Resv Type--Seats Reserved");	// displaying the passengers menu
		System.out.println("");
		
		for(int i = 0; i<fResDetails.size();i++)	// beginning of for loop
			{
				temp2 =(flightResDetails)fResDetails.elementAt(i);
				System.out.println(temp2.Flight_Num+"--"+temp2.Name+"--"+temp2.Address+"--"+temp2.phone+"--"+temp2.Email+"--"+temp2.Res+"--"+temp2.Num_OfResSeats);	// displaying passengers record
			}
	}


	public FlightDetails get(String num)	// start of method
	{
	
		// making two objects of class flight details which are temp and temp2
		
		FlightDetails temp = new FlightDetails();
		FlightDetails temp2 = new FlightDetails();

		fDetails = manager.loadVector();	// loading manager record

		for(int i = 0;i<fDetails.size();i++)	// start of for loop
		{
			temp2 = (FlightDetails)fDetails.elementAt(i);
			if(temp2.Flight_Num.equals(num))	// if condition checking if the flight number becomes equal to the input given.
				{
					temp = temp2;	// then store temp2 in temp
				}

		}

		return temp;
	}	// end of method



	public static void updateFDetails2(String num,int n)	// start of the method
	{
		// making two objects of class flight details which are temp and temp2	

		FlightDetails temp = new FlightDetails();
		FlightDetails temp2 = new FlightDetails();

		for(int i=0;i<fDetails.size();i++)
			{
				temp = (FlightDetails)fDetails.elementAt(i);
		
				if(temp.Flight_Num.equals(num))
					{
				                                temp.Num_Of_Seats = temp.Num_Of_Seats + n;
				                                fDetails.setElementAt(temp,i);
					}
			}

		manager.saveVector(fDetails);	// saving record in manager file
	
	}//end of method

	public static void updateFDetails(String num,int n)	// start of method
	{
		// making two objects of class flight details which are temp and temp2	
	
		FlightDetails temp = new FlightDetails();
		FlightDetails temp2 = new FlightDetails();
	
		for(int i=0;i<fDetails.size();i++)	// start of for loop
		{
			temp = (FlightDetails)fDetails.elementAt(i);	
			
		                        if(temp.Num_Of_Seats< n)	// condition testing if the seats available are less than the seats reserved
                		        {
			                        System.out.print("Seats already booked");	// displaying information to users that seats are already booked.
		                        }
		                        else{
			                        if(temp.Flight_Num.equals(num))	
			        	                {
			                	                temp.Num_Of_Seats = temp.Num_Of_Seats - n;
			                                	fDetails.setElementAt(temp,i);
		                        		}	// end of if condition
                        			}	// end of else statement
		}	//end of for loop



		manager.saveVector(fDetails);	// saving managers record
		
	}//end of method

	public static void cancelBooking() throws java.io.IOException	// start of method
	{
		// variable declarations	
		String Name;
		String Address;
	
		fDetails = manager.loadVector();	// loading manager vector file

		System.out.println("Please Enter the Following information to cancel your flight");	// displaying information message

		System.out.print("Please Enter your Name :   ");	// displaying message to enter name
		Name = read.GetString();	// prompt for name

		System.out.print("Please Enter your Address :  ");		// displaying message to enter address
		Address = read.GetString();	// prompt for address

		flightResDetails temp = new flightResDetails();	// making object of class flight reservation details

		for(int i=0;i<fResDetails.size();i++)	// start of for loop
			{
				temp = (flightResDetails)fResDetails.elementAt(i);
				if(temp.Name.equals(Name) && temp.Address.equals(Address))
				{
					updateFDetails2(temp.Flight_Num,temp.Num_OfResSeats);
					fResDetails.removeElementAt(fResDetails.indexOf(temp));

				}	// end of if statement

			}	// end of lor loop
	}	// end of method



	public static void searchResEntry() throws java.io.IOException	// start of method
	{
		// variable declarations

		String Name;
		String Address;

		System.out.print("Please enter your following information for your reservation result:  \n");	// displaying the information to enter for searching a reservation
		
		System.out.print("	Enter Name  :   ");	// displaying message to enter name
		Name = read.GetString();	// prompt for the name

		System.out.print("	Enter Address  :   ");	// displaying message to enter address
		Address = read.GetString();	//prompt for address

		flightResDetails temp2 = new flightResDetails();	//making object  of the class flight Reservation details

		for(int i=0;i<fResDetails.size();i++)	// start of the for loop
			{	
				temp2 = (flightResDetails)fResDetails.elementAt(i);	//

				if(temp2.Name.equals(Name) && temp2.Address.equals(Address))	// check if the name and addres get matched.
					{
						// printing passenger reservation information
						System.out.println(temp2.Flight_Num+"--"+temp2.Name+"--"+temp2.Address+"--"+temp2.phone+"--"+temp2.Email+"--"+temp2.Res+"--"+temp2.Num_OfResSeats);
					}
			}
	}


	public static void searchEntry() throws java.io.IOException	// start of method
	{
 	// varibale declarations
		String num;
		String Name;
		FlightDetails temp;
	
	// loading manager file
 	                fDetails = manager.loadVector(); 

	               // Searching the managers database for  the particular flight
		System.out.print("  Please Enter The Country Name you Wish to Travel to?   ");
		num = read.GetString();	// prompt for the name of the country
		
		System.out.println("---Flight No.---Flight Date---Flight Time---NO.Seats---Source---Dest---");	// displaying flight schedule
		
		System.out.println("");
			for(int i = 0; i<fDetails.size();i++)	// start of for loop
			{
				temp =(FlightDetails)fDetails.elementAt(i);	// temporary variable 
                		                	if(temp.Destination.equals(num))	//start of if statement
						{
							System.out.println(temp.Flight_Num+"----"+temp.FlightDate+"----"+temp.Time+"----"+temp.Num_Of_Seats+"----"+temp.Source+"----"+temp.Destination);
						} // end of if statement	
			}	// end of for loop

	}	// end of method

	public static void saveEntry()		// start of loadEntry method
	{
		fres.saveVector(fResDetails);
		System.out.println();
		System.out.println();
		System.out.println("	======	Your Entries For Today Have Been Saved!	======	");

	}	//end of method
	

	public static void loadEntry()		// start of loadEntry method
	{
		fResDetails = fres.loadVector();
		System.out.println();
		System.out.println();
		System.out.println("	Your Entries Been Loaded!	");
	}	//end of method

	public static void loadPassEntry()	// start of method to load passenger
	{
		System.out.println();
		System.out.println();
		System.out.println("Passenger Entries Been Loaded!");

	}	// end of loadPasEnty method

	public static void showMenu() throws java.io.IOException	// start of method to show menu
	{
		int myInput;	// declaring variable to get input for the menu options

		do{	// start of do-while loop
		
			System.out.println("	***********************************************************	");	// displaying the line of astericks for beauty of our code
			System.out.println("	*	      WELCOME TO FLIGHT RESERVATION SYSTEM	  *	");	// displaying welcome message to the users
			System.out.println("	***********************************************************	");
			System.out.println("	|							  | 	");
			System.out.println("	|							  |	");
			System.out.println("	------------------- MAIN MENU -----------------------------	");	// displaying heading for the main menu
			System.out.println("");
			System.out.println("    	......    1.   Book Flight   			......");	// Option to book flight flights.
			System.out.println("	......    2.   Cancel Flight			......	");	// Option to cancel the flight
			System.out.println("    	......    3.   Search for Flights             	......");	// Option to search for the flight
			System.out.println("	......    4.   Search for Reservation Details	......");	// Option to get information
			System.out.println("        ......    5.   Exit System                      ......");	// Option to get out of the system.
		
			System.out.println("");	// printing a new line for an extra space.
			System.out.print("	~~~ Enter The Number Of The Menu You Wish To Follow !     ");	// message asking users to select a choice
			myInput=read.GetInt();	// prompt for the menu choices
		
			if(myInput == 1)
			{
				AddResMenu();	// calling method add reservation entry if input given is 1.
			}
			if(myInput == 2)
			{
				cancelBooking();	// calling method to cancel booking reservation entry if input given is 2.
			}
			if(myInput == 3)
			{
				searchEntry ();	// calling method for flight enquiry entry if input given is 3.
			}
			if(myInput == 4)
			{
				searchResEntry();	// calling method search reservation entry if input given is 4.
			}

		}while(myInput !=5);		// termination condition for the do-while loop
	
		saveEntry();	// calling method save entry to save all the entry, when the while loop condition got true
	
		System.out.print("	======        Thank you for Using The System!   ====== 	  ");	// message to be displayed upon exit of the program

	}// end of do-while loop



	public static void main(String args[]) throws java.io.IOException	// start of main method 
	{
		loadEntry();	// calling method to load the entry

		showMenu();	// calling method to show all menu

	}	//end of Main Method

}//end of class

