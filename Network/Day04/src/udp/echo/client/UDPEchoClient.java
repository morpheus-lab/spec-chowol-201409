package udp.echo.client;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class UDPEchoClient {
	
	public static void main(String[] args) throws IOException {
		
		// DatagramSocket 생성
		DatagramSocket dSock = new DatagramSocket();
		
		// 보낼 메시지를 키보드로 부터 입력
		Scanner scanner = new Scanner(System.in);
		
		while (true) {
			System.out.print("전송할 메시지: ");
			String msg = scanner.nextLine();
			
			// DatagramPacket을 수신할 대상
			InetAddress destination = InetAddress.getByName("127.0.0.1");
			
			// 보낼 DatagramPacket 생성
			DatagramPacket sendPacket = new DatagramPacket(
					msg.getBytes(),
					msg.getBytes().length,
					destination,
					10001);
			
			// DatagramSocket의 send() 메소드를 통해 보낼 DatagramPacket 송신
			dSock.send(sendPacket);
			
			// 반복문 종료 조건 체크
			if (msg.equals("/quit")) {
				break;
			}
			
			// 서버의 응답 DatagramPacket을 수신하고
			
			// 패킷을 받을 저장공간(그릇)을 준비
			byte[] buffer = new byte[msg.getBytes().length];
			DatagramPacket rPacket = new DatagramPacket(buffer, buffer.length);
			
			dSock.receive(rPacket);	// dSock을 통해 패킷을 수신하고, 그 데이터를 rPacket에 담아라
			
			msg = new String(rPacket.getData());
			
			// 화면에 출력하고
			System.out.println("받은 메시지: " + msg);
		}
		
		scanner.close();
		
		// 끝
		dSock.close();
	}
	
}
