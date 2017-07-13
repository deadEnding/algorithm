package leetcode.L460_LFUCache;

import java.util.HashMap;
import java.util.LinkedHashSet;

/**
 * @author: deadend
 * @date: 2:42 PM 2/13/17
 * @version: 1.0
 * @description:
 */


public class LFUCache {

    class Node {
        int count;
        LinkedHashSet<Integer> keys = new LinkedHashSet<>();
        Node prev, next;
        public Node(int cnt) {
            count = cnt;
        }
    }

    private Node dummy = new Node(-1);
    private int capacity = 0;
    private HashMap<Integer, Integer> vmap = new HashMap<>();
    private HashMap<Integer, Node> nmap = new HashMap<>();

    public LFUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if (vmap.containsKey(key)) {
            increaseCount(key);
            return vmap.get(key);
        }
        return -1;
    }

    private void increaseCount(int key) {
        Node node = nmap.get(key);
        node.keys.remove(key);
        if (node.next == null) {
            node.next = new Node(node.count + 1);
            node.next.prev = node;
            node.next.keys.add(key);
        } else if (node.next.count == node.count + 1) {
            node.next.keys.add(key);
        } else {
            Node tmp = new Node(node.count + 1);
            tmp.keys.add(key);
            tmp.prev = node;
            tmp.next = node.next;
            node.next.prev = tmp;
            node.next = tmp;
        }
        if (node.keys.size() == 0) {
            remove(node);
        }

        nmap.put(key, node.next);
    }

    private void remove(Node node) {
        node.prev.next = node.next;
        if (node.next != null) {
            node.next.prev = node.prev;
        }
    }

    public void put(int key, int value) {
        if (capacity == 0) {
            return;
        }

        if (vmap.containsKey(key)) {
            vmap.put(key, value);
            increaseCount(key);
        } else {
            if (vmap.size() == capacity) {
                removeLFU();
            }
            vmap.put(key, value);
            addKey(key);
        }
    }

    private void removeLFU() {
        int lfuKey = 0;
        for (int n : dummy.next.keys) {
            lfuKey = n;
            break;
        }

        dummy.next.keys.remove(lfuKey);
        vmap.remove(lfuKey);
        nmap.remove(lfuKey);
        if (dummy.next.keys.size() == 0) {
            dummy.next = dummy.next.next;
            if (dummy.next != null) {
                dummy.next.prev = dummy;
            }
        }
    }

    private void addKey(int key) {
        if (dummy.next == null || dummy.next.count != 1) {
            Node node = new Node(1);
            node.next = dummy.next;
            node.prev = dummy;
            if (dummy.next != null) {
                dummy.next.prev = node;
            }
            dummy.next = node;
        }
        dummy.next.keys.add(key);
        nmap.put(key, dummy.next);
    }

    public void print() {
        Node p = dummy.next;
        System.out.println("-------------- keys: " + vmap.size());
        while (p != null) {
            System.out.print(p.count + ": ");
            for (int key : p.keys) {
                System.out.print(key + " ");
            }
            System.out.println();
            p = p.next;
        }
    }

    public static void main(String[] args) {
        LFUCache cache = new LFUCache(1);
        cache.put(2,1);
        cache.print();
        cache.get(2);
        cache.print();
        cache.put(3,2);
        cache.print();
        cache.get(2);
        cache.print();
        cache.get(3);
        cache.print();
    }
}
