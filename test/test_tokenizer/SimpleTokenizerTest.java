package test_tokenizer;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import tokenizer.Tokenizer;
import tokenizer.IndexingTokenizer;
import tokenizer.SimpleTokenizer;

public class SimpleTokenizerTest {

	@Test
	public void testTokenize() {
		Tokenizer tok = new IndexingTokenizer();
		ArrayList<String> tokens = tok.tokenize("mother-in-law product.");
		assertEquals("Failed lowercase", "a", tokens.get(0));
		assertEquals("Failed hyphen test", "mother-in-law", tokens.get(0));
		assertEquals("Failed simple token", "product", tokens.get(2));
	}

	
	@Test
	public void myNewTest() {
		//create all objects to be used for this test
		//if you can, guarantee random input 
		assertEquals("Who knows" , "Hello", "hello");
	}
	
	
	
	@Test
	public void failAlways() {
		//Thread.sleep(3000);
		fail("This always fails");
	}
}
