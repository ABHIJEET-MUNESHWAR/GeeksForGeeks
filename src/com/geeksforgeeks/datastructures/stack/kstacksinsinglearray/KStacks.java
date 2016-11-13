package com.geeksforgeeks.datastructures.stack.kstacksinsinglearray;

/**
 * Created using IntelliJ IDEA.
 * User: Abhijeet
 * Date: 23/10/16
 * Time: 10:48 PM
 * http://www.geeksforgeeks.org/efficiently-implement-k-stacks-single-array/
 * http://code.geeksforgeeks.org/WZ6Aqz
 */
public class KStacks {
    int k, n, free;
    int[] top;
    int[] next;
    int[] arr;

    KStacks(int k, int n) {
        this.k = k;
        this.n = n;
        top = new int[k];
        next = new int[n];
        arr = new int[n];
        for (int i = 0; i < k; i++) {
            top[i] = -1;
        }
        for (int i = 0; i < n - 1; i++) {
            next[i] = i + 1;
        }
        next[n - 1] = -1;
        free = 0;
    }

    private void push(int data, int kn) {
        if (isFull()) {
            System.out.println("Stack overflow");
            return;
        }
        int i = free;
        free = next[i];
        next[i] = top[kn];
        top[kn] = i;
        arr[i] = data;
    }

    private int pop(int kn) {
        if (isEmpty(kn)) {
            System.out.println("Stack underflow");
            return Integer.MAX_VALUE;
        }
        int i = top[kn];
        top[kn] = next[i];
        next[i] = free;
        free = i;
        return arr[i];
    }

    private boolean isFull() {
        return free == -1;
    }

    private boolean isEmpty(int kn) {
        return top[kn] == -1;
    }

    public static void main(String[] args) {
        int k = 3, n = 10;
        KStacks ks = new KStacks(k, n);
        // Let us put some items in stack number 2
        ks.push(15, 2);
        ks.push(45, 2);

        // Let us put some items in stack number 1
        ks.push(17, 1);
        ks.push(49, 1);
        ks.push(39, 1);

        // Let us put some items in stack number 0
        ks.push(11, 0);
        ks.push(9, 0);
        ks.push(7, 0);

        System.out.println("Popped element from stack 2 is " + ks.pop(2));
        System.out.println("Popped element from stack 1 is " + ks.pop(1));
        System.out.println("Popped element from stack 0 is " + ks.pop(0));
    }
}
