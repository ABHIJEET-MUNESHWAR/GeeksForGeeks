package com.geeksforgeeks.datastructures.queue.petrolpump;

/**
 * Created using IntelliJ IDEA.
 * User: Abhijeet
 * Date: 13/11/16
 * Time: 1:32 PM
 * http://www.geeksforgeeks.org/find-a-tour-that-visits-all-stations/
 */

import java.util.*;

class PetrolPump {

    java.util.Queue<Petrol> queue = new LinkedList<>();

    static class Petrol {
        int quantity;
        int distance;
        Petrol next;

        public Petrol(int q, int d) {
            this.quantity = q;
            this.distance = d;
        }
    }

    int findCircle() {
        int index = 1;
        int quantity = 0;
        Petrol firstPetrol = null;
        while (queue != null) {
            Petrol p = queue.poll();
            if (!queue.isEmpty()) {
                quantity = quantity + p.quantity;
                if (index == 1)
                    firstPetrol = queue.peek();
                if (quantity >= p.distance) {
                    quantity = quantity - p.distance;
                    continue;
                } else {
                    if (queue.peek() == firstPetrol && index != 1) {
                        return -1;
                    }
                    index++;
                    quantity = 0;
                    queue.add(p);
                }
            } else {
                break;
            }
        }

        return index;
    }

    public static void main(String a[]) {
        PetrolPump p = new PetrolPump();

        p.queue.add(new Petrol(4, 6));
        p.queue.add(new Petrol(6, 3));
        p.queue.add(new Petrol(2, 3));
        p.queue.add(new Petrol(4, 5));
        System.out.println(p.findCircle());
    }

}