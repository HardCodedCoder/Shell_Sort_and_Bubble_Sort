package at.fhburgenland.interfaces;

import java.util.List;

public interface Sorter {
    public <T extends Comparable<T>> void sort(List<T> collection);

    public String toString();
}
