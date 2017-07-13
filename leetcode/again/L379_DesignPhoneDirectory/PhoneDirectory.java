package leetcode.again.L379_DesignPhoneDirectory;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.regex.Pattern;

/**
 * @author: deadend
 * @date: 5:03 PM 3/13/17
 * @version: 1.0
 * @description:
 */


public class PhoneDirectory {

    private int n;
    private HashSet<Integer> unavailable = new HashSet<>();
    private Queue<Integer> available = new LinkedList<>();

    /** Initialize your data structure here
     @param maxNumbers - The maximum numbers that can be stored in the phone directory. */
    public PhoneDirectory(int maxNumbers) {
        n = maxNumbers;
        for (int i = 0; i < n; i++) {
            available.offer(i);
        }
    }

    /** Provide a number which is not assigned to anyone.
     @return - Return an available number. Return -1 if none is available. */
    public int get() {
        if (available.isEmpty()) {
            return -1;
        }

        int num = available.poll();
        unavailable.add(num);
        return num;
    }

    /** Check if a number is available or not. */
    public boolean check(int number) {
        return !unavailable.contains(number);
    }

    /** Recycle or release a number. */
    public void release(int number) {
        if (unavailable.contains(number)) {
            unavailable.remove(number);
            available.offer(number);
        }
    }
}
