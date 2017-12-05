package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileManager {
	
	public static List<String> getLinesFromFile(File file){
		try {
			Scanner scan = new Scanner(file);
			
			ArrayList<String> out = new ArrayList<>();
			
			while(scan.hasNextLine())
				out.add(scan.nextLine());
			
			return out;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
		
	}
	
}
