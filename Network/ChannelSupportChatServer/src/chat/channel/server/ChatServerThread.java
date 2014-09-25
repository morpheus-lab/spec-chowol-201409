package chat.channel.server;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;


public class ChatServerThread extends Thread {
	
	// 이 쓰레드에게 할당된 클라이언트와 연결되어 있는 소켓
	private Socket socket;
	private BufferedWriter writer;
	private BufferedReader reader;
	
	public ChatServerThread(Socket socket) {
		this.socket = socket;
	}
	
	public void sendMessage(String message) throws IOException {
		writer.write(message + "\n");
		writer.flush();
	}
	
	@Override
	public void run() {
		
		try {
			// 클라이언트와 메시지를 주고 받을 Writer 및 Reader 객체 생성
			writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			
			// 환영 메시지를 클라이언트로 보내기
			sendMessage("스펙초월 채팅 서버에 접속하신 것을 환영합니다.");
			
			// 클라이언트로부터 로그인 정보 입력받기
			sendMessage("아이디를 입력하세요.");
			String id = reader.readLine();
			
			// 중복 아이디를 사용하는 클라이언트가 있는지 체크
			// TODO
			
			// 클라이언트에게 메뉴 보여주기
			sendMessage("[채팅방 목록]\n"
					// 채팅방 목록
					+ "\n1. 채팅방 개설   2. 채팅방 참여   3. 접속 종료");
			// 클라이언트가 선택한 메뉴 읽기
			int menu = -1;
			try {
				menu = Integer.parseInt(reader.readLine());
			} catch (NumberFormatException e) {
				// TODO - 메뉴를 다시 입력하도록
			}
			
			switch (menu) {
			case 1:
				// 채팅방 개설에 필요한 정보 입력 받기
				
				// 채팅방 개설
				
				// 개설된 채팅방에 입장시키기
				
				break;
			case 2:
				// 채팅방에 입장
				
				break;
			case 3:
				
				break;
			default:
				break;
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			// 접속 종료
			try {
				sendMessage("접속을 종료합니다. ㅂㅇㅉㅇㅉㅇ");
			} catch (IOException e) {}
			try {
				writer.close();
			} catch (IOException e) {}
			try {
				reader.close();
			} catch (IOException e) {}
			try {
				socket.close();
			} catch (IOException e) {}
		}
		
	}
	
	
}
