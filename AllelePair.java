public class AllelePair {
	
	ALLELE first;
	ALLELE second;
	
	public AllelePair(ALLELE one, ALLELE two) {
		first = one;
		second = two;	
	}
	
	public ALLELE getFirst() {
		return first;
	}
	
	public void setFirst(ALLELE f) {
		first = f;
	}
	
	public ALLELE getSecond() {
		return second;
	}
	
	public void setSecond(ALLELE s) {
		second = s;
	}
	
	public String toString() {
		return ("Allele Pair - first = " + first.toString() + " second = " + second.toString());
	}
}
