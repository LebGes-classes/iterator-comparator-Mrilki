package org.example;

public class Main {
    public static void main(String[] args) {
        DoubleLinkedList test = new DoubleLinkedList();

        test.add(3);
        test.add(4);
        test.add(5);

        LLIterator iterator = new LLIterator(test);

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}