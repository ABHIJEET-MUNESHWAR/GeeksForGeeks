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
        Stack<String> stack = new Stack<String>();
        int len = str.length();
        for (int i = 0; i < len; i++) {
            char ch = str.charAt(i);
            switch (ch) {
                case '(':
                    stack.push("(");
                    break;
                case ')':
                    if ((!stack.isEmpty()) && (stack.peek().equals("("))) {
                        stack.pop();
                    } else {
                        stack.push(")");
                    }
                    break;
            }
        }
        return (len - stack.size());
    }

    public static void main(String[] args) {
        LongestParenthesis longestParenthesis = new LongestParenthesis();
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int len = longestParenthesis.getLongestParenthesisLength(str);
        System.out.println(len);
    }
}
