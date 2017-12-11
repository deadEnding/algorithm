package custom.company.baidu.Q20170927.A;

public class Main {

    static class Node {
        int val;
        Node next;

        public Node(int v) {
            val = v;
        }
    }

    public static Node reorder(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        Node newHead = head.next;
        head.next = reorder(head.next.next);
        newHead.next = head;
        return newHead;
    }
}
