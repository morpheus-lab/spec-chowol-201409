package chat;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class ChattingServer {
	
	private ArrayList<Socket> clients;
	private ServerSocket ss;
	
	public ChattingServer(int port) throws IOException {
		clients = new ArrayList<Socket>();
		ss = new ServerSocket(port);
	}
	
	// 새로운 클라이언트 접속 시, 클라이언트 목록에 추가
	public void addClient(Socket sock) {
		clients.add(sock);
	}
	
	// 모든 채팅 클라이언트에게 message 전송
	public void sendMsgToAll(String message) {
		// TODO
	}
	
	// 모든 채팅 클라이언트에게 새로운 클라이언트 접속 알림
	public void sendWelcomeMsg(String id) {
		String message = id + "님이 접속하였습니다.";
		sendMsgToAll(message);
	}
	
	// 모든 채팅 클라이언트에게 접속 종료한 클라이언트 알림
	public void sendDisconnectMsg(String id) {
		String message = id + "님이 접속 종료하였습니다.";
		sendMsgToAll(message);
	}
	
}
