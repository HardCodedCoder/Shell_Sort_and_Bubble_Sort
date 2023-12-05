package at.fhburgenland;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

/**
 * Class which reads the digits from a file.
 */
public class DigitsReader {
    /**
     * Reads the digits from a file being seperated by a ';' sign.
     * @param fileName the path pointing to the file.
     * @return A list of integers containing the digits in the order of the file.
     * @throws IllegalArgumentException if the file does not exist or cannot be read.
     */
    public List<Integer> readDigitsFromFile(String fileName) {
        Path path = Path.of(fileName);
        if (!path.toFile().exists()) {
            throw new IllegalArgumentException("File does not exist");
        }

        List<String> lines = null;
        try {
            lines = Files.readAllLines(path);
        } catch (Exception e) {
            throw new IllegalArgumentException("An error occurred while reading the file: " + e.getMessage());
        }

        if (lines == null)
            throw new IllegalArgumentException("No lines were read from the file");

        List<Integer> numbers = new ArrayList<Integer>();
        for (String line : lines) {
            for (String element : line.split(";")) {
                try
                {
                    numbers.add(Integer.parseInt(element));
                } catch (NumberFormatException e) {
                    System.err.println("Wrong format of element: " + element + " in line: '" +
                            line + "'. Skipping element...");
                }
            }
        }

        return numbers;
    }
}
