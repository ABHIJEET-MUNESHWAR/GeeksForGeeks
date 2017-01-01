package com.geeksforgeeks.algorithms.searchingandsorting.wavesort;

/**
 * Created using IntelliJ IDEA.
 * User: abhijeet
 * Date: 01/01/17
 * Time: 5:07 PM
 * http://www.geeksforgeeks.org/sort-array-wave-form-2/
 */
public class WaveSort {
    private void swap(int[] input, int a, int b) {
        int t = input[a];
        input[a] = input[b];
        input[b] = t;
    }

    private void waveSort(int[] input, int size) {
        for (int i = 0; i < size; i += 2) {
            if ((i > 0) && (input[i] < input[i - 1])) {
                swap(input, i - 1, i);
            }
            if ((i < size - 1) && (input[i] < input[i + 1])) {
                swap(input, i, i + 1);
            }
        }
    }

    public static void main(String[] args) {
        WaveSort waveSort = new WaveSort();
        int[] input = {10, 90, 49, 2, 1, 5, 23};
        int size = input.length;
        waveSort.waveSort(input, size);
        for (int i = 0; i < size; i++) {
            System.out.println(input[i]);
        }
    }
}
