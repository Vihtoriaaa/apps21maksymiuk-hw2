package ua.edu.ucu.collections;
import ua.edu.ucu.collections.immutable.ImmutableLinkedList;


public class Queue {
    private ImmutableLinkedList queue;

    public Queue(Object[] objects) {
        queue = new ImmutableLinkedList(objects);
    }

    public Object peek() {
        return queue.getFirst();
    }

    public Object dequeue() {
        Object firstElem = queue.getFirst();
        try {
            queue = queue.removeFirst();
        } catch (IndexOutOfBoundsException e) {
            return null;
        }
        return firstElem;
    }

    public void enqueue(Object e) {
        this.queue = queue.addLast(e);
    }
}
