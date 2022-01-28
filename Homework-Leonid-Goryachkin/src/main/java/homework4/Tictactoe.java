package homework4;



import java.util.Scanner;

public class Tictactoe {

    public static char[][] gamesArray = {{'_','_','_'}, {'_','_','_'}, {' ',' ',' ',}};
    public static int playersChoice, account = 0, tieCounter = 0;
    public static String scannersInput;
    public static char[] stringAnalysis;
    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        Tictactoe ttt = new Tictactoe();
        System.out.println("Hello, players. Lets do some game");
        ttt.wait(3);
        System.out.println("This is how the game field looks like");
        System.out.println("_1_|_2_|_3_");
        System.out.println("_4_|_5_|_6_");
        System.out.println(" 7 | 8 | 9 ");
        ttt.wait(3);
        System.out.println("The numbers, which you can see here corresponds to the positions of X's and O's");
        System.out.println("So, by using numbers from 1 to 9, decide the position of your sign");
        printGameArray();
        gamerNumberOne();
    }
    public static void printGameArray() {
        System.out.println("_" + gamesArray[0][0] +"_|_"+gamesArray[0][1]+"_|_" +gamesArray[0][2]+ "_");
        System.out.println("_" + gamesArray[1][0] +"_|_"+gamesArray[1][1]+"_|_" +gamesArray[1][2]+ "_");
        System.out.println(" " + gamesArray[2][0] +" | "+gamesArray[2][1]+" | " +gamesArray[2][2]+" ");
    }
    public static void gamerNumberOne() {
        System.out.println("Player Number one, please, tell the position of X");
        scannersInput = scanner.nextLine();
        realAnswerTransformX(scannersInput);
        for (int i = 0; i<gamesArray.length; i++) {
            for (int j = 0; j<gamesArray[i].length; j++) {
                account++;
                if (account == playersChoice) {
                    fieldAnalysisX(i,j);
                }
            }
        }
    }
    public static void fieldAnalysisX(int row, int column) {
        if (gamesArray[row][column] == 'X' || gamesArray[row][column] == 'O') {
            System.out.println("This field is already taken");
            account = 0;
            printGameArray();
            gamerNumberOne();
            return;
        } else {
            account = 0;
            gamesArray[row][column] = 'X';
            tieCounter++;
            printGameArray();
            tieGame();
            winnerAnalysisX();
            gamerNumberTwo();
        }
    }
    public static void gamerNumberTwo() {
        System.out.println("Player Number two, please, tell the position of O");
        scannersInput = scanner.nextLine();
        realAnswerTransformO(scannersInput);
        for (int i = 0; i<gamesArray.length; i++) {
            for (int j = 0; j<gamesArray[i].length; j++) {
                account++;
                if (account == playersChoice) {
                    fieldAnalysisO(i,j);
                }
            }
        }
    }
    public static void fieldAnalysisO(int row, int column) {
        if (gamesArray[row][column] == 'X' || gamesArray[row][column] == 'O') {
            System.out.println("This field is already taken");
            account = 0;
            printGameArray();
            gamerNumberTwo();
            return;
        } else {
            account = 0;
            gamesArray[row][column] = 'O';
            tieCounter++;
            printGameArray();
            tieGame();
            winnerAnalysisO();
            gamerNumberOne();
        }
    }
    public static void winnerAnalysisX() {
        if ((gamesArray[0][0] == 'X' && gamesArray[0][1] == 'X' && gamesArray[0][2] =='X') ||
                (gamesArray[1][0] == 'X' && gamesArray[1][1] == 'X' && gamesArray[1][2] =='X') ||
                (gamesArray[2][0] == 'X' && gamesArray[2][1] == 'X' && gamesArray[2][2] =='X') ||
                (gamesArray[0][0] == 'X' && gamesArray[1][0] == 'X' && gamesArray[2][0] =='X') ||
                (gamesArray[0][1] == 'X' && gamesArray[1][1] == 'X' && gamesArray[2][1] =='X') ||
                (gamesArray[0][2] == 'X' && gamesArray[1][2] == 'X' && gamesArray[2][2] =='X') ||
                (gamesArray[0][0] == 'X' && gamesArray[1][1] == 'X' && gamesArray[2][2] =='X') ||
                (gamesArray[0][2] == 'X' && gamesArray[1][1] == 'X' && gamesArray[2][0] =='X')) {
            System.out.println("Player one won, and player two is a loser booooooo");
            System.exit(0);
        } else {
            return;
        }
    }
    public static void winnerAnalysisO() {
        if ((gamesArray[0][0] == 'O' && gamesArray[0][1] == 'O' && gamesArray[0][2] =='O') ||
                (gamesArray[1][0] == 'O' && gamesArray[1][1] == 'O' && gamesArray[1][2] =='O') ||
                (gamesArray[2][0] == 'O' && gamesArray[2][1] == 'O' && gamesArray[2][2] =='O') ||
                (gamesArray[0][0] == 'O' && gamesArray[1][0] == 'O' && gamesArray[2][0] =='O') ||
                (gamesArray[0][1] == 'O' && gamesArray[1][1] == 'O' && gamesArray[2][1] =='O') ||
                (gamesArray[0][2] == 'O' && gamesArray[1][2] == 'O' && gamesArray[2][2] =='O') ||
                (gamesArray[0][0] == 'O' && gamesArray[1][1] == 'O' && gamesArray[2][2] =='O') ||
                (gamesArray[0][2] == 'O' && gamesArray[1][1] == 'O' && gamesArray[2][0] =='O')) {
            System.out.println("Player two won, and player one is a loser booooooo");
            System.exit(0);
        } else {
            return;
        }
    }
    public static void realAnswerTransformX(String youRang) {
        if (youRang.length() > 1) {
            System.out.println("No-no, incorrect input. Try only use numbers from 1 to 9");
            gamerNumberOne();
            return;
        }
        stringAnalysis = youRang.toCharArray();
        for (int i = 0; i<stringAnalysis.length; i++) {
            if (Character.isLetter(stringAnalysis[i])) {
                System.out.println("No-no, incorrect input. Try only use numbers from 1 to 9");
                gamerNumberOne();
                return;
            }
        }
        if (youRang.length() == 1 && Character.isDigit(youRang.charAt(0))) {
            playersChoice = Integer.parseInt(youRang);
        }
    }
    public static void realAnswerTransformO(String youRang) {
        if (youRang.length() > 1) {
            System.out.println("No-no, incorrect input. Try only use numbers from 1 to 9");
            gamerNumberTwo();
            return;
        }
        stringAnalysis = youRang.toCharArray();
        for (int i = 0; i<stringAnalysis.length; i++) {
            if (Character.isLetter(stringAnalysis[i])) {
                System.out.println("No-no, incorrect input. Try only use numbers from 1 to 9");
                gamerNumberTwo();
                return;
            }
        }
        if (youRang.length() == 1 && Character.isDigit(youRang.charAt(0))) {
            playersChoice = Integer.parseInt(youRang);
        }
    }
    public static void tieGame() {
        if (tieCounter == 9) {
            winnerAnalysisX();
            winnerAnalysisO();
            System.out.println("Game is over. Tie!");
            System.exit(0);
        } else {
            return;
        }
    }
    public void wait (int seconds) {
        try {
            Thread.currentThread().sleep(seconds*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
