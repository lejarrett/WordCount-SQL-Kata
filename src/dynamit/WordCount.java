package dynamit;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class WordCount {

	public static void main(String[] args) {
		
		WordCount wordCount = new WordCount();

		File inputFile = wordCount.getFilePathFromUser();

		HashMap<String, Integer> mapToSort = wordCount.getWordCount(inputFile);

		wordCount.printOutSortedMap(mapToSort);

	}

	/**
	 * Asks the user for the path to a text file.
	 * @return returns a File to be used for the Word Count
	 */

	public File getFilePathFromUser() {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Please enter a path to file you'd like a word count of >>> \n");

		String filePath = scanner.nextLine();

		File inputFile = new File(filePath);

		if (inputFile.exists() == false) { // checks for the existence of a file

			System.out.println(filePath + " does not exist, please try again.");
			scanner.close();
			System.exit(1);

		} else if (inputFile.isFile() == false) {

			System.out.println(filePath + " is not a file, please try again.");
			scanner.close();
			System.exit(1);
		}
		scanner.close();

		return inputFile;
	}

	/**
	 * Takes each word, removes characters and numbers, adds it to an unsorted map
	 * @returns a Map to be sorted 
	 */

	public HashMap<String, Integer> getWordCount(File fileToCount) {

		HashMap<String, Integer> wordMap = new HashMap<String, Integer>();

		try (Scanner fileScanner = new Scanner(fileToCount)) {

			while (fileScanner.hasNext()) {

				String word = fileScanner.next().replaceAll("[^a-zA-Z ]", "").toLowerCase(); // lowercase is important so that the program doesn't think for example, "The" and "the" are different words

				if (word.equals("")) {
					
					word = fileScanner.next();
				}
				
				if (!wordMap.containsKey(word)) {

					wordMap.put(word, 1);
					
				} else {

					int count = wordMap.get(word);
					wordMap.put(word, count + 1);
					
				}

			}

		} catch (FileNotFoundException e) {
			
			System.out.println("Whoops. We've encountered an error.");
			e.printStackTrace();
		}

		return wordMap;
	}

	/**
	 * Takes a map, and using a Comparator, sorts the instances of the words in the file from greatest, to least.
	 * @returns a sorted Map
	 */

	public Map<String, Integer> sortByCount(HashMap<String, Integer> wordMap) {

		List<Map.Entry<String, Integer>> sortedList = new LinkedList<Map.Entry<String, Integer>>(wordMap.entrySet());

		Collections.sort(sortedList, new Comparator<Map.Entry<String, Integer>>() {

			public int compare(Map.Entry<String, Integer> w1, Map.Entry<String, Integer> w2) {
				return (w2.getValue()).compareTo(w1.getValue()); // simply swap w1 and w2 to change sort order

			}
		});

		HashMap<String, Integer> sortedMap = new LinkedHashMap<String, Integer>();
		for (Map.Entry<String, Integer> word : sortedList) {

			sortedMap.put(word.getKey(), word.getValue());
		}

		return sortedMap;

	}

	/**
	 * This method simply takes a sorted Map, and prints out the log to the console
	 *
	 */

	public void printOutSortedMap(HashMap<String, Integer> wordMap) {

		Map<String, Integer> finalCount = sortByCount(wordMap);

		for (Map.Entry<String, Integer> ww : finalCount.entrySet()) {

			System.out.println("-----------");
			System.out.println(ww.getKey() + ": " + ww.getValue());
		}
		
			System.out.println("-----------");
			System.out.println("Total Unique Words: " + finalCount.size());
		
	}

}
