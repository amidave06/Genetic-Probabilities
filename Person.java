public class Person {
	private EyeColor eyeColor;
	private HairType hairType;
	private Freckles freckles;
	
	public Person(EyeColor e, HairType h, Freckles f) {
		eyeColor = e;
		hairType = h;
		freckles = f;
	}
	
	public EyeColor getEyeColor() {
		return eyeColor;
	}
	
	public void setEyeColor(EyeColor e) {
		eyeColor = e;
	}
	
	public HairType getHairType() {
		return hairType;
	}
	
	public void setHairType(HairType h) {
		hairType = h;
	}

	public Freckles getFreckles() {
		return freckles;
	}
	
	public void setFreckles(Freckles f) {
		freckles = f;
	}
}
