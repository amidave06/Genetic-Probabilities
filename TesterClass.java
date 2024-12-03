import java.util.Scanner;

public class TesterClass {
	Scanner userInput = new Scanner(System.in);  // Create a Scanner object
    
	Person dad;
	Person mom;
	Person child;

    String childEyeColorType;
    String childHairType;
    String childFrecklesType;

	private void createDad() {
		
    	String e;
    	String h; 
    	String f;
    	
    	// Dad's Eye Color
	    while (true) {
		    System.out.println("Enter DAD eye color, either be brown (dominant) or blue (recessive): ");
			e = userInput.nextLine();  // Read user input
			
			if (EyeColor.isValidColor(e))
					break;
	    }
	    
	    // Dad's Hair Type
	    while(true) {
		    System.out.println("Enter DAD's hair type, either be curly (dominant) or straight (recessive): ");
			h = userInput.nextLine();  // Read user input
			
			if(HairType.isValidHairType(h))
				break;
	    }
	    
	    // Dad's Freckles 
	    while(true) {
		    System.out.println("Does DAD have freckles (dominant) or no-freckles (recessive): ");
			f = userInput.nextLine();  // Read user input
			
			if(Freckles.isValidFreckles(f))
				break;
	    }
	    
		//EYE COLOR
		EyeColor dadEye = new EyeColor(e);
		
		//HAIR TEXTURE
		HairType dadHair = new HairType(h);
		
		//FRECKLES
		Freckles dadFreckles = new Freckles(f);
		
		// create Dad
		dad = new Person(dadEye, dadHair, dadFreckles);
		//System.out.println("Created Dad");
	}
	
	private void createMom() {
	
    	String e, h, f;

    	// Mom's Eye Color
	    while (true) {
		    System.out.println("Enter MOM eye color, either be brown (dominant) or blue (recessive): ");
			e = userInput.nextLine();  // Read user input
			
			if (EyeColor.isValidColor(e))
					break;
	    }

	    // Mom's Hair Type
	    while(true) {
		    System.out.println("Enter MOM's hair type, either be curly (dominant) or straight (recessive): ");
			h = userInput.nextLine();  // Read user input
			
			if(HairType.isValidHairType(h))
				break;
	    }

	    // Mom's Freckles
	    while(true) {
		    System.out.println("Does DAD have freckles (dominant) or no-freckles (recessive): ");
			f = userInput.nextLine();  // Read user input
			
			if(Freckles.isValidFreckles(f))
				break;
	    }

		//EYE COLOR
		EyeColor momEye = new EyeColor(e);
		
		//HAIR TEXTURE
		HairType momHair = new HairType(h);
		
		//FRECKLES
		Freckles momFreckles = new Freckles(f);
		
		
		// create Mom
		mom = new Person(momEye, momHair, momFreckles);
//		System.out.println("Created Mom");
	}

	public void createChild() {

    	String e, h, f;
    	
    	// Child's Eye Color
	    while (true) {
		    System.out.println("Enter the CHILD'S expected eye color, brown (dominant) or blue (recessive): ");
			e = userInput.nextLine();  // Read user input
			
			if (EyeColor.isValidColor(e))
					break;
	    }

	    // Child's Hair Type
	    while(true) {
			System.out.println("Enter the CHILD'S expected hair type, curly (dominant) or straight (recessive): ");
			h = userInput.nextLine();  // Read user input
			
			if(HairType.isValidHairType(h))
				break;
	    }

	    // Child's Freckles
	    while(true) {
		    System.out.println("Enter if CHILD expects to have freckles (dominant) or no-freckles (recessive): ");
			f = userInput.nextLine();  // Read user input
			
			if(Freckles.isValidFreckles(f))
				break;
	    }
	    
		//EYE COLOR
		EyeColor childEye = new EyeColor(e);
		
		//HAIR TEXTURE
		HairType childHair = new HairType(h);
		
		//FRECKLES
		Freckles childFreckles = new Freckles(f);
		
		
		// create Child
		child = new Person(childEye, childHair, childFreckles);

		childEyeColorType = e;
		childHairType = h;
		childFrecklesType = f;
//		System.out.println("Created Child");
	}

	public void runGeneticTest() {
		createDad();
		createMom();
		createChild();
	    
	    
	    double eyeProbability = EyeColor.eyeProbability(dad.getEyeColor(), mom.getEyeColor(), childEyeColorType);
	    System.out.println("Probability of Child's Eye Color being " + childEyeColorType + " = " + eyeProbability); 
	    
	    double hairProbability = HairType.hairProbability(dad.getHairType(), mom.getHairType(), childHairType);
	    System.out.println("Probability of Child's Hair Type being " + childHairType + " = " + hairProbability);
	    
	    
	    double frecklesProbability = Freckles.frecklesProbability(dad.getFreckles(), mom.getFreckles(), childFrecklesType);
	    System.out.println("Probability of Child having " + childFrecklesType + " = " + frecklesProbability);

	    
	    double totalProbability = eyeProbability * hairProbability * hairProbability;
	    System.out.println("Total Probability of Child having " + childEyeColorType + " eyes AND " + childHairType + " hair AND " + childFrecklesType + " = " + totalProbability);
	}

	public static void main(String[] args) {
		
		TesterClass tc = new TesterClass();
		tc.runGeneticTest();
	}
}
