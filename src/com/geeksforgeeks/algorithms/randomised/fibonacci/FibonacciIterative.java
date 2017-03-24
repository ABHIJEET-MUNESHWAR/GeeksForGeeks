package com.geeksforgeeks.algorithms.randomised.fibonacci;

/**
 * Created using IntelliJ IDEA.
 * User: abhijeet
 * Date: 23/03/17
 * Time: 8:44 PM
 * 1 1 2 3 5 8
 */
public class FibonacciIterative {
    public static void main(String[] args) {
        FibonacciIterative fibonacciIterative = new FibonacciIterative();
        int n = 4;
        int num = fibonacciIterative.fibonacciIterative(n);
        System.out.println(num);
    }

    private int fibonacciIterative(int n) {
        int fib = 0;
        int a = 1;
        for (int i = 0; i < n; i++) {
            fib = fib + a;
            a = fib;
        }
        return fib;
    }
}
