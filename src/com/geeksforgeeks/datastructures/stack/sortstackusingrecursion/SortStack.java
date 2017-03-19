package com.geeksforgeeks.datastructures.stack.sortstackusingrecursion;

/**
 * Created using IntelliJ IDEA.
 * User: Abhijeet
 * Date: 22/10/16
 * Time: 9:36 PM
 * http://www.geeksforgeeks.org/sort-a-stack-using-recursion/
 */

import java.util.*;

public class SortStack {
    private void sortStack(Stack<Integer> stack) {
        if (!stack.isEmpty()) {
            int num = stack.pop();
            sortStack(stack);
            sortedInsert(num, stack);
        }
    }

    private void sortedInsert(int num, Stack<Integer> stack) {
        if ((stack.isEmpty()) || (num > stack.peek())) {
            stack.push(num);
            return;
        }
        Integer t = stack.pop();
        sortedInsert(num, stack);
        stack.push(t);
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(3);
        stack.push(2);
        stack.push(4);
        stack.push(1);
        stack.push(6);
        stack.push(5);
        System.out.println("Stack before sorting: " + stack);
        SortStack sortStack = new SortStack();
        sortStack.sortStack(stack);
        System.out.println("Stack after sorting: " + stack);
    }
}
