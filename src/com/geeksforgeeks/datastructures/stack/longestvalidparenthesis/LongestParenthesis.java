package com.geeksforgeeks.datastructures.stack.longestvalidparenthesis;

/**
 * Created using IntelliJ IDEA.
 * User: Abhijeet
 * Date: 25/10/16
 * Time: 7:36 AM
 */

import java.util.*;

public class LongestParenthesis {
    private int getLongestParenthesisLength(String str) {
        Stack<Integer> stack = new Stack<Integer>();
        int n = str.length();
        int length = 0;
        int lastMatchedIndex = -1;
        for (int i = 0; i < n; i++) {
            char ch = str.charAt(i);
            switch (ch) {
                case '(':
                    stack.push(i);
                    break;
                case ')':
                    if (stack.isEmpty()) {
                        lastMatchedIndex = i;
                    } else {
                        stack.pop();
                        if (stack.isEmpty()) {
                            length = Math.max(length, i - lastMatchedIndex);
                        } else {
                            length = Math.max(length, i - stack.peek());
                        }
                    }
                    break;
            }
        }
        return length;
    }

    public static void main(String[] args) {
        LongestParenthesis longestParenthesis = new LongestParenthesis();
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int len = longestParenthesis.getLongestParenthesisLength(str);
        System.out.println(len);
    }
}
