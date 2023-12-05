package org.example;

import org.example.interfaces.Sorter;

import java.util.List;

/**
 * Class which implements the Shell Sort algorithm.
 */
public class ShellSort implements Sorter {

    /**
     *  Sorts the given collection using the Shell Sort algorithm.
     * @param collection
     * @param <T>
     */
    @Override
    public <T extends Comparable<T>> void sort(List<T> collection) {
        int numberOfElements = collection.size();

        // Start with a big gap (half of the size of the collection), decrease gap each round
        for (int gap = numberOfElements / 2; gap > 0; gap /= 2) {

            // Go through the elements in the collection
            for (int i = gap; i < numberOfElements; i++) {
                T currentElement = collection.get(i);
                int indexToCompareTo = i;

                // Move the elements, which are bigger than the current element,
                // gap positions to the right.
                while (indexToCompareTo >= gap && collection.get(indexToCompareTo - gap).compareTo(currentElement) > 0)
                {
                    collection.set(indexToCompareTo, collection.get(indexToCompareTo - gap));
                    indexToCompareTo -= gap;
                }

                // Set the current element at the correct position
                collection.set(indexToCompareTo, currentElement);
            }
        }
    }

    @Override
    public String toString() {
        return "Shell Sort - Algorithmus";
    }
}
