package test;

import index.InvertedIndex;
import io.FileDocSource;
import tokenizer.IndexingTokenizer;
import tokenizer.SimpleTokenizer;
import tokenizer.Tokenizer;

public class TestInvertedIndex {

	
	public static void main(String[] args) {
		
//		 soln.index.InvertedIndex ss = new soln.index.InvertedIndex(new io.StaticDocSource(), 
//				   new tokenizer.SimpleTokenizer(), 
//				   new score.TFScoringFun());
		 
		 index.InvertedIndex ss = new index.InvertedIndex(new io.StaticDocSource(), 
				   new tokenizer.SimpleTokenizer(), 
				   new score.TFScoringFun());
		
		//directory might not be files, especially is you havent downloaded zip from quercus yet 
		ss.buildIndex();
		System.out.println(ss);
		
		System.out.println("this is the frequency" + ss.getDocumentFreq("of"));
	
		System.out.print(ss.getSortedSearchResults("What if it is"));
	
	}

	
	
	
}
