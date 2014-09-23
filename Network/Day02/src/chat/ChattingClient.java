package chat;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class ChattingClient extends Thread {
	
	// 필드 (멤버 변수)
	Socket sock;
	BufferedReader sockReader;
	BufferedWriter sockWriter;
	BufferedReader kbReader;
	
	// 생성자
	public ChattingClient() throws UnknownHostException, IOException {
		sock = new Socket("127.0.0.1", 10001);
		sockReader = new BufferedReader(new InputStreamReader(sock.getInputStream()));
		sockWriter = new BufferedWriter(new OutputStreamWriter(sock.getOutputStream()));
		kbReader = new BufferedReader(new InputStreamReader(System.in));
	}
	
	// 메서드 (기능)
	// 서버에 메시지 전송
	public void sendMessage(String message) throws IOException {
		sockWriter.write(message + "\n");
		sockWriter.flush();
	}
	
	// 채팅 클라이언트가 서버로부터 데이터를 읽어 화면에 출력
	public void run() {
		try {
			String line = null;
			while ((line = sockReader.readLine()) != null) {
				System.out.println(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void close() {
		// in/out stream 정리
		try {
			sockReader.close();
		} catch (IOException e) {}
		try {
			sockWriter.close();
		} catch (IOException e) {}
		try {
			kbReader.close();
		} catch (IOException e) {}
		
		// Socket 닫기
		try {
			sock.close();
		} catch (IOException e) {}
	}
	
	public static void main(String[] args) throws UnknownHostException,
			IOException {
		
		ChattingClient client = new ChattingClient();
		
		// 본인의 아이디를 서버에 전송
		System.out.print("ID: ");
		String line = client.kbReader.readLine();
		
		client.sendMessage(line);
		
		while (true) {
			System.out.print("서버에 전송할 문자열: ");
			// 키보드 입력으로 부터 문자열을 읽음
			line = client.kbReader.readLine();
			
			// 종료 조건 판단
			if (line != null && line.equals("/quit")) {
				client.sendMessage(line);
				break;
			}
			
			// 소켓으로 문자열 쓰기
			client.sendMessage(line);
		}
		
		client.close();
		
		/*
		Socket sock = new Socket("127.0.0.1", 10001);
		
		// 소켓으로 데이터를 쓸 수 있는 OutputStream
		OutputStream out = sock.getOutputStream();
		OutputStreamWriter osw = new OutputStreamWriter(out);
		BufferedWriter writer = new BufferedWriter(osw);
		
		// 키보드 입력을 받아 들이는 InputStream
		InputStream in = System.in;
		InputStreamReader isr = new InputStreamReader(in);
		BufferedReader kbReader = new BufferedReader(isr);
		
		// 본인의 아이디를 서버에 전송
		System.out.print("ID: ");
		String line = kbReader.readLine();
		
		writer.write(line + "\n");
		writer.flush();
		
		while (true) {
			System.out.print("서버에 전송할 문자열: ");
			// 키보드 입력으로 부터 문자열을 읽음
			line = kbReader.readLine();
			
			// 종료 조건 판단
			if (line != null && line.equals("/quit")) {
				writer.write(line + "\n");
				writer.flush();
				break;
			}
			
			// 소켓으로 문자열 쓰기
			writer.write(line + "\n");
			writer.flush();
		}
		
		// in/out stream 정리
		writer.close();
		kbReader.close();
		
		// Socket 닫기
		sock.close();
		*/
	}

}
