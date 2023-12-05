package at.fhburgenland;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DigitsReaderTest {

    private DigitsReader reader;

    @BeforeEach
    void setUp() {
        reader = new DigitsReader();
    }

    @Test
    void readDigitsFromFile_ValidFile_ReturnsCorrectList(@TempDir Path tempDir) throws Exception {
        Path tempFile = tempDir.resolve("digits.txt");
        Files.write(tempFile, "1;2;3\n4;5;6".getBytes());
        List<Integer> result = reader.readDigitsFromFile(tempFile.toString());
        assertEquals(Arrays.asList(1, 2, 3, 4, 5, 6), result);
    }

    @Test
    void readDigitsFromFile_NonExistentFile_ThrowsException() {
        String fileName = "nonexistent.txt";
        assertThrows(IllegalArgumentException.class, () -> reader.readDigitsFromFile(fileName));
    }

    @Test
    void readDigitsFromFile_InvalidFormat_IgnoresInvalidNumbers(@TempDir Path tempDir) throws Exception {
        Path tempFile = tempDir.resolve("invalidDigits.txt");
        Files.write(tempFile, "1;2;abc\n3;x;4".getBytes());
        List<Integer> result = reader.readDigitsFromFile(tempFile.toString());
        assertEquals(Arrays.asList(1, 2, 3, 4), result);
    }

    @Test
    void readDigitsFromFile_EmptyFile_ReturnsEmptyList(@TempDir Path tempDir) throws Exception {
        Path tempFile = tempDir.resolve("empty.txt");
        Files.createFile(tempFile);

        List<Integer> result = reader.readDigitsFromFile(tempFile.toString());

        assertTrue(result.isEmpty());
    }

    @Test
    void readDigitsFromFile_SingleLineFile_ReturnsCorrectList(@TempDir Path tempDir) throws Exception {
        Path tempFile = tempDir.resolve("singleLine.txt");
        Files.write(tempFile, "7;8;9".getBytes());

        List<Integer> result = reader.readDigitsFromFile(tempFile.toString());

        assertEquals(Arrays.asList(7, 8, 9), result);
    }

    @Test
    void readDigitsFromFile_FileWithEmptyLines_ReturnsCorrectList(@TempDir Path tempDir) throws Exception {
        Path tempFile = tempDir.resolve("emptyLines.txt");
        Files.write(tempFile, "\n1;2;3\n\n4;5;6\n".getBytes());

        List<Integer> result = reader.readDigitsFromFile(tempFile.toString());

        assertEquals(Arrays.asList(1, 2, 3, 4, 5, 6), result);
    }

    @Test
    void readDigitsFromFile_FileWithMixedFormats_IgnoresInvalidNumbers(@TempDir Path tempDir) throws Exception {
        Path tempFile = tempDir.resolve("mixedFormats.txt");
        Files.write(tempFile, "1;abc;2\n3;x;4;def".getBytes());

        List<Integer> result = reader.readDigitsFromFile(tempFile.toString());

        assertEquals(Arrays.asList(1, 2, 3, 4), result);
    }

    @Test
    void readDigitsFromFile_FileWithOnlyInvalidFormats_ReturnsEmptyList(@TempDir Path tempDir) throws Exception {
        Path tempFile = tempDir.resolve("invalidFormatsOnly.txt");
        Files.write(tempFile, "abc;def;ghi".getBytes());

        List<Integer> result = reader.readDigitsFromFile(tempFile.toString());

        assertTrue(result.isEmpty());
    }

    @Test
    void readDigitsFromFile_FileWithWhitespaces_ReturnsCorrectList(@TempDir Path tempDir) throws Exception {
        Path tempFile = tempDir.resolve("whitespaces.txt");
        Files.write(tempFile, " 1 ; 2 ; 3 ".getBytes());

        List<Integer> result = reader.readDigitsFromFile(tempFile.toString());

        assertEquals(Arrays.asList(1, 2, 3), result);
    }

    @Test
    void readDigitsFromFile_UnreadableFile_ThrowsExceptionWithDetails(@TempDir Path tempDir) throws Exception {
        Path tempFile = tempDir.resolve("unreadable.txt");
        Files.createFile(tempFile);
        tempFile.toFile().setReadable(false);

        Exception exception = assertThrows(IllegalArgumentException.class, () -> reader.readDigitsFromFile(tempFile.toString()));

        assertTrue(exception.getMessage().contains("An error occurred while reading the file"));
    }
}
