package com.dustinscharf.taskpyramid.util;

public class NavigationList<DataType> {
    private Node head;
    private Node tail;

    private Iterator iterator;

    private class Node {
        private Node previous;
        private DataType data;
        private Node next;

        public Node(Node previous, DataType data, Node next) {
            this.previous = previous;
            this.data = data;
            this.next = next;
        }
    }

    public class Iterator {
        private Node pointer;

        public DataType pointToFirst() {
            this.pointer = head;
            return this.pointer.data;
        }

        public DataType pointToLast() {
            this.pointer = tail;
            return this.pointer.data;
        }

        public boolean hasNext() {
            return this.pointer.next != null;
        }

        public boolean hasPrevious() {
            return this.pointer.previous != null;
        }

        public DataType getNext() {
            if (!this.hasNext()) {
                throw new NullPointerException("No next element in list");
            }

            return this.pointer.next.data;
        }

        public DataType getPrevious() {
            if (!this.hasPrevious()) {
                throw new NullPointerException("No previous element in list");
            }

            return this.pointer.previous.data;
        }

        public DataType goNext() {
            this.pointer = this.pointer.next;
            return this.pointer.data;
        }

        public DataType goPrevious() {
            this.pointer = this.pointer.previous;
            return this.pointer.data;
        }
    }

    public NavigationList() {
        this.head = null;
        this.tail = null;

        this.iterator = new Iterator();
    }

    public void appendAfterCurrentAndDropAfter(DataType data) {
        if (this.head == null) {
            this.head = new Node(null, data, null);
            this.tail = this.head;
            return;
        }

        this.tail = this.iterator.pointer;

        Node appendNode = new Node(this.tail, data, null);
        this.tail.next = appendNode;
        this.tail = appendNode;
    }

    public Iterator getInternIterator() {
        return this.iterator;
    }
}
