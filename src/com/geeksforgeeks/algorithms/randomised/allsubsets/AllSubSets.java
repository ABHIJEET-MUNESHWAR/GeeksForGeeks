package com.geeksforgeeks.algorithms.randomised.allsubsets;

/**
 * Created using IntelliJ IDEA.
 * User: abhijeet
 * Date: 26/02/17
 * Time: 11:53 AM
 */
public class AllSubSets {

    private void printAllSubSets(int[] input) {
        int size = input.length;
        for (int i = 0; i < (1 << size); i++) {
            System.out.print("{");
            for (int j = 0; j < size; j++) {
                if ((i & (1 << j)) > 0) {
                    System.out.print(input[j]);
                }
            }
            System.out.println("}");
        }
    }

    public static void main(String[] args) {
        int[] set = {1, 2, 3};
        AllSubSets allSubSets = new AllSubSets();
        allSubSets.printAllSubSets(set);
    }
}
