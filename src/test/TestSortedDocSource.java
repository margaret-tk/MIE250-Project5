package test;
import index.SortedDocScore;

public class TestSortedDocSource {
	public static void main(String[] arg0) {
		SortedDocScore doc1 = new SortedDocScore(1.0,0,"The quick brown fox jumped over the lazy dog");
		SortedDocScore doc1Copy = new SortedDocScore(doc1);
		SortedDocScore doc2 = new SortedDocScore(1.0, 1, "Amazingly few discotheques prvide jukeboxes");
		SortedDocScore doc3 = new SortedDocScore(2.0 ,2, "Cog");
//		System.out.println("Does doc1 equal doc1Copy?" + (doc1.equals(doc1Copy) ? "yes" : "no"));
//		System.out.println("Does doc1 equal doc2?" + (doc1.equals(doc2) ? "yes" : "no"));
//		System.out.println("Does doc1 come before doc2?" + (doc1.compareTo(doc2) == -1 ? "yes" : "no"));
//		System.out.println("Doc1 hash code: " + doc1.hashCode());
//		System.out.println("Doc2 hash code: " + doc2.hashCode());
		System.out.println("Doc 1 compare to doc 1: " + doc1.compareTo(doc1Copy));
		System.out.println("Doc 1 compare to doc 2: " + doc1.compareTo(doc2));
		System.out.println("Doc 1 compare to doc 3: " + doc1.compareTo(doc3));
		System.out.println("Doc 2 compare to doc 3: " + doc2.compareTo(doc3));
	}

}
