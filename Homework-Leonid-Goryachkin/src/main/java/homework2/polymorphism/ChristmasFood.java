package homework.polymorphism;

public class ChristmasFood {
	public void hotCacao(String ingredient1, String ingredient2) {
		System.out.println("This cacao is standard recipe, and also it has  " + ingredient1 + " and " + ingredient2);
	}
	public void hotCacao(String ingredient1, String ingredient2, String ingredient3) {
		System.out.println("This cacao is standard recipe, and also it has " + ingredient1 + ", " + ingredient2 + " and " + ingredient3);
	}
	public void gingerBreadMan(int count, String ingredient1) {
		System.out.println("This ginger bread man is standard recipe, and also it has " + count + " of " + ingredient1);
	}
	public void gingerBreadMan(int count, String ingredient1, String size) {
		System.out.println("This ginger bread man is standard recipe, and also it has " + count + " of " + ingredient1 + ", also, its size is " + size);
	}
}
