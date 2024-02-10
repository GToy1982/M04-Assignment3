import java.util.Objects;

// MyList interface definition
interface MyList<E> {
    void add(E e);
    boolean remove(E e);
    E get(int index);
    boolean contains(E e);
    int size();
    // Other methods...
}

public class TwoWayLinkedList<E> implements MyList<E> {
    private Node<E> head, tail;
    private int size = 0;

    public TwoWayLinkedList() {
    }

    public TwoWayLinkedList(E[] objects) {
        for (E object : objects) {
            add(object);
        }
    }

    @Override
    public void add(E e) {
        Node<E> newNode = new Node<>(e);
        if (tail == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.previous = tail;
            tail = newNode;
        }
        size++;
    }

    @Override
    public boolean remove(E e) {
        if (size == 0) {
            return false;
        }

        Node<E> current = head;
        while (current != null) {
            if (Objects.equals(current.element, e)) {
                if (current == head) {
                    return removeFirst();
                } else if (current == tail) {
                    return removeLast();
                } else {
                    current.previous.next = current.next;
                    current.next.previous = current.previous;
                    size--;
                    return true;
                }
            }
            current = current.next;
        }
        return false;
    }

    @Override
    public E get(int index) {
        if (index < 0 || index >= size) {
            return null;
        }

        Node<E> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.element;
    }

    @Override
    public boolean contains(E e) {
        Node<E> current = head;
        while (current != null) {
            if (Objects.equals(current.element, e)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("[");
        Node<E> current = head;
        for (int i = 0; i < size; i++) {
            result.append(current.element);
            current = current.next;
            if (current != null) {
                result.append(", ");
            } else {
                result.append("]");
            }
        }
        return result.toString();
    }

    private boolean removeFirst() {
        if (size == 0) {
            return false;
        }
        head = head.next;
        if (head != null) {
            head.previous = null;
        } else {
            tail = null;
        }
        size--;
        return true;
    }

    private boolean removeLast() {
        if (size == 0) {
            return false;
        }
        if (size == 1) {
            head = tail = null;
        } else {
            tail = tail.previous;
            tail.next = null;
        }
        size--;
        return true;
    }

    private static class Node<E> {
        E element;
        Node<E> next;
        Node<E> previous;

        public Node(E e) {
            element = e;
        }
    }

    // Inner class for ListIterator...
}
