public class IntList {
    public int first;
    public IntList rest;
    public IntList (int f, IntList r) {
        this.first = f;
        this.rest = r;
    }

    public static void removeDuplicate(IntList p) {
        if (p == null) {
            return;
        }

        IntList current = p.rest;

        IntList previous = p;

        while (current != null) {

            if (current.first != previous.first) {
                previous = current;
            } else {
                previous.rest = current.rest;
            }

            current = current.rest;
        }
    }

    public void skippify() {
        IntList p = this;
        int n = 1;
        while (p != null) {

            IntList next = p.rest;

            for (int i = 0; i < n; i++) {
                if (next == null) {
                    break;
                }
                next = next.rest;
            }
            p.rest = next;
            p = next;
            n++;
        }
    }

    public static int[] flatten(int[][] x) {
        int totalLength = 0;

        for (int[] item : x){
            totalLength += item.length;
        }

        int[] a = new int[totalLength];
        int aIndex = 0;

        for (int[] arr : x) {
            for (int item : arr) {
                a[aIndex] = item;
                aIndex += 1;
            }
        }

        return a;
    }
}
