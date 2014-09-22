package chat;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class ChattingThread extends Thread {
	
	private Socket sock;
	private BufferedReader reader;
	private BufferedWriter writer;
	
	private ChattingServer server;
	
	private String id;
	
	// 생성자
	public ChattingThread(Socket sock, ChattingServer server) throws IOException {
		this.sock = sock;
		if (sock != null) {
			// reader 객체 생성
			InputStream in = sock.getInputStream();
			InputStreamReader isr = new InputStreamReader(in);
			reader = new BufferedReader(isr);
			// writer 객체 생성
			OutputStream out = sock.getOutputStream();
			OutputStreamWriter osw = new OutputStreamWriter(out);
			writer = new BufferedWriter(osw);
		}
		
		this.server = server;
	}
	
	// 클라이언트로부터 메시지를 받아 서버로 전달하는 기능
	// 1. 접속 알림
	public void notifyConnection() {
		server.sendWelcomeMsg(id);
	}
	
	// 2. 일반 메시지
	public void sendToAll(String message) {
		server.sendGeneralMsg(id, message);
	}
	
	// 3. 종료 알림
	public void notifyDisconnection() {
		server.clients.remove(this);
		server.sendDisconnectMsg(id);
	}
	
	// 서버로부터 메시지를 받아 클라이언트로 전달하는 기능
	public void sendToClient(String message) {
		try {
			writer.write(message + "\n");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void run() {
		
		try {
			id = reader.readLine();	// 아이디 읽어서
			notifyConnection();	// 접속 알림
			
			String line = null;
			while ((line = reader.readLine()) != null) {
				// 종료 명령어 여부 체크
				if (line.equals("/quit")) {
					break;
				}
				// 일반 메시지
				else {
					sendToAll(line);
				}
			}
			// 종료 작업
			reader.close();
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				sock.close();
			} catch (IOException e) {}
			notifyDisconnection();	// 서버에 종료 알림
		}
	}
	
}
