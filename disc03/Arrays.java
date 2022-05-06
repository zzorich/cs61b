public class Arrays {
    public static int[] insert(int[] arr, int item, int position) {
        int[] inserted = new int[arr.length + 1];
        for (int i = 0; i < position; i++) {
            inserted[i] = arr[i];
        }
        inserted[position] = item;
        for (int i = position + 1; i < arr.length; i++) {
            inserted[i] = arr[i - 1];
        }
        return inserted;
    }

    public static void reverse(int[] arr) {
        for (int i = 0; i < arr.length/2; i++) {
            int temp = arr[i];
            arr[i] = arr[arr.length - i -1];
            arr[arr.length - i - 1] = temp;
        }
    }

    public static int[] replicate(int[] arr) {
        int totallength = 0;
        for (int x : arr) {
            totallength += x;
        }
        int[] replicated = new int[totallength];
        int totalIndex = 0;
        for (int x : arr) {
           for (int i = 0; i < x; i++) {
               replicated[totalIndex] = x;
               totalIndex += 1;
           }
        }
        return replicated;
    }
}

