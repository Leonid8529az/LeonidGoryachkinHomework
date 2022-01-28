package homework.inheritance;

public class MyObjectClass {
	public static void main(String[] args) {
		ChessMobile chess = new ChessMobile();
		ChipsFactory lays = new ChipsFactory();
		Tesla teslaCar = new Tesla();
		MechanicalHand mechanicalHand = new MechanicalHand();
		
		System.out.println("---------------Chess----------------");
		chess.creator();
		chess.task();
		chess.myIntelligence();
		chess.learnAbility();
		chess.adaption();
		chess.playStyle();
		chess.difficulty();
		System.out.println("--------------------------------------");
		System.out.println("-------------Chips Lays---------------");
		lays.creator();
		lays.task();
		lays.myBehavior();
		lays.learnAbility();
		lays.whatIConsistOf();
		lays.myTimeSheet();
		lays.productCreation();
		System.out.println("--------------------------------------");
		System.out.println("--------------Tesla car---------------");
		teslaCar.creator();
		teslaCar.task();
		teslaCar.myIntelligence();
		teslaCar.learnAbility();
		teslaCar.adaption();
		teslaCar.myTestDrive();
		teslaCar.myThirdEye();
		System.out.println("--------------------------------------");
		System.out.println("-----------Mechanical Hand------------");
		mechanicalHand.creator();
		mechanicalHand.task();
		mechanicalHand.myBehavior();
		mechanicalHand.learnAbility();
		mechanicalHand.whatIConsistOf();
		mechanicalHand.whatAmI();
		mechanicalHand.alwaysServing();
		System.out.println("--------------------------------------");
	}
}
