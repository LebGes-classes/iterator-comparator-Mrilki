package org.example;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LLIterator implements Iterator {
    Node current;

    public LLIterator(DoubleLinkedList elem) {
        current = elem.head;
    }

    @Override
    public boolean hasNext() {
        return current != null;
    }

    @Override
    public Integer next() {
        if(!hasNext()) {
            throw new NoSuchElementException();
        }
        Node prev = current;
        int value = current.elem;
        current.previous = prev;
        current = current.next;

        return value;
    }

    @Override
    public void remove() {
        if (current.next != null){
            Node previous = current.previous;
            Node next = current.next;
            previous.next = next;
            next.previous = previous;
        }else {
            current.previous.next = null;

        }
    }
}
