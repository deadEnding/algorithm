package leetcode.L472_ConcatenatedWords;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: deadend
 * @date: 12:46 PM 2/13/17
 * @version: 1.0
 * @description:
 */


public class Solution {

    private boolean isComprised(String word, HashSet<String> set, HashMap<String, Boolean> cache, boolean isOriginal) {
        if (cache.containsKey(word)) {
            return cache.get(word);
        }

        if (!isOriginal && set.contains(word)) {
            return true;
        }

        for (int i = 1; i < word.length(); i++) {
            if (isComprised(word.substring(0, i), set, cache, false) && isComprised(word.substring(i), set, cache, false)) {
                cache.put(word, true);
                return true;
            }
        }
        cache.put(word, false);
        return false;
    }

    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        HashSet<String> set = new HashSet<>();
        for (String word : words) {
            set.add(word);
        }

        List<String> result = new LinkedList<>();
        for (String word : words) {
            if (isComprised(word, set, new HashMap<>(), true)) {
                result.add(word);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String[] words = {"cat","cats","catsdogcats","dog","dogcatsdog","hippopotamuses","rat","ratcatdogcat"};
        List<String> result = new Solution().findAllConcatenatedWordsInADict(words);
        for (String w : result) {
            System.out.println(w);
        }
    }
}
