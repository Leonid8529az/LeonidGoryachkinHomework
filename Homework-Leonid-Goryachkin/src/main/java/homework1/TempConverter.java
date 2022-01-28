package tempconverter;

import java.util.Scanner;

public class TempConverter {

	public static void main(String[] args) {
		System.out.println("-----------------------Welcome---------------------");
		System.out.println("--Celsius-Fahrenheit/Fahrenheit-Celsius converter--");
		System.out.println();
		makeYourChoice();

}
	static void makeYourChoice() {
		System.out.println("Choose the conversion mode:");
		System.out.println("1 - Ceslius - Fahrenheit");
		System.out.println("2 - Fahrenheit - Celsius");
		Scanner scanner = new Scanner(System.in);
		String yourInput = scanner.nextLine();
		if (yourInput.equals("1")) {
			celsiusToFahrenheit();
		}
		else if (yourInput.equals("2")) {
			fahrenheitToCelsius();
		}
		else {
			System.out.println("Sorry, invalid number. Choose between 1 and 2");
			makeYourChoice();
		}
	}
	static void celsiusToFahrenheit() {
		System.out.println("Please, input the value of celsius to be converted into fahrenheit");
		Scanner scanner2 = new Scanner(System.in);
		double userCelsius = scanner2.nextDouble();
		double f = (userCelsius*9/5)+32;
		System.out.println("The value of fahrenheit is " + f);
		System.out.println();
		endOfTask();
	}
	static void fahrenheitToCelsius() {
		System.out.println("Please, input the value of fahrenheit to be converted into celsius");
		Scanner scanner3 = new Scanner(System.in);
		double userFahrenheit = scanner3.nextDouble();
		double c = (userFahrenheit-32)*5/9;
		System.out.println("The value of celsius is " + c);
		System.out.println();
		endOfTask();
	}
	static void endOfTask() {
		System.out.println("Do you want to convert other temperatures? Y/N");
		Scanner scanner4 = new Scanner(System.in);
		String yesOrNo = scanner4.nextLine();
		String sure = yesOrNo.toUpperCase();
		if (sure.equals("Y")) {
			makeYourChoice();
		}
		else if (sure.equals("N")) {
			System.out.println("----------------Good bye, see you soon--------------");
		}
		else {
			System.out.println("Invalid input, please choose between Y or N");
			endOfTask();
		}
	}
}
