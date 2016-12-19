package leetcode.L383_RansomNote;

import java.util.HashMap;

/**
 * @author: deadend
 * @date: 9:24 AM 12/19/16
 * @version: 1.0
 * @description:
 */


public class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character, Integer> counter = new HashMap<>();

        for (char c : magazine.toCharArray()) {
            counter.put(c, counter.containsKey(c) ? counter.get(c) + 1: 1);
        }

        for (char c : ransomNote.toCharArray()) {
            if (!counter.containsKey(c) || counter.get(c) < 1) {
                return false;
            }
            counter.put(c, counter.get(c) - 1);
        }
        return true;
    }
}
