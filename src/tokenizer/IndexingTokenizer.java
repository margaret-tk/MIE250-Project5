package tokenizer;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IndexingTokenizer implements Tokenizer {

	@Override
	public ArrayList<String> tokenize(String s) {

		// Note: can see following page for special characters in Java Regex:
		//       https://docs.oracle.com/javase/6/docs/api/java/util/regex/Pattern.html
		
		ArrayList<String> ret = new ArrayList<String>();
		Pattern p = Pattern.compile("\\w[-\\w]*+"); 
		Matcher m = p.matcher(s.toLowerCase()); 
		while (m.find()) {
			ret.add(m.group());
			// Equivalently we could also say: ret.add(s.substring(m.start(), m.end()));
        }
		return ret;
	}

	public static void main(String[] args) {
		String s = "SoftBank is buying a chunk of Uber and it's state-of-the-art hailing system";
		IndexingTokenizer it = new IndexingTokenizer();
		ArrayList<String> output = it.tokenize(s);
		System.out.println(output);
	}
	
}
