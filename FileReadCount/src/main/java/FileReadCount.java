package main.java;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class FileReadCount {
	public static void main(String args[]) {

		// reading file line by line in Java using BufferedReader
		FileInputStream fis = null;
		BufferedReader reader = null;
		Map<String, Long> nameCount = new HashMap<String, Long>();

		try {
			fis = new FileInputStream("C:/Users/Jyothirbindu/text.txt");
			reader = new BufferedReader(new InputStreamReader(fis));

			System.out
					.println("Reading File line by line using BufferedReader");

			String line = reader.readLine();
			while (line != null) {
				System.out.println(line);
				line = reader.readLine();
			}

		} catch (FileNotFoundException ex) {
		} catch (IOException ex) {

		} finally {
			try {
				reader.close();
				fis.close();
			} catch (IOException ex) {
			}
		}
	}
}
