import java.util.ArrayList;

public class EyeColor {

	private final static String dominantColor = "brown";
	private final static String recessiveColor = "blue";
	
	private String color;
	
	private ArrayList <AllelePair> eyeAlleleList= new ArrayList <AllelePair>();
	
	public EyeColor(String c) {
		this.setColor(c);
	}
	
	public void setColor(String o) {
		if (o.compareToIgnoreCase(dominantColor)==0) {		
			// set it to brown
			color = dominantColor;
			
			//Adding dominant allele pairs
			eyeAlleleList.clear();
			eyeAlleleList.add(new AllelePair(ALLELE.DOMINANT, ALLELE.DOMINANT));
			eyeAlleleList.add(new AllelePair(ALLELE.DOMINANT, ALLELE.RECESSIVE));
		}
		else if(o.compareToIgnoreCase(recessiveColor)==0) {
			// set it to blue
			color = recessiveColor;
			
			//Adding recessive allele pairs
			eyeAlleleList.clear();
			eyeAlleleList.add(new AllelePair(ALLELE.RECESSIVE, ALLELE.RECESSIVE));
		}
	}
	
	public String getColor() {
		return color;
	}
	
	public ArrayList <AllelePair> getAlleleList() {
		return eyeAlleleList;
	}
	
	public static boolean isValidColor(String e) {		
		if(e.compareToIgnoreCase(dominantColor) == 0
				|| e.compareToIgnoreCase(recessiveColor) == 0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public static boolean isDominantColor(String c) {
		if (c.compareToIgnoreCase(dominantColor) == 0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public static double eyeProbability(EyeColor dad, EyeColor mom, String childEyeColor) {
		
		double eyeProbability = 0;
		
//		System.out.println("Child's expected Eye color = " + childEyeColor);
		
		if (!EyeColor.isValidColor(childEyeColor)) {
			return 0;
		}
		
		boolean isDominant = EyeColor.isDominantColor(childEyeColor);
		
		ArrayList <AllelePair> d = dad.getAlleleList();
		ArrayList <AllelePair> m = mom.getAlleleList();
	
//		System.out.println("Dad AllelePair Count = " + d.size());
//		System.out.println("Mom AllelePair Count = " + m.size());

		int matchingCount = 0;
		int totalCount = 0;
		
		for (int i = 0; i < d.size(); i++) {
//			System.out.println("Dad - Eye Color Allele Pair [" + i + "] = " + d.get(i));
			for (int j = 0; j < m.size(); j++) {
//			System.out.println("Mom - Eye Color Allele Pair [" + j + "] = " + m.get(j));
				
				
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
		eyeProbability = ((double)matchingCount / (double)totalCount);

//		System.out.println("matchingCount = " + matchingCount);
//		System.out.println("totalCount = " + totalCount);
//		System.out.printf("probability = %.9f\n", probability);
//		System.out.println("probability = " + probability);
		
		return eyeProbability;
	}
	
}
