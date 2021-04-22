/**
 * @author Aadithyaa Sridharbaskari
 * @param <T> Type that you pass into the list
 */
public class LinkedListDeque<T> {
    private class Node {
        private final T item;
        private Node prev;
        private Node next;

        Node(T item) {
            this.item = item;
        }
    }
    private final Node sentinel;
    private int size;

    /**
     * Constructor for the LinkedListDeque class
     * Initializes an empty sentinel node that points to itself on both sides
     */

    public LinkedListDeque() {
        sentinel = new Node(null);
        sentinel.prev = sentinel;
        sentinel.next = sentinel;

        size = 0;
    }

    /**
     * Checks whether LLD is empty
     * Happens only when sentinel.prev and sentinel.next point to sentinel
     */

    public boolean isEmpty() {
        boolean ret = false;
        boolean firstEqualsFront = sentinel.next.equals(sentinel);
        boolean lastEqualsFront = sentinel.prev.equals(sentinel);

        if (firstEqualsFront && lastEqualsFront) {
            ret = true;
        }
        return ret;
    }

    public void addFirst(T item) {
        Node first = new Node(item);
        if (isEmpty()) {
            first.next = null;
            first.prev = sentinel;
            sentinel.next = first;
            sentinel.prev = first;
        } else {
            Node second = sentinel.next;
            sentinel.next = first;
            first.prev = sentinel;
            first.next = second;
            second.prev = first;
        }
        size += 1;
    }

    public void addLast(T item) {
        Node last = new Node(item);
        if (isEmpty()) {
            last.next = null;
            last.prev = sentinel;
            sentinel.next = last;
            sentinel.prev = last;
        } else {
            Node secondToLast = sentinel.prev;
            sentinel.prev = last;
            secondToLast.next = last;
            last.prev = secondToLast;
            last.next = null;
        }
        size += 1;

    }

    public T removeFirst() {
        Node first = sentinel.next;
        if (isEmpty()) {
            return null;
        } else if (size == 1) {
            sentinel.next = sentinel;
            sentinel.prev = sentinel;
            first.prev = null;
        } else {
            Node second = first.next;
            sentinel.next = second;
            second.prev = sentinel;
            first.next = null;
            first.prev = null;
        }
        size -= 1;
        return first.item;
    }

    public T removeLast() {
        Node last = sentinel.prev;
        if (isEmpty()) {
            return null;
        } else if (size == 1) {
            return removeFirst();
        } else {
            Node newLast = last.prev;
            sentinel.prev = newLast;
            last.prev = null;
            last.next = null;
        }
        size -= 1;
        return last.item;
    }

    public int size() {
        return size;
    }

    public T get(int index) {
        Node scan = sentinel;
        for (int i = 0; i <= index; i++) {
            scan = scan.next;
        }
        return scan.item;
    }

    public T getRecursive(int index) {
        Node p = getRecursiveHelper(index);
        return p.item;
    }

    public void printDeque() {
        for (int i = 0; i < size; i++) {
            System.out.print(get(i) + " ");
        }
    }

    private Node getRecursiveHelper(int index) {
        if (index == 0) {
            return sentinel.next;
        } else {
            Node p = getRecursiveHelper(index - 1);
            return p.next;
        }
    }

}
