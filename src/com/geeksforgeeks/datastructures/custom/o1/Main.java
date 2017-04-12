package com.geeksforgeeks.datastructures.custom.o1;

/**
 * Created using IntelliJ IDEA
 * User: Abhijeet
 * Date: 12-04-2017
 * Time: 03:48 PM
 * http://www.geeksforgeeks.org/design-a-data-structure-that-supports-insert-delete-search-and-getrandom-in-constant-time/
 */
public class Main {
    public static void main(String[] args) {
        MyDS ds = new MyDS();
        ds.add(10);
        ds.add(20);
        ds.add(30);
        ds.add(40);
        System.out.println(ds.search(30));
        ds.remove(20);
        ds.add(50);
        System.out.println(ds.search(50));
        System.out.println(ds.getRandom());
    }
}
