package serialization.client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import serialization.SendData;

public class ObjectCalculatorClient {
	
	public static void main(String[] args) {
		
		// Socket 객체를 통해 서버에 연결
		Socket sock = null;
		
		try {
			sock = new Socket("127.0.0.1", 10004);
			
			// 위 Socket 객체로부터 in/out stream 얻은 다음
			// ObjectInputStream, ObjectOutputStream 객체를 생성
			ObjectOutputStream oos = new ObjectOutputStream(sock.getOutputStream());
			ObjectInputStream ois = new ObjectInputStream(sock.getInputStream());
			
			// 서버로 전송할 SendData 객체를 생성
			SendData data = new SendData(3, 0, "/");
			
			// 이 SendData 객체를 OjbectOutputStream을 통해 서버로 전송
			oos.writeObject(data);
			oos.flush();
			
			// ObjectInputStream을 통해 서버의 응답 메시지를 받음
			String result = (String) ois.readObject();
			
			// 서버 응답 메시지를 화면에 출력
			System.out.println(result);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				// Socket 닫고
				sock.close();
			} catch (IOException e) {}
		}
		// 끝.
	}
	
}
