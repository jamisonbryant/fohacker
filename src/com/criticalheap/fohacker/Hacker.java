package com.criticalheap.fohacker;

import java.util.ArrayList;

/**
 * Password hacking class. Takes in a list of passwords, analyzes them, and recommends a password to try.
 *
 * @author Jamison Bryant
 */
public class Hacker
{
    ArrayList<String> passwords;
    char[][] characters;

    /**
     * Creates a new Hacker object with a given password list
     *
     * @param list List of possible passwords
     */
    public Hacker(ArrayList<String> list)
    {
        // Capture password list
        passwords = list;

        // Create character array
        int length = 0;
        for (String password : passwords) {
            length = (password.length() > length ? password.length() : length);
        }

        characters = new char[list.size()][length];
    }

    /**
     * Suggests a password to try
     *
     * @return Possible password
     */
    public String getPassword()
    {
        return null;
    }
}
