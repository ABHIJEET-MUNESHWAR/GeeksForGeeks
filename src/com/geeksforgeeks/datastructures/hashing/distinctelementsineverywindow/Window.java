package com.geeksforgeeks.datastructures.hashing.distinctelementsineverywindow;

/**
 * Created using IntelliJ IDEA.
 * User: abhijeet
 * Date: 17/12/16
 * Time: 3:12 PM
 * http://www.geeksforgeeks.org/count-distinct-elements-in-every-window-of-size-k/
 */

import java.util.HashMap;

public class Window {
    public void countDistinct(int[] input, int windowLength) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        int size = input.length;
        int windowCounter = 0;
        for (int i = 0; i < windowLength; i++) {
            int element = input[i];
            if (hashMap.containsKey(element)) {
                hashMap.put(element, hashMap.get(element) + 1);
            } else {
                hashMap.put(element, 0);
            }
        }
        System.out.println(hashMap.size());
        for (int i = windowLength; i < size; i++) {
            int element = input[i];
            int removeElementIndex = i - windowLength;
            int removeElement = input[removeElementIndex];
            if (hashMap.containsKey(removeElement)) {
                int s = hashMap.get(removeElement);
                if (s > 0) {
                    hashMap.put(removeElement, hashMap.get(removeElement) - 1);
                } else {
                    hashMap.remove(removeElement);
                }
                if (hashMap.containsKey(element)) {
                    hashMap.put(element, hashMap.get(element) + 1);
                } else {
                    hashMap.put(element, 1);
                }
            }
            System.out.println(hashMap.size());
        }
    }

    public static void main(String[] args) {
        Window window = new Window();
        int arr[] = {1, 2, 1, 3, 4, 2, 3};
        int k = 4;
        window.countDistinct(arr, k);
    }
}
