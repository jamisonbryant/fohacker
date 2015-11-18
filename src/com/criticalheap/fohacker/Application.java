package com.criticalheap.fohacker;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

/**
 * Main application class. Contains logic for creating application GUI, handling user input, and analyzing passwords.
 */
public class Application
{
    private JFrame frame;

    /**
     * Creates GUI
     */
    public void create()
    {
        // Create main frame
        frame = new JFrame("FOHacker");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700, 400);
        frame.setLocationRelativeTo(null);

        // Create content panel
        Container contentPanel = frame.getContentPane();
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));

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

        // Create output panel
        JPanel outputPanel = new JPanel();
        outputPanel.setLayout(new BorderLayout());
        outputPanel.setBorder(BorderFactory.createTitledBorder("Commands"));
        JTextArea commandsField = new JTextArea();
        commandsField.setEditable(false);
        outputPanel.add(commandsField);

        // Add panels to frame
        contentPanel.add(inputPanel);
        contentPanel.add(controlsPanel);
        contentPanel.add(outputPanel);
    }

    /**
     * Displays GUI
     */
    public void display()
    {
        frame.setVisible(true);
    }
}
