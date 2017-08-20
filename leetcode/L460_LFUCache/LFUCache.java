package leetcode.L460_LFUCache;


import custom.templates.practice.LRUCache;

import java.util.HashMap;
import java.util.LinkedHashSet;

public class LFUCache {

    class Node {
        int count;
        LinkedHashSet<Integer> keys;
        Node prev, next;

        public Node(int count) {
            this.count = count;
            this.keys = new LinkedHashSet<>();
        }
    }

    private int capacity;
    private Node dummy = new Node(-1);
    private HashMap<Integer, Integer> valMap = new HashMap<>();
    private HashMap<Integer, Node> nodeMap = new HashMap<>();

    public LFUCache(int capacity) {
        this.capacity = capacity;
        dummy.next = dummy.prev = dummy;
    }

    private void link(Node prev, Node node) {
        Node next = prev.next;
        prev.next = node;
        node.prev = prev;
        next.prev = node;
        node.next = next;
    }

    private void unlink(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void moveToNext(int key) {
        Node node = nodeMap.get(key);
        node.keys.remove(key);
        if (node.next.count != node.count + 1) {
            link(node, new Node(node.count + 1));
        }

        node.next.keys.add(key);
        nodeMap.put(key, node.next);

        if (node.keys.isEmpty()) {
            unlink(node);
        }

    }

    private void addToFirst(int key) {
        if (dummy.next.count != 1) {
            link(dummy, new Node(1));
        }

        nodeMap.put(key, dummy.next);
        dummy.next.keys.add(key);
    }

    private void removeLFU() {
        int lfuKey = 0;
        for (int key : dummy.next.keys) {
            lfuKey = key;
            break;
        }

        valMap.remove(lfuKey);
        nodeMap.remove(lfuKey);
        dummy.next.keys.remove(lfuKey);
        if (dummy.next.keys.isEmpty()) {
            unlink(dummy.next);
        }
    }

    public int get(int key) {
        if (!valMap.containsKey(key)) {
            return -1;
        }

        moveToNext(key);
        return valMap.get(key);
    }

    public void put(int key, int value) {
        if (capacity == 0) {
            return;
        }

        if (nodeMap.containsKey(key)) {
            valMap.put(key, value);
            moveToNext(key);
        } else {
            if (valMap.size() == capacity) {
                removeLFU();
            }
            valMap.put(key, value);
            addToFirst(key);
        }
    }

    public void print() {
        Node p = dummy.next;
        System.out.println("-------------- keys: " + valMap.size());
        while (p != dummy) {
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
        System.out.println(cache.get(2));
        cache.print();
        cache.put(3,2);
        cache.print();
        System.out.println(cache.get(2));
        cache.print();
        System.out.println(cache.get(3));
        cache.print();
    }
}
