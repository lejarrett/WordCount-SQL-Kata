package dynamit;

import java.io.File;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class WordCountTests {
	
	WordCount testCount  = new WordCount();
	@SuppressWarnings("static-access")
	File testFile = testCount.getFilePathFromUser();



	@Test
	void getFilePathFromUserTest() {		
		
		Assert.assertEquals("Paragraph.txt", testFile.toString());
		Assert.assertEquals(true, testFile.exists());
		
	}
	
	@Test
	void wordCountTest() {		
		
		Assert.assertEquals(4, testCount.wordCount(testFile));
		Assert.assertEquals(true, testFile.exists());
		
	}

}
