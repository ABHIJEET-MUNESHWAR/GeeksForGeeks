package com.geeksforgeeks.datastructures.queue.generatebinarynumbers;

/**
 * Created using IntelliJ IDEA.
 * User: Abhijeet
 * Date: 13/11/16
 * Time: 2:20 PM
 */

import java.util.*;

public class BinaryNumbers {
    private void generateBinaryNumbers(int n) {
        Queue<String> queue = new LinkedList<String>();
        queue.add("1");
        while (n-- > 0) {
            String s1 = queue.poll();
            System.out.println(s1);
            String s2 = s1;
            queue.add(s1 + "0");
            queue.add(s2 + "1");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        BinaryNumbers binaryNumbers = new BinaryNumbers();
        binaryNumbers.generateBinaryNumbers(n);
    }
}
