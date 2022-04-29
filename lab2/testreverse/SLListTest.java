import static org.junit.Assert.*;
import org.junit.Test;


public class SLListTest {
    @Test
    public void test_reverse(){
        SLList s1 = new SLList();
        s1.addFirst(1);
        s1.addFirst(2);
        s1.addFirst(3);

        SLList s2 = new SLList();
        s2.addFirst(3);
        s2.addFirst(2);
        s2.addFirst(1);

        s2.reverse();
        SLList.IntNode p1 = s1.first;
        SLList.IntNode p2 = s2.first;
        while (p1.next != null) {
            System.out.println(p1.item);
            System.out.println(p2.item);
            assert p1.item == p2.item;
            p1 = p1.next;
            p2 = p2.next;
        }
        assert p2.next == null;
    }

    @Test
    public void test_rer_reverse() {
        SLList s1 = new SLList();
        s1.addFirst(1);
        s1.addFirst(2);
        s1.addFirst(3);

        SLList s2 = new SLList();
        s2.addFirst(3);
        s2.addFirst(2);
        s2.addFirst(1);

        s2.recur_reverse();
        SLList.IntNode p1 = s1.first;
        SLList.IntNode p2 = s2.first;
        while (p1.next != null) {
            System.out.println(p1.item);
            System.out.println(p2.item);
            assert p1.item == p2.item;
            p1 = p1.next;
            p2 = p2.next;
        }
        assert p2.next == null;
    }
}

