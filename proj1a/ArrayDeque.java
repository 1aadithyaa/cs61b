public class ArrayDeque<T> {
    /**
     * INVARIANTS
     * front + 1 is the index of the first item of the list
     * back -1 is the index of the last item of the list
     */
    private T[] items;
    private int size;
    private int front;
    private int back;


    public ArrayDeque() {
        items = (T[]) new Object[8];
        size = 0;
        front = 0;
        back = 0;
    }

    private void resizeFront() {
        T[] temp = (T[]) new Object[size*2];
        System.arraycopy(items, 0, temp, size, size);
        front = size - 1;
    }

    private void resizeBack() {
        T[] temp = (T[]) new Object[size*2];
        System.arraycopy(items, 0, temp, 0, size);
        back = size;
    }
    public void addFirst(T item) {
        if(front == -1) {
            resizeFront();
        }
        items[front] = item;
        front -= 1;
        size += 1;

    }

    public void addLast(T item) {
        if(back == items.length-1) {
            resizeBack();
        }
        items[back] = item;
        back += 1;
        size += 1;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        for(int i = front + 1; i < size; i += 1) {
            System.out.print(get(i) + " ");
        }
    }

    public T removeFirst() {
        T ret = get(front + 1);
        items[front+1] = null;
        front += 1;
        size -= 1;
        return ret;
    }

    public T removeLast() {
        T ret = get(back - 1);
        items[back - 1] = null;
        back -= 1;
        size -= 1;
        return ret;

    }

    public T get(int index) {
        return items[front + 1 + index];
    }
}
