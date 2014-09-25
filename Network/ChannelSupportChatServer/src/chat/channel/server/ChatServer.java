package chat.channel.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class ChatServer {
	
	static ArrayList<ChatServerThread> CLIENTS = new ArrayList<ChatServerThread>();
	
	public static void main(String[] args) throws IOException {
		
		// ServerSocket 객체 생성
		ServerSocket server = new ServerSocket(10001);
		
		while (true) {
			// 연결 수락 => Socket 객체
			Socket socket = server.accept();
			
			// 위 Socket 객체로 클라이언트의 명령을 처리할 쓰레드 생성
			ChatServerThread csThread = new ChatServerThread(socket);
			
			// 위 쓰레드를 시작
			csThread.start();
			
			synchronized(ChatServer.CLIENTS) {
				// 접속된 클라이언트 목록에 위 쓰레드 추가
				ChatServer.CLIENTS.add(csThread);
			}
		}
		
		
	}
	
}
