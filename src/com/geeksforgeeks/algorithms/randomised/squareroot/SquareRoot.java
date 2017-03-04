package com.geeksforgeeks.algorithms.randomised.squareroot;

/**
 * Created using IntelliJ IDEA.
 * User: abhijeet
 * Date: 04/03/17
 * Time: 7:39 PM
 * http://www.geeksforgeeks.org/square-root-of-an-integer/
 */
public class SquareRoot {
    private int squareRoot(int n) {
        if ((n == 0) || (n == 1)) {
            return n;
        }
        int start = 0;
        int end = n;
        int ans = 0;
        while (start <= end) {
            int mid = (start + end) / 2;
            if ((mid * mid) == n) {
                return mid;
            }
            if (mid * mid < n) {
                start = mid + 1;
                ans = mid;
            } else {
                end = mid - 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        SquareRoot squareRoot = new SquareRoot();
        int x = 15;
        int s = squareRoot.squareRoot(x);
        System.out.println(s);
    }
}
