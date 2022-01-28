package homework.abstraction;

public abstract class Constants {
	public abstract void radius();
	public abstract void mass();
	public abstract void accelarationOfGravity();
	
	public void belongsToSolarSystem() {
		System.out.println("The planet belongs to the solar system");
	}

}
