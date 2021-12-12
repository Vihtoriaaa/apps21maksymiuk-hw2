package ua.edu.ucu.collections;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


public class StackTest {
    private Stack stack;
    private Stack emptyStack;

    @Before
    public void setUp() {
        Object[] data = {2, 4, 8, 6};
        stack = new Stack(data);
        emptyStack = new Stack(new Integer[0]);
    }

    @Test
    public void testPeek() {
        assertEquals(6, stack.peek());
    }

    @Test
    public void testPeekEmpty() {
        assertNull(emptyStack.peek());
    }

    @Test
    public void testPop() {
        assertEquals(6, stack.pop());
        assertEquals(8, stack.pop());
    }

    @Test
    public void testPopEmpty() {
        assertNull(emptyStack.pop());
    }

    @Test
    public void testPush() {
        stack.push(1);
        stack.push(4);
        assertEquals(4, stack.peek());
    }

    @Test
    public void testPushEmpty() {
        emptyStack.push(2);
        emptyStack.push(3);
        assertEquals(3, emptyStack.peek());
    }
}
