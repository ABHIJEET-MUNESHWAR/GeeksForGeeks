package com.geeksforgeeks.datastructures.stack.twostacksinarray;

/**
 * Created by Abhijeet on 20/10/16.
 * https://www.geeksforgeeks.org/implement-two-stacks-in-an-array/
 */

import java.util.*;

public class TwoStacks {
    int size, top1, top2, arr[];

    TwoStacks(int n) {
        arr = new int[n];
        this.size = n;
        this.top1 = -1;
        this.top2 = n;
    }

    private void push1(int data) {
        if (top1 < top2 - 1) {
            top1++;
            arr[top1] = data;
        } else {
            System.out.println("Stack overflow");
        }
    }

    private void push2(int data) {
        if (top1 < top2 - 1) {
            top2--;
            arr[top2] = data;
        } else {
            System.out.println("Stack overflow");
        }
    }

    private int pop1() {
        if(top1==-1) {
            System.out.println("Stack Underflow");
            return 0;
        } else {
            int d = arr[top1];
            top1--;
            return d;
        }
    }

    private int pop2(){
        if(top2==size) {
            System.out.println("Stack Underflow");
            return 0;
        } else {
            int d = arr[top2];
            top2++;
            return d;
        }
    }

    public static void main(String[] args) {
        TwoStacks twoStacks = new TwoStacks(5);
        twoStacks.push1(5);
        twoStacks.push2(10);
        twoStacks.push2(15);
        twoStacks.push1(11);
        twoStacks.push2(7);
        System.out.println("Popped element form stack 1 is: " + twoStacks.pop1());
        System.out.println("Popped element form stack 2 is: " + twoStacks.pop2());
    }
}
