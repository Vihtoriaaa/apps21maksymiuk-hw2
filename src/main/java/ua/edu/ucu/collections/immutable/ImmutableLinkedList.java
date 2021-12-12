package ua.edu.ucu.collections.immutable;


public class ImmutableLinkedList implements ImmutableList {
    private Node first;
    private Node last;
    private int linkedListSize;

    public ImmutableLinkedList(Object[] objects) {
        linkedListSize = objects.length;
        if (objects.length == 0) {
            first = null;
            return;
        }
        first = new Node(objects[0]);
        Node current = first;
        int count = 0;
        for (Object obj: objects) {
            if (count == 0) {
                count++;
                continue;
            }
            Node newNode = new Node(obj, current, null);
            current.setNext(newNode);
            current = newNode;
            count++;
        }
        last = current;
    }

    public ImmutableLinkedList(Node firstNode, Node lastNode, int size) {
        if (firstNode == null) {
            this.first = null;
            this.last = null;
            this.linkedListSize = 0;
            return;
        }
        this.first = new Node(firstNode.getValue());
        Node oldCurrent = firstNode;
        Node newCurrent = this.first;
        while (oldCurrent.getNext() != null) {
            newCurrent.setNext(
                    new Node(oldCurrent.getNext().getValue()));
            newCurrent.getNext().setPrevious(newCurrent);
            newCurrent = newCurrent.getNext();
            oldCurrent = oldCurrent.getNext();
        }
        this.last = newCurrent;
        this.linkedListSize = size;
    }

    @Override
    public ImmutableList add(Object e) {
        return add(linkedListSize, e);
    }

    @Override
    public ImmutableList add(int index, Object e) {
        return addAll(index, new Object[] {e});
    }

    @Override
    public ImmutableList addAll(Object[] c) {
        return addAll(linkedListSize, c);
    }

    private boolean addElementsAtPositionIfNeeded(int counter, int index,
                                                  Node curr, Object[] e) {
        Node current = curr;
        if (counter == index) {
            Node newNode = new Node(e[0], current, null);
            Node continueNode;
            if (current.getNext() != null) {
                continueNode = new Node(current.getNext().getValue(),
                        null, current.getNext().getNext());
            } else {
                continueNode = null;
            }
            current.setNext(newNode);
            current = newNode;
            int innerCount = 0;
            for (Object elem: e) {
                if (innerCount == 0) {
                    innerCount++;
                    continue;
                }
                current.setNext(new Node(elem, current, null));
                current = current.getNext();
                innerCount++;
            }
            if (continueNode != null) {
                current.setNext(continueNode);
                continueNode.setPrevious(current);
            }
            return true;
        }
        return false;
    }

    @Override
    public ImmutableList addAll(int index, Object[] c) {
        if (index > linkedListSize) {
            throw new IndexOutOfBoundsException();
        }
        if (first == null) {
            return new ImmutableLinkedList(c);
        }
        ImmutableLinkedList newList = new ImmutableLinkedList(
                first, last, linkedListSize + c.length);
        Node current = newList.first;
        for (int counter = 0; counter < linkedListSize; counter++) {
            if (addElementsAtPositionIfNeeded(counter, index - 1, current, c)) {
                break;
            }
            if (counter != linkedListSize - 1) {
                current = current.getNext();
            }
        }
        if (addElementsAtPositionIfNeeded(linkedListSize, index, current, c)) {
            newList.last = current.getNext();
        }
        return newList;
    }

    @Override
    public Object get(int index) {
        if (index >= linkedListSize || isEmpty()) {
            throw new IndexOutOfBoundsException();
        }

        Node current = first;
        int counter = 0;
        while (current.getNext() != null) {
            if (counter == index) {
                break;
            }
            current = current.getNext();
            counter++;
        }
        return current.getValue();
    }

    @Override
    public ImmutableList remove(int index) {
        if (index >= linkedListSize || isEmpty()) {
            throw new IndexOutOfBoundsException();
        }
        ImmutableLinkedList newList = new ImmutableLinkedList(
                first, last, linkedListSize - 1);
        if (index == 0) {
            newList.first = newList.first.getNext();
            return newList;
        } else if (index == linkedListSize - 1) {
            newList.last = newList.last.getPrevious();
            newList.last.setNext(null);
            return newList;
        }
        int counter = 0;
        Node current = newList.first;
        while (current != null) {
            if (counter == index) {
                current.getPrevious().setNext(current.getNext());
                current.getNext().setPrevious(current.getPrevious());
                break;
            }
            current = current.getNext();
            counter++;
        }
        return newList;
    }

    @Override
    public ImmutableList set(int index, Object e) {
        if (index >= linkedListSize) {
            throw new IndexOutOfBoundsException();
        }
        ImmutableLinkedList newList = new ImmutableLinkedList(
                first, last, linkedListSize);
        Node current = newList.first;
        int counter = 0;
        while (current.getNext() != null) {
            if (counter == index) {
                current.setValue(e);
                break;
            }
            current = current.getNext();
            counter++;
        }
        return newList;
    }

    @Override
    public int indexOf(Object e) {
        Node current = first;
        int counter = 0;
        while (current.getNext() != null) {
            if (current.getValue().equals(e)) {
                return counter;
            }
            current = current.getNext();
            counter++;
        }
        return -1;
    }

    @Override
    public int size() {
        return linkedListSize;
    }

    @Override
    public ImmutableList clear() {
        return new ImmutableLinkedList(new Object[0]);
    }

    @Override
    public boolean isEmpty() {
        return linkedListSize == 0;
    }

    @Override
    public Object[] toArray() {
        Object[] objArray = new Object[linkedListSize];
        Node current = first;

        for (int counter = 0; counter < linkedListSize; counter++) {
            objArray[counter] = current.getValue();
            current = current.getNext();
        }
        return objArray;
    }

    public ImmutableLinkedList addFirst(Object e) {
        ImmutableLinkedList newList = new ImmutableLinkedList(
                first, last, linkedListSize + 1);

        Node newNode = new Node(e, null, newList.first);
        if (newList.first != null) {
            newList.first.setPrevious(newNode);
            newList.first = newNode;
        } else {
            newList.first = newNode;
            newList.last = newNode;
        }

        return newList;
    }

    public ImmutableLinkedList addLast(Object e) {
        ImmutableLinkedList newList = new ImmutableLinkedList(
                first, last, linkedListSize + 1);

        Node newNode = new Node(e, newList.last, null);
        if (newList.last != null) {
            newList.last.setNext(newNode);
            newList.last = newNode;
        } else {
            newList.first = newNode;
            newList.last = newNode;
        }

        return newList;
    }

    public Object getFirst() {
        if (first == null) {
            return null;
        }
        return first.getValue();
    }

    public Object getLast() {
        if (last == null) {
            return null;
        }
        return last.getValue();
    }

    public ImmutableLinkedList removeFirst() {
        return (ImmutableLinkedList) remove(0);
    }

    public ImmutableLinkedList removeLast() {
        return (ImmutableLinkedList) remove(linkedListSize - 1);
    }
}
