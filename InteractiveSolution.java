//Number Guessing: Interactive Edition!
//Google Kick Start 2019 Practice Round (http://tinyurl.com/y2nxcrrm)

import java.util.Scanner;

public class InteractiveSolution {

    private int lowBorder;
    private int highBorder;

    //A and B
    private void bounds(int low, int high){
        lowBorder = low;
        highBorder = high;
    }

    private int makeGuess(){
        return lowBorder + ((highBorder-lowBorder)/2);
    }

    private void adjust(int result, int lastGuess){
        System.out.println("Thinking...");
        if(result == 2){
            lowBorder = lastGuess + 1;
        }
        else{
            highBorder = lastGuess - 1;
        }
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("-----------------------------------------------------------------------");
        System.out.println("                       Welcome to NUMBER GUESSING");
        System.out.println("        The game you never thought you'd be playing right now.");
        System.out.println("-----------------------------------------------------------------------");

        System.out.println();
        System.out.println("This program doesn't store the number you want me to guess. Please keep");
        System.out.println("it in your head, or written down somewhere so you don't forget.");
        System.out.println();
        System.out.println("To start, tell me how many numbers we are guessing today:");
        int testCases = input.nextInt();

        InteractiveSolution newTest = new InteractiveSolution();

        for(int i=0; i<testCases; i++){

            int numGuesses;
            int guessCounter = 0;

            System.out.println();
            System.out.println("// MYSTERY NUMBER : " + i+1 + " //");

            //Enter low and high bound
            System.out.println("Enter both a low bound and high bound. [e.g: 0 10]");
            newTest.bounds(input.nextInt(),input.nextInt());
            //Max Guesses
            System.out.println("How many guesses can I make for this number? (Be reasonable! Or not.)");
            numGuesses = input.nextInt();

            int result;

            do {

                int guess = newTest.makeGuess();
                System.out.println("Is your secret number: " + guess +"? [enter the number: (1)YES, (2)TOO SMALL, (3)TOO BIG]");
                result = input.nextInt();

                while(!(result == 1 || result == 2 || result == 3)){
                    System.out.println("Invalid input. Please enter any of these numbers: (1)YES, (2)TOO SMALL, (3)TOO BIG");
                    result = input.nextInt();
                }

                if(result == 2 || result == 3){
                    newTest.adjust(result,guess);
                    guessCounter++;

                    //Guess limit reached
                    if(guessCounter==numGuesses){
                        System.out.println("Welp, I'm out of guesses.");
                        break;
                    }

                }
            }
            while (result != 1);
            System.out.println();
        }

        System.out.println("Thanks for playing!");
    }
}
