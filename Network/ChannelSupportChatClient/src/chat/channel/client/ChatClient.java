package chat.channel.client;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

public class ChatClient {
	
	public static void main(String[] args) throws IOException {
		
		// 서버에 접속할 Socket 객체 생성
		Socket socket = new Socket("192.168.0.105", 10001);
		
		// InputStream을 꺼내서 ChatClientThread 객체를 생성
		InputStream in = socket.getInputStream();
		ChatClientThread ccThread = new ChatClientThread(in);
		
		// ChatClientThread 객체 시작
		ccThread.start();
		
		// OutputStream을 꺼내서 Writer 객체 생성
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
		
		// 사용자가 키보드를 통해 입력하는 내용을 읽어들일 수 있는 Scanner 객체 생성
		Scanner scanner = new Scanner(System.in);
		
		try {
			while (true) {
				// Scanner로 사용자 입력 읽어서
				String msg = scanner.nextLine();
				
				// 서버로 전송
				writer.write(msg + "\n");
				writer.flush();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			// 서버로부터 접속이 끊겼거나, IO 관련 오류가 발생한 경우
			try {
				socket.close();
			} catch (IOException e) {}
		}
		
		
	}
	
}
