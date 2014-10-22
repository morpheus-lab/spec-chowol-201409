package exceptions;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileWrite {

	public static void main(String[] args) {
		
		try {
			File file = new File("text/text.txt");
			
			FileWriter writer = new FileWriter(file);
			
			writer.write("test!!!!!");
			
			writer.flush();
			
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
}
