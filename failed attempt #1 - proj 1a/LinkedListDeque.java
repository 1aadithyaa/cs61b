public class LinkedListDeque<T> {

    //Helper class that will hide the naked recursive data structure
    private class Node {
        private T item;
        private Node next;
        private Node prev;

        public Node(T item) {
            this.item = item;
        }

    }
    private final Node sentinel;
    private int size;



    /**
     * Add and remove operations CANNOT involve any looping or recursion
     * Must take constant time
     * Get operation must use iteration
     * Size must take constant time
     * Don't maintain references to items no longer in the deque
     */

    /**
     * INVARIANTS:
     * sentinel.next will always reference the first element of the LinkedListDeque
     * sentinel.prev will always reference the last element of the LinkedListDeque
     * size will always hold the number of non-sentinel items in the list
     */


    public LinkedListDeque() {
        sentinel = new Node();
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
        size = 0;
    }


    public void addFirst(T item) {
        sentinel.next = new Node();
        sentinel.next.item = item;
        sentinel.next.prev = sentinel;

        /**
         * If the first element added is the only element in the list, sentinel.prev now points to it
         * This keeps sentinel.prev pointing to the last item in the list
         */


        if(size == 0) {
            sentinel.prev = sentinel.next;
        }


        size += 1;

    }

    public void addLast(T item) {
        Node last = sentinel.prev;
        Node newLast = new Node();
        last.next = newLast;
        newLast.item = item;
        newLast.prev = last;

        sentinel.prev = newLast;
        size += 1;

    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        for(int i = 0; i < size; i++) {
            System.out.print(get(i) + " ");
        }
    }

    public T removeFirst() {
        Node first = sentinel.next;
        Node second = first.next;
        sentinel.next = second;
        second.prev = sentinel;

        size -= 1;

        return first.item;
    }

    public T removeLast() {
        Node last = sentinel.prev;
        Node secondToLast = last.prev;

        sentinel.prev = secondToLast;
        secondToLast.next = null;

        size -= 1;

        return last.item;
    }

    public T get(int index) {
        T ret;
        //If the item is in the back half of the list, you only need to search at most half the list
        //You can do this by starting from the last node, which sentinel.prev points to
        if(index > size/2) {
            Node p = sentinel.prev;
            int i = size - 1 - index;
            while(i > 0) {
                p = p.prev;
                i--;
            }
            ret = p.item;
        }

        else {
            Node p = sentinel.next;
            int i = 0;
            while(i < index) {
                p = p.next;
                i++;
            }
            ret = p.item;
        }
        return ret;
    }

    public T getRecursive(int index) {
        Node p = getRecursiveHelper(index);
        return p.item;
    }

    private Node getRecursiveHelper(int index) {
        if(index == 0) {
            return sentinel.next;
        }
        else {
            Node p = getRecursiveHelper(index-1);
            return p.next;
        }
    }

}
