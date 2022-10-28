import org.junit.Test;

public class RadixSortTester {
    @Test
    public void RadixSortSortTest() {
        String[] test2 = new String[]{"22>ýNÈË", "Ñó;r["};
        test2 = RadixSort.sort(test2);
        for (String string: test2) {
            System.out.println(string);
        }
    }
}
