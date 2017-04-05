package com.geeksforgeeks.algorithms.backtracking.towerofhanoi;

/**
 * Created using IntelliJ IDEA
 * User: Abhijeet
 * Date: 05-04-2017
 * Time: 06:27 PM
 * https://www.tutorialspoint.com/javaexamples/method_tower.htm
 */
public class TowerOfHanoi {
    public static void main(String[] args) {
        int disks = 3;
        doTowers(disks, 'A', 'B', 'C');
    }

    private static void doTowers(int top, char from, char inter, char to) {
        if (top == 1) {
            System.out.println("Disk 1 from " + from + " to " + to);
        } else {
            doTowers(top - 1, from, to, inter);
            System.out.println("Disk " + top + " from " + from + " to " + to);
            doTowers(top - 1, inter, from, to);
        }
    }
}
