package ua.edu.ucu.collections.immutable;

import org.junit.Test;

import static org.junit.Assert.*;

public class ImmutableArrayListTest {
    private Integer[] data;

    @Test
    public void add() {
        data = new Integer[] {1, -2, 3, -4};
        ImmutableList actualArr1 = new ImmutableArrayList(data);
        ImmutableList actualArr2 = actualArr1.add(6);
        Integer[] expectedData = new Integer[] {1, -2, 3, -4, 6};
        assertArrayEquals(data, actualArr1.toArray());
        assertArrayEquals(expectedData, actualArr2.toArray());
    }

    @Test
    public void testAdd() {
        data = new Integer[] {1, -2, 3, -4};
        ImmutableList actualArr1 = new ImmutableArrayList(data);
        ImmutableList actualArr2 = actualArr1.add(1, 8);
        Integer[] expectedData = new Integer[] {1, 8, -2, 3, -4};
        assertArrayEquals(data, actualArr1.toArray());
        assertArrayEquals(expectedData, actualArr2.toArray());
    }

    @Test
    public void addAll() {
        data = new Integer[] {1, -2, 3, -4};
        ImmutableList actualArr1 = new ImmutableArrayList(data);
        ImmutableList actualArr2 = actualArr1.addAll(new Integer[] {5, -6, 7, -8});
        Integer[] expectedData = new Integer[] {1, -2, 3, -4, 5, -6, 7, -8};
        assertArrayEquals(data, actualArr1.toArray());
        assertArrayEquals(expectedData, actualArr2.toArray());
    }

    @Test
    public void testAddAll() {
        data = new Integer[] {1, -2, 3, -4};
        ImmutableList actualArr1 = new ImmutableArrayList(data);
        ImmutableList actualArr2 = actualArr1.addAll(1, new Integer[] {3, -5, 1, 5});
        Integer[] expectedData = new Integer[] {1, 3, -5, 1, 5, -2, 3, -4};
        assertArrayEquals(data, actualArr1.toArray());
        assertArrayEquals(expectedData, actualArr2.toArray());
    }

    @Test
    public void get() {
        data = new Integer[] {1, -2, 3, -45};
        ImmutableList actualArr = new ImmutableArrayList(data);
        assertEquals(3, actualArr.get(2));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testThrowErrorOnAdd() {
        ImmutableList actualArr = new ImmutableArrayList(new Integer[] {1, -2, 3, -4});
        actualArr.get(9);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testThrowErrorOnAddAll() {
        ImmutableList actualArr = new ImmutableArrayList(new Integer[] {1, -2, 3, -4});
        actualArr.addAll(10, new Integer[0]);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testThrowErrorOnRemove() {
        ImmutableList actualArr = new ImmutableArrayList(new Integer[] {1, -2, 3, -4});
        actualArr.remove(10);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testThrowErrorOnSet() {
        ImmutableList actualArr = new ImmutableArrayList(new Integer[] {1, -2, 3, -4});
        actualArr.set(10, 10);
    }

    @Test
    public void remove() {
        data = new Integer[] {1, -2, 3, -4};
        ImmutableList actualArr1 = new ImmutableArrayList(data);
        ImmutableList actualArr2 = actualArr1.remove(2);
        Integer[] expectedData = new Integer[] {1, -2, -4};
        assertArrayEquals(data, actualArr1.toArray());
        assertArrayEquals(expectedData, actualArr2.toArray());
    }

    @Test
    public void set() {
        data = new Integer[] {1, -2, 3, -4};
        ImmutableList actualArr1 = new ImmutableArrayList(data);
        ImmutableList actualArr2 = actualArr1.set(1, 7);
        Integer[] expectedData = new Integer[] {1, 7, 3, -4};
        assertArrayEquals(data, actualArr1.toArray());
        assertArrayEquals(expectedData, actualArr2.toArray());
    }

    @Test
    public void indexOf() {
        data = new Integer[] {3, -5, 1, 5};
        ImmutableList actualArr = new ImmutableArrayList(data);
        assertEquals(2, actualArr.indexOf(1));
        assertEquals(-1, actualArr.indexOf(10));
    }

    @Test
    public void size() {
        data = new Integer[] {1, -2, 3, -4};
        ImmutableList actualArr = new ImmutableArrayList(data);
        assertEquals(4, actualArr.size());
    }

    @Test
    public void clear() {
        data = new Integer[] {1, -2, 3, -4};
        ImmutableList actualArr1 = new ImmutableArrayList(data);
        ImmutableList actualArr2 = actualArr1.clear();
        Integer[] expectedData = new Integer[] {};
        assertArrayEquals(data, actualArr1.toArray());
        assertArrayEquals(expectedData, actualArr2.toArray());
    }

    @Test
    public void isEmpty() {
        data = new Integer[] {1, -2, 3, -4};
        ImmutableList actualArr1 = new ImmutableArrayList(data);
        ImmutableList actualArr2 = actualArr1.clear();
        assertFalse(actualArr1.isEmpty());
        assertTrue(actualArr2.isEmpty());
    }

    @Test
    public void toArray() {
        data = new Integer[] {1, -2, 3, -4};
        ImmutableList actualArr1 = new ImmutableArrayList(data);
        ImmutableList actualArr2 = actualArr1.clear();
        assertArrayEquals(data, actualArr1.toArray());
        assertArrayEquals(new Integer[0], actualArr2.toArray());
    }
}
