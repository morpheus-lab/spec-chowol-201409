package chat;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;

/**
 * 클라이언트와 연결된 후 생성되는 Socket을 이용하여 
 * 여러 기능을 제공하는 쓰레드
 */
public class ChattingThread extends Thread {
	
	// 필드 (멤버 변수)
	private Socket socket;
	private BufferedReader reader;
	private BufferedWriter writer;
	private ChattingServer server;
	
	// 생성자
	public ChattingThread(ChattingServer server, Socket socket) {
		this.server = server;
		this.socket = socket;
		init();
	}
	
	// 기능 (메서드)
	
	/**
	 * 초기화 작업
	 */
	private void init() {
		if (socket != null) {
			// BufferedReader 만들기
			try {
				InputStream in = socket.getInputStream();
				InputStreamReader isr = new InputStreamReader(in);
				reader = new BufferedReader(isr);
			} catch (IOException e) {
				e.printStackTrace();
			}
			// BufferedWriter 만들기
			try {
				OutputStream out = socket.getOutputStream();
				OutputStreamWriter osw = new OutputStreamWriter(out);
				writer = new BufferedWriter(osw);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 특정 클라이언트 (이 클래스가 담당하는 연결)에게 메시지 송신
	 * @throws IOException 
	 */
	public void sendMessage(String message) throws IOException {
		writer.write(message + "\n");
	}
	
	/**
	 * 
	 */
	public void run() {
		String line = null;
		
		try {
			String id = reader.readLine();
			// 모든 클라이언트에 접속 알림 전송
			server.sendMessageToAll(id + "님이 접속하였습니다.");
			
			// 클라이언트가 보내는 문자열을 읽어서 모든 클라이언트에 전송
			while ((line = reader.readLine()) != null) {
				if (line.equals("/quit")) {
					// 접속 종료 처리
					server.sendMessageToAll(id + "님이 접속을 종료하였습니다.");
					break;
				}
				// 일반 대화문으로 처리
				server.sendMessageToAll(id + ": " + line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}










