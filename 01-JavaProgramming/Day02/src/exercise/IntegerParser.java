package exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

public class IntegerParser {
	
	public static void main(String[] args) throws IOException {
		
		Long l;		// long
		Integer i;	// int
		Short s;	// short
		Byte b;		// byte
		
		Double d;	// double
		Float f;	// float
		
		Boolean bl;	// boolean
		
		
		
		
		Reader isr = new InputStreamReader(System.in);
		BufferedReader reader = new BufferedReader(isr);
		
		String line = null;
		while (true) {
			line = reader.readLine();
			try {
				int a = Integer.parseInt(line);
				System.out.println(String.format("%x", a));
			} catch (Exception e) {
				// 예외 처리
				System.out.println("예외발생");
			}
			
//			if (line != null && !line.trim().equals("")) {
//				int a = Integer.parseInt(line);
//				System.out.println(String.format("%x", a));
//			}
		}
		
		
		
		
		
	}
	
}
