package com.geeksforgeeks.datastructures.custom.o1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Random;

/**
 * Created using IntelliJ IDEA
 * User: Abhijeet
 * Date: 12-04-2017
 * Time: 03:47 PM
 * http://www.geeksforgeeks.org/design-a-data-structure-that-supports-insert-delete-search-and-getrandom-in-constant-time/
 */
public class MyDS {
    ArrayList<Integer>        list;
    HashMap<Integer, Integer> hashMap;

    MyDS() {
        list = new ArrayList<>();
        hashMap = new HashMap<>();
    }

    // A Theta(1) function to add an element to MyDS
    // data structure
    void add(int x) {
        if (!hashMap.containsKey(x)) {
            int size = list.size();
            list.add(x);
            hashMap.put(x, size);
        }
    }

    // A Theta(1) function to remove an element from MyDS
    // data structure
    void remove(int x) {
        Integer index = hashMap.get(x);
        hashMap.remove(x);
        int     size = list.size();
        Integer last = list.get(size - 1);
        Collections.swap(list, index, size - 1);
        list.remove(size - 1);
        hashMap.put(last, index);
    }

    // Returns a random element from MyDS
    int getRandom() {
        Random random = new Random();
        int    index  = random.nextInt(list.size());
        return list.get(index);
    }

    // Returns index of element if element is present, otherwise null
    Integer search(int x) {
        return hashMap.get(x);
    }
}
