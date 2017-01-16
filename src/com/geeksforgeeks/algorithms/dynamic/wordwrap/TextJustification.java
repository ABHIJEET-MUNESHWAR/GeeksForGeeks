package com.geeksforgeeks.algorithms.dynamic.wordwrap;

/**
 * Created using IntelliJ IDEA.
 * User: abhijeet
 * Date: 16/01/17
 * Time: 12:48 AM
 * http://www.geeksforgeeks.org/dynamic-programming-set-18-word-wrap/
 * https://github.com/mission-peace/interview/blob/master/src/com/interview/dynamic/TextJustification.java
 */
public class TextJustification {
    public String justify(String[] word, int width) {
        int length = word.length;
        int[][] cost = new int[length][length];
        for (int i = 0; i < length; i++) {
            cost[i][i] = width - word[i].length() - 1;
            for (int j = i + 1; j < length; j++) {
                cost[i][j] = cost[i][j - 1] - word[j].length() - 1;
            }
        }
        for (int i = 0; i < length; i++) {
            for (int j = i; j < length; j++) {
                if (cost[i][j] < 0) {
                    cost[i][j] = Integer.MAX_VALUE;
                } else {
                    cost[i][j] = (int) Math.pow(cost[i][j], 2);
                }
            }
        }
        int[] minCost = new int[length];
        int[] result = new int[length];
        for (int i = length - 1; i >= 0; i--) {
            minCost[i] = cost[i][length - 1];
            result[i] = length;
            for (int j = length - 1; j > i; j--) {
                if (cost[i][j - 1] == Integer.MAX_VALUE) {
                    continue;
                }
                if (minCost[i] > (minCost[j] + cost[i][j - 1])) {
                    minCost[i] = minCost[j] + cost[i][j - 1];
                    result[i] = j;
                }
            }
        }
        System.out.println("Minimum cost is: " + minCost[0]);
        StringBuilder builder = new StringBuilder();
        int i = 0;
        int j;
        do {
            j = result[i];
            for (int k = i; k < j; k++) {
                builder.append(word[k] + " ");
            }
            builder.append("\n");
            i = j;
        } while (j < length);
        return builder.toString();

    }

    public static void main(String args[]) {
        String words1[] = {"Tushar", "likes", "to", "write", "code", "at", "free", "time"};
        TextJustification awl = new TextJustification();
        System.out.println(awl.justify(words1, 12));
    }
}
