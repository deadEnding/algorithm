package custom.company.indeed.others;

public class UnrolledLinkedList {

    public static final int N = 5;

    class Node {
        char[] chars = new char[N];
        int len;
        Node next;

        public boolean isFull() {
            return len == N;
        }

        public void insert(char ch, int index) {
            for (int i = len; i > index; i--) {
                chars[i] = chars[i - 1];
            }

            chars[index] = ch;
            len++;
        }

        public char removeLast() {
            return chars[--len];
        }

    }

    private Node head = new Node();
    private int totalLen;

    public char get(int index) {
        if (index >= totalLen) {
            return '\0';
        }

        int ix = 0;
        for (Node p = head; p != null; p = p.next) {
            if (ix + p.len > index) {
                return p.chars[index - ix];
            }
        }

        return '\0';
    }

    public void insert(char ch, int index) {
        totalLen++;
        int ix = 0;
        Node prev = null;
        for (Node p = head; p != null; ix += p.len, p = p.next) {
            if (ix + N > index) {
                if (p.isFull()) {
                    Node newNode = new Node();
                    newNode.insert(p.removeLast(), 0);
                    newNode.next = p.next;
                    p.next = newNode;
                    p.insert(ch, index - ix);
                } else {
                    p.insert(ch, index - ix);
                }
                return;
            }

            prev = p;
        }

        prev.next = new Node();
        prev.next.insert(ch, index - ix);
    }

    public void print() {
        for (Node p = head; p != null; p = p.next) {
            for (int i = 0; i < p.len; i++) {
                System.out.print(p.chars[i] + " ");
            }
            System.out.print("# ");
        }

        System.out.println();
    }

    public static void main(String[] args) {
        UnrolledLinkedList linkedList = new UnrolledLinkedList();
        linkedList.insert('a', 0);
        linkedList.insert('b', 1);
        linkedList.insert('c', 1);
        linkedList.insert('d', 0);
        linkedList.insert('e', 1);
        linkedList.insert('f', 5);
        linkedList.print();
        System.out.println(linkedList.totalLen);
    }
}
