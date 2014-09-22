package echo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
	
	public static void main(String[] args) throws IOException {
		
		ServerSocket ss = new ServerSocket(10001);
		System.out.println("포트 10001번, 에코 서버 시작 완료");
		
		System.out.println("연결대기중...");
		// 클라이언트로부터 연결 대기
		Socket client = ss.accept();
		
		System.out.println("연결 완료");
		
		// 위 클라이언트 연결 소켓으로부터 in, out 얻어내고
		InputStream in = client.getInputStream();
		OutputStream out = client.getOutputStream();
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(in));
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(out));
		
		// in / reader 로부터 데이터를 읽고,
		String line = reader.readLine();
		System.out.println("클라이언트로 부터 받은 데이터: " + line);
		
		// 위 데이터를 out을 통해 보내면
		writer.write(line + "\n");
		writer.flush();
		
		// 끝
		in.close();
		out.close();
		client.close();
		ss.close();
		
	}
	
}
