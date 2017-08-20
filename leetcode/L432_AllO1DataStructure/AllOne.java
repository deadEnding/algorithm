package leetcode.L432_AllO1DataStructure;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @author: deadend
 * @date: 1:38 PM 2/18/17
 * @version: 1.0
 * @description:
 */


public class AllOne {

    class Node {
        int val;
        HashSet<String> keys = new HashSet<>();
        Node prev, next;
        public Node(int val) {
            this.val = val;
        }
    }

    private Node dummy;
    private HashMap<String, Node> map;

    /** Initialize your data structure here. */
    public AllOne() {
        dummy = new Node(0);
        dummy.next = dummy.prev = dummy;
        map = new HashMap<>();
    }

    private void removeNode(Node node) {
        if (node == null) {
            return;
        }
        node.next.prev = node.prev;
        node.prev.next = node.next;
    }

    private void removeKey(Node node, String key) {
        node.keys.remove(key);
        if (node.keys.size() == 0) {
            removeNode(node);
        }
    }

    private Node addNode(Node prev, int val) {
        Node node = new Node(val);
        node.next = prev.next;
        prev.next = node;
        node.prev = prev;
        node.next.prev = node;
        return node;
    }

    /** Inserts B new key <Key> with value 1. Or increments an existing key by 1. */
    public void inc(String key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            if (node.next.val != node.val + 1) {
                addNode(node, node.val + 1);
            }
            node.next.keys.add(key);
            map.put(key, node.next);
            removeKey(node, key);
        } else {
            if (dummy.next.val != 1) {
                addNode(dummy, 1);
            }
            dummy.next.keys.add(key);
            map.put(key, dummy.next);
        }
    }

    /** Decrements an existing key by 1. If Key's value is 1, remove it from the data structure. */
    public void dec(String key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            if (node.val != 1) {
                if (node.prev.val != node.val - 1) {
                    addNode(node.prev, node.val - 1);
                }
                node.prev.keys.add(key);
                map.put(key, node.prev);
                removeKey(node, key);
            } else {
                map.remove(key);
                removeKey(node, key);
            }
        }
    }

    /** Returns one of the keys with maximal value. */
    public String getMaxKey() {
        String max = "";
        for (String key : dummy.prev.keys) {
            max = key;
            break;
        }
        return max;
    }

    /** Returns one of the keys with Minimal value. */
    public String getMinKey() {
        String min = "";
        for (String key : dummy.next.keys) {
            min = key;
            break;
        }
        return min;
    }

    public static void main(String[] args) {
        AllOne allOne = new AllOne();
        allOne.inc("alibaba");
        System.out.println(allOne.getMaxKey());
        System.out.println(allOne.getMinKey());
        allOne.inc("bbb");
        allOne.inc("bbb");
        allOne.dec("bbb");
        allOne.dec("bbb");
        System.out.println(allOne.getMaxKey());
        System.out.println(allOne.getMinKey());
    }
}
