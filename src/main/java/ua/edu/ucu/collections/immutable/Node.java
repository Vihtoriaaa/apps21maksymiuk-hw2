package ua.edu.ucu.collections.immutable;

public class Node {
    private Node previous;
    private Node next;
    private Object value;

    public Node(Object value) {
        this.value = value;
    }

    public Node(Object val, Node prevValue, Node nextValue) {
        this.value = val;
        this.previous = prevValue;
        this.next = nextValue;
    }

    public Node getPrevious() {
        return previous;
    }

    public void setPrevious(Node setPrev) {
        this.previous = setPrev;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object setVal) {
        this.value = setVal;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node setNext) {
        this.next = setNext;
    }
}
