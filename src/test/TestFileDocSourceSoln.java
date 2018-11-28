package test;

import soln.io.FileDocSource;
import soln.tokenizer.IndexingTokenizer;

public class TestFileDocSourceSoln {
 
	public static void main(String[] args) {
		FileDocSource fds = new FileDocSource("files"); //directory might not be files, especially is you havent downloaded zip from quercus yet 
		System.out.println(fds.getNumDocs());
		System.out.println("-----------------------");
		System.out.println(fds.getDoc(0));
		System.out.println("-------------");
		IndexingTokenizer it = new IndexingTokenizer();
		System.out.println(it.tokenize(fds.getDoc(0)));
		
	}
}
