package MyJUnitTests;
import static org.junit.Assert.*;

import org.junit.Test;



public class TestFileDocSource {

	
	@Test
	public void testGetDoc() {
		
		//Build my FileDocSource and solution FileDocSource objects
		io.DocSource mySource = new io.FileDocSource("files/Part1/awards_1994");
		soln.io.FileDocSource solnSource = new soln.io.FileDocSource("files/Part1/awards_1994");
		
		//Make sure that the number of docs is the same in my source
		assertEquals("Same number of docs", solnSource.getNumDocs() , mySource.getNumDocs());
		
		//Generate random integer between zero and number_of_docs in source (to test different case everytime) 
		int docID = 0 + (int)(Math.random() * ((solnSource.getNumDocs() - 0) + 1));
		
		//Test getDoc to make sure the source is being converted correctly 
		assertEquals("Failed Scoring", mySource.getDoc(docID) ,  solnSource.getDoc(docID) ); 
		
	}

}
