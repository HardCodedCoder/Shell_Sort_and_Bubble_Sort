package org.example;

import java.util.List;
import java.util.Scanner;

public class ConsoleIOHandler {
    public static final String ANSI_RESET = "\u001B[0m";
    private static Scanner scanner = new Scanner(System.in);

    /**
     * Displays a menu to the console and returns the choice of the user.
     * @param options The options of the menu.
     * @return The choice of the user.
     */
    public int displayMenu(List<String> options) {
        AsciiArtHeader.printAsciiArtHeader();

        for (int i = 0; i < options.size(); i++) {
            System.out.println((i + 1) + ". " + options.get(i));
        }

        int choice;
        while (true) {
            try {
                System.out.print("Bitte wählen Sie eine Option: ");
                String input = scanner.nextLine();
                choice = Integer.parseInt(input);

                if (choice >= 1 && choice <= options.size()) {
                    break;
                } else {
                    System.out.println("Ungültige Option. Bitte geben Sie eine gültige Option ein.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Ungültige Eingabe. Bitte geben Sie eine Zahl ein.");
            }
        }

        return choice;
    }

    /**
     * Prints a text to the console.
     * @param toPrint The text to print.
     * @param foregroundColor The foreground color of the text.
     */
    private void printColored(String toPrint, ForegroundColor foregroundColor)
    {
        System.out.print(foregroundColor.getCode() + toPrint + ANSI_RESET);
    }

    /**
     * Prints a success message to the console.
     * @param toPrint The message to print.
     */
    public void printSuccess(String toPrint)
    {
        System.out.println();
        this.printColored("[SUCCESS]: ", ForegroundColor.GREEN);
        System.out.println(toPrint);
    }
}
