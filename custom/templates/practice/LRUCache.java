package custom.templates.practice;

import java.util.HashMap;

/**
 * Created by yuhui.zzc on 13/08/2017.
 */
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

    private Node dummy = new Node(-1, -1);
    private HashMap<Integer, Node> map = new HashMap<>();

    public LRUCache(int capacity) {
        this.capacity = capacity;
        dummy.prev = dummy.next = dummy;
    }

    private void link(Node prev, Node node) {
        prev.next.prev = node;
        node.next = prev.next;
        prev.next = node;
        node.prev = prev;
    }

    private void unlink(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void addToLast(Node node) {
        map.put(node.key, node);
        link(dummy.prev, node);
    }

    private void moveToLast(Node node) {
        unlink(node);
        addToLast(node);
    }

    private void removeFirst() {
        map.remove(dummy.next.key);
        unlink(dummy.next);
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
            addToLast(new Node(key, value));
            if (map.size() > capacity) {
                removeFirst();
            }
        }
    }
}
