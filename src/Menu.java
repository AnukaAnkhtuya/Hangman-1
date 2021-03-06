
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;

public class Menu {
    public Menu() {


    }
    public void showGame() throws IOException {
        File dictionary = new File("src/english2.txt");

        Scanner textScanner = new Scanner(dictionary);
        Scanner input = new Scanner(System.in);

        ArrayList<String> words = new ArrayList<>();
        while(textScanner.hasNextLine()) {
            words.add(textScanner.nextLine());
        }
        String hiddenText = words.get((int)(Math.random()* words.size()));
        char[] textArray = hiddenText.toCharArray();

        char[] myAnswers = new char[textArray.length];
        for(int i = 0; i < textArray.length; i++){
            myAnswers[i] = '?';
        }

        boolean finished = false;
        int lives = 6;

        while(!finished) {
            System.out.println(hiddenText);
            System.out.println("*********************");

            String letter = input.next();
            // check for a valid input
            while(letter.length() != 1 || Character.isDigit(letter.charAt(0))){
                System.out.println("Error Input - Try again");
                letter = input.next();
            }
            //check if letter is in the word
            boolean found = false;
            for(int i = 0; i < textArray.length; i++) {
                if(letter.charAt(0) == textArray[i]) {
                    myAnswers[i] = textArray[i];
                    found = true;
                }
            }
            if(!found){
                lives--;

                System.out.println("Wrong letter");
            }
            boolean done = true;
            for (char myAnswer : myAnswers) {
                if (myAnswer == '?') {
                    System.out.print(" _");
                    done = false;
                } else {
                    System.out.print(" " + myAnswer);
                }
            }
            System.out.println("\n" + "Lives left: " + lives);
            drawHangman(lives);

            //check if the game ends
            if(done) {
                System.out.println("Congrats :D You found a letter");
                finished = true;

            }
            if(lives <= 0) {
                System.out.println("you are dead!");
                finished = true;
            }
        }
    }
    public static void drawHangman(int l) {
        if(l == 6) {
            System.out.println("|----------");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
        }
        else if(l == 5) {
            System.out.println("|----------");
            System.out.println("|    O");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
        }
        else if(l == 4) {
            System.out.println("|----------");
            System.out.println("|    O");
            System.out.println("|    |");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
        }
        else if(l == 3) {
            System.out.println("|----------");
            System.out.println("|    O");
            System.out.println("|   -|");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
        }
        else if(l == 2) {
            System.out.println("|----------");
            System.out.println("|    O");
            System.out.println("|   -|-");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
        }
        else if(l == 1) {
            System.out.println("|----------");
            System.out.println("|    O");
            System.out.println("|   -|-");
            System.out.println("|   /");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
        }
        else{
            System.out.println("|----------");
            System.out.println("|    O");
            System.out.println("|   -|-");
            System.out.println("|   /|");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
        }
    }


    public static String update(String Alpha) {

        return "";
    }
}
