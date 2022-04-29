public class SLList {
    public class IntNode {
        public int item;
        public IntNode next;
        public IntNode(int item, IntNode next) {
            this.item = item;
            this.next = next;
        }
    }
    public IntNode first;

    public SLList() {
        first = null;
    }

    public void addFirst(int x) {
        first = new IntNode(x, first);
    }

    public void reverse() {
        IntNode prev = null;
        IntNode now = first;
        while (now != null) {
            IntNode remainder = now.next;
            now.next = prev;
            prev = now;
            now = remainder;
        }
        first = prev;
    }

    public void recur_reverse() {
        first = reverse(first);
    }
    public IntNode reverse(IntNode p) {
        if (p.next == null || p == null) {
            return p;
        }
        IntNode p_next_r = reverse(p.next);
        p.next.next = p;
        p.next = null;
        return p_next_r;
    }

}
