package homework3;

import java.util.Scanner;

public class Factorial {
    public static Scanner scanner = new Scanner(System.in);
    public static int userNumber;
    public static String answerAnalyser;
    public static void main(String[] args) {
        System.out.println("Hi, please, input a number, so i can count factorial for you");
        userNumber = scanner.nextInt();
        System.out.println("Your factorial is :" +Factorial(userNumber));
    }
    public static int Factorial(int yourChoice) {
        int total = 1;
        for (int i = yourChoice; i>0; i--) {
            total=total*i;
        }
        return total;
    }
}
