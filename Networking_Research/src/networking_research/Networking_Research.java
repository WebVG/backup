/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package networking_research;

import java.io.IOException;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.UnknownHostException;

/**
 *
 * @author Fluxu
 */
public class Networking_Research {
    
    public static void pullInfo() throws UnknownHostException, IOException {
        
        InetAddress localhost = InetAddress.getLocalHost();
        byte[] ip = localhost.getAddress();
        NetworkInterface network = NetworkInterface.getByInetAddress(localhost);
        
        for (int i = 1; i <= 254; i++) {
            ip[3] = (byte)i;
            InetAddress address = InetAddress.getByAddress(ip);
            
            if(address.isReachable(1000)) {
                System.out.println
                                ("This machine is: " + address + "\n" + 
                                "Host Address: " + address.getHostAddress() + 
                                 "\n" + address.getAddress() +
                                 "\n" + address.getHostName() + "\n" + address.getCanonicalHostName());
                
            }
        }
    }
    public static void main(String args[]) throws IOException{
 
		InetAddress localhost = InetAddress.getLocalHost();
		// this code assumes IPv4 is used
		byte[] ip = localhost.getAddress();
 
		for (int i = 1; i <= 254; i++)
		{
			ip[3] = (byte)i;
			InetAddress address = InetAddress.getByAddress(ip);
		if (address.isReachable(1000))
		{
			System.out.println(address + " machine is turned on and can be pinged");
                        Networking_Research.pullInfo();
		}
		else if (!address.getHostAddress().equals(address.getHostName()))
		{
			System.out.println(address + " machine is known in a DNS lookup");
		}
		else
		{
			System.out.println(address + " the host address and host name are equal, meaning the host name could be resolved");
		}
		}
 
	}
}
