package tempconverter;

import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class GameMine {
	public static String answer, upperAnswer;
	public static boolean isNumber = false, isCharacter = false;
	static Scanner scanner = new Scanner(System.in);
	public static int[] gamesArray;	
	
	public static void main(String[] args) {
		
		System.out.println("-----------------Welcome to suffle game-----------------");
		System.out.println("------------------Guess where the 0 is------------------");
		beginningOfTheGame();
		return;
	
	}
	public static int[] shuffleGame(int[] ar) {
		
		Random random = ThreadLocalRandom.current();
		
		for (int i = ar.length-1; i > 0; i--) {
			int index = random.nextInt(i+1);
			int a = ar[index];
			ar[index] = ar[i];
			ar[i] = a;
		}
		
		return ar;
		}
	public static void beginningOfTheGame() {
		System.out.println("---------------Are you ready to play? Y/N---------------");
		answer = scanner.nextLine();
		char[] testString = answer.toCharArray();
		for (int i = 0; i < testString.length; i++) {
			if(Character.isDigit(testString[i])) {
				isNumber = true;
			}
			}
		if (isNumber == true) {
				System.out.println("-------Sorry, try to input either Y or N-------");
				beginningOfTheGame();
				isNumber = false;
				return;
			}
		if (answer.equalsIgnoreCase("y")) {
			System.out.println("Okay! I am randomizing a number for you. Hold on just a nanosecond");
			gamesArray = shuffleGame(new int []{0,1,1,1});
			System.out.println("Here you go. 0 is hiding behind one of these doors. Choose 1, 2, 3 or 4");
			progressingGame();
			return;
			
		}else if (answer.equalsIgnoreCase("n")) {
			System.out.println("------------See you later then!--------------");
		} else {
			System.out.println("-------Sorry, try to input either Y or N-------");
			beginningOfTheGame();
			return;
		}
	}
	public static void progressingGame () {
		System.out.println("[ ] [ ] [ ] [ ]");
		System.out.println(" 1   2   3   4");
		answer = scanner.nextLine();
		char[] testString = answer.toCharArray();
		isCharacter = false;
		for (int i = 0; i < testString.length; i++) {
			if(Character.isLetter(testString[i])) {
				isCharacter = true;
			}
			
			
	}	if (isCharacter == true) {
				System.out.println("----Sorry, do not input letters. Try 1, 2 ,3 or 4----");
				progressingGame();
				isCharacter = false;
				return;
			}
		int actualChoice = Integer.parseInt(answer);
		if (actualChoice > 4 || actualChoice <= 0) {
			System.out.println("----Sorry, your number is out of bounderies. Try 1, 2,3 or 4----");
			progressingGame();
			return;
		}
		if (gamesArray[actualChoice-1] == 0) {
			System.out.println("----Congratulations! You won! Zero IS in that position----");
			arrayIntroduction();
			tryAgain();
			return;
			
		
		}
		else {
			System.out.println("----Oh no! Unfortunately, zero is not here. Try again.----");
			progressingGame();
			return;
		}			
		} 	
			public static void arrayIntroduction () {
			for (int j = 0; j < gamesArray.length; j++) {
				System.out.print("[" + gamesArray[j] + "]");
			}
			System.out.println();
			System.out.println(" 1  2  3  4");
			
	}
			public static void tryAgain() {
				System.out.println("-----------Do you want to try again? Y/N------------");
				answer = scanner.nextLine();
				char[] testString = answer.toCharArray();
				for (int i = 0; i < testString.length; i++) {
					if(Character.isDigit(testString[i])) {
						isNumber = true;
					}
					}
				if (isNumber == true) {
						System.out.println("-------Sorry, try to input either Y or N-------");
						isNumber = false;
						tryAgain();
						return;
					}
				if (answer.equalsIgnoreCase("y")) {
					beginningOfTheGame();
					return;
					
				}else if (answer.equalsIgnoreCase("n")) {
					System.out.println("------------See you later then!--------------");
				} else {
					System.out.println("-------Sorry, try to input either Y or N-------");
					tryAgain();
					return;
				
			}
}
}

