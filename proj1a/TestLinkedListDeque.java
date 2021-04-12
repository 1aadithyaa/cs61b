import org.junit.Test;
import static org.junit.Assert.*;
public class TestLinkedListDeque {

    @Test
    public void testAddFirst() {
        LinkedListDeque<Integer> lld = new LinkedListDeque<>();
        lld.addFirst(1);
        lld.addFirst(0);
        assertEquals(false, lld.isEmpty());
    }

    @Test
    public void testAddLast() {
        LinkedListDeque<Integer> lld = new LinkedListDeque<>();
        lld.addLast(0);
        lld.addLast(1);
        assertEquals(false, lld.isEmpty());
    }

    @Test
    public void testRemoveFirst() {
        LinkedListDeque<Integer> lld = new LinkedListDeque<>();
        lld.addLast(0);
        lld.addLast(1);
        int expected = 0;
        int actual = lld.removeFirst();
        assertEquals(expected, actual);

        assertEquals(1, lld.size());
    }

    @Test
    public void testRemoveLast() {
        LinkedListDeque<Integer> lld = new LinkedListDeque<>();
        lld.addLast(0);
        lld.addLast(1);
        int expected = 1;
        int actual = lld.removeLast();
        assertEquals(expected, actual);

        assertEquals(1, lld.size());
    }

    @Test
    public void testIsEmpty() {
        LinkedListDeque<Integer> lld = new LinkedListDeque<>();
        assertTrue(lld.isEmpty());
    }

    @Test
    public void testSize() {
        LinkedListDeque<Integer> lld = new LinkedListDeque<>();
        lld.addLast(0);
        lld.addLast(1);
        lld.addLast(2);
        lld.addLast(3);
        lld.addLast(4);

        assertEquals(5, lld.size());

    }

    @Test
    public void testGet() {
        LinkedListDeque<Integer> lld = new LinkedListDeque<>();
        lld.addLast(0);
        lld.addLast(1);
        lld.addLast(2);
        lld.addLast(3);
        lld.addLast(4);

        assertEquals(4, (int) lld.get(4));

    }
}
