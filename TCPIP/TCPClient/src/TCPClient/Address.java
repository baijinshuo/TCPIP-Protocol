package TCPClient;
import java.net.*;

public class Address {
	
	String localip;
	String localname;
	
	/**
	 * 
	 */
	public Address() {
		InetAddress ip;
		try {
			ip = InetAddress.getLocalHost();
			localip = ip.getHostAddress();
			localname = ip.getHostName();
		} 
		catch (UnknownHostException e) {
			e.printStackTrace();
		}
		
	}

	public String getLocalip() {
		return localip;
	}


	public String getLocalname() {
		return localname;
	}
}
