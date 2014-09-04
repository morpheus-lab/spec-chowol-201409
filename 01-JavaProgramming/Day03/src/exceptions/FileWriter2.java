package exceptions;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


public class FileWriter2 {

	public static void main(String[] args) {
		
		// Ű����κ��� ���ڿ��� �Է¹��� �� �ִ� Scanner ��ü ����
		Scanner sc = new Scanner(System.in);
		
		String buffer = "";
		
		while (true) {
			// Ű����κ��� ���ڿ��� �Է¹ޱ�
			String line = sc.nextLine();
			
			if (line.equals("quit")) {
				break;
			}
			
			// �Է¹��� ���ڿ��� ���ۿ� ���
			buffer += line;
			buffer += "\r\n";
		}
		
		// ���ۿ� ����� ���ڿ��� ���Ͽ� ����
		FileWriter writer = null;
		try {
			File file = new File("test.txt");
			writer = new FileWriter(file);
			writer.write(buffer);
			writer.flush();
		} catch (IOException e) {
			// ���� ó��
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
