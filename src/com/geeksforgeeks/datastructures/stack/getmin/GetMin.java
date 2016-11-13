package com.geeksforgeeks.datastructures.stack.getmin;

/**
 * Created using IntelliJ IDEA.
 * User: Abhijeet
 * Date: 23/10/16
 * Time: 4:29 PM
 */
import java.util.*;
public class GetMin {
    private void push(Stack<Integer> stack, Stack<Integer> minStack, int element) {
        if(stack.isEmpty()) {
            stack.push(element);
            minStack.push(element);
        } else {
            if(element<minStack.peek()) {
                minStack.push(element);
                stack.push(element);
            } else {
                minStack.push(minStack.peek());
                stack.push(element);
            }
        }
    }
    private int getMin(Stack<Integer> minStack) {
        return minStack.peek();
    }
    private int pop(Stack<Integer> stack, Stack<Integer> minStack) {
        minStack.pop();
        return stack.pop();
    }
    public static void main(String[] args) {
        GetMin specialStack = new GetMin();
        Stack<Integer> stack = new Stack<Integer>();
        Stack<Integer> minStack = new Stack<Integer>();
        specialStack.push(stack, minStack, 16);
        System.out.println("The minimum element is: " + specialStack.getMin(minStack));
        specialStack.push(stack, minStack, 15);
        specialStack.push(stack, minStack, 29);
        System.out.println("The minimum element is: " + specialStack.getMin(minStack));
        specialStack.push(stack, minStack, 11);
        specialStack.push(stack, minStack, 19);
        specialStack.push(stack, minStack, 18);
        System.out.println("The minimum element is: " + specialStack.getMin(minStack));
        System.out.println("The popped element is: " + specialStack.pop(stack, minStack));
        System.out.println("The minimum element is: " + specialStack.getMin(minStack));
    }
}
