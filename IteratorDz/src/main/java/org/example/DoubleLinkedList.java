package org.example;

public class DoubleLinkedList {
    Node head;
    Node tail;
    int size;

    DoubleLinkedList(){}

    DoubleLinkedList(int[] elements){
        for (int c: elements) {
            add(c);
        }
    }


    public void add(int elem) {
        Node elemToAdd = new Node(elem);
        size++;
        if(isEmpty()) {
            head = elemToAdd;
            tail = elemToAdd;
            return;
        }

        tail.next = elemToAdd;
        elemToAdd.previous = tail;
        tail = elemToAdd;
    }

    public void add(int index, int elem) {
        if (size < index || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        Node elemToAdd = new Node(elem);
        int cnt = 0;
        if (index == 0) {
            head.previous = elemToAdd;
            elemToAdd.next = head;
            head = elemToAdd;
        }
        else if (index == size){
            tail.next = elemToAdd;
            elemToAdd.previous = tail;
            tail = elemToAdd;
        }
        else {
            if (index < size / 2) {
                Node curr = head;
                while (cnt < index - 1) {
                    curr = curr.next;
                    cnt++;
                }
                curr.next.previous = elemToAdd;
                elemToAdd.next = curr.next;
                elemToAdd.previous = curr;
                curr.next = elemToAdd;
            } else {
                Node curr = tail;
                while (cnt < (size - index - 1)) {
                    curr = curr.previous;
                    cnt++;
                }
                curr.previous.next = elemToAdd;
                elemToAdd.next = curr;
                elemToAdd.previous = curr.previous;
                curr.previous = elemToAdd;

            }
        }
        size++;
    }

    public void clear() {
        head = null;
        tail = null;
    }

    public void remove(int index) {
        Node currElem;
        int cnt = 0;
        if (size < index || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        if (index == 0){
            currElem = head;
            currElem.next.previous = null;
            head = currElem.next;
            size--;
            return;
        }
        if (index == size - 1){
            currElem = tail;
            currElem.previous.next = null;
            tail = currElem.previous;
            size--;
            return;
        }
        if (size / 2 > index){
            currElem = head;
            while (cnt < index) {
                currElem = currElem.next;
                cnt++;
            }
            currElem.previous.next = currElem.next;
            currElem.next.previous = currElem.previous;
        }
        else {
            currElem = tail;
            while (cnt < (size - index-1)){
                currElem = currElem.previous;
                cnt++;
            }
            currElem.previous.next = currElem.next;
            currElem.next.previous = currElem.previous;
        }
        size--;
    }

    public int findByIndex(int index) {
        int cnt = 0;
        if (size < index) {
            throw new IndexOutOfBoundsException();
        }
        if (index < size / 2) {
            Node curr = head;
            while (cnt < index) {
                curr = curr.next;
                cnt++;
            }
            return curr.elem;
        }
        else {
            Node curr = tail;
            while (cnt < size - index - 1) {
                curr = curr.previous;
                cnt++;
            }
            return curr.elem;
        }
    }


    public boolean isEmpty() {
        return head == null;
    }

    public String toString() {
        if (isEmpty()) {
            return "";
        }
        Node curr = head;
        String toReturn = "";
        while (curr != null){
            if (curr.next == null) {

            }
            toReturn += curr.elem + " ";
            curr = curr.next;
        }
        return toReturn;
    }
}
