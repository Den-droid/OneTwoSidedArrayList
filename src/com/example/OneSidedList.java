package com.example;

public class OneSidedList {
    private class Node {
        private int data;
        private Node next;

        public int getData() {
            return data;
        }

        public void setData(int data) {
            this.data = data;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }

    private Node head;
    private Node tail;
    private int length;

    public OneSidedList() {
        head = tail = null;
        length = 0;
    }

    public Node getHead() {
        return head;
    }

    private void setHead(Node head) {
        this.head = head;
    }

    public Node getTail() {
        return tail;
    }

    private void setTail(Node tail) {
        this.tail = tail;
    }

    public int getLength() {
        return length;
    }

    private void setLength(int length) {
        this.length = length;
    }

    public void addFirst(int data) {
        Node node = new Node();
        node.setData(data);
        node.setNext(this.getHead());

        if (this.getLength() == 0) {
            this.setTail(node);
        }
        this.setHead(node);

        this.setLength(this.getLength() + 1);
    }

    public void addLast(int data) {
        Node node = new Node();
        node.setData(data);

        if (this.getTail() != null) {
            this.getTail().setNext(node);
        }

        if (length == 0) {
            this.setHead(node);
        }
        this.setTail(node);

        this.setLength(this.getLength() + 1);
    }

    public void insert(int data, int index) {
        if (index < 1 || index > this.getLength() + 1) {
            return;
        }
        if (index == 1) {
            this.addFirst(data);
            return;
        }
        if (index == this.getLength() + 1) {
            this.addLast(data);
            return;
        }
        Node node = new Node();
        node.setData(data);
        Node prevNode = new Node();
        Node loopNode = this.getHead();
        for (int i = 1; i < index; i++) {
            if (i == index - 1) {
                prevNode = loopNode;
            }
            loopNode = loopNode.getNext();
        }
        Node prevNodeAtIndex = prevNode.getNext();
        prevNode.setNext(node);
        node.setNext(prevNodeAtIndex);

        this.setLength(this.getLength() + 1);
    }

    public int deleteElement(int index) {
        if (index < 1 || index > this.getLength()) {
            return -1;
        }
        Node prevDeletedNode = this.getHead();
        int counter = 1;
        while (counter < index - 1) {
            prevDeletedNode = prevDeletedNode.getNext();
            counter++;
        }
        Node deletedNode;

        if (prevDeletedNode.equals(this.getHead()) && index == 1) {
            deletedNode = this.getHead();
            this.setHead(prevDeletedNode.getNext());
        } else {
            deletedNode = prevDeletedNode.getNext();
            prevDeletedNode.setNext(deletedNode.getNext());
        }
        this.setLength(this.getLength() - 1);
        return deletedNode.getData();
    }

    public int deleteFirst(){
        return deleteElement(1);
    }

    public int deleteLast(){
        return deleteElement(this.getLength());
    }

    public void replace(int newValue, int index) {
        Node replaceNode = this.getHead();
        for (int i = 1; i < this.getLength() + 1; i++) {
            if (i == index) {
                replaceNode.setData(newValue);
                break;
            }
            replaceNode = replaceNode.getNext();
        }
    }

    public int indexAt(int value) {
        Node valueNode = this.getHead();
        int index = 0;
        for (int i = 1; i < this.getLength() + 1; i++) {
            if (valueNode.getData() == value) {
                index = i;
                break;
            }
            valueNode = valueNode.getNext();
        }
        return index;
    }

    public int sum() {
        int sum = 0;
        Node node = this.getHead();
        for (int i = 1; i < this.getLength() + 1; i++) {
            sum += node.getData();
            node = node.getNext();
        }
        return sum;
    }

    public void show() {
        Node node = this.getHead();
        for (int i = 1; i < this.getLength() + 1; i++) {
            System.out.print(node.getData() + " ");
            node = node.getNext();
        }
        System.out.println();
    }
}