//Number Guessing
//Google Kick Start 2019 Practice Round (http://tinyurl.com/y2nxcrrm)

import java.util.Scanner;

public class Solution {

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

    private void adjust(String result, int lastGuess){
        if(result.equals("TOO_SMALL")){
            lowBorder = lastGuess + 1;
        }
        else{
            highBorder = lastGuess - 1;
        }
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        //How many cases?
        int testCases = input.nextInt();

        Solution newTest = new Solution();

        for(int i=0; i<testCases; i++){

            int numGuesses;
            int guessCounter = 0;

            //Enter low and high bound (e.g 0 10)
            newTest.bounds(input.nextInt(),input.nextInt());
            //What is the maximum number of guesses I can make?
            numGuesses = input.nextInt();

            String result;

            do {

                int guess = newTest.makeGuess();
                //My guess is...
                System.out.println(guess);
                //Did I get it right? (TOO_SMALL, TOO_BIG)
                result = input.next();

                if(result.equals("TOO_BIG") || result.equals("TOO_SMALL")){
                    newTest.adjust(result,guess);
                    guessCounter++;

                    //Guess limit reached
                    if(guessCounter==numGuesses){
                        break;
                    }

                }
            }
            while (!result.equals("CORRECT"));
        }
    }
}
