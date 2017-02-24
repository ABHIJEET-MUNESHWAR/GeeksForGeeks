package com.geeksforgeeks.datastructures.heap.minheap;

/**
 * Created using IntelliJ IDEA.
 * User: abhijeet
 * Date: 21/02/17
 * Time: 8:27 PM
 * http://algorithms.tutorialhorizon.com/binary-min-max-heap/
 */
public class MinHeap {
    int size;
    int[] mH;
    int position;

    MinHeap(int size) {
        this.size = size;
        position = 0;
        mH = new int[size + 1];
    }

    private void createHeap(int[] input) {
        int len = input.length;
        if (len > 0) {
            for (int i = 0; i < len; i++) {
                insert(input[i]);
            }
        }
    }

    private void insert(int data) {
        if (position == 0) {
            mH[position + 1] = data;
            position = 2;
        } else {
            mH[position++] = data;
            bubbleUp();
        }
    }

    private void bubbleUp() {
        int pos = position - 1;
        while ((pos > 0) && (mH[pos / 2] > mH[pos])) {
            int t = mH[pos / 2];
            mH[pos / 2] = mH[pos];
            mH[pos] = t;
            pos = pos / 2;
        }
    }

    private void display() {
        for (int i = 1; i < mH.length; i++) {
            System.out.print(mH[i] + " ");
        }
        System.out.println();
    }

    private int extractMin() {
        int min = mH[1];
        mH[1] = mH[position - 1];
        mH[position - 1] = 0;
        position--;
        sinkDown(1);
        return min;
    }

    private void sinkDown(int data) {
        int a = mH[data];
        int smallest = data;
        if (((2 * data) < position) && (mH[smallest] > mH[2 * data])) {
            smallest = 2 * data;
        }
        if (((2 * data + 1) < position) && (mH[smallest] > mH[2 * data + 1])) {
            smallest = 2 * data + 1;
        }
        if (smallest != data) {
            swap(data, smallest);
            sinkDown(smallest);
        }
    }

    private void swap(int a, int b) {
        int t = mH[a];
        mH[a] = mH[b];
        mH[b] = t;
    }

    public static void main(String[] args) {
        int[] input = {3, 2, 1, 7, 8, 4, 10, 16, 12};
        MinHeap minHeap = new MinHeap(input.length);
        minHeap.createHeap(input);
        minHeap.display();
        System.out.print("Extract Min :");
        for (int i = 0; i < input.length; i++) {
            System.out.print("  " + minHeap.extractMin());
        }
    }
}