public class SLList {
    private class IntNode {
        public int item;
        public IntNode next;
        public IntNode(int item, IntNode next) {
            this.item = item;
            this.next = next;
        }
    }

    private IntNode first;

    public void addFirst(int x) {
        first = new IntNode(x, first);
    }

    public void insert(int item, int position) {
        if (position == 0) {
            addFirst(item);
        }
        IntNode ptr = first;
        while (position > 1 && ptr.next != null) {
            ptr = ptr.next;
            position -= 1;
        }
        ptr.next = new IntNode(item, ptr.next);
    }

    public void reverse() {
        first = reverse(first);
    }

    private IntNode reverse(IntNode node) {
        if (node.next == null || node == null) {
            return node;
        }
        reverse(node.next);
        node.next.next = node;
        node.next = null;
        return node;
    }

    public void itreverse() {
        IntNode currNode = null;
        IntNode nextNode = first;
        while (nextNode != null) {
            IntNode temp = nextNode.next;
            nextNode.next = currNode;
            currNode = nextNode;
            nextNode = temp;
        }
        first = currNode;
    }
}
