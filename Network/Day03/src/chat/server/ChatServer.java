package chat.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class ChatServer {
	
	static ArrayList<ClientConnectionThread> clients
		= new ArrayList<ClientConnectionThread>();
	
	public static void main(String[] args) throws IOException {
		
		// 서버 소켓 생성
		ServerSocket server = new ServerSocket(10001);
		System.out.println("서버 소켓 생성 완료");
		
		while (true) {
			System.out.println("클라이언트 연결 대기중...");
			// 서버 소켓으로 들어오는 연결 요청을 받아들여,
			// 클라이언트와의 연결을 담당하는 소켓을 얻어냄
			Socket sock = server.accept();
			
			System.out.println(sock.getInetAddress().getHostName() +
					"와(과) 연결 완료");
			
			// 클라이언트와 연결된 소켓으로부터 메시지를 입력 받고,
			// 입력받은 메시지를 현재 연결된 모든 클라이언트에게 전달하는
			// 쓰레드를 생성하고 시작
			ClientConnectionThread connection = new ClientConnectionThread(sock);
			connection.start();
			
			synchronized (clients) {
				// 연결된 클라이언트 정보를 저장
				ChatServer.clients.add(connection);
			}
		}
		
	}
	
}
