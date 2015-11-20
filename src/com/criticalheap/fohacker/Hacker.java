package com.criticalheap.fohacker;

import java.util.ArrayList;
import java.util.Random;

/**
 * Password hacking class. Takes in a list of passwords, analyzes them, and recommends a password to try.
 *
 * @author Jamison Bryant
 * @link http://mitchellthompson.net/demos/terminal
 */
public class Hacker
{
    private ArrayList<String> passwords;
    private String guess;

    public Hacker(ArrayList<String> list)
    {
        // Initialize password list
        passwords = list;

        // Initialize guess
        guess = "";
    }

    /**
     * Returns a random guess from the password list
     *
     * @return Random guess
     */
    public String getGuess()
    {
//        guess = passwords.get((new Random()).nextInt(passwords.size()));
        guess = passwords.get(0);
        return guess;
    }

    /**
     * Returns an educated guess from the password list
     *
     * @param similarity Similarity of previous guess and correct answer
     * @return Educated guess
     */
    public String getGuess(int similarity)
    {
        // Remove old guess from passwords list
        if (passwords.contains(guess)) {
            passwords.remove(guess);
        }

        for (int i = 0; i < passwords.size(); i++) {
            // Compare old guess to each password
            String password = passwords.get(i);
            int matches = 0;

            for (int j = 0; j < password.length(); j++) {
                if (password.charAt(j) == guess.charAt(j)) {
                    matches++;
                }
            }

            // Check if password and guess are similar
            if (matches != similarity) {
                // Remove password from passwords list
                passwords.remove(password);
            }
        }

        // Get new guess from passwords list
        guess = passwords.get(0);

        // Return new guess
        return guess;
    }
}
