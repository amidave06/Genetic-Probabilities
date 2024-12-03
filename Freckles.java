import java.util.ArrayList;

public class Freckles {

	private final static String dominantTrait = "freckles";
	private final static String recessiveTrait = "no-freckles";
	
	private String freckles;
	
	private ArrayList <AllelePair> freckleAlleleList= new ArrayList <AllelePair>();
	

	public Freckles(String c) {
		this.setFreckles(c);
	}
	
	public void setFreckles(String o) {
		if (o.compareToIgnoreCase(dominantTrait)==0) {		
			// set it to brown
			freckles = dominantTrait;
			
			//Adding dominant allele pairs
			freckleAlleleList.clear();
			freckleAlleleList.add(new AllelePair(ALLELE.DOMINANT, ALLELE.DOMINANT));
			freckleAlleleList.add(new AllelePair(ALLELE.DOMINANT, ALLELE.RECESSIVE));
		}
		else if(o.compareToIgnoreCase(recessiveTrait)==0) {
			// set it to blue
			freckles = recessiveTrait;
			
			//Adding recessive allele pairs
			freckleAlleleList.clear();
			freckleAlleleList.add(new AllelePair(ALLELE.RECESSIVE, ALLELE.RECESSIVE));
		}
	}
	
	public String getFreckles() {
		return freckles;
	}
	
	public ArrayList <AllelePair> getAlleleList(){
		return freckleAlleleList;
	}
	
	public static boolean isValidFreckles(String e) {		
		if(e.compareToIgnoreCase(dominantTrait) == 0
				|| e.compareToIgnoreCase(recessiveTrait) == 0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public static boolean isDominantFreckles(String c) {
		if (c.compareToIgnoreCase(dominantTrait) == 0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public static double frecklesProbability(Freckles dad, Freckles mom, String childFreckles) {
		
		double frecklesProbability = 0;
		
//		System.out.println("Child's expected Freckle status = " + childFreckles);
		
		if (!Freckles.isValidFreckles(childFreckles)) {
			return 0;
		}
		
		boolean isDominant = Freckles.isDominantFreckles(childFreckles);
		
		ArrayList <AllelePair> d = dad.getAlleleList();
		ArrayList <AllelePair> m = mom.getAlleleList();
	
//		System.out.println("Dad AllelePair Count = " + d.size());3
//		System.out.println("Mom AllelePair Count = " + m.size());

		int matchingCount = 0;
		int totalCount = 0;
		
		for (int i = 0; i < d.size(); i++) {
//			System.out.println("Dad - Freckle Status Allele Pair [" + i + "] = " + d.get(i));
			for (int j = 0; j < m.size(); j++) {
//			System.out.println("Mom - Freckle Status Allele Pair [" + j + "] = " + m.get(j));
				
				if(isDominant) {
					if(d.get(i).first == ALLELE.DOMINANT || m.get(j).first == ALLELE.DOMINANT) {
						matchingCount++;
					}
					if(d.get(i).first == ALLELE.DOMINANT || m.get(j).second == ALLELE.DOMINANT) {
						matchingCount++;
					}
					if(d.get(i).second == ALLELE.DOMINANT || m.get(j).first == ALLELE.DOMINANT) {
						matchingCount++;
					}
					if(d.get(i).second == ALLELE.DOMINANT || m.get(j).second == ALLELE.DOMINANT) {
						matchingCount++;
					}
					totalCount +=4;
				}
				else {
					if(d.get(i).first == ALLELE.RECESSIVE && m.get(j).first == ALLELE.RECESSIVE) {
						matchingCount++;
					}
					if(d.get(i).first == ALLELE.RECESSIVE && m.get(j).second == ALLELE.RECESSIVE) {
						matchingCount++;
					}
					if(d.get(i).second == ALLELE.RECESSIVE && m.get(j).first == ALLELE.RECESSIVE) {
						matchingCount++;
					}
					if(d.get(i).second == ALLELE.RECESSIVE && m.get(j).second == ALLELE.RECESSIVE) {
						matchingCount++;
					}
					totalCount +=4;
				}
//				System.out.println("matchingCount = " + matchingCount);
			}
		}
		frecklesProbability = ((double)matchingCount / (double)totalCount);

//		System.out.println("matchingCount = " + matchingCount);
//		System.out.println("totalCount = " + totalCount);
//		System.out.printf("probability = %.9f\n", probability);
//		System.out.println("probability = " + probability);
		
		return frecklesProbability;
	}
	
}
