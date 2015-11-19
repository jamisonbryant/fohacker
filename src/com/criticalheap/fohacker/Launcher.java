package com.criticalheap.fohacker;

/**
 * Launches the application. If command-line arguments are given, they are processed before the application is launched.
 *
 * @author Jamison Bryant
 */
public class Launcher
{
    public static void main(String[] args)
    {

        /*
         * Handle command-line arguments if present
         */
        if (args.length >= 0) {
            // Process command-line arguments here
        }

        /*
         * Create new instance of application
         */
        Application app = new Application();

        /*
         * Prepare and display application
         */
        app.build();
        app.display();
    }
}
