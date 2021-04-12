
public class ArrayDeque<T> {
    private T[] items;
    private int size;
    private int nextFront;
    private int nextBack;

    public ArrayDeque() {
        items = (T[]) new Object[8];
        size = 0;
        nextFront = 3;
        nextBack = 4;
    }

    public void addFirst(T item) {
        int arraySize = items.length;
        if (size == items.length) {
            resize();
        }
        items[nextFront] = item;

        if (nextFront == 0) {
            nextFront = items.length - 1;
        } else {
            nextFront--;
        }
        size++;
    }

    public void addLast(T item) {
        int arraySize = items.length;
        if (size == items.length) {
            resize();
        }
        items[nextBack] = item;

        if (nextBack == items.length - 1) {
            nextBack = 0;
        } else {
            nextBack++;
        }
        size++;
    }

    public T removeFirst() {
        if (nextFront == items.length - 1) {
            nextFront = 0;
        } else {
            nextFront++;
        }
        T item = items[nextFront];
        size--;
        return item;
    }

    public T removeLast() {
        if (nextBack == 0) {
            nextBack = items.length - 1;
        } else {
            nextBack--;
        }
        T item = items[nextBack];
        size--;
        return item;
    }

    public T get(int index) {
        return items[(nextFront + 1 + index) % items.length];
    }

    private void resize() {
        T[] newItems = (T[]) new Object[items.length * 2];

        int trueSize = items.length;

        int i = nextFront + 1 % trueSize;
        int j = 0;

        while (j < size) {
            newItems[j] = items[i];
            i = (i + 1) % trueSize;
        }
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}
