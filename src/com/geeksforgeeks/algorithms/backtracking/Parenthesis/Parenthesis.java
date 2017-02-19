package com.geeksforgeeks.algorithms.backtracking.Parenthesis;

/**
 * Created using IntelliJ IDEA.
 * User: abhijeet
 * Date: 18/02/17
 * Time: 9:39 AM
 * http://www.geeksforgeeks.org/print-all-combinations-of-balanced-parentheses/
 */
public class Parenthesis {
    public void printAllValidParenthesis(int openP, int closeP, String string) {
        if ((openP == 0) && (closeP == 0)) {
            System.out.println(string);
        }
        if (openP > closeP) {
            return;
        }
        if (openP > 0) {
            printAllValidParenthesis(openP - 1, closeP, string + "(");
        }
        if (closeP > 0) {
            printAllValidParenthesis(openP, closeP - 1, string + ")");
        }
    }

    public static void main(String[] args) {
        Parenthesis parenthesis = new Parenthesis();
        int n = 6;
        parenthesis.printAllValidParenthesis(n / 2, n / 2, "");
    }
}
