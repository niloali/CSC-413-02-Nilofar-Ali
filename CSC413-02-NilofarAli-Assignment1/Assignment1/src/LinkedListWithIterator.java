//Nilofar M. Ali
//ID#: 920311584
//CSC 413-02 Spring 2024
//Assignment 1 part 1

import java.util.Iterator;

public class LinkedListWithIterator {
    public static void main(String[] args) {
        // Create an instance of MyLList
        MyLList<String> myList = new MyLList<>();

        // Add data to the list
        myList.add("Apple");
        myList.add("Banana");
        myList.add("Orange");
        myList.remove(1);
        // Get the array representation of the list
        Comparable[] array = myList.toArray();

        // Print the array
        System.out.println("Array representation of the list:");
        for (Comparable item : array) {
            System.out.println(item);
        }

        // Get and print the entry at a specified position
        int position = 2; // Get the entry at position 2
        Comparable entry = myList.getEntry(position);
        System.out.println("Entry at position " + position + ": " + entry);
    }
}
