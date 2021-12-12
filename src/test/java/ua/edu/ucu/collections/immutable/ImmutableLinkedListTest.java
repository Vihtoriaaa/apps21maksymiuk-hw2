package ua.edu.ucu.collections.immutable;

import org.junit.Test;
import static org.junit.Assert.*;


public class ImmutableLinkedListTest {
    private Integer[] data;

    @Test
    public void add() {
        data = new Integer[] {1, -2, 3, -4};
        ImmutableList actualList1 = new ImmutableLinkedList(data);
        ImmutableList actualList2 = actualList1.add(7);
        Integer[] expectedData = new Integer[] {1, -2, 3, -4, 7};
        assertArrayEquals(data, actualList1.toArray());
        assertArrayEquals(expectedData, actualList2.toArray());
    }

    @Test
    public void testAdd() {
        data = new Integer[] {1, -2, 3, -4};
        ImmutableList actualList1 = new ImmutableLinkedList(data);
        ImmutableList actualList2 = actualList1.add(2, 7);
        Integer[] expectedData = new Integer[] {1, -2, 7, 3, -4};
        assertArrayEquals(data, actualList1.toArray());
        assertArrayEquals(expectedData, actualList2.toArray());
    }

    @Test
    public void addAll() {
        data = new Integer[] {1, -2, 3, -4};
        ImmutableList actualList1 = new ImmutableLinkedList(data);
        ImmutableList actualList2 = actualList1.addAll(new Integer[] {1, -2, 3, -4});
        Integer[] expectedData = new Integer[] {1, -2, 3, -4, 1, -2, 3, -4};
        assertArrayEquals(data, actualList1.toArray());
        assertArrayEquals(expectedData, actualList2.toArray());
    }

    @Test
    public void testAddAll() {
        data = new Integer[] {3, -5, 1, 5};
        ImmutableList actualList1 = new ImmutableLinkedList(data);
        ImmutableList emptyList = new ImmutableLinkedList(new Integer[0]);
        ImmutableList actualList2 = actualList1.addAll(1, new Integer[] {3, -5, 1, 5});
        ImmutableList filledList = emptyList.addAll(0, new Integer[] {3, -5, 1, 5});
        Integer[] expectedData = new Integer[] {3, 3, -5, 1, 5, -5, 1, 5};
        assertArrayEquals(data, actualList1.toArray());
        assertArrayEquals(expectedData, actualList2.toArray());
        assertArrayEquals(data, filledList.toArray());
    }

    @Test
    public void testGet() {
        data = new Integer[] {1, -2, 3, -4};
        ImmutableList actualArr = new ImmutableLinkedList(data);
        ImmutableLinkedList emptyArr = new ImmutableLinkedList(new Integer[0]);
        assertEquals(-2, actualArr.get(1));
        assertNull(emptyArr.getFirst());
        assertNull(emptyArr.getLast());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testThrowErrorOnAdd() {
        ImmutableList actualArr = new ImmutableLinkedList(new Integer[] {1, -2, 3, -4});
        actualArr.get(10);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testThrowErrorOnAddAll() {
        ImmutableList actualArr = new ImmutableLinkedList(new Integer[] {1, -2, 3, -4});
        actualArr.addAll(10, new Integer[0]);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testThrowErrorOnRemove() {
        ImmutableList actualArr = new ImmutableLinkedList(new Integer[] {1, -2, 3, -4});
        actualArr.remove(10);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testThrowErrorOnSet() {
        ImmutableList actualArr = new ImmutableLinkedList(new Integer[] {1, -2, 3, -4});
        actualArr.set(10, 10);
    }

    @Test
    public void remove() {
        data = new Integer[] {1, -2, 3, -4};
        ImmutableList actualList1 = new ImmutableLinkedList(data);
        ImmutableList actualList2 = actualList1.remove(2);
        Integer[] expectedData = new Integer[] {1, -2, -4};
        assertArrayEquals(data, actualList1.toArray());
        assertArrayEquals(expectedData, actualList2.toArray());
    }

    @Test
    public void set() {
        data = new Integer[] {1, -2, 3, -4};
        ImmutableList actualList1 = new ImmutableLinkedList(data);
        ImmutableList actualList2 = actualList1.set(1, 0);
        Integer[] expectedData = new Integer[] {1, 0, 3, -4};
        assertArrayEquals(data, actualList1.toArray());
        assertArrayEquals(expectedData, actualList2.toArray());
    }

    @Test
    public void indexOf() {
        data = new Integer[] {3, -5, 1, 5};
        ImmutableList actualArr = new ImmutableLinkedList(data);
        assertEquals(2, actualArr.indexOf(1));
        assertEquals(-1, actualArr.indexOf(10));
    }

    @Test
    public void size() {
        data = new Integer[] {3, -5, 1, 5};
        ImmutableList actualArr = new ImmutableLinkedList(data);
        assertEquals(4, actualArr.size());
    }

    @Test
    public void clear() {
        data = new Integer[] {3, -5, 1, 5};
        ImmutableList actualList1 = new ImmutableLinkedList(data);
        ImmutableList actualList2 = actualList1.clear();
        Integer[] expectedData = new Integer[] {};
        assertArrayEquals(data, actualList1.toArray());
        assertArrayEquals(expectedData, actualList2.toArray());
    }

    @Test
    public void isEmpty() {
        data = new Integer[] {1, -2, 3, -4};
        ImmutableList actualList1 = new ImmutableLinkedList(data);
        ImmutableList actualList2 = actualList1.clear();
        assertFalse(actualList1.isEmpty());
        assertTrue(actualList2.isEmpty());
    }

    @Test
    public void toArray() {
        data = new Integer[] {1, -2, 3, -4};
        ImmutableList actualList1 = new ImmutableLinkedList(data);
        ImmutableList actualList2 = actualList1.clear();
        assertArrayEquals(data, actualList1.toArray());
        assertArrayEquals(new Integer[0], actualList2.toArray());
    }

    @Test
    public void testAddFirst() {
        data = new Integer[] {1, -2, 3, -4};
        ImmutableLinkedList actualList1 = new ImmutableLinkedList(data);
        ImmutableLinkedList emptyList = new ImmutableLinkedList(new Integer[0]);
        ImmutableLinkedList emptyList2 = emptyList.addFirst(10);
        ImmutableLinkedList actualList2 = actualList1.addFirst(10);
        ImmutableLinkedList actualList3 = actualList2.removeFirst();
        Integer[] expectedData = new Integer[] {10, 1, -2, 3, -4};
        assertArrayEquals(data, actualList1.toArray());
        assertArrayEquals(expectedData, actualList2.toArray());
        assertEquals(10, actualList2.getFirst());
        assertEquals(10, emptyList2.getFirst());
        assertArrayEquals(data, actualList3.toArray());
    }

    @Test
    public void testAddLast() {
        data = new Integer[] {1, -2, 3, -4};
        ImmutableLinkedList actualList1 = new ImmutableLinkedList(data);
        ImmutableLinkedList actualList2 = actualList1.addLast(8);
        ImmutableLinkedList actualList3 = actualList2.removeLast();
        Integer[] expectedData = new Integer[] {1, -2, 3, -4, 8};
        assertArrayEquals(data, actualList1.toArray());
        assertArrayEquals(expectedData, actualList2.toArray());
        assertEquals(8, actualList2.getLast());
        assertArrayEquals(data, actualList3.toArray());
    }
}
