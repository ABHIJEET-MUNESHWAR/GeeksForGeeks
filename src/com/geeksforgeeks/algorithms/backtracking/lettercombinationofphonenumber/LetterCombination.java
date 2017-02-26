package com.geeksforgeeks.algorithms.backtracking.lettercombinationofphonenumber;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * Created using IntelliJ IDEA.
 * User: abhijeet
 * Date: 26/02/17
 * Time: 7:13 PM
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/?tab=Solutions
 */
public class LetterCombination {
    public static void main(String[] args) {
        LetterCombination letterCombination = new LetterCombination();
        String str = "246";
        LinkedList<String> combinations = letterCombination.letterCombinations(str);
        Iterator<String> i = combinations.listIterator();
        while (i.hasNext()) {
            System.out.print(i.next() + " ");
        }
    }

    private LinkedList<String> letterCombinations(String digits) {
        LinkedList<String> ans = new LinkedList<>();
        String[] mapping = new String[]{"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        ans.add("");
        int size = digits.length();
        for (int i = 0; i < size; i++) {
            int x = Character.getNumericValue(digits.charAt(i));
            while (ans.peek().length() == i) {
                String t = ans.remove();
                for (char s : mapping[x].toCharArray()) {
                    ans.add(t + s);
                }
            }
        }
        return ans;
    }

}
