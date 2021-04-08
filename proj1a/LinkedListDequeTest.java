

import org.junit.Test;
import static org.junit.Assert.*;


/** Performs some basic linked list tests. */
public class LinkedListDequeTest {

	@Test
	public void testIsEmpty() {
		LinkedListDeque<Integer> lld = new LinkedListDeque<>();
		boolean actual = lld.isEmpty();
		boolean expected = true;
		assertEquals(expected, actual);
	}

	@Test
	public void testSize() {
		LinkedListDeque<Integer> lld = new LinkedListDeque<>();
		lld.addLast(0);
		lld.addLast(1);
		lld.addLast(2);
		lld.addLast(3);
		lld.addLast(4);

		int actual = lld.size();
		int expected = 5;
		assertEquals(expected, actual);
	}


	@Test
	public void testAddFirst() {
		LinkedListDeque<Integer> lld = new LinkedListDeque<>();
		lld.addFirst(10);
		assertFalse(lld.isEmpty());
	}

	@Test
	public void testAddLast() {
		LinkedListDeque<Integer> lld = new LinkedListDeque<>();
		lld.addLast(0);
		assertFalse(lld.isEmpty());
	}

	@Test
	public void testRemoveLast() {
		LinkedListDeque<Integer> lld = new LinkedListDeque<>();
		lld.addLast(0);
		int actual = lld.removeLast();
		int expected = 0;
		assertEquals(expected, actual);

		actual = lld.size();
		expected = 0;
		assertEquals(expected, actual);


	}

	@Test
	public void testGet() {
		LinkedListDeque<Integer> lld = new LinkedListDeque<>();
		lld.addLast(0);
		lld.addLast(1);
		lld.addLast(2);
		lld.addLast(3);
		assertEquals(2, (int) lld.get(2));

	}
	@Test
	public void testGetRecursive() {
		LinkedListDeque<Integer> lld = new LinkedListDeque<>();
		lld.addLast(0);
		lld.addLast(1);
		lld.addLast(2);
		lld.addLast(3);
		assertEquals(2, (int) lld.getRecursive(2));
	}

} 