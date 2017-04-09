package com.geeksforgeeks.datastructures.array.petrolpump;

/**
 * Created using IntelliJ IDEA
 * User: Abhijeet
 * Date: 06-04-2017
 * Time: 09:21 AM
 * http://stackoverflow.com/questions/2286849/algorithm-for-truck-moving-around-a-circle-of-gas-stations
 * https://leetcode.com/problems/gas-station/?tab=Description#/solutions
 */
public class PetrolPump {

    public static void main(String[] args) {
        PetrolPump petrolPump = new PetrolPump();
        int[]      petrol     = {6, 3, 7};
        int[]      distance   = {4, 6, 3};
        int        index      = petrolPump.findCircle2(petrol, distance);
        System.out.println(index);
    }

    private int findCircle(int[] petrol, int[] distance) {
        int min      = Integer.MAX_VALUE;
        int quantity = 0;
        int position = 0;
        int n        = petrol.length;
        for (int i = 0; i < n; i++) {
            quantity += petrol[i] - distance[i];
            if (min > quantity) {
                min = quantity;
                position = (i + 1) % n;
            }
        }
        if (quantity >= 0) {
            return position;
        } else {
            return -1;
        }
    }

    private int findCircle2(int[] petrol, int[] distance) {
        int tank  = 0;
        int start = 0;
        int total = 0;
        int n     = petrol.length;
        for (int i = 0; i < n; i++) {
            tank = tank + petrol[i] - distance[i];
            if (tank < 0) {
                start = i + 1;
                total = total + tank;
                tank = 0;
            }
        }
        if ((total + tank) < 0) {
            return -1;
        } else {
            return start;
        }
    }
}