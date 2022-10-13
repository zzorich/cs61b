import edu.princeton.cs.algs4.Queue;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Assert.*;

public class TestSort {

    @Test
    public void TestMergeSort() {
        Queue<String> names = new Queue<>();
        Assert.assertTrue(MergeSort.mergeSort(names).isEmpty());
        Queue<String> namesOrigin = new Queue<>();
        names.enqueue("Alice");
        namesOrigin.enqueue("Alice");
        namesOrigin.enqueue("BOB");
        names.enqueue("ZDY");
        namesOrigin.enqueue("ZDY");
        names.enqueue("ZDY");
        namesOrigin.enqueue("ZDY");
        names.enqueue("ZLJ");
        namesOrigin.enqueue("ZLJ");
        names.enqueue("BOB");
        Queue<String> msorted = MergeSort.mergeSort(names);
        for (String name: msorted) {
            Assert.assertTrue(name.equals(namesOrigin.dequeue()));
        }
    }

    @Test
    public void TestQuickSort() {
        Queue<String> names = new Queue<>();
        Assert.assertTrue(QuickSort.quickSort(names).isEmpty());
        Queue<String> namesOrigin = new Queue<>();
        names.enqueue("Alice");
        namesOrigin.enqueue("Alice");
        namesOrigin.enqueue("BOB");
        names.enqueue("ZDY");
        namesOrigin.enqueue("ZDY");
        names.enqueue("ZDY");
        namesOrigin.enqueue("ZDY");
        names.enqueue("ZLJ");
        namesOrigin.enqueue("ZLJ");
        names.enqueue("BOB");
        Queue<String> qsorted = QuickSort.quickSort(names);
        for (String name: qsorted) {
            Assert.assertTrue(name.equals(namesOrigin.dequeue()));
        }
    }
}
