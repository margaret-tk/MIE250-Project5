package MyJUnitTests;


import static org.junit.Assert.*;

import org.junit.Test;



public class IndexTest{

	
	
	//this tests whether sortedSearchResults returns the same arraylist 
	
	@Test
	public void testIndex_searchResults() {

		soln.index.InvertedIndex solIndex = new soln.index.InvertedIndex(new io.FileDocSource("files/Part1/awards_1994"), 
                new soln.tokenizer.IndexingTokenizer(), 
				  new soln.score.TFIDFScoringFun()); 
		
		index.InvertedIndex myIndex = new index.InvertedIndex(new io.FileDocSource("files/Part1/awards_1994"), 
                new tokenizer.IndexingTokenizer(), 
				  new score.TFIDFScoringFun()); 
		
		solIndex.buildIndex();
		myIndex.buildIndex();
	
		
		assertEquals("Failed buildIndex", solIndex.getSortedSearchResults("The elephants in the room are me and Maria") , myIndex.getSortedSearchResults("The elephants in the room are me and Maria")); 
		

	}

}
