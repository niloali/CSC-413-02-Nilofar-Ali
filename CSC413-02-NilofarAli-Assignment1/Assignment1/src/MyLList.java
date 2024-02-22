//Nilofar M. Ali
//ID#: 920311584
//CSC 413-02 Spring 2024
//Assignment 1 part 1

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyLList<E extends Comparable<E>> implements ListInterface<E> {
    // Inner class Node representing each element in the linked list
    private class Node {
        private E data;
        private Node next;

        public Node(E dataPortion) {
            this(dataPortion, null);
        }

        public Node(E dataPortion, Node nextNode) {
            data = dataPortion;
            next = nextNode;
        }
    }

    private Node head; // Reference to the first node in the list
    private int size; // Current size of the list

    // Constructor
    public MyLList() {
        head = null;
        size = 0;
    }

    // Method to add a new entry to the end of the list
    public void add(E newEntry) {
        Node newNode = new Node(newEntry);

        if (isEmpty()) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
    }

    // Method to add a new entry at a specified position
    public boolean add(int newPosition, E newEntry) {
        if (newPosition < 1 || newPosition > size + 1) {
            return false;
        }

        Node newNode = new Node(newEntry);
        if (newPosition == 1) {
            newNode.next = head;
            head = newNode;
        } else {
            Node previous = getNodeAt(newPosition - 1);
            newNode.next = previous.next;
            previous.next = newNode;
        }
        size++;
        return true;
    }

    // Method to remove an entry at a specified position
    public Comparable<E> remove(int givenPosition) {
        Comparable<E> result = null;
        if (givenPosition >= 1 && givenPosition <= size) {
            if (givenPosition == 1) {
                result = head.data;
                head = head.next;
            } else {
                Node previous = getNodeAt(givenPosition - 1);
                Node current = previous.next;
                result = current.data;
                previous.next = current.next;
            }
            size--;
        }
        return result;
    }

    // Method to remove all entries from the list
    public void clear() {
        head = null;
        size = 0;
    }

    // Method to replace the entry at a specified position with a new entry
    public E replace(int givenPosition, E newEntry) {
        if (givenPosition < 1 || givenPosition > size) {
            throw new IndexOutOfBoundsException("Illegal position given to replace operation.");
        }

        Node currentNode = getNodeAt(givenPosition);
        E originalEntry = currentNode.data;
        currentNode.data = newEntry;
        return originalEntry;
    }

    // Method to retrieve the entry at a specified position
    public Comparable<E> getEntry(int givenPosition) {
        if (givenPosition < 1 || givenPosition > size) {
            throw new IndexOutOfBoundsException("Illegal position given to getEntry operation.");
        }

        return getNodeAt(givenPosition).data;
    }

    // Method to retrieve all entries as an array
    public Comparable<E>[] toArray() {
        Comparable<E>[] result = (Comparable<E>[]) new Comparable[size];
        int index = 0;
        Node current = head;
        while (current != null) {
            result[index] = current.data;
            current = current.next;
            index++;
        }
        return result;
    }

    // Method to check if the list contains a given entry
    public boolean contains(E anEntry) {
        Node current = head;
        while (current != null) {
            if (current.data.equals(anEntry)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    // Method to get the length of the list
    public int getLength() {
        return size;
    }

    // Method to check if the list is empty
    public boolean isEmpty() {
        return size == 0;
    }

    // Method to get the node at a specified position
    private Node getNodeAt(int givenPosition) {
        if (givenPosition < 1 || givenPosition > size) {
            throw new IndexOutOfBoundsException("Illegal position given to getNodeAt operation.");
        }

        Node current = head;
        for (int i = 1; i < givenPosition; i++) {
            current = current.next;
        }
        return current;
    }

    // Implementing Iterator interface within MyLList
    private class LinkedListIterator implements Iterator<E> {
        private Node current;

        public LinkedListIterator() {
            current = head;
        }

        public boolean hasNext() {
            return current != null;
        }

        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            E data = current.data;
            current = current.next;
            return data;
        }
    }

    // Method to get an iterator for this list
    public Iterator<E> getIterator() {
        return new LinkedListIterator();
    }
}