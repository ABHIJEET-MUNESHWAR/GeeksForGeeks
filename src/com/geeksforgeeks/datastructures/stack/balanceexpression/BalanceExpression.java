package com.geeksforgeeks.datastructures.stack.balanceexpression;

/**
 * Created using IntelliJ IDEA.
 * User: Abhijeet
 * Date: 27/10/16
 * Time: 7:11 AM
 * http://www.geeksforgeeks.org/minimum-number-of-bracket-reversals-needed-to-make-an-expression-balanced/
 */

import java.util.*;

public class BalanceExpression {
    private int numOfBracketReversal(String str) {
        int bal = -1;
        Stack<String> stack = new Stack<String>();
        int len = str.length();
        if(len%2==1) {
            return bal;
        }
        for (int i = 0; i < len; i++) {
            char ch = str.charAt(i);
            switch (ch) {
                case '{':
                    stack.push("{");
                    break;
                case '}':
                    if (!stack.isEmpty()) {
                        stack.pop();
                    } else {
                        stack.push("}");
                    }
                    break;
            }
        }
        int a = stack.size();
        int b = 0;
        while (!stack.isEmpty()) {
            String s = stack.pop();
            if (s.equals("{")) {
                b++;
            }
        }
        bal = a/2 + b%2;
        return bal;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        BalanceExpression balanceExpression = new BalanceExpression();
        int bal = balanceExpression.numOfBracketReversal(str);
        System.out.println(bal);
    }
}