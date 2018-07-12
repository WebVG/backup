import java.util.*;
import java.io.*;

public class systemUsers
 {

        static ManageVector system1 = new ManageVector("login1.txt");
	
	static Vector systemuser1 = new Vector();

        public static void saveUser()
	{
		system1.saveVector(systemuser1);
	}

        public static void loadUser()
	{	
		systemuser1 = system1.loadVector();
	}

        public static void addNewUser() throws java.io.IOException
        {
        System.out.print("Please Enter your Name:");
        String name = read.GetString();
        System.out.print("Please Enter Your Password:");
        String pass = read.GetString();
        System.out.print("Please enter your type 1-Manager 2-User");
        int n=  read.GetInt();
        systemuser1.addElement(new Users(name,pass,n));
        saveUser();

        }


        public static void loginMenu()throws java.io.IOException
	{
		System.out.println("    ---------------------------------------------------------------  ");
		System.out.println("    ---------------------  LOGIN MENU -----------------------------  ");
		System.out.println("    ---------------------------------------------------------------  ");
		System.out.println("    |					                	  |"); 
		System.out.print("    |							          |\n");
		System.out.println("    |     Enter your name and password to login either as 	  | \n\n			Administrator / User  ?          ");

                //systemuser1.addElement(new Users("Mazhar","Hello",1));
                //systemuser1.addElement(new Users("Mazhar2","Hello2",2));

		System.out.print("\n    ===========      Please Enter your Name :   ");
		String Name = read.GetString();

		System.out.print("\n    ===========      Please Enter your Password  :  ");
		String pass = read.GetString();

		System.out.print("\n    ===========      Please Enter type  :   ");
		int tt = read.GetInt();

		Users Temp = new Users();

		for(int i=0;i<systemuser1.size();i++)
		{	
			Temp = (Users)systemuser1.elementAt(i);
			if(Temp.Name.equals(Name) && Temp.Password.equals(pass))
				{
					if(Temp.type == 1)
					{
						flightMenu mymenu = new flightMenu();
						
						mymenu.loadEntry();
						mymenu.showMenu();
					}
					else						
					if(Temp.type == 2)
					{
						flightResMenu mymenu = new flightResMenu();
		
						mymenu.loadEntry();
						mymenu.showMenu();
					}
				
					else
					{
						System.out.println("\n 	     ************************************************	");
						System.out.println(" 		Alert !!!    You are not a correct user	?????	");
						System.out.println(" 		Make sure user name and password are correct	");
						System.out.println(" 	     ************************************************	");
					}
					
				}
		else
			{
				
			}
		}

	}


 public static void main(String args[]) throws java.io.IOException
 {
 int input;
 //loadUser();
 do
 {
 System.out.println("Main Menu");
 System.out.println("1.Login Menu");
 System.out.println("2.New User");
 System.out.println("3.EXIT SYSTEM");
 input = read.GetInt();
 if(input == 1)
 {
 loginMenu();
 }
 if(input == 2)
 {
 addNewUser();
 }

 }
 while(input!=3);


 }




 }

class Users implements Serializable
  {
		public String Name;
		public String Password;
		public int type;
	public Users(){

	}


	public Users(String one, String two, int three)
	{
		this.Name = one;
		this.Password = two;
		this.type = three;
	}	


  }
