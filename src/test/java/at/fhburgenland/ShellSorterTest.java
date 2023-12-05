package at.fhburgenland;

import at.fhburgenland.sorter.ShellSort;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ShellSorterTest {

    private final ShellSort shellSort = new ShellSort();

    @Test
    void testEmptyList() {
        List<Integer> list = Collections.emptyList();
        shellSort.sort(list);
        assertTrue(list.isEmpty());
    }

    @Test
    void testSingleElement() {
        List<Integer> list = Collections.singletonList(1);
        shellSort.sort(list);
        assertEquals(Collections.singletonList(1), list);
    }

    @Test
    void testAlreadySortedList() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        shellSort.sort(list);
        assertEquals(Arrays.asList(1, 2, 3, 4, 5), list);
    }

    @Test
    void testUnsortedList() {
        List<Integer> list = Arrays.asList(4, 2, 5, 1, 3);
        shellSort.sort(list);
        assertEquals(Arrays.asList(1, 2, 3, 4, 5), list);
    }

    @Test
    void testListWithDuplicates() {
        List<Integer> list = Arrays.asList(4, 2, 5, 2, 3);
        shellSort.sort(list);
        assertEquals(Arrays.asList(2, 2, 3, 4, 5), list);
    }

    @Test
    void testReverseOrderedList() {
        List<Integer> list = Arrays.asList(5, 4, 3, 2, 1);
        shellSort.sort(list);
        assertEquals(Arrays.asList(1, 2, 3, 4, 5), list);
    }
}
