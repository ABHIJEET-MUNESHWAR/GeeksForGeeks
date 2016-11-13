package com.geeksforgeeks.datastructures.stack.reversestackusingrecursion;

/**
 * Created by Abhijeet on 22/10/16.
 * http://www.geeksforgeeks.org/reverse-a-stack-using-recursion/
 */

import java.util.*;

public class ReverseStack {
    private void reverseStack(Stack<Integer> stack) {
        Integer num = stack.pop();
        if (!stack.isEmpty()) {
            reverseStack(stack);
        }
        pushToBottom(num, stack);
    }

    private void pushToBottom(int num, Stack<Integer> stack) {
        if (stack.isEmpty()) {
            stack.push(num);
            return;
        }
        Integer t = stack.pop();
        pushToBottom(num, stack);
        stack.push(t);
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        System.out.println("Stack elements before reversing: " + stack);
        ReverseStack reverseStack = new ReverseStack();
        reverseStack.reverseStack(stack);
        System.out.println("Stack elements after reversing: " + stack);
    }
}
