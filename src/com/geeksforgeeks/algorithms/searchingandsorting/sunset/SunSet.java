package com.geeksforgeeks.algorithms.searchingandsorting.sunset;

/**
 * Created using IntelliJ IDEA.
 * User: abhijeet
 * Date: 04/01/17
 * Time: 10:19 PM
 * http://www.practice.geeksforgeeks.org/problem-page.php?pid=515
 */

import java.util.Scanner;

public class SunSet {
    private int countBuildings(int[] buildings, int size) {
        int count = 1;
        int element = buildings[0];
        for (int i = 1; i < size; i++) {
            if (buildings[i] > element) {
                count++;
                element = buildings[i];
            }
        }
        return count;
    }

    public static void main(String[] args) {
        SunSet sunSet = new SunSet();
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int size = sc.nextInt();
            int[] buildings = new int[size];
            for (int i = 0; i < size; i++) {
                buildings[i] = sc.nextInt();
            }
            int count = sunSet.countBuildings(buildings, size);
            System.out.println(count);
        }
    }
}
