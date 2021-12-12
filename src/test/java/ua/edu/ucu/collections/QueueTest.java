package ua.edu.ucu.collections;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class QueueTest {
    Queue queue, emptyQueue;

    @Before
    public void setUp() {
        Object[] array = {2, 4, 8, 6};
        queue = new Queue(array);
        emptyQueue = new Queue(new Integer[0]);
    }

    @Test
    public void testPeek() {
        assertEquals(2, queue.peek());
    }

    @Test
    public void testPeekEmpty() {
        assertNull(emptyQueue.peek());
    }

    @Test
    public void testDequeue() {
        assertEquals(2, queue.dequeue());
        assertEquals(4, queue.dequeue());
    }

    @Test
    public void testDequeueEmpty() {
        assertNull(emptyQueue.dequeue());
    }

    @Test
    public void testEnqueue() {
        assertEquals(2, queue.peek());
    }

    @Test
    public void testEnqueueEmpty() {
        emptyQueue.enqueue(2);
        emptyQueue.enqueue(3);
        assertEquals(2, emptyQueue.peek());
    }
}
