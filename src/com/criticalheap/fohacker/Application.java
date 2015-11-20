package com.criticalheap.fohacker;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Main application class. Contains logic for creating application GUI, handling user input, and displaying output.
 *
 * @author Jamison Bryant
 */
public class Application
{
    private JFrame frame;
    private Hacker hacker;

    /**
     * Builds GUI
     */
    public void build()
    {
        // Create main frame
        frame = new JFrame("FOHacker");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(300, 300);
        frame.setLocationRelativeTo(null);

        // Create content panel
        JPanel contentPanel = (JPanel) frame.getContentPane();
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
        contentPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        // Create input panel
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BorderLayout());
        inputPanel.setBorder(BorderFactory.createTitledBorder("Passwords"));
        JTextArea passwordsField = new JTextArea();
        inputPanel.add(passwordsField);

        // Create controls panel
        JPanel controlsPanel = new JPanel();
        JButton startButton = new JButton("Start");
        JButton resetButton = new JButton("Reset");
        controlsPanel.add(startButton);
        controlsPanel.add(resetButton);

        // Create controls handlers
        startButton.addActionListener(e -> {
            // Get passwords from field
            String[] list = passwordsField.getText().split("\n");
            int maxLength = 0;

            for (String s : list) {
                if (s.length() > maxLength) {
                    maxLength = s.length();
                }
            }


            // Create hacker object
            hacker = new Hacker(new ArrayList<>(Arrays.asList(list)));
            boolean isComplete = false;

            // Start password hacking algorithm
            do {
                // Get next password to try
                String password = hacker.getGuess().toUpperCase();

                // Display password suggestion dialog
                JOptionPane.showMessageDialog(frame, "Try " + password, "FOHacker", JOptionPane.INFORMATION_MESSAGE);

                // Display password success prompt
                int response = JOptionPane.showConfirmDialog(frame, "Did " + password + " work?", "FOHacker",
                        JOptionPane.YES_NO_OPTION);

                if (response != -1) {
                    boolean wasSuccessful = (1 - response == 1);

                    if (!wasSuccessful) {
                        // Display correct chars input dialog
                        String input = (String) JOptionPane.showInputDialog(frame, "How many characters were correct?",
                                "FOHacker", JOptionPane.QUESTION_MESSAGE);

                        // Process correct chars number
                        try {
                            // Set correct number of chars
                            int chars = Integer.parseInt(input);
                            hacker.setCorrectChars(chars);
                        } catch(NumberFormatException nfe) {
                            // Display invalid input dialog
                            JOptionPane.showMessageDialog(frame, "Invalid input", "FOHacker",
                                    JOptionPane.ERROR_MESSAGE);
                        }
                    } else {
                        // Mark hacking as complete (will exit loop)
                        isComplete = true;
                    }
                } else {
                    // Display hacking cancelled dialog
                    JOptionPane.showMessageDialog(frame, "Hacking cancelled", "FOHacker", JOptionPane.ERROR_MESSAGE);

                    // Delete hacker object
                    hacker = null;

                    // Force break out of loop
                    break;
                }
            } while (!isComplete);
        });

        resetButton.addActionListener(e -> {
            // Delete hacker object
            hacker = null;

            // Clear text fields
            passwordsField.setText("");
        });

        // Add panels to frame
        contentPanel.add(inputPanel);
        contentPanel.add(controlsPanel);
    }

    /**
     * Displays GUI
     */
    public void display()
    {
        frame.setVisible(true);
    }
}
