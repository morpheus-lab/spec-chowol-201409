package udp.echo.server;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPEchoServer {
	
	public static void main(String[] args) throws IOException {
		
		// DatagramSocket 객체 생성
		DatagramSocket dSock = new DatagramSocket(10001);
		
		// DatagramPacket 객체 생성
		while (true) {
			byte[] buffer = new byte[1024];
			DatagramPacket receivePacket = new DatagramPacket(buffer, buffer.length);
			
			// receive() 메소드를 통해 클라이언트가 전송하는 패킷 대기 & 수신
			dSock.receive(receivePacket);	// dSock으로부터 메시지를 수신해서 receivePacket에 담아라
			
			String msg = new String(receivePacket.getData(), 0, receivePacket.getLength());
			
			System.out.println("전송받은 문자열: " + msg);
			
			if (msg.equals("/quit")) {
				break;
			}
			
			// 위에서 수신한 메시지를 이용해 새로운 DatagramPacket 생성
			
			DatagramPacket sendPacket = new DatagramPacket(
					receivePacket.getData(),	// 받은 메시지 데이터 그대로
					receivePacket.getData().length,	// 받은 메시지 데이터의 길이 그대로
					receivePacket.getAddress(),		// 보내온 애한테 돌려줌
					receivePacket.getPort()			// 보내온 애의 포트로 돌려줌
					);
			
			System.out.println("송신 호스트의 주소: " + receivePacket.getAddress());
			System.out.println("송신 호스트의 포트: " + receivePacket.getPort());
			
			// DatagramSocket의 send() 메소드를 통해 위 DatagramPacket 송신
			dSock.send(sendPacket);
		}
		
		// DatagramSocket close()
		dSock.close();
		
	}
	
}
