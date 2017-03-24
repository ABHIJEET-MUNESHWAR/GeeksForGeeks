package com.geeksforgeeks.algorithms.randomised.fibonacci;

/**
 * Created using IntelliJ IDEA.
 * User: abhijeet
 * Date: 23/03/17
 * Time: 8:45 PM
 */
public class FibonacciRecursive {
    public static void main(String[] args) {
        FibonacciRecursive fibonacciRecursive = new FibonacciRecursive();
        int n = 6;
        int num = fibonacciRecursive.fibonacciRecursive(n);
        System.out.println(num);
    }

    private int fibonacciRecursive(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            return (fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2));
        }
    }
}
