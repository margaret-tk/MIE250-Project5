package index;



public class SortedDocScore extends DocScore implements Comparable {

	public SortedDocScore(DocScore ds) {
		super(ds);
		// TODO Auto-generated constructor stub
	}

	public SortedDocScore(double score, int doc_id, String content) {
		super(score,doc_id,content);
	}

	
	@Override
	public int compareTo(Object arg0) { //done I think 
		if (!(arg0 instanceof SortedDocScore)) return 0;
		SortedDocScore s = (SortedDocScore)arg0;
		if(this._score > s._score) return -1;
		else if(this._score < s._score) return 1;
		else return this.getContent().compareTo(s.getContent());
	}
	
	
	

	@Override 
	public boolean equals(Object arg0) {
		if(!(arg0 instanceof SortedDocScore)) return false;
		SortedDocScore s = (SortedDocScore)arg0;	
	return this._docID == s._docID && this._score == s._score && this._content.equals(s._content); 
	}
	
	

	
	//optional 
//	@Override
//	public int hashCode() {
		//takes score and id and creates unique identifier 
		
		//Make use of the following already existent hashcodes, don't have to make it fully from scratch 
		
		//_content.hashcode();
		//_score.hashcode( );
		//_id.hashcode();
//		return SortedDocScore.hash(_score, _docID);
//	}

//	}

	
}
