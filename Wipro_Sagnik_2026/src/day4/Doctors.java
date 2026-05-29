package day4;

class Doctors extends Doctor{
	public Doctors(String name,String specialization) {
		super(name,specialization);
	}
	
	void diagnose(Paitent P) {
		if(specialization.equalsIgnoreCase("cardiologist")) {
			if(P.getIllness().contains("heart")) {
				System.out.println("Cardiologist " + name + 
						" treats heart paitent " + P.getName());
				System.out.println();
			}else {
				System.out.println("Cardiologist Suggest "
						+ "check for general checkup");
				System.out.println();
			}
		}else {
			System.out.println("General Physician " + name +
					" treats " + P.getName() + " for " + P.getIllness());
			System.out.println();
		}
	}
}
