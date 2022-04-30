public class ArrayDequeTest {
    public static void addFirsttest() {
        ArrayDeque<Integer> ad1 = new ArrayDeque<>();
        boolean passed = ad1.isEmpty();
        for (int i = 0; i < 8; i++) {
            ad1.addFirst(i);
        }
        passed = ad1.size() == 8 && passed;
        passed = ad1.get(0) == 7 && passed;
        ad1.addFirst(8);
        passed = ad1.get(0) == 8 && passed;
        passed = ad1.size() == 9 && passed;
        if (passed) {
            System.out.println("Passed");
        } else {
            System.out.println("Failed");
        }
    }

    public static void addLasttest() {
        ArrayDeque<Integer> ad1 = new ArrayDeque<>();
        boolean passed = ad1.isEmpty();
        for (int i = 0; i < 8; i++) {
            ad1.addLast(i);
        }
        passed = ad1.size() == 8 && passed;
        passed = ad1.get(0) == 0 && passed;
        passed = ad1.get(ad1.size() - 1) == 7 && passed;
        ad1.addLast(8);
        passed = ad1.size() == 9 && passed;
        passed = ad1.get(ad1.size() - 1) == 8 && passed;
        passed = ad1.size() == 9 && passed;
        if (passed) {
            System.out.println("Passed");
        } else {
            System.out.println("Failed");
        }
    }

    public static void removeTest() {
        ArrayDeque<Integer> ad1 = new ArrayDeque<>();
        ad1.addFirst(1);
        boolean passed = ad1.removeLast() == 1 && ad1.isEmpty();
        for (int i = 0; i < 8; i++) {
            ad1.addLast(i);
        }

        if (passed) {
            System.out.println("Passed");
        } else {
            System.out.println("Failed");
        }
    }

    public static void removeaddtest() {
        ArrayDeque<Integer> ad1 = new ArrayDeque<>();
        ad1.addFirst(0);
        ad1.addFirst(1);
        boolean passed = ad1.get(1) == 0;
        ad1.addLast(3);
        passed = ad1.get(0) == 1 && passed;
        ad1.addLast(5);
        ad1.addFirst(6);
        passed = ad1.get(3) == 3 && passed;
        ad1.addFirst(8);
        ad1.addFirst(9);
        ad1.addLast(10);
        passed = ad1.removeFirst() == 9 && passed;
        passed = ad1.removeLast()  == 10 && passed;
        passed = ad1.removeFirst() == 8 && passed;
        passed = ad1.removeLast() == 5  && passed;

        ArrayDeque<Integer> ad2 = new ArrayDeque<>();
        ad2.addLast(0);
        ad2.addLast(1);
        passed = ad2.removeFirst() == 0 && passed;
        ad2.addLast(3);
        ad2.addFirst(4);
        passed = ad2.removeFirst() == 4 && passed;
        ad2.addFirst(6);
        ad2.addFirst(7);
        ad2.addLast(8);
        ad2.addLast(9);
        passed = ad2.get(5) == 9 && passed;
        ad2.addFirst(11);
        ad2.addLast(12);
        passed = ad2.removeFirst() == 11 && passed;
        ad2.addFirst(14);
        passed = ad2.removeLast() == 12 && passed;
        passed = ad2.removeFirst() == 14 && passed;
        passed = ad2.removeLast()  == 9 && passed;
        ad2.addFirst(18);
        passed = ad2.removeLast() == 8 && passed;

        if (passed) {
            System.out.println("Passed");
        } else {
            System.out.println("Failed");
        }
    }
    public static void main(String[] args) {
        addFirsttest();
        addLasttest();
        removeTest();
        removeaddtest();
    }
}
