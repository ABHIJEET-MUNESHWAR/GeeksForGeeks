package com.geeksforgeeks.datastructures.hashing.printitinerary;

import java.util.HashMap;

/**
 * Created using IntelliJ IDEA.
 * User: abhijeet
 * Date: 11/12/16
 * Time: 2:26 PM
 * http://www.geeksforgeeks.org/find-itinerary-from-a-given-list-of-tickets/
 */

public class PrintItinerary {
    private void printItinerary(HashMap<String, String> dataSet) {
        String start = null;
        for (HashMap.Entry<String, String> entry : dataSet.entrySet()) {
            if (!dataSet.containsValue(entry.getKey())) {
                start = entry.getKey();
                break;
            }
        }
        if (start == null) {
            System.out.println("Invalid input");
        }
        String to = dataSet.get(start);
        while (to != null) {
            System.out.println(start + " -> " + to);
            start = to;
            to = dataSet.get(to);
        }
    }

    public static void main(String[] args) {
        HashMap<String, String> dataSet = new HashMap<>();
        dataSet.put("Chennai", "Banglore");
        dataSet.put("Bombay", "Delhi");
        dataSet.put("Goa", "Chennai");
        dataSet.put("Delhi", "Goa");
        PrintItinerary itinerary = new PrintItinerary();
        itinerary.printItinerary(dataSet);
    }
}
