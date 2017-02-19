package com.geeksforgeeks.algorithms.randomised.romantodecimal;

/**
 * Created using IntelliJ IDEA.
 * User: abhijeet
 * Date: 19/02/17
 * Time: 8:27 PM
 */
public class RomanToDecimal {

    // This function returns value of a Roman symbol
    int value(char r) {
        if (r == 'I')
            return 1;
        if (r == 'V')
            return 5;
        if (r == 'X')
            return 10;
        if (r == 'L')
            return 50;
        if (r == 'C')
            return 100;
        if (r == 'D')
            return 500;
        if (r == 'M')
            return 1000;
        return -1;
    }

    private int romanToDecimal(String str) {
        int result = 0;
        int size = str.length();
        for (int i = 0; i < size; i++) {
            int s1 = value(str.charAt(i));
            if ((i + 1) < size) {
                int s2 = value(str.charAt(i + 1));
                if (s1 >= s2) {
                    result = result + s1;
                } else {
                    result = result + s2 - s1;
                    i++;
                }
            } else {
                result = result + s1;
                i++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        RomanToDecimal romanToDecimal = new RomanToDecimal();
        String str = "MCMIV";
        System.out.println("Integer form of Roman Numeral" +
                " is " + romanToDecimal.romanToDecimal(str));
    }
}
