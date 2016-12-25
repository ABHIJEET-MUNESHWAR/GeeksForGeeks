package com.geeksforgeeks.datastructures.hashing.reducedarrayform;

/**
 * Created using IntelliJ IDEA.
 * User: abhijeet
 * Date: 25/12/16
 * Time: 5:36 PM
 * http://www.geeksforgeeks.org/convert-array-reduced-form/
 */

import java.util.Arrays;
import java.util.HashMap;

public class ReducedArrayForm {
    private void convert(int[] input) {
        int size = input.length;
        HashMap<Integer, Integer> hashMap = new HashMap();
        int[] temp = new int[size];
        for (int i = 0; i < size; i++) {
            temp[i] = input[i];
        }
        Arrays.sort(temp);
        for (int i = 0; i < size; i++) {
            hashMap.put(temp[i], i);
        }
        for (int i = 0; i < size; i++) {
            System.out.println(hashMap.get(input[i]));
        }
    }

    public static void main(String[] args) {
        int arr[] = {10, 20, 15, 12, 11, 50};
        ReducedArrayForm reducedArrayForm = new ReducedArrayForm();
        reducedArrayForm.convert(arr);
    }
}
