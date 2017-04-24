/*
 Author: Mr. Kaune
 Editor: Eric Mazza
 Date of Edit: 21/04/2017
 Description:
 The player has to guess a word.
 */
package wordguess;

import java.util.Scanner;

/**
 * Plays a word guessing game with one player.
 */
public class WordGuess {

    public static void main(String[] args) {
        final String SECRET_WORD = "BRAIN";
        final String FLAG = "!";
        String wordSoFar = "", updatedWord = "";
        String letterGuess, wordGuess = "";
        int numGuesses = 0;
        int points = 100;
        Scanner input = new Scanner(System.in);

        /* begin game */
        System.out.println("WordGuess game.\n");
        for (int i = 0; i < SECRET_WORD.length(); i++) {
            wordSoFar += "-";								//word as dashes
        }
        System.out.println(wordSoFar + "\n");				//display dashes

        /* allow player to make guesses*/
        do {
            System.out.println("You have: " + points + " points.");
            System.out.print("Enter a letter (" + FLAG + " to guess entire word): ");
            letterGuess = input.nextLine();
            letterGuess = letterGuess.toUpperCase();

            /* increment number of guesses */
            numGuesses += 1;

            if (letterGuess.length() > 1) {
                System.out.println("To guess more than one letter, please press '!'.");
            }

            /* player correctly guessed a letter--extract string in wordSoFar up to the letter 
             * guessed and then append guessed letter to that string. Next, extract rest of 
             * wordSoFar and append after the guessed letter
             */
            if (SECRET_WORD.indexOf(letterGuess) >= 0) {
                updatedWord = wordSoFar.substring(0, SECRET_WORD.indexOf(letterGuess));
                updatedWord += letterGuess;
                updatedWord += wordSoFar.substring(SECRET_WORD.indexOf(letterGuess) + 1, wordSoFar.length());
                wordSoFar = updatedWord;
            } else {
                points -= 10;
            }

            /* display guessed letter instead of dash */
            System.out.println(wordSoFar + "\n");
        } while (!letterGuess.equals(FLAG) && !wordSoFar.equals(SECRET_WORD) && points != 0);

        /* finish game and display message and number of guesses */
        if (letterGuess.equals(FLAG)) {
            System.out.println("What is your guess? ");
            wordGuess = input.nextLine();
            wordGuess = wordGuess.toUpperCase();
        }
        if (points == 0) {
            System.out.println("Sorry, you lose.");
        } else {
            if (wordGuess.equals(SECRET_WORD) || wordSoFar.equals(SECRET_WORD)) {
                System.out.println("You won!");
            } else {
                System.out.println("Sorry. You lose.");
                System.out.println("You made " + numGuesses + " incorrect guesses.");
            }
            System.out.println("The secret word is " + SECRET_WORD);
            System.out.println("You made " + numGuesses + " guesses.");
        }
    }
}
