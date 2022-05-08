import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByOne {

    static CharacterComparator offByOne = new OffByOne();

    // Your tests go here.
    @Test
    public void testEqualChar() {
        assertTrue(offByOne.equalChars('a', 'b'));
        assertTrue(offByOne.equalChars('b', 'A'));
        assertTrue(offByOne.equalChars('&', '%'));
        assertFalse(offByOne.equalChars('c', 'e'));
    }
}
