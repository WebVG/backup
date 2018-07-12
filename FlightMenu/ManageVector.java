import java.util.*;
import java.io.*;

public class ManageVector
{

//A Temporary Vector
public Vector myVector = new Vector();
//The File Path
public String filePath;

//Default Constructor
public ManageVector()
{
}

//Constructor With the Specified File Path given
//Example File Path "C:/Sample.txt"
public ManageVector(String file)
{
this.filePath =file;
}

//Method To Save A Vector Into The File
public void saveVector(Vector temp)
{

try{
	ObjectOutputStream saveObject = new ObjectOutputStream(new FileOutputStream(filePath));
    	saveObject.writeObject(temp);
    	saveObject.close();
        
   }
    catch(IOException e)
    {
    System.out.print(e.toString());
    }
}//End of Save Method

public Vector loadVector()
{
try
{
ObjectInputStream loadObject = new ObjectInputStream(new FileInputStream(filePath));
myVector = (Vector)(loadObject.readObject());
}
catch(FileNotFoundException e1)
{
System.out.print(e1.toString());
}
catch(ClassNotFoundException e2)
{
System.out.print(e2.toString());
}
catch(IOException e)
{
System.out.print(e.toString());
}

return myVector;
}




}//End OF Class Manage Vector