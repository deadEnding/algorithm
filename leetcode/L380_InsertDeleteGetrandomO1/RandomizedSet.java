package leetcode.L380_InsertDeleteGetrandomO1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

/**
 * @author: deadend
 * @date: 2:25 PM 11/23/16
 * @version: 1.0
 * @description:
 */


public class RandomizedSet {

    private int size;
    private ArrayList<Integer> list;
    private HashMap<Integer, Integer> map;
    private Random random;

    /** Initialize your data structure here. */
    public RandomizedSet() {
        size = 0;
        list =  new ArrayList<>();
        map = new HashMap<>();
        random = new Random();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        }
        map.put(val, size);
        list.add(size++, val);
        return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }
        int ix = map.get(val);
        map.remove(val);
        if (ix < size - 1) {
            list.set(ix, list.get(size - 1));
            map.put(list.get(size - 1), ix);
        }
        size--;
        return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        return list.get(random.nextInt(size));
    }

    public static void main(String[] args) {
        RandomizedSet set = new RandomizedSet();
        System.out.println(set.insert(1));
        System.out.println(set.remove(2));
        System.out.println(set.insert(2));
        System.out.println(set.getRandom());
        System.out.println(set.remove(1));
        System.out.println(set.insert(2));
        System.out.println(set.getRandom());
    }
}
