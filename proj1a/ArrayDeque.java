public class ArrayDeque<T> {
    private int nextfirstPos;
    private int nextlastPos;
    private T[] item;
    private int size;
    private static int expandFactor = 3;
    private static int shrinkFactor = 2;

    public ArrayDeque() {
        item = (T []) new Object[8];
        nextfirstPos = 0;
        nextlastPos = 0;
        size = 0;
    }

    /**
     * @param x with 0 <= x < item.length.
     * @return int y = (x - 1) modulos item.length with 0 <= y < item.length.
     */
    private int minusOne(int x) {
        if (x - 1 < 0) {
            return (x - 1) + item.length;
        } else {
            return x - 1;
        }
    }

    /**
     * @param x with 0 <= x < item.length.
     * @return int y = (x + 1) modulos item.length with 0 <= y < item.length.
     */
    private int plusOne(int x) {
        return (x + 1) % item.length;
    }

    public void addFirst(T first) {
        if (isEmpty()) {
            nextlastPos = plusOne(nextlastPos);
        }
        item[nextfirstPos] = first;
        nextfirstPos = minusOne(nextfirstPos);
        size += 1;
        resize();
    }

    public void addLast(T last) {
        if (isEmpty()) {
            nextfirstPos = minusOne(nextfirstPos);
        }
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
     *
     * @param index, 0 <= index < size - 1
     * @return
     */
    public T get(int index) {
        if (index < size) {
            return item[(nextfirstPos + 1 + index) % (item.length)];
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
            newitem[i] = this.get(i);
        }
        this.item = newitem;
        nextfirstPos = minusOne(0);
        nextlastPos =  size;
    }

    private void expand() {
        int newsize = item.length * expandFactor;
        T[] newitem = (T []) new Object[newsize];
        for (int i = 0; i < size; i++) {
            newitem[i] = this.get(i);
        }
        this.item = newitem;
        nextfirstPos = minusOne(0);
        nextlastPos =  size;
    }
    private void resize() {
        if (size > item.length - 1) {
            expand();
        }

        if (size < item.length / 4 && item.length > 16) {
            shrink();
        }
    }
}


