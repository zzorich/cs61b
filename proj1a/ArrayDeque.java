public class ArrayDeque<T> {
    private int nextFirst;
    private int nextLast;
    private T[] item;
    private int size;

    public ArrayDeque() {
        item = (T []) new Object[8];
        nextFirst = 4;
        nextLast = nextFirst;
        size = 0;
    }

    public void addFirst(T first) {
        this.item[nextFirst] = first;
        nextFirst -= 1;
        size += 1;
    }

    public void addLast(T first) {
        this.item[nextLast] = first;
        nextLast += 1;
        size += 1;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public T get(int index) {
        if (index < size - 1) {
            return item[(nextFirst + 1 + index) % (item.length)];
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
            nextFirst = (nextFirst + 1) % item.length;
            T result = this.item[nextFirst];
            this.item[nextFirst] = null;
            size -= 1;
            return result;
        }

        return null;
    }

    public T removeLast() {
        if (size > 0) {
            nextLast = (nextLast - 1) % item.length;
            T result = this.item[nextLast];
            this.item[nextLast] = null;
            size -= 1;
            return result;
        }

        return null;
    }

    public void resize() {
        int expandFactor = 3;
        int shrinkFactor = 2;
        if (size > item.length - 1) {
            int newsize  = size * expandFactor;
            T[] newitem = (T []) new Object[newsize];
            for (int i = 0; i < size; i++) {
                newitem[i + newsize / 3] = this.get(i);
            }
            this.item = newitem;
            nextFirst = newsize / 3 - 1;
            nextLast = nextFirst + 1 + size;
        }

        if (size < item.length / 4) {
            int newsize  = size / shrinkFactor;
            T[] newitem = (T []) new Object[newsize];
            for (int i = 0; i < size; i++) {
                newitem[i + newsize / 3] = this.get(i);
            }
            this.item = newitem;
            nextFirst = newsize / 3 - 1;
            nextLast = nextFirst + 1 + size;
        }
    }
}


