package leetcode.L381_InsertDeleteGetrandomO1DuplicatesAllowed;

import java.util.*;

/**
 * @author: deadend
 * @date: 2:49 PM 11/23/16
 * @version: 1.0
 * @description:
 */


public class RandomizedCollection {

    private int size;
    private HashMap<Integer, HashSet<Integer>> map;
    private ArrayList<Integer> list;
    private Random random;


    /** Initialize your data structure here. */
    public RandomizedCollection() {
        size = 0;
        map = new HashMap<>();
        list = new ArrayList<>();
        random = new Random();
    }

    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        if (!map.containsKey(val)) {
            map.put(val, new HashSet<Integer>());
        }
        map.get(val).add(size);
        list.add(size++, val);
        return map.get(val).size() == 1;
    }

    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        if (!map.containsKey(val) || map.get(val).size() == 0) {
            return false;
        }
        Iterator<Integer> iter = map.get(val).iterator();
        int ix = iter.next();
        map.get(val).remove(ix);
        if (ix < size - 1) {
            list.set(ix, list.get(size - 1));
            map.get(list.get(size - 1)).add(ix);
            map.get(list.get(size - 1)).remove(size - 1);
        }
        size--;
        return true;
    }

    /** Get a random element from the collection. */
    public int getRandom() {
        return list.get(random.nextInt(size));
    }

    public static void main(String[] args) {
        RandomizedCollection collection = new RandomizedCollection();
        System.out.println(collection.insert(1));
        System.out.println(collection.insert(1));
        System.out.println(collection.insert(2));
        System.out.println(collection.getRandom());
        System.out.println(collection.remove(1));
        System.out.println(collection.getRandom());
    }
}
