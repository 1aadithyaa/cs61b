import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByOne {
    static CharacterComparator offByOne = new OffByOne();

    @Test
    public void testEqualChars() {
        char x = 'a';
        char y = 'b';
        assertTrue(offByOne.equalChars(x, y));
        y = 'c';
        assertFalse(offByOne.equalChars(x, y));
        assertTrue(offByOne.equalChars('&', '%'));
    }

}
