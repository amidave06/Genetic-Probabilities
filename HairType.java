import java.util.ArrayList;

public class HairType {

	private final static String dominantHairType = "curly";
	private final static String recessiveHairType = "straight";
	
	private String hairType;
	
	private ArrayList <AllelePair> hairAlleleList= new ArrayList <AllelePair>();
	

	public HairType(String c) {
		this.setHairType(c);
	}
	
	public void setHairType(String o) {
		if (o.compareToIgnoreCase(dominantHairType)==0) {		
			// set it to curly
			hairType = dominantHairType;
			
			//Adding dominant allele pairs
			hairAlleleList.clear();
			hairAlleleList.add(new AllelePair(ALLELE.DOMINANT, ALLELE.DOMINANT));
			hairAlleleList.add(new AllelePair(ALLELE.DOMINANT, ALLELE.RECESSIVE));
		}
		else if(o.compareToIgnoreCase(recessiveHairType)==0) {
			// set it to straight
			hairType = recessiveHairType;
			
			//Adding recessive allele pairs
			hairAlleleList.clear();
			hairAlleleList.add(new AllelePair(ALLELE.RECESSIVE, ALLELE.RECESSIVE));
		}
	}
	
	public String getHairType() {
		return hairType;
	}
	
	public ArrayList <AllelePair> getAlleleList() {
		return hairAlleleList;
	}
	
	public static boolean isValidHairType(String e) {		
		if(e.compareToIgnoreCase(dominantHairType) == 0
				|| e.compareToIgnoreCase(recessiveHairType) == 0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public static boolean isDominantHairType(String c) {
		if (c.compareToIgnoreCase(dominantHairType) == 0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public static double hairProbability(HairType dad, HairType mom, String childHairType) {
		
		double hairProbability = 0;
		
//		System.out.println("Child's expected Hair Type = " + childHairType);
		
		if (!HairType.isValidHairType(childHairType)) {
			return 0;
		}
		
		boolean isDominant = HairType.isDominantHairType(childHairType);
		
		ArrayList <AllelePair> d = dad.getAlleleList();
		ArrayList <AllelePair> m = mom.getAlleleList();
	
//		System.out.println("Dad AllelePair Count = " + d.size());
//		System.out.println("Mom AllelePair Count = " + m.size());

		int matchingCount = 0;
		int totalCount = 0;
		
		for (int i = 0; i < d.size(); i++) {
//			System.out.println("Dad - Hair Type Allele Pair [" + i + "] = " + d.get(i));
			for (int j = 0; j < m.size(); j++) {
//			System.out.println("Mom - Hair Type Allele Pair [" + j + "] = " + m.get(j));
				
				
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
		hairProbability = ((double)matchingCount / (double)totalCount);
//
//		System.out.println("matchingCount = " + matchingCount);
//		System.out.println("totalCount = " + totalCount);
//		System.out.printf("probability = %.9f\n", probability);
//		System.out.println("probability = " + probability);
		
		return hairProbability;
	}
}
