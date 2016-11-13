package com.geeksforgeeks.datastructures.stack.introduction;

/**
 * Created by Abhijeet on 20/10/16.
 * http://quiz.geeksforgeeks.org/stack-set-1/
 */
import java.util.*;
public class Introduction {
    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.push("One");
        stack.push("Two");
        stack.push("Three");
        System.out.println("Elements in stack:" + stack);
        System.out.println("The top element is: " + stack.peek());
        System.out.println("The popped element is: " + stack.pop());
        System.out.println("Elements in stack:" + stack);
    }
}
