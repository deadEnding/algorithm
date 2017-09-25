package leetcode.L472_ConcatenatedWords;

import java.util.*;

/**
 * @author: deadend
 * @date: 12:46 PM 2/13/17
 * @version: 1.0
 * @description:
 */


class Solution {

    private boolean isComprised(String word, HashSet<String> set, HashMap<String, Boolean> cache, boolean isOriginal) {
        if (!isOriginal && set.contains(word)) {
            return true;
        }

        if (!cache.containsKey(word)) {
            for (int i = 1; i < word.length(); i++) {
                if (isComprised(word.substring(0, i), set, cache, false) && isComprised(word.substring(i), set, cache, false)) {
                    cache.put(word, true);
                    return true;
                }
            }
            cache.put(word, false);
        }

        return cache.get(word);
    }

    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        HashSet<String> set = new HashSet<>();
        for (String w : words) {
            set.add(w);
        }

        List<String> result = new ArrayList<>();
        for (String w : words) {
            if (isComprised(w, set, new HashMap<>(), true)) {
                result.add(w);
            }
        }

        return result;
    }
}

class OldSolution {

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
