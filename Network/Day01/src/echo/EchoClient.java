package echo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;


public class EchoClient {
	
	public static void main(String[] args) throws UnknownHostException, IOException {
		
		// 서버에 연결하는 소켓 생성
		Socket sock = new Socket("192.168.0.105", 10001);
		
		// 소켓에서 in 꺼내고
		InputStream in = sock.getInputStream();
		BufferedReader reader = new BufferedReader(new InputStreamReader(in));
		
		// 소켓에서 out 꺼내고
		OutputStream out  = sock.getOutputStream();
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(out));
		
		// out을 통해 데이터 보내고
		writer.write("HELLO" + "\n");
		writer.flush();
		
		// in을 통해 서버로 부터 반환되는 데이터 표시
		String line = reader.readLine();
		System.out.println("서버로 부터 온 데이터: " + line);
		
		// 끝
		in.close();
		out.close();
		sock.close();
		
	}
	
}
