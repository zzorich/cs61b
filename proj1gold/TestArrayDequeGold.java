import static org.junit.Assert.*;
import org.junit.Test;

import java.util.Deque;

public class TestArrayDequeGold {

    @Test
    public void testRemoveFirst() {
        ArrayDequeSolution<Integer> correct = new ArrayDequeSolution<>();
        StudentArrayDeque<Integer> student = new StudentArrayDeque<>();
        int random = StdRandom.uniform(100);
        correct.addFirst(random);
        student.addFirst(random);
        assertEquals(correct.removeFirst(), student.removeFirst());
    }

    @Test
    public void testRemoveLast() {
        ArrayDequeSolution<Integer> correct = new ArrayDequeSolution<>();
        StudentArrayDeque<Integer> student = new StudentArrayDeque<>();
        int random = StdRandom.uniform(100);
        correct.addLast(random);
        student.addLast(random);
        assertEquals(correct.removeLast(), student.removeLast());
    }

    @Test
    public void testAddFirst() {
        int[] testarray = StdRandom.permutation(100);
        ArrayDequeSolution<Integer> correct = new ArrayDequeSolution<>();
        StudentArrayDeque<Integer> student = new StudentArrayDeque<>();
        for (int x : testarray) {
            correct.addFirst(x);
            student.addFirst(x);
        }

        assertTrue(testEqualFirst(correct,student));

        for (int x : testarray) {
            correct.addFirst(x);
            student.addFirst(x);
        }

        assertTrue(testEqualLast(correct,student));
    }

    @Test
    public void testAddLast() {
        int[] testarray = StdRandom.permutation(100);
        ArrayDequeSolution<Integer> correct = new ArrayDequeSolution<>();
        StudentArrayDeque<Integer> student = new StudentArrayDeque<>();
        for (int x : testarray) {
            correct.addLast(x);
            student.addLast(x);
        }

        assertTrue(testEqualFirst(correct,student));

        for (int x : testarray) {
            correct.addLast(x);
            student.addLast(x);
        }

        assertTrue(testEqualLast(correct,student));
    }

    private boolean testEqualFirst(ArrayDequeSolution a, StudentArrayDeque b) {
        while (!(a.isEmpty() || b.isEmpty())) {
            Integer actual = (Integer) a.removeFirst();
            Integer student = (Integer) b.removeFirst();
            assertEquals("Oh noooo!\nThis is bad:\n  your number: " + student + ", should be: " + actual
            , actual, student);
        }
        return a.isEmpty() && b.isEmpty();
    }

    private boolean testEqualLast(ArrayDequeSolution a, StudentArrayDeque b) {
        while (!(a.isEmpty() || b.isEmpty())) {
            Integer actual = (Integer) a.removeLast();
            Integer student = (Integer) b.removeLast();
            assertEquals("Oh noooo!\nThis is bad:\n  your number: " + student + ", should be: " + actual
                    , actual, student);
        }
        return a.isEmpty() && b.isEmpty();
    }
}
