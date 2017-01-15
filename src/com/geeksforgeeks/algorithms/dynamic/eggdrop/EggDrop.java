package com.geeksforgeeks.algorithms.dynamic.eggdrop;

/**
 * Created using IntelliJ IDEA.
 * User: abhijeet
 * Date: 14/01/17
 * Time: 7:47 PM
 * http://www.geeksforgeeks.org/dynamic-programming-set-11-egg-dropping-puzzle/
 */
public class EggDrop {
    private int calculteMinPrice(int egg, int floor) {
        int[][] result = new int[egg + 1][floor + 1];
        for (int i = 0; i <= floor; i++) {
            result[1][i] = i;
        }
        for (int e = 2; e <= egg; e++) {
            for (int f = 1; f <= floor; f++) {
                result[e][f] = Integer.MAX_VALUE;
                for (int k = 1; k <= f; k++) {
                    int t = 1 + Math.max(result[e - 1][k - 1], result[e][f - k]);
                    if (t < result[e][f]) {
                        result[e][f] = t;
                    }
                }
            }
        }
        return result[egg][floor];
    }

    public static void main(String[] args) {
        EggDrop eggDrop = new EggDrop();
        int egg = 2;
        int floor = 10;
        int minTrials = eggDrop.calculteMinPrice(egg, floor);
        System.out.println(minTrials);
    }
}
