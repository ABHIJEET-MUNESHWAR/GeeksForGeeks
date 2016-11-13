package com.geeksforgeeks.datastructures.stack.balancedparentheses;

/**
 * Created by Abhijeet on 20/10/16.
 */

import java.util.*;

public class BalancedParenthesis {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<String> stack = new Stack<String>();
        String string = sc.next();
        int len = string.length();
        String s;
        boolean isValid = true;
        for (int i = 0; i < len; i++) {
            char ch = string.charAt(i);
            switch (ch) {
                case '(':
                    stack.push("(");
                    break;
                case '{':
                    stack.push("{");
                    break;
                case '[':
                    stack.push("[");
                    break;
                case ')':
                    s = stack.pop();
                    if (!s.equals("(")) {
                        isValid = false;
                    }
                    break;
                case '}':
                    s = stack.pop();
                    if (!s.equals("{")) {
                        isValid = false;
                    }
                    break;
                case ']':
                    s = stack.pop();
                    if (!s.equals("[")) {
                        isValid = false;
                    }
                    break;
            }
        }
        if (!stack.isEmpty()) {
            isValid = false;
        }
        if (isValid) {
            System.out.println("Valid");
        } else {
            System.out.println("Invalid");
        }
    }
}
