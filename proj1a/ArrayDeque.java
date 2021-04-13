public class ArrayDeque<T> {
    private T[] items;
    private int size;
    private int nextFront;
    private int nextBack;

    public ArrayDeque() {
        items = (T[]) new Object[8];
        size = 0;
        nextFront = items.length - 1;
        nextBack = 0;
    }

    public void addFirst(T item) {
        if (size == items.length) {
            resize(items.length * 2);
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
        if (size == items.length) {
            resize(items.length * 2);
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
        if (size == 0) {
            return null;
        }
        if (nextFront == items.length - 1) {
            nextFront = 0;
        } else {
            nextFront++;
        }
        T item = items[nextFront];
        items[nextFront] = null;
        size--;

        if (size >= 16 && (size - 1.0) / items.length < 0.25) {
            resize(items.length / 2);
        }

        return item;
    }

    public T removeLast() {
        if (size == 0) {
            return null;
        }

        if (nextBack == 0) {
            nextBack = items.length - 1;
        } else {
            nextBack--;
        }
        T item = items[nextBack];
        items[nextBack] = null;
        size--;

        if (size >= 16 && (size - 1.0) / items.length < 0.25) {
            resize(items.length / 2);
        }
        return item;
    }

    public T get(int index) {
        if (index < 0 || index > size - 1) {
            return null;
        }
        if (size == 0) {
            return null;
        }
        return items[(nextFront + 1 + index) % items.length];
    }

    public void printDeque() {
        for (int i = 0; i < size; i++) {
            System.out.print(get(i) + " ");
        }
    }

    private void resize(int newlen) {
        T[] newItems = (T[]) new Object[newlen];
        int i = (nextFront + 1) % items.length;
        int j = 0;
        while (j < size) {
            newItems[j] = items[i];
            i = (i + 1) % items.length;
            j++;
        }

        items = newItems;
        nextFront = items.length - 1;
        nextBack = size;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}