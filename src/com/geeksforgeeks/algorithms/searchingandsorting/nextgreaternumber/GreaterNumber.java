package com.geeksforgeeks.algorithms.searchingandsorting.nextgreaternumber;

/**
 * Created using IntelliJ IDEA.
 * User: abhijeet
 * Date: 04/01/17
 * Time: 11:49 PM
 * http://www.geeksforgeeks.org/find-next-greater-number-set-digits/
 */
public class GreaterNumber {
    private int findNext(String str, int size) {
        char[] chars = str.toCharArray();
        int i;
        for(i=size-1; i>0; i--) {
            int a = Integer.valueOf(chars[i]);
            int b = Integer.valueOf(chars[i-1]);
            if(a>b) {
                break;
            }
        }
        if(i==0) {
            System.out.println("Next number is not possible.");
        }
        int x = Integer.valueOf(chars[i-1]);
        int smallest = i;
        for(int j=i+1; j<size; j++) {
            int j1 = Integer.valueOf(chars[j]);
            int smallest1 = Integer.valueOf(chars[smallest]);
            if((j1>x)&&(j1<smallest1)) {
                smallest = j1;
            }
        }
        return 0;
    }
    public static void main(String[] args) {
        GreaterNumber greaterNumber = new GreaterNumber();
        String str = "534976";
        int size = str.length();
        greaterNumber.findNext(str, size);
    }
}
