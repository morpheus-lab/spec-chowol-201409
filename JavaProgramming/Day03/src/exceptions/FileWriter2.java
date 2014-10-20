package exceptions;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


public class FileWriter2 {

	public static void main(String[] args) {
		
		// 키보드로부터 문자열을 입력받을 수 있는 Scanner 객체 생성
		Scanner sc = new Scanner(System.in);
		
		String buffer = "";
		
		while (true) {
			// 키보드로부터 문자열을 입력받기
			String line = sc.nextLine();
			
			if (line.equals("quit")) {
				break;
			}
			
			// 입력받은 문자열을 버퍼에 담기
			buffer += line;
			buffer += "\r\n";
		}
		
		// 버퍼에 저장된 문자열을 파일에 쓰기
		FileWriter writer = null;
		try {
			File file = new File("test.txt");
			writer = new FileWriter(file);
			writer.write(buffer);
			writer.flush();
		} catch (IOException e) {
			// 예외 처리
			e.printStackTrace();
		} finally {
			try {
				if (writer != null) {
					writer.close();
				}
			} catch (Exception e) {}
		}
	}
	
}
