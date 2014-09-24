package chat.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;

public class ClientConnectionThread extends Thread {
	
	// 소켓 (이 클라이언트와의 메시지 통신을 담당하는)
	Socket socket;
	// 위 소켓을 통해 메시지를 보낼 수 있는 Writer
	PrintWriter writer;
	// 위 소켓을 통해 메시지를 받을 수 있는 Reader
	BufferedReader reader;
	
	// 생성자
	public ClientConnectionThread(Socket socket) throws IOException {
		this.socket = socket;
		// writer & reader 초기화
		writer = new PrintWriter(socket.getOutputStream());
		reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
	}
	
	// 이 클라이언트에게 메시지를 보내는 메서드
	public void sendMessage(String message) {
		writer.write(message + "\n");
		writer.flush();
	}
	
	// 이 쓰레드가 할 일
	public void run() {
		
		String line = null;
		
		while (true) {
			try {
				// 클라이언트로부터 메시지를 수신
				line = reader.readLine();
				
				synchronized (ChatServer.clients) {
					// 이 클라이언트를 포함한, 모든 클라이언트에게 메시지 송신
					ArrayList<ClientConnectionThread> list = ChatServer.clients;
					
					for (int i = 0; i < list.size(); i++) {
						ClientConnectionThread client = list.get(i);
						client.sendMessage(line);
					}
				}
				
			} catch (IOException e) {
				e.printStackTrace();
				break;
			}
		}
		
		try {
			socket.close();
		} catch (IOException e) {}
		
	}
	
}
