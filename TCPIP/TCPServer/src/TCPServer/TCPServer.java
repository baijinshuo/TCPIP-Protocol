package TCPServer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author Jinshuo Bai
 *
 */
public class TCPServer {

	/**
	 * @param args
	 */
	
	private BufferedReader reader;
	private ServerSocket server;
	private Socket socket;
	
	public void getServer(){
		try {
			server = new ServerSocket(8877);
			System.out.println("Create Socket Successfully!");
			while (true) {
				System.out.println("Waiting for connection:");
				socket = server.accept();
				reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				getClientMessage();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void getClientMessage() {
		try {
			while (true) {
				System.out.println("Client£º" + reader.readLine());
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		try {
			if(reader != null){
				reader.close();
			}
			if(socket != null){
				socket.close();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public static void main(String[] args) {
		TCPServer server = new TCPServer();
		server.getServer();
	}

}
