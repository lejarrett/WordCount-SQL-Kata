package dynamit;

import java.io.File;
import java.util.Scanner;

public class WordCount {

	public static void main(String[] args) {
		
		
		
		
		
	}
	
	
	
		// this method asks the user to input a path to a file.
		public File getFilePathFromUser() {
			Scanner scanner = new Scanner(System.in);
			System.out.print("Please enter a path to file you'd like a word count of >>> ");
			String filePath = scanner.nextLine();
			
			File inputFile = new File(filePath);
			if (inputFile.exists() == false) { // checks for the existence of a file
				System.out.println(filePath + " does not exist, please try again.");
				System.exit(1);

			} else if (inputFile.isFile() == false) {
				System.out.println(filePath + " is not a file, please try again.");
				System.exit(1);
			}
			return inputFile;
		}
		
		
		//private File fileToCount = getFilePathFromUser();
		
		
		
		
		
		
		
		
		
	}


