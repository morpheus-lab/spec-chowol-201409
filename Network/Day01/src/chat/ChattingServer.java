package chat;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class ChattingServer {
	
	ArrayList<ChattingThread> clients;
	private ServerSocket ss;
	
	public ChattingServer(int port) throws IOException {
		clients = new ArrayList<ChattingThread>();
		ss = new ServerSocket(port);
	}
	
	// 새로운 클라이언트 접속 대기
	public ChattingThread accept() throws IOException {
		if (ss != null && !ss.isClosed()) {
			Socket newClient = ss.accept();
			return new ChattingThread(newClient, this);
		}
		return null;
	}
	
	// 새로운 클라이언트 접속 시, 클라이언트 목록에 추가
	public void addClient(ChattingThread client) {
		clients.add(client);
	}
	
	// 모든 채팅 클라이언트에게 message 전송
	public void sendMsgToAll(String message) {
		for (int i = 0; i < clients.size(); i++) {
			clients.get(i).sendToClient(message);
		}
	}
	
	// 일반 대화
	public void sendGeneralMsg(String id, String message) {
		String msg = id + ": " + message;
		sendMsgToAll(msg);
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
