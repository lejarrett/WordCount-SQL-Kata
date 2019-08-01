package dynamit;

import java.io.File;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class WordCountTests {

	@Test
	void FilePathTest() {
		
		WordCount wordCount  = new WordCount();
		
		@SuppressWarnings("static-access")
		File testFile = wordCount.getFilePathFromUser();
		
		Assert.assertEquals("Paragraph.txt", testFile.toString());
		
		
	}
	

}
