package org.example;

import org.example.interfaces.Sorter;

import java.util.List;

/**
 *  Class which implements the Bubble Sort algorithm.
 */
public class BubbleSort implements Sorter {
    /**
     * Sorts the given list using the Bubble Sort algorithm.
     * @param list
     * @param <T>
     */
    @Override
    public <T extends Comparable<T>> void sort(List<T> list) {
        boolean swapped = false;
        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = 0; j < list.size() - i - 1; j++) {
                if (list.get(j).compareTo(list.get(j + 1)) > 0) {
                    T temp = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, temp);
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
            swapped = false;
        }
    }
    @Override
    public String toString() {
        return "Bubble Sort - Algorithmus";
    }
}
