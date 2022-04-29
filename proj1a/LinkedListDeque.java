public class LinkedListDeque<T> {

    private TNode sentinel;
    private int size;

    private class TNode {
        public T item;
        public TNode prev;
        public TNode next;

        public TNode(T item, TNode prev, TNode next) {
            this.item = item;
            this.prev = prev;
            this.next = next;
        }
    }

    /**
     * Create a empty circular linked list.
     */
    public LinkedListDeque() {
        sentinel = new TNode(null, null, null);
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
        size = 0;
    }

    /**
     * add an element to the head of list.
     * @param item of preconfigured type to be passed in.
     */
    public void addFirst(T item) {
        TNode FirstNode = new TNode(item, sentinel, sentinel.next);
        sentinel.next.prev = FirstNode;
        sentinel.next = FirstNode;
        size += 1;
    }

    /**
     * add an element to the tail of the list.
     * @param item, the value to be passed in.
     */
    public void addLast(T item) {
        TNode LastNode = new TNode(item, sentinel.prev, sentinel);
        sentinel.prev.next = LastNode;
        sentinel.prev = LastNode;
        size += 1;
    }

    /**
     * Check whether the linked list is empty.
     * @return true if it is empty, otherwise false.
     */
    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    /**
     * Print out the Deque.
     */
    public void printDeque() {
        TNode ptr = sentinel.next;
        while (ptr != sentinel) {
            System.out.print( ptr.item +" ");
            ptr = ptr.next;
        }
    }

    public T removeLast() {
        T item = null;
        if (size > 0) {
            item = sentinel.prev.item;
            sentinel.prev.prev.next = sentinel;
            sentinel.prev = sentinel.prev.prev;
            size -=1;
        }
        return item;
    }

    public T removeFirst() {
        T item = null;
        if (size > 0) {
            item = sentinel.next.item;
            sentinel.next.next.prev = sentinel;
            sentinel.next = sentinel.next.next;
            size -= 1;
        }
        return item;
    }

    public T get(int index) {
        TNode ptr = sentinel.next;
        if (index < size) {
            while (index > 0) {
                ptr = ptr.next;
            }
        }
        return ptr.item;
    }

    private T getRecursive(int index, TNode ptr) {
        if (index > 0) {
            return getRecursive(index-1, ptr.next);
        }
        return ptr.item;
    }

    public T getRecursive(int index) {
        if (index < size) {
            return getRecursive(index, sentinel.next);
        }
        return null;
    }









}
