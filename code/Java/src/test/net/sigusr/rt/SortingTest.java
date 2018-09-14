package net.sigusr.rt;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static net.sigusr.rt.Sorting.insertionSort;
import static org.junit.jupiter.api.Assertions.*;

@SuppressWarnings("ALL")
class SortingTest {

    @Test
    void insertionSortTest() {
        int[] source = {9,14,3,2,43,11,58,22};
        int[] sorted = {2,3,9,11,14,22,43,58};
        int[] actual = insertionSort(source);

        assertArrayEquals(actual,sorted, "Sorted and actual arrays sould be equal");
        assertFalse(Arrays.equals(actual,source), "Sorted and source arrays sould not be equal");
    }
}