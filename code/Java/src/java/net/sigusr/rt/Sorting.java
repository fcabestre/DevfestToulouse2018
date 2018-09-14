package net.sigusr.rt;

@SuppressWarnings("ALL")
public class Sorting {
    public static int[] insertionSort(int array[]) {
        int n = array.length;
        int[] result = new int[n];
        for (int j = 0; j < n; j++) {
            int key = array[j];
            int i = j-1;
            while ( (i > -1) && ( result[i] > key ) ) {
                result [i+1] = result[i];
                i--;
            }
            result[i+1] = key;
        }
        return result;
    }
}