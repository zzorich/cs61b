import static org.junit.Assert.*;
import org.junit.Test;

import java.util.Deque;

public class TestArrayDequeGold {


    @Test
    public void testAddFirst() {
        int[] testarray = StdRandom.permutation(100);
        ArrayDequeSolution<Integer> correct = new ArrayDequeSolution<>();
        StudentArrayDeque<Integer> student = new StudentArrayDeque<>();
        String message = "";
        for (int x : testarray) {
            correct.addFirst(x);
            student.addFirst(x);
            message += "addFirst(" + x + ")\n";
        }
        while (!(student.isEmpty() || correct.isEmpty())) {
            Integer cr = correct.removeLast();
            Integer st = student.removeLast();
            message += "removeLast()\n";
            assertEquals(message, cr, st);
        }
    }


}
