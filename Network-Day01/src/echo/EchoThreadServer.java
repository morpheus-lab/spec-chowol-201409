package echo;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoThreadServer {
	
	public static void main(String[] args) throws IOException {
		
		ServerSocket ss = new ServerSocket(10001);
		
		while (true) {
			Socket sock = ss.accept();
			EchoThread thread = new EchoThread(sock);
			thread.start();
		}
		
	}
	
}
