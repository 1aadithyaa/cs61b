import static org.junit.Assert.*;
import org.junit.Test;

public class TestArrayDequeGold {
    @Test
    public void testDeque() {
        StudentArrayDeque<Integer> sad = new StudentArrayDeque<>();
        ArrayDequeSolution<Integer> ads = new ArrayDequeSolution<>();
        int i = 0;
        String output = "";
        while (true) {
            double numberBetweenZeroAndOne = StdRandom.uniform();
            output += "\n";
            if (numberBetweenZeroAndOne < 0.2) {
                sad.addLast(i);
                ads.addLast(i);
                output += "addLast(" + i + ")";
            } else if (numberBetweenZeroAndOne < 0.4) {
                sad.addFirst(i);
                ads.addFirst(i);
                output += "addFirst(" + i + ")";
            }
            else if (numberBetweenZeroAndOne < 0.6) {
                output += "removeFirst()";
                if (sad.removeFirst() != null && ads.removeFirst() != null) {
                    assertEquals(output, ads.removeFirst(), sad.removeFirst());
                }
                else {
                    continue;
                }
            }
            else if (numberBetweenZeroAndOne < 0.8) {
                output += "removeLast()";
                if (sad.removeLast() != null && ads.removeLast() != null) {
                    assertEquals(output, ads.removeLast(), sad.removeLast());
                }
                else {
                    continue;
                }
            }
            else {
                output += "removeFirst()";
                if (sad.removeFirst() != null && ads.removeFirst() != null) {
                    assertEquals(output, ads.removeFirst(), sad.removeFirst());
                }
                else {
                    continue;
                }
            }
            i += 1;
        }
    }
}
