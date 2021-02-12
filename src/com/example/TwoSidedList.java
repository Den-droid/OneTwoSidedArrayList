package com.example;

public class TwoSidedList implements IListsFunctionality{
    public class Node {
        private int data;
        private Node next;
        private Node previous;

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

        public Node getPrevious() {
            return previous;
        }

        public void setPrevious(Node previous) {
            this.previous = previous;
        }
    }

    private Node head;
    private Node tail;
    private int length;

    public TwoSidedList() {
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

    @Override
    public void addFirst(int data) {
        Node node = new Node();
        node.setData(data);
        node.setNext(this.getHead());

        if (this.getHead() != null) {
            this.getHead().setPrevious(node);
        }

        if (this.getLength() == 0) {
            this.setTail(node);
        }
        this.setHead(node);

        this.setLength(this.getLength() + 1);
    }

    @Override
    public void addLast(int data) {
        Node node = new Node();
        node.setData(data);
        node.setPrevious(this.getTail());

        if (this.getTail() != null) {
            this.getTail().setNext(node);
        }

        if (length == 0) {
            this.setHead(node);
        }
        this.setTail(node);

        this.setLength(this.getLength() + 1);
    }

    @Override
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
        Node prevNodeAtIndex = new Node();
        int middle = this.getLength() / 2;
        if (index <= middle) {
            Node loopNode = this.getHead();
            for (int i = 1; i < index; i++) {
                if (i == index - 1) {
                    prevNode = loopNode;
                }
                loopNode = loopNode.getNext();
            }
            prevNodeAtIndex = prevNode.getNext();
        } else {
            Node loopNode = this.getTail();
            for (int i = this.getLength(); i > index - 1; i--) {
                if (i == index) {
                    prevNodeAtIndex = loopNode;
                }
                loopNode = loopNode.getPrevious();
            }
            prevNode = prevNodeAtIndex.getPrevious();
        }
        prevNode.setNext(node);
        node.setPrevious(prevNode);
        node.setNext(prevNodeAtIndex);
        prevNodeAtIndex.setPrevious(node);

        this.setLength(this.getLength() + 1);
    }

    @Override
    public int deleteElement(int index) {
        if (index < 1 || index > this.getLength()) {
            return -1;
        }

        int middle = this.getLength() / 2;
        int counter;
        Node deletedNode;
        if (index <= middle) {
            deletedNode = this.getHead();
            counter = 1;
            while(counter < index){
                deletedNode = deletedNode.getNext();
                counter++;
            }
        } else {
            deletedNode = this.getTail();
            counter = this.getLength();
            while(counter > index){
                deletedNode = deletedNode.getPrevious();
                counter--;
            }
        }
        Node previousNode = deletedNode.getPrevious();
        Node nextNode = deletedNode.getNext();

        if(previousNode != null && index != 1){
            previousNode.setNext(nextNode);
        }
        if(nextNode != null && index != length){
            nextNode.setPrevious(previousNode);
        }

        if(index == 1){
            this.setHead(nextNode);
        }
        else if(index == this.getLength()){
            this.setTail(previousNode);
        }

        this.setLength(this.getLength() - 1);
        return deletedNode.getData();
    }

    @Override
    public int deleteFirst(){
        return deleteElement(1);
    }

    @Override
    public int deleteLast(){
        return deleteElement(this.getLength());
    }

    @Override
    public void replaceFirst(int newValue) {
        this.replace(newValue, 1);
    }

    @Override
    public void replaceLast(int newValue) {
        this.replace(newValue, this.getLength());
    }

    @Override
    public void replace(int newValue, int index) {
        Node replaceNode;
        int middle = this.getLength() / 2;
        if(index <= middle){
            replaceNode = this.getHead();
            for (int i = 1; i < index + 1; i++) {
                if (i == index) {
                    replaceNode.setData(newValue);
                    break;
                }
                replaceNode = replaceNode.getNext();
            }
        }
        else{
            replaceNode = this.getTail();
            for(int i = this.getLength(); i > index - 1; i--){
                if (i == index) {
                    replaceNode.setData(newValue);
                    break;
                }
                replaceNode = replaceNode.getPrevious();
            }
        }
    }

    @Override
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

    @Override
    public int sum() {
        int sum = 0;
        Node node = this.getHead();
        for (int i = 1; i < this.getLength() + 1; i++) {
            sum += node.getData();
            node = node.getNext();
        }
        return sum;
    }

    @Override
    public void show() {
        Node node = this.getHead();
        for (int i = 1; i < this.getLength() + 1; i++) {
            System.out.print(node.getData() + " ");
            node = node.getNext();
        }
        System.out.println();
    }
}