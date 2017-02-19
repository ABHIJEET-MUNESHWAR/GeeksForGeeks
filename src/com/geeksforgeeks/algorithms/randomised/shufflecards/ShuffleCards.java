package com.geeksforgeeks.algorithms.randomised.shufflecards;

import java.util.Random;

/**
 * Created using IntelliJ IDEA.
 * User: abhijeet
 * Date: 19/02/17
 * Time: 4:00 PM
 */
public class ShuffleCards {
    public static void main(String[] args) {
        int[] cards = new int[52];
        for (int i = 0; i < 52; i++) {
            cards[i] = i;
        }
        for (int i = 0; i < 52; i++) {
            int j = new Random().nextInt(52 - i) + i;
            int temp = cards[i];
            cards[i] = cards[j];
            cards[j] = temp;
        }
        for (int i = 0; i < 52; i++) {
            System.out.print(cards[i] + " ");
        }
    }
}
