package leetcode.L380_InsertDeleteGetrandomO1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

/**
 * @author: deadend
 * @date: 8:35 PM 3/16/17
 * @version: 1.0
 * @description:
 */


public class RandomizedSet {

    private HashMap<Integer, Integer> map;
    private ArrayList<Integer> arr;
    private Random random;

    /** Initialize your data structure here. */
    public RandomizedSet() {
        map = new HashMap<>();
        arr = new ArrayList<>();
        random = new Random();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        }
        map.put(val, arr.size());
        arr.add(val);
        return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }

        int ix = map.remove(val);
        int lastIx = arr.size() - 1;
        if (ix != lastIx) {
            map.put(arr.get(lastIx), ix);
            arr.set(ix, arr.get(lastIx));
        }
        arr.remove(lastIx);
        return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        return arr.get(random.nextInt(arr.size()));
    }
}
