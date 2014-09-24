package serialization.server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import serialization.SendData;

public class ObjectCalculatorServer {
	
	public static void main(String[] args) {
		
		ServerSocket server = null;
		Socket sock = null;
		
		try {
			// 서버 소켓 생성
			server = new ServerSocket(10004);
			System.out.println("클라이언트 연결 대기중...");
			// 클라이언트 연결 요청 대기
			sock = server.accept();
			System.out.println("클라이언트와 연결되었습니다.");
			
			ObjectInputStream ois = new ObjectInputStream(sock.getInputStream());
			ObjectOutputStream oos = new ObjectOutputStream(sock.getOutputStream());
			
			// 클라이언트로 부터 읽을 데이터의 임시 저장 변수
			Object obj = null;
			
			// 클라이언트로 부터 데이터를 읽고 임시 저장 변수 obj에 저장
			obj = ois.readObject();
			
			SendData data = (SendData) obj;
			
			int op1 = data.getOp1();
			int op2 = data.getOp2();
			String opCode = data.getOpCode();	// "+", "-", "*", "/"
			
			String result = null;
			
			if ("+".equals(opCode)) {	// opCode.equals("+")
				// op1 = 1 이고, op2 = 2 였다면,
				// "1 + 2 = 3"이라고 출력
				result = op1 + " + " + op2 + " = " + (op1 + op2);
			}
			else if ("-".equals(opCode)) {
				result = op1 + " - " + op2 + " = " + (op1 - op2);
			}
			else if ("*".equals(opCode)) {
				result = op1 + " * " + op2 + " = " + (op1 * op2);
			}
			else if ("/".equals(opCode)) {
				if (op2 == 0) {
					result = "[ERROR] 0으로 나눌 수 없습니다.";
				} else {
					result = op1 + " / " + op2 + " = " + (op1 / op2);
				}
			} else {
				result = "[ERROR] 지원하지 않는 연산자이거나, 연산자가 NULL입니다.";
			}
			
			oos.writeObject(result);
			oos.flush();
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				sock.close();
			} catch (IOException e) {}
			
			try {
				server.close();
			} catch (IOException e) {}
		}
		
	}
	
}





























