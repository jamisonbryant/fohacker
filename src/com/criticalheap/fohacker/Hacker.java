package com.criticalheap.fohacker;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Password hacking class. Takes in a list of passwords, analyzes them, and recommends a password to try.
 *
 * @author Jamison Bryant
 * @link http://mitchellthompson.net/demos/terminal
 */
public class Hacker
{
    private ArrayList<String> passwords;
    private ArrayList<String> guesses;
    private int correctChars;

    public Hacker(ArrayList<String> list)
    {
        // Initialize passwords/guesses lists
        passwords = new ArrayList<String>();
        guesses = new ArrayList<String>();

        for (String s : list) {
            passwords.add(s);
            guesses.add(s);
        }

        // Initialize correct char count
        correctChars = -1;
    }

    public String getGuess()
    {
        // Check if first guess has been made
        String guess = guesses.get(0);

        if (correctChars != -1) {
            // Iterate over password list
            for (String password : passwords) {
                // Count number of character matches
                int matches = 0;

                for (int i = 0; i < password.length(); i++) {
                    // Check if password is not the current guess
                    if (!password.equals(guess)) {
                        // Check if current char matches
                        if (password.charAt(i) == guess.charAt(i)) {
                            matches++;
                        }
                    }
                }

                // Check if password has correct number of chars
                if (matches != correctChars) {
                    // Remove password from guesses list
                    guesses.remove(0);
                }
            }

            // Get new guess
            guess = guesses.get(0);
        }

        return guess;
    }

    public void setCorrectChars(int chars) { correctChars = chars; }
}
