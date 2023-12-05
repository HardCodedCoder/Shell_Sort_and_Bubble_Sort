package at.fhburgenland;
import static org.junit.jupiter.api.Assertions.*;

import at.fhburgenland.sorter.BubbleSort;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class BubbleSortTest {

    private final BubbleSort bubbleSort = new BubbleSort();

    @Test
    void testEmptyList() {
        List<Integer> list = Collections.emptyList();
        bubbleSort.sort(list);
        assertTrue(list.isEmpty());
    }

    @Test
    void testSingleElement() {
        List<Integer> list = Collections.singletonList(1);
        bubbleSort.sort(list);
        assertEquals(Collections.singletonList(1), list);
    }

    @Test
    void testAlreadySortedList() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        bubbleSort.sort(list);
        assertEquals(Arrays.asList(1, 2, 3, 4, 5), list);
    }

    @Test
    void testUnsortedList() {
        List<Integer> list = Arrays.asList(4, 2, 5, 1, 3);
        bubbleSort.sort(list);
        assertEquals(Arrays.asList(1, 2, 3, 4, 5), list);
    }

    @Test
    void testListWithDuplicates() {
        List<Integer> list = Arrays.asList(4, 2, 5, 2, 3);
        bubbleSort.sort(list);
        assertEquals(Arrays.asList(2, 2, 3, 4, 5), list);
    }

    @Test
    void testReverseOrderedList() {
        List<Integer> list = Arrays.asList(5, 4, 3, 2, 1);
        bubbleSort.sort(list);
        assertEquals(Arrays.asList(1, 2, 3, 4, 5), list);
    }
}

