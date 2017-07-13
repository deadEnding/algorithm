package leetcode.again.L359_LoggerRateLimiter;

import java.util.HashMap;

/**
 * @author: deadend
 * @date: 8:47 PM 3/11/17
 * @version: 1.0
 * @description:
 */


public class Logger {

    private HashMap<String, Integer> map;
    private static final int THRESHOLD = 10;

    /** Initialize your data structure here. */
    public Logger() {
        map = new HashMap<>();
    }

    /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
     If this method returns false, the message will not be printed.
     The timestamp is in seconds granularity. */
    public boolean shouldPrintMessage(int timestamp, String message) {
        if (map.containsKey(message) && timestamp - map.get(message) < THRESHOLD) {
            return false;
        }
        map.put(message, timestamp);
        return true;
    }
}
