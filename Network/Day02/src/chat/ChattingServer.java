package chat;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

/**
 * 여러 클라이언트로부터 연결을 받아들일 수 있는 채팅 서버
 * @since 2014-09-23
 * @author Heejin Cha
 */
public class ChattingServer {
	
	// 필드 (멤버 변수)
	private static final int DEFAULT_PORT = 10001;
	ServerSocket ss;
	ArrayList<ChattingThread> connections;
	
	
	// 생성자
	/**
	 * 기본 생성자 (기본 포트를 이용하여 서버소켓 생성)
	 * @throws IOException 
	 */
	public ChattingServer() throws IOException {
		init(DEFAULT_PORT);
	}
	
	/**
	 * 지정한 포트를 이용하여 서버소켓을 생성하는 생성자
	 * @param port 서버가 연결을 받아들일 포트 번호
	 * @throws IOException
	 */
	public ChattingServer(int port) throws IOException {
		init(port);
	}
	
	// 메서드 (기능)
	/**
	 * @throws IOException 
	 */
	private void init(int port) throws IOException {
		// connections ArrayList를 생성
		ss = new ServerSocket(port);
		connections = new ArrayList<ChattingThread>();
	}
	
	/**
	 * 모든 클라이언트에게 메시지를 전송하는 메서드
	 * @param message 전송할 메시지
	 */
	public void sendMessageToAll(String message) {
		for (int i = 0; i < connections.size(); i++) {
			// ChattingThread의 sendMessage 메서드를 통해 메시지 전송
			ChattingThread conn = connections.get(i);
			try {
				conn.sendMessage(message);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		ChattingServer server = new ChattingServer();
		
		while (true) {
			// 채팅 클라이언트로부터 연결을 수립하고 Socket 인스턴스를 얻어와서,
			Socket sock = server.ss.accept();
			// 위 Socket 인스턴스로 ChattingThread 인스턴스를 만들고
			ChattingThread connection = new ChattingThread(sock);
			// ChattingThread 목록 (connections)에 추가
			server.connections.add(connection);
			// ChattingThread 쓰레드 실행
			connection.start();
		}
	}
	
}
