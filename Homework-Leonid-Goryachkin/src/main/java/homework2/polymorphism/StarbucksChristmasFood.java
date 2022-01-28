package homework.polymorphism;

public class StarbucksChristmasFood extends ChristmasFood {
	@Override
	public void hotCacao(String ingredient1, String ingredient2) {
		System.out.println("This cacao is Starbucks recipe, not only it has  " + ingredient1 + " and " + ingredient2 + ", but also half and half, chocolate powder, syrop, and decorative chocolate bar");
	}
	@Override
	public void gingerBreadMan(int count, String ingredient1) {
		System.out.println("This ginger bread man is Starbucks recipe, not only it has " + count + " of " + ingredient1 + ", but also frosting, powder sugar and fruit jelly");
	}

}
