package homework3;

public class FibonacciNumbers {
    public static void main(String[] args) {
        int first = 0, second = 1, total;
        System.out.print("here are 40 Fibonacci numbers: " + first + " " + second);
        for (int i = 0; i<38; i++) {
            total = first+second;
            System.out.print(" " + total);
            first=second;
            second=total;
            if (i%6==0) {
                System.out.println();
            }

        }
    }
}
