public class ArrayDeque<T> {
    private int nextfirstPos;
    private int nextlastPos;
    private static int sentinelPos = 0;
    private T[] item;
    private int size;
    private static int expandFactor = 3;
    private static int shrinkFactor = 3;
    

    public ArrayDeque() {
        item = (T []) new Object[9];
        item[sentinelPos] = null;
        nextfirstPos = item.length - 1;
        nextlastPos = 1;
        size = 0;
    }

    /**
     * @param x current index, 1 <= x < item.length - 1
     * @return index move leftward, skipping the sentinel (0).
     */
    private int minusOne(int x) {
        if (x == 1) {
            return item.length - 1;
        } else {
            return x - 1;
        }
    }

    /**
     * @param x with 1 <= x < item.length - 1.
     * @return index move rightward, skipping the sentinel
     */
    private int plusOne(int x) {
        if (x == item.length - 1) {
            return 1;
        } else {
            return x + 1;
        }
    }

    public void addFirst(T first) {
        item[nextfirstPos] = first;
        nextfirstPos = minusOne(nextfirstPos);
        size += 1;
        resize();
    }

    public void addLast(T last) {
        item[nextlastPos] = last;
        nextlastPos = plusOne(nextlastPos);
        size += 1;
        resize();
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    /**
     * @param index, return not null if 0 <= index < size - 1
     * @return item at the actindex, where 1<= actindex <= item.length - 1, skipping the sentinel
     */
    public T get(int index) {
        if (index < size) {
            int actindex = plusOne(nextfirstPos) + index;
            if (actindex > item.length - 1) {
                actindex = actindex % item.length + 1;
            }
            return item[actindex];
        }
        return null;
    }

    public void printDeque() {
        for (int i = 0; i < size; i++) {
            System.out.print(this.get(i) + " ");
        }
    }

    public T removeFirst() {
        if (size > 0) {
            int firstPos = plusOne(nextfirstPos);
            T result = item[firstPos];
            item[firstPos] = null;
            nextfirstPos = firstPos;
            size -= 1;
            resize();
            return result;
        }
        return null;
    }

    public T removeLast() {
        if (size > 0) {
            int lastPos = minusOne(nextlastPos);
            T result = item[lastPos];
            item[lastPos] = null;
            nextlastPos = lastPos;
            size -= 1;
            resize();
            return result;
        }
        return null;
    }

    private void shrink() {
        int newsize  = item.length / shrinkFactor;
        T[] newitem = (T []) new Object[newsize];
        for (int i = 0; i < size; i++) {
            newitem[i + 1] = this.get(i);
        }
        this.item = newitem;
        nextfirstPos = item.length - 1;;
        nextlastPos =  size + 1;
    }

    private void expand() {
        int newsize = item.length * expandFactor;
        T[] newitem = (T []) new Object[newsize];
        for (int i = 0; i < size; i++) {
            newitem[i + 1] = this.get(i);
        }
        this.item = newitem;
        nextfirstPos = item.length - 1;
        nextlastPos =  size + 1;
    }

     /* Resize or reset pointer of the empty deque*/
    private void resize() {
        if (size == 0) {
            nextlastPos = 1;
            nextfirstPos = item.length - 1;
        }
        if (size > item.length - 2) {
            expand();
        }

        if (size < item.length / 4 && item.length > 16) {
            shrink();
        }
    }
}


