package ua.edu.ucu.collections;

import ua.edu.ucu.collections.immutable.ImmutableLinkedList;

public class Stack {
    private ImmutableLinkedList stackList;

    public Stack(Object[] objects) {
        Object[] swappedArray = new Object[objects.length];
        for (int i = objects.length - 1; i >= 0; i--) {
            swappedArray[objects.length - i - 1] = objects[i];
        }
        stackList = new ImmutableLinkedList(swappedArray);
    }

    public Object peek() {
        return stackList.getFirst();
    }

    public Object pop() {
        Object firstElement = stackList.getFirst();
        try {
            stackList = stackList.removeFirst();
        } catch (IndexOutOfBoundsException e) {
            return null;
        }
        return firstElement;
    }

    public void push(Object e) {
        stackList = stackList.addFirst(e);
    }
}
