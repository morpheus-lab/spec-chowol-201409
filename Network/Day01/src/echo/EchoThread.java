package echo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class EchoThread extends Thread {
	
	private Socket sock;
	
	public EchoThread(Socket sock) {
		this.sock = sock;
	}

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + " 실행 시작");
		
		// 별도 스레드로 실행할 일
		try {
			InputStream in = sock.getInputStream();
			OutputStream out = sock.getOutputStream();
			
			BufferedReader reader = new BufferedReader(new InputStreamReader(in));
			BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(out));
			
			//
			System.out.println("클라이언트정보: " + sock.getInetAddress().getHostName());
//			System.out.println("클라이언트정보: " + sock.getInetAddress().getHostAddress());
			
			// in / reader 로부터 데이터를 읽고,
			String line = reader.readLine();
			System.out.println("클라이언트로 부터 받은 데이터: " + line);
			
			// 위 데이터를 out을 통해 보내면
			writer.write(line + "\n");
			writer.flush();
			
			in.close();
			out.close();
			reader.close();
			writer.close();
			// sock.close();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				sock.close();
			} catch (IOException e) {}
		}
	}
	
}
