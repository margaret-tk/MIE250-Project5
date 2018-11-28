package MyJUnitTests;

import static org.junit.Assert.*;

import org.junit.Test;

public class testScoring {

	@Test
	public void TestTFIDFScoring() {
		 
		
		//Build solution and my code index
		soln.index.InvertedIndex solIndex = new soln.index.InvertedIndex(new io.FileDocSource("files/Part1/awards_1994"), 
                new soln.tokenizer.IndexingTokenizer(), 
				  new soln.score.TFIDFScoringFun()); 
		
		index.InvertedIndex myIndex = new index.InvertedIndex(new io.FileDocSource("files/Part1/awards_1994"), 
                new tokenizer.IndexingTokenizer(), 
				  new score.TFIDFScoringFun()); 
		
		//build my and solution index
		solIndex.buildIndex();
		myIndex.buildIndex();
		
		//build TFIDF Scoring and solution TFIDFScoring
		score.TermScoringFun myScore = new score.TFIDFScoringFun(); 
		 soln.score.TFIDFScoringFun solnScore = new soln.score.TFIDFScoringFun(); 
		
		 //Initalize index into scoring 
		 myScore.init(myIndex);
		 solnScore.init(solIndex);
		 
		 //test same scoring with some term and some frequency 
		 assertEquals("Failed Scoring", myScore.scoreToken("this", 2) ,  solnScore.scoreToken("this", 2), 0.0001); 
		 
	}

}
