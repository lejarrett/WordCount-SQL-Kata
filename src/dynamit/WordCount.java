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
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

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
			scanner.close();
			return null;
			//System.exit(1);

		} else if (inputFile.isFile() == false) {

			System.out.println(filePath + " is not a file, please try again.");
			scanner.close();
			return null;
			//System.exit(1);
		}
		scanner.close();

		return inputFile;
	}

	// this method takes each word, removes characters and numbers, and prints the
	// count of times it appears.
	public static void wordCount(File fileToCount) {

		HashMap<String, Integer> wordMap = new HashMap<String, Integer>();

		try (Scanner fileScanner = new Scanner(fileToCount)) {

			while (fileScanner.hasNext()) {

				String word = fileScanner.next().replaceAll("[^a-zA-Z ]", "");

				if (!wordMap.containsKey(word)) {
					
					if (word == (" ")) {
						System.out.println("YES I AM BLANK");
					}

					wordMap.put(word, 1);
				} else {

					int count = wordMap.get(word);
					wordMap.put(word, count + 1);
				}

			}
			
			Map <String, Integer> finalCount = sortByCount(wordMap);
			
			for (Map.Entry<String, Integer> ww : finalCount.entrySet()) {
				
				System.out.println(ww.getKey() + " " + ww.getValue());
				
			}

		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}
	}
	
	// this method takes the filled map, and sorts them into a new map based, based on frequency found.
	public static Map<String, Integer> sortByCount (HashMap<String, Integer> wordMap){
		
		List<Map.Entry<String, Integer> > sortedList = new LinkedList<Map.Entry<String,Integer> >(wordMap.entrySet());
		
		Collections.sort(sortedList, new Comparator<Map.Entry<String, Integer> > () {
			
			public int compare(Map.Entry<String, Integer> w1, Map.Entry<String, Integer> w2) {
				return (w2.getValue()).compareTo(w1.getValue()); //simply swap w1 and w2 to change sort order
				
			}
		});
		
		HashMap<String, Integer> temp = new LinkedHashMap<String, Integer>();
		for (Map.Entry<String, Integer> word : sortedList) {
			
			temp.put(word.getKey(), word.getValue());
		}
		
		return temp;
		
	}			
	
}
