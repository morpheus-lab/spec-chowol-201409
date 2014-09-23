package chat.onetoone;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class OneToOneChatServer {
	
	public static class ChatThread extends Thread {
		
		private BufferedReader reader;
		
		public ChatThread(BufferedReader reader) {
			this.reader = reader;
		}
		
		public void run() {
			try {
				while (true) {
					System.out.println("C: " + reader.readLine());
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		
		// 서버소켓 생성
		ServerSocket server = new ServerSocket(10001);
		
		// 서버소켓으로부터 클라이언트와 연결을 대기 후 소켓을 생성
		Socket socket = server.accept();
		
		// 키보드 입력을 받을 수 있는 Reader 객체 생성
		Scanner scanner = new Scanner(System.in);
		
		// 소켓을 통해 메시지를 보낼 수 있는 Writer 객체 생성
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
		
		// 소켓을 통해 메시지를 받을 수 있는 Reader 객체 생성
		BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		
		// 메시지를 읽어서 화면에 출력하는 별도 쓰레드 생성
		ChatThread t = new ChatThread(reader);
		
		// 쓰레드 시작
		t.start();
		
		while (true) {
			// 소켓을 통해 메시지를 보내는 부분
			// 프롬프트 출력
			System.out.print("S: ");
			String message = scanner.nextLine();
			
			if (message.equals("/exit")) {
				break;
			}
			
			writer.write(message + "\n");
			writer.flush();
			
			// 소켓을 통해 메시지를 받는 부분
//			message = reader.readLine();
//			System.out.println("받은 메시지: " + message);
		}
		
		// 소켓 닫기
		socket.close();
	}
	
}
