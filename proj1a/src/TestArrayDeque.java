import org.junit.Test;
import static org.junit.Assert.*;
public class TestArrayDeque {

    @Test
    public void testAddFirst() {
        ArrayDeque<Integer> lld = new ArrayDeque<>();
        lld.addFirst(1);
        lld.addFirst(0);
        assertEquals(false, lld.isEmpty());
    }

    @Test
    public void testAddLast() {
        ArrayDeque<Integer> lld = new ArrayDeque<>();
        lld.addLast(0);
        lld.addLast(1);
        assertEquals(false, lld.isEmpty());
    }

    @Test
    public void testRemoveFirst() {
        ArrayDeque<Integer> lld = new ArrayDeque<>();
        lld.addLast(0);
        lld.addLast(1);
        int expected = 0;
        int actual = lld.removeFirst();
        assertEquals(expected, actual);

        assertEquals(1, lld.size());
    }

    @Test
    public void testRemoveLast() {
        ArrayDeque<Integer> lld = new ArrayDeque<>();
        lld.addLast(0);
        lld.addLast(1);
        int expected = 1;
        int actual = lld.removeLast();
        assertEquals(expected, actual);

        assertEquals(1, lld.size());
    }

    @Test
    public void testIsEmpty() {
        ArrayDeque<Integer> lld = new ArrayDeque<>();
        assertTrue(lld.isEmpty());
    }

    @Test
    public void testSize() {
        ArrayDeque<Integer> lld = new ArrayDeque<>();
        lld.addLast(0);
        lld.addLast(1);
        lld.addLast(2);
        lld.addLast(3);
        lld.addLast(4);
        lld.addLast(4);
        lld.addLast(4);
        lld.addLast(4);
        lld.addLast(4);
        lld.addLast(4);
        lld.addLast(4);


        assertEquals(11, lld.size());

    }

    @Test
    public void testGet() {
        ArrayDeque<Integer> lld = new ArrayDeque<>();
        lld.addLast(0);
        lld.addLast(1);
        lld.addLast(2);
        lld.addLast(3);
        lld.addLast(4);

        assertEquals(4, (int) lld.get(4));

    }
}
