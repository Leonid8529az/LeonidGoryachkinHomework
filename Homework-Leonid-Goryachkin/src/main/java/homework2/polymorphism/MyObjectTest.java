package homework.polymorphism;

public class MyObjectTest {

	public static void main(String[] args) {
		ChristmasFood yummy = new ChristmasFood();
		yummy.hotCacao("Marshmallow", "Whip cream");
		yummy.hotCacao("Marshmallow", "Whip cream", "Caramel");
		System.out.println("---------------------------------------------");
		yummy.gingerBreadMan(10, "Candies");
		yummy.gingerBreadMan(10, "Candies", "large");
		System.out.println("---------------------------------------------");
		StarbucksChristmasFood veryGood = new StarbucksChristmasFood();
		veryGood.gingerBreadMan(10, "Candies");
		veryGood.hotCacao("Marshmallow", "Whip cream");
		
	}

}
