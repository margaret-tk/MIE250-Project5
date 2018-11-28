package index;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

import io.DocSource;
import io.FileDocSource;
import score.TermScoringFun;
import tokenizer.Tokenizer;

import java.io.File;

public class InvertedIndex extends Index {

	private Map<String, HashMap<Integer,Integer>> _index;
	private HashMap<String, Integer> _docFreq;
	private HashMap<Integer, Integer> _indexInner;
	 
	public InvertedIndex(DocSource doc_source, Tokenizer tokenizer, TermScoringFun scoring) {
		super(doc_source,tokenizer,scoring);
		_index = new HashMap<String, HashMap<Integer,Integer>>();
		_docFreq = new HashMap<String, Integer>();
	}
	
	
//	@Override
//	public String toString() { //double check that this is identical 
//		StringBuilder sb = new StringBuilder();
//
//		for(String each: _index.keySet()) {
//			sb.append(each + "={");
//			for(int every : _index.get(each).keySet()) {
//				sb.append(every + "=" + _index.get(each).get(every) + " ");
//		}
//			
//		sb.append("}, ");
//			
//		}
//		
//		return sb.toString();
//	}
	
	
	
	
	@Override
	public void buildIndex() {
		
		int freq;
		
		for (int i = 0; i < _docSource.getNumDocs(); i++) { //each file 
			
			for( String each : _tokenizer.tokenize(_docSource.getDoc(i))) { //goes through each string in the file 
				
			
				if(_index.containsKey(each)) {//if key already exists 
					
					
					if(!_index.get(each).containsKey(i)) { //not in same doc as already existed
						_index.get(each).put(i, 1);
						//we're only concerned with counting number of docs term exists in so we only increase docFreq when string is not in doc where it previously existed 
						_docFreq.put(each, _docFreq.get(each)+1); 
						
					}
					
					else { // key is in the same doc as it's already been seen
						
						
						freq =  _index.get(each).get(i) + 1; 
						_index.get(each).put(i,freq) ;
					;
					}
				
				} 
				
				
				else {
					_index.put(each, new HashMap<Integer,Integer>() );
				_index.get(each).put(i, 1);
				 _docFreq.put(each,1); //if the tozenized term is
				}
			}
		}	
			//System.out.println("This is docFreq" + _docFreq);
		}
		
	

	@Override
	public Integer getDocumentFreq(String term) {
		return _docFreq.get(term);
	}

	@Override
	public ArrayList<DocScore> getSortedSearchResults(String query) {  
		
		HashMap<Integer, Double> scores = new HashMap<Integer,Double>();
		double currentScore;
		TreeSet<DocScore> docScores = new TreeSet<DocScore>();

		for( String term:  _tokenizer.tokenize(query)) { //for each term in query 
			
			if(_index.containsKey(term)) {	
			
				for (int ID : _index.get(term).keySet()) { //for each document that contains the term 
		
					if(!scores.containsKey(ID) && _index.get(term).get(ID) != null) {
//					
						scores.put(ID, _scoring.scoreToken(term, _index.get(term).get(ID)));
					}
					else {
						currentScore = scores.get(ID);
						scores.put(ID, currentScore + _scoring.scoreToken(term, _index.get(term).get(ID))); //add score to old score 
					}
				
			}
			}
		}
		
		
		
		
		for(Integer each: scores.keySet()) {
			
			SortedDocScore sorted = new SortedDocScore( scores.get(each) , each , _docSource.getDoc(each) );
			docScores.add(sorted);
	
		}
		
		
		return new ArrayList<DocScore>(docScores);
	}

}
