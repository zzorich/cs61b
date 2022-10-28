/**
 * Class for doing Radix sort
 *
 * @author Akhil Batra, Alexander Hwang
 *
 */
public class RadixSort {
    /**
     * Does LSD radix sort on the passed in array with the following restrictions:
     * The array can only have ASCII Strings (sequence of 1 byte characters)
     * The sorting is stable and non-destructive
     * The Strings can be variable length (all Strings are not constrained to 1 length)
     *
     * @param asciis String[] that needs to be sorted
     *
     * @return String[] the sorted array
     */
    public static String[] sort(String[] asciis) {
        // TODO: Implement LSD Sort
        if (asciis.length == 0) {
            return asciis;
        }
        int max = -1;
        for (String string: asciis) {
            max = Math.max(string.length(), max);
        }
        for (int j = max - 1; j >= 0; j--) {
            asciis = stableSort(asciis, j, max);
        }

        return asciis;
    }
    private static String[] stableSort(String[] asciis, int index, int max) {
        int[] counts = new int[257];
        for (String string: asciis) {
            int val = charAt(string, index);
            counts[val] += 1;
        }

        int pos = 0;
        int[] start = new int[257];
        for (int i = 0; i < 257; i++) {
            start[i] = pos;
            pos += counts[i];
        }

        String[] sorted = new String[asciis.length];
        for (String string: asciis) {
            int val = charAt(string, index);
            sorted[start[val]] = string;
            start[val] += 1;
        }

        return sorted;
    }

    private static int charAt(String string, int index) {
        if (index < string.length()) {
            return string.charAt(index) + 1;
        } else {
            return 0;
        }
    }
    /**
     * LSD helper method that performs a destructive counting sort the array of
     * Strings based off characters at a specific index.
     * @param asciis Input array of Strings
     * @param index The position to sort the Strings on.
     */
    private static void sortHelperLSD(String[] asciis, int index) {
        // Optional LSD helper method for required LSD radix sort
        return;
    }

    /**
     * MSD radix sort helper function that recursively calls itself to achieve the sorted array.
     * Destructive method that changes the passed in array, asciis.
     *
     * @param asciis String[] to be sorted
     * @param start int for where to start sorting in this method (includes String at start)
     * @param end int for where to end sorting in this method (does not include String at end)
     * @param index the index of the character the method is currently sorting on
     *
     **/
    private static void sortHelperMSD(String[] asciis, int start, int end, int index) {
        // Optional MSD helper method for optional MSD radix sort
        return;
    }
}
