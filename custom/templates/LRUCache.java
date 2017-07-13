package custom.templates;


import java.util.HashMap;

public class LRUCache {

    class Node {
        int key, val;
        Node prev, next;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    private int capacity;
    private int count;
    private Node dummy;
    private HashMap<Integer, Node> map;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        dummy = new Node(-1, -1);
        dummy.prev = dummy.next = dummy;
        map = new HashMap<>();
    }

    private void link(Node prev, Node node) {
        Node next = prev.next;
        prev.next = node;
        node.next = next;
        node.prev = prev;
        next.prev = node;
    }

    private void unlink(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void removeFirst() {
        map.remove(dummy.next.key);
        unlink(dummy.next);
    }

    private void addLast(Node node) {
        map.put(node.key, node);
        link(dummy.prev, node);
    }

    private void moveToLast(Node node) {
        unlink(node);
        link(dummy.prev, node);
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }

        Node node = map.get(key);
        moveToLast(node);
        return node.val;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.val = value;
            moveToLast(node);
        } else {
            Node node = new Node(key, value);
            addLast(node);
            if (++count > capacity) {
                removeFirst();
            }
        }
    }
}
