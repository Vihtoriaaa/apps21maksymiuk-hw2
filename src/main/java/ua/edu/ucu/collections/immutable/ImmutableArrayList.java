package ua.edu.ucu.collections.immutable;


public class ImmutableArrayList implements ImmutableList {
    private Object[] elementArray;

    public ImmutableArrayList(Object[] objects) {
        Object[] newObjectsArray = new Object[objects.length];
        int counter = 0;
        for (Object elem: objects) {
            newObjectsArray[counter] = elem;
            counter++;
        }
        this.elementArray = newObjectsArray;
    }

    @Override
    public ImmutableList add(Object e) {
        return add(elementArray.length, e);
    }

    @Override
    public ImmutableList add(int index, Object e) {
        return addAll(index, new Object[] {e});
    }

    @Override
    public ImmutableList addAll(Object[] c) {
        return addAll(elementArray.length, c);
    }

    private int addElementsAtPositionIfNeeded(
            int counter, int index, Object[] newObjectsArray, Object[] c) {
        int ind = counter;
        if (ind == index) {
            for (Object elem: c) {
                newObjectsArray[ind] = elem;
                ind++;
            }
        }
        return ind;
    }

    @Override
    public ImmutableList addAll(int index, Object[] c) {
        if (index > elementArray.length) {
            throw new IndexOutOfBoundsException();
        }
        Object[] newObjectsArray = new Object[elementArray.length + c.length];
        int counter = 0;
        for (Object elem: elementArray) {
            counter = addElementsAtPositionIfNeeded(
                    counter, index, newObjectsArray, c);
            newObjectsArray[counter] = elem;
            counter++;
        }
        addElementsAtPositionIfNeeded(counter, index, newObjectsArray, c);
        return new ImmutableArrayList(newObjectsArray);
    }

    @Override
    public Object get(int index) {
        if (index >= elementArray.length) {
            throw new IndexOutOfBoundsException();
        }
        return elementArray[index];
    }

    @Override
    public ImmutableList remove(int index) {
        if (index > elementArray.length) {
            throw new IndexOutOfBoundsException();
        }
        Object[] newObjectsArray = new Object[elementArray.length - 1];
        int counter = 0, newIndex = 0;
        for (Object elem: elementArray) {
            if (counter == index) {
                counter++;
                continue;
            }
            newObjectsArray[newIndex] = elem;
            counter++;
            newIndex++;
        }
        return new ImmutableArrayList(newObjectsArray);
    }

    @Override
    public ImmutableList set(int index, Object e) {
        if (index > elementArray.length) {
            throw new IndexOutOfBoundsException();
        }
        Object[] newObjectsArray = new Object[elementArray.length];
        int counter = 0;
        for (Object elem: elementArray) {
            if (counter == index) {
                newObjectsArray[counter] = e;
                counter++;
                continue;
            }
            newObjectsArray[counter] = elem;
            counter++;
        }
        return new ImmutableArrayList(newObjectsArray);
    }

    @Override
    public int indexOf(Object e) {
        int counter = 0;
        for (Object elem: elementArray) {
            if (elem.equals(e)) {
                return counter;
            }
            counter++;
        }
        return -1;
    }

    @Override
    public int size() {
        return elementArray.length;
    }

    @Override
    public ImmutableList clear() {
        return new ImmutableArrayList(new Object[0]);
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public Object[] toArray() {
        Object[] newObjectsArray = new Object[elementArray.length];
        int counter = 0;
        for (Object elem: elementArray) {
            newObjectsArray[counter] = elem;
            counter++;
        }
        return newObjectsArray;
    }
}
