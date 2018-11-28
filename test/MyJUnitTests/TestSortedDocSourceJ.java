package MyJUnitTests;

import static org.junit.Assert.*;

import org.junit.Test;

import index.SortedDocScore;

public class TestSortedDocSourceJ {

	@Test
	public void testCompareTo() {

		//my code
		SortedDocScore doc1 = new SortedDocScore(1.0,0,"The quick brown fox jumped over the lazy dog");
		SortedDocScore doc1Copy = new SortedDocScore(doc1);
		SortedDocScore doc2 = new SortedDocScore(1.0, 1, "Amazingly few discotheques prvide jukeboxes");
		SortedDocScore doc3 = new SortedDocScore(2.0 ,2, "Cog");
		
		//Solution code 
		soln.index.SortedDocScore doc1s = new soln.index.SortedDocScore(1.0,0,"The quick brown fox jumped over the lazy dog");
		soln.index.SortedDocScore doc1Copys = new soln.index.SortedDocScore(doc1);
		soln.index.SortedDocScore doc2s = new soln.index.SortedDocScore(1.0, 1, "Amazingly few discotheques prvide jukeboxes");
		soln.index.SortedDocScore doc3s = new soln.index.SortedDocScore(2.0 ,2, "Cog");
		
		//Test sorting by score 
		assertEquals("Test with diff score", doc1s.compareTo(doc3s) , doc1.compareTo(doc3) );
		
		//Test sorting with same score, alphabetical ordering 
		assertEquals("Test with same score", doc1s.compareTo(doc2s) , doc1s.compareTo(doc2s) ); 
		
	}

	
	
	@Test
	public void testEquals() {
		
		SortedDocScore doc1 = new SortedDocScore(1.0,0,"The quick brown fox jumped over the lazy dog");
		SortedDocScore doc1Copy = new SortedDocScore(doc1);
		SortedDocScore doc2 = new SortedDocScore(1.0, 1, "Amazingly few discotheques prvide jukeboxes");
		SortedDocScore doc3 = new SortedDocScore(2.0 ,2, "Cog");
		
		//Solution code 
		soln.index.SortedDocScore doc1s = new soln.index.SortedDocScore(1.0,0,"The quick brown fox jumped over the lazy dog");
		soln.index.SortedDocScore doc1Copys = new soln.index.SortedDocScore(doc1);
		soln.index.SortedDocScore doc2s = new soln.index.SortedDocScore(1.0, 1, "Amazingly few discotheques prvide jukeboxes");
		soln.index.SortedDocScore doc3s = new soln.index.SortedDocScore(2.0 ,2, "Cog");
		
		
		//Test sorting by score 
		assertEquals("Test different doc, same content", doc1s.compareTo(doc1Copys) , doc1.compareTo(doc1Copy) );
				
		//Test sorting with same score, alphabetical ordering 
		assertEquals("Test with different content", doc1s.compareTo(doc2s) , doc1s.compareTo(doc2s) ); 
		
	}
	
	
}
