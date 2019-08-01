package dynamit;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class WordCount {

	public static void main(String[] args) {

		File inputFile = getFilePathFromUser();
		ArrayList<String> inputList = wordSplitter(inputFile);
		wordCounter(inputList);

	}

	// this method asks the user to input a path to a file.
	public static File getFilePathFromUser() {
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
		scanner.close();
		return inputFile;
	}

	public static ArrayList<String> wordSplitter(File fileToCount) {

		ArrayList<String> wordList = new ArrayList<String>();

		try (Scanner fileScanner = new Scanner(fileToCount)) {

			while (fileScanner.hasNext()) {

				String myTest = fileScanner.nextLine();

				String[] wordSplit = myTest.replaceAll("[^a-zA-Z ]", "").toLowerCase().split("[-\\s]");

				for (int i = 0; i < wordSplit.length; i++) {

					wordList.add(wordSplit[i]);
				}

			}

			System.out.println(wordList.size());

		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}
		return wordList;

	}

	public static void wordCounter(ArrayList wordList) {

		Map<String, Integer> wordMap = new HashMap<String, Integer>();

		String[] words = new String[wordList.size()];

		for (int i = 0; i < wordList.size(); i++) {

			words[i] = (String) wordList.get(i);
		}

		for (String w : words) {

			if (!wordMap.containsKey(w)) {

				wordMap.put(w, 1);
			} else {

				int count = wordMap.get(w);
				wordMap.put(w, count + 1);
			}

			System.out.println(w + ": " + wordMap.get(w));

		}

	}

}
