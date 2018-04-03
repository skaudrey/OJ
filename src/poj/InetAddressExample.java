package poj;

import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Enumeration;

public class InetAddressExample {  
	  
    public static void main(String[] args) {  
  
        // Get the network interfaces and associated addresses for this host  
        try {  
            Enumeration<NetworkInterface> interfaceList = NetworkInterface.getNetworkInterfaces();  
            if (interfaceList == null) {  
                System.out.println("--No interfaces found--");  
            } else {  
                while (interfaceList.hasMoreElements()) {  
                    NetworkInterface iface = interfaceList.nextElement();  
                    System.out.println("Interface " + iface.getName() + ":");  
                    Enumeration<InetAddress> addrList = iface.getInetAddresses();  
                    if (!addrList.hasMoreElements()) {  
                        System.out.println("\t(No addresses for this interface)");  
                    }  
                    while (addrList.hasMoreElements()) {  
                        InetAddress address = addrList.nextElement();  
                        System.out.print("\tAddress "+ ((address instanceof Inet4Address ? "(v4)": (address instanceof Inet6Address ? "(v6)": "(?)"))));  
                        System.out.println(": " + address.getHostAddress());  
                    }  
                }  
            }  
        } catch (SocketException se) {  
            System.out.println("Error getting network interfaces:"+ se.getMessage());  
        }  
  
        // Get name(s)/address(es) of hosts given on command line
/** Demo of key-value
 *   Map<String, String> map = new HashMap<String, String>();
 *   map.put("1", "v1");
 *   map.put("2", "v2");
 *   for (String key : map.keySet()) {
 *      System.out.println("key= " + key + " and value= " + map.get(key));
 *   }
 * **/
        for (String host : args) {
            try {  
                System.out.println(host + ":");  
                InetAddress[] addressList = InetAddress.getAllByName(host);  
                for (InetAddress address : addressList) {  
                    System.out.println("\t" + address.getHostName() + "/"+ address.getHostAddress());  
                }  
            } catch (UnknownHostException e) {  
                System.out.println("\tUnable to find address for " + host);  
            }  
        }  
    }  
}