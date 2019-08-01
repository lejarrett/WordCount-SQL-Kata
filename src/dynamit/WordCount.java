package dynamit;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class WordCount {

	public static void main(String[] args) {

		File inputFile = getFilePathFromUser();
		wordCount(inputFile);

	}

	// this method asks the user to input a path to a file.
	public static File getFilePathFromUser() {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Please enter a path to file you'd like a word count of >>> \n");

		String filePath = scanner.nextLine();

		File inputFile = new File(filePath);

		if (inputFile.exists() == false) { // checks for the existence of a file

			System.out.println(filePath + " does not exist, please try again.");

			System.exit(1);

		} else if (inputFile.isFile() == false) {

			System.out.println(filePath + " is not a file, please try again.");

			System.exit(1);
		}
		scanner.close();

		return inputFile;
	}

	// this method takes each word, removes characters and numbers, and prints the
	// count of times it appears.
	public static void wordCount(File fileToCount) {

		Map<String, Integer> wordMap = new HashMap<String, Integer>();

		try (Scanner fileScanner = new Scanner(fileToCount)) {

			while (fileScanner.hasNext()) {

				String word = fileScanner.next().replaceAll("[^a-zA-Z ]", "");

				if (!wordMap.containsKey(word)) {

					wordMap.put(word, 1);
				} else {

					int count = wordMap.get(word);
					wordMap.put(word, count + 1);
				}

				System.out.println(word + ": " + wordMap.get(word));

			}

		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}
	}
}
