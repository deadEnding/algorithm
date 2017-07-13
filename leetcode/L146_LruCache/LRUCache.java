package leetcode.L146_LruCache;

import java.util.*;

/**
 * @author: deadend
 * @date: P10:51 AM 12/7/16
 * @version: 1.0
 * @description:
 */


public class LRUCache extends LinkedHashMap<Integer, Integer> {

    private int capacity;

    public LRUCache(int capacity) {
        super(capacity, 0.75f, true);   // accessOrder: LRU实现
        this.capacity = capacity;
    }

    public int get(int key) {
        return containsKey(key) ? super.get(key) : -1;
    }

    public void set(int key, int value) {
        super.put(key, value);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return super.size() > capacity;
    }
}
