public class ArrayDeque<T> {
    private int firstPos;
    private int lastPos;
    private T[] item;
    private int size;
    private static int expandFactor = 3;
    private static int shrinkFactor = 2;

    public ArrayDeque() {
        item = (T []) new Object[8];
        firstPos = 0;
        lastPos = 0;
        size = 0;
    }

    private int minusOne(int x) {
        return (x - 1) % item.length;
    }

    private int plusOne(int x) {
        return (x + 1) % item.length;
    }

    public void addFirst(T first) {
        firstPos = minusOne(firstPos);
        item[firstPos] = first;
        size += 1;
        resize();
    }

    public void addLast(T last) {
        lastPos = plusOne(lastPos);
        item[lastPos] = last;
        size += 1;
        resize();
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public T get(int index) {
        if (index < size - 1) {
            return item[(firstPos + index) % (item.length)];
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
            T result = item[firstPos];
            item[firstPos] = null;
            firstPos = plusOne(firstPos);
            size -= 1;
            resize();
            return result;
        }
        return null;
    }

    public T removeLast() {
        if (size > 0) {
            T result = item[lastPos];
            item[lastPos] = null;
            lastPos = minusOne(lastPos);
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
        firstPos = 0;
        lastPos = firstPos + size - 1;
    }

    public void expand() {
        int newsize = item.length * expandFactor;
        T[] newitem = (T []) new Object[newsize];
        for (int i = 0; i < size; i++) {
            newitem[i] = this.get(i);
        }
        this.item = newitem;
        firstPos = 0;
        lastPos = firstPos + size - 1;
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


