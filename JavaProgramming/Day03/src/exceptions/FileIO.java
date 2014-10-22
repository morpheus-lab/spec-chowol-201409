package exceptions;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileIO {

	public static void main(String[] args) {

		BufferedReader reader = null;
		
		try {
			File file = new File("FileIOTest.txt");

			FileReader fReader = null;
			fReader = new FileReader(file);

			reader = new BufferedReader(fReader);

			String line = null;

			while ((line = reader.readLine()) != null) {
				System.out.println(line);
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				reader.close();
			} catch (IOException e) {}
		}
	}

}
