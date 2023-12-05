package at.fhburgenland;

import at.fhburgenland.view.ConsoleIOHandler;
import at.fhburgenland.interfaces.Sorter;
import at.fhburgenland.sorter.BubbleSort;
import at.fhburgenland.sorter.ShellSort;

import java.util.ArrayList;
import java.util.List;

/**
 * Class which holds the main entry point of the application.
 */
public class Main {
    /**
     * Main entry point of the application
     * @param args
     */
    public static void main(String[] args) {
        System.out.println();

        ConsoleIOHandler ioHandler = new ConsoleIOHandler();

        boolean quit = false;

        while (!quit) {

            List<Integer> digits = new ArrayList<>();
            try {
                digits = readDigits();
            } catch (Exception e) {
                System.err.println(e.getMessage());
                return;
            }

            List<String> mainMenuOptions = List.of("Bubble Sort Ergebnis anzeigen", "Shell Sort Ergebnis anzeigen", "Beenden");
            int choice = ioHandler.displayMenu( mainMenuOptions);
            switch (choice) {
                case 1 -> {
                    Sorter sorter = new BubbleSort();
                    double durationInMillis = measureExecutionTime(sorter, digits);
                    printList(digits);
                    ioHandler.printSuccess(String.format("Die Sortierung von %d Zahlen mittels %s dauerte: %.2f ms", digits.size(), sorter.toString(), durationInMillis));
                }
                case 2 -> {
                    Sorter sorter = new ShellSort();
                    double durationInMillis = measureExecutionTime(sorter, digits);
                    printList(digits);
                    ioHandler.printSuccess(String.format("Die Sortierung von %d Zahlen mittels %s dauerte: %.2f ms", digits.size(), sorter.toString(), durationInMillis));
                }
                case 3 ->
                    quit = true;
            }

            System.out.println("\n");
        }
    }

    public static List<Integer> readDigits() {
        List<Integer> digits = null;
        DigitsReader reader = new DigitsReader();
        digits = reader.readDigitsFromFile("src/main/resources/digits.txt");
        return digits;
    }

    public static <T extends Comparable> double measureExecutionTime(Sorter sorter, List<T> toSort) {
        long startTime = System.nanoTime();
        sorter.sort(toSort);
        long endTime = System.nanoTime();
        long durationInNano = (endTime - startTime);
        return (double)durationInNano / (double)1_000_000;
    }

    public static void printList(List<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i));
            if (i!= list.size() - 1) {
                System.out.print(", ");
            }
        }

        System.out.println();
    }
}
