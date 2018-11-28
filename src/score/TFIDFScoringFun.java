package score;

import index.Index;


public class TFIDFScoringFun implements TermScoringFun{

	
	private Index _indexx; 
	
	@Override
	public void init(Index s) {
		_indexx = s;
		
	}

	@Override
	public double scoreToken(String term, int freq) {
	 return ((1 + Math.log10(freq))*(Math.log10((double)_indexx.getDocSource().getNumDocs()/(double)_indexx.getDocumentFreq(term))));

	}

}
