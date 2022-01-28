package homework.abstraction;

public class Mars extends Constants implements EarthPoint, SunPoint {
	public void radius() {
		System.out.println("The radius of the Mars is 3389 km");
	}
	public void mass() {
		System.out.println("The mass of the Mars is 6.42*10^23 kg");
	}
	public void accelarationOfGravity() {
		System.out.println("The accelaration of gravity of the Mars is 3,711 m/s");
		}
	public void planetName() {
		System.out.println("Planet name is Mars");
	}
	public void howFarFromSun() {
		System.out.println("Mars is 144.52 M miles aways from Sun");	
	}
	public void positionInSolarSystem() {
		System.out.println("Mars is 4th planet of the solar system");
	}
	public void howManySatellites() {
		System.out.println("Mars has 2 satellites");
	}
	public void howFarFromEarth() {
		System.out.println("Maximum distance Mars from Earth is 221.82 M miles, minimum distance is 33.9 M milles");
	}
	public void visibleFromEarth() {
		System.out.println("Mars is visible from the Earth");
	}
	public void gravitationalPull() {
		System.out.println("Mars pulls the Earth with force of 0,006% of Earth gravitational field");
	}
	

}
