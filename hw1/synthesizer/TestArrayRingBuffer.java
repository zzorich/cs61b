package synthesizer;
import org.junit.Test;
import static org.junit.Assert.*;

/** Tests the ArrayRingBuffer class.
 *  @author Josh Hug
 */

public class TestArrayRingBuffer {
    @Test
    public void someTest() {
        ArrayRingBuffer<Integer> arb = new ArrayRingBuffer<>(10);
        assertTrue(arb.isEmpty());
        for (int i = 0; i < 10; i++) {
            arb.enqueue(i);
            assertEquals(arb.fillCount(), i + 1);
        }

        assertTrue(arb.isFull());
        for (int j = 0; j < 10; j++) {
            assertEquals(j, (int) arb.dequeue());
        }
        assertTrue(arb.isEmpty());
    }

    /** Calls tests for ArrayRingBuffer. */
    public static void main(String[] args) {
        jh61b.junit.textui.runClasses(TestArrayRingBuffer.class);
    }
} 
