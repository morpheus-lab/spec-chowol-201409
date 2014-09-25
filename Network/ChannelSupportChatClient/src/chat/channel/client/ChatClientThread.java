package chat.channel.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * 서버로부터 화면에 출력할 내용을 받아와서
 * 화면에 표시
 */
public class ChatClientThread extends Thread {
	
	// 서버로 부터 메시지를 읽어 올 InputStream
	private InputStream in;
	
	// 생성자
	public ChatClientThread(InputStream in) {
		this.in = in;
	}
	
	// 이 쓰레드만의 기능
	@Override
	public void run() {
		BufferedReader reader = new BufferedReader(new InputStreamReader(in));
		
		try {
			String msg = null;
			while ((msg = reader.readLine()) != null) {
				System.out.println(msg);
			}
		} catch (IOException e) {
			System.out.println("접속이 종료되었습니다.");
		} finally {
			try {
				reader.close();
			} catch (IOException e) {}
		}
	}
	
}
