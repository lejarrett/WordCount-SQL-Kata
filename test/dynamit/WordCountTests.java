package dynamit;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class WordCountTests {
	
	WordCount testCount  = new WordCount();
	
	File sample = new File("sample.txt");



	@Test
	void getFilePathFromUserTest() {		
		
		System.out.println("** FILE PATH TEST BELOW **");
		File testFile = testCount.getFilePathFromUser();

		Assert.assertEquals(true, testFile.exists());
		
	}
	
	@Test
	void wordCountTest() {		
		
		HashMap<String, Integer> testMap = testCount.getWordCount(sample);
		
		Assert.assertEquals(8, testMap.size());
		Assert.assertEquals(true, testMap.containsKey("the"));
		Assert.assertEquals(true, testMap.containsKey("quick"));
		Assert.assertEquals(true, testMap.containsKey("brown"));
		Assert.assertEquals(true, testMap.containsKey("fox"));
		Assert.assertEquals(true, testMap.containsKey("jumped"));
		Assert.assertEquals(true, testMap.containsKey("over"));
		Assert.assertEquals(true, testMap.containsKey("lazy"));
		Assert.assertEquals(true, testMap.containsKey("dog"));
		Assert.assertEquals(false, testMap.containsKey("The"));
		Assert.assertEquals(false, testMap.containsKey("Frank"));
		Assert.assertEquals(false, testMap.containsKey("-./"));
		Assert.assertEquals(false, testMap.containsKey("1934"));
		
		Assert.assertEquals((Integer)2, testMap.get("the"));
		Assert.assertEquals((Integer)1, testMap.get("quick"));
		Assert.assertEquals((Integer)1, testMap.get("brown"));
		Assert.assertEquals(null, testMap.get("Frank"));

		
	}
	
	@Test
	void unsortedPrintTest() {		
		
		HashMap<String, Integer> testMap = testCount.getWordCount(sample);
		
		System.out.println("**********");
		System.out.println("** SHOULD BE UNSORTED BELOW **");
		System.out.println("**********");

		
		for (Map.Entry<String, Integer> word : testMap.entrySet()) {

			System.out.println(word.getKey() + " " + word.getValue());
		}

	}
	
	@Test
	void sortedPrintTest() {		
		
		System.out.println("**********");
		System.out.println("** SHOULD BE SORTED BELOW **");
		System.out.println("**********");

		
		HashMap<String, Integer> testMap = testCount.getWordCount(sample);
		
		testCount.printOutSortedMap(testMap);
		System.out.println("\n");
		
	}

}
