package tokenizer;

import java.util.ArrayList;

/** Provides a single method that turns a String s into a list of
 *  individual tokens (i.e., word terms) for indexing.
 * 
 * @author ssanner@mie.utoronto.ca
 *
 */
public interface Tokenizer {
	public abstract ArrayList<String> tokenize(String s);
}

//takes in string and returns list of words 
//needs to handle words with hyphens and convert upper and lower case words to be the same 