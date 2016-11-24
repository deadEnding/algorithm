package leetcode.L030_SubstringWithConcatenationOfAllWords;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: deadend
 * @date: 1:36 PM 11/24/16
 * @version: 1.0
 * @description:
 */


public class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new LinkedList<>();
        if (words.length == 0 || s.length() < words.length * words[0].length()) {
            return result;
        }

        final int size = s.length();
        final int step = words[0].length();
        HashMap<String, Integer> map = new HashMap<>();
        for (String w : words) {
            if (!map.containsKey(w)) {
                map.put(w, 1);
            } else {
                map.put(w, map.get(w) + 1);
            }
        }

        for (int i = 0; i < step; i++) {
            HashMap<String, Integer> m = new HashMap<>(map);
            for (int j = i, start = i; j + step <= size;) {
                String slug = s.substring(j, j + step);
                if (m.containsKey(slug)) {
                    if (m.get(slug) > 0) {
                        if (countDown(m, slug)) {
                            result.add(start);
                            String tmp = s.substring(start, start + step);
                            m.put(tmp, m.get(tmp) + 1);
                            start += step;
                        }
                        j += step;
                    } else {
                        String tmp = s.substring(start, start + step);
                        m.put(tmp, m.get(tmp) + 1);
                        start += step;
                    }
                } else {
                    m = new HashMap<>(map);
                    start = j + step;
                    j += step;
                }
            }
        }
        return result;
    }

    private boolean countDown(HashMap<String, Integer> map, String word) {
        map.put(word, map.get(word) - 1);
        for (String key : map.keySet()) {
            if (map.get(key) > 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
//        String s = "wordgoodgoodgoodbestword";
//        String[] words = {"word","good","best","good"};
        String s = "barfoofoobarthefoobarman";
        String[] words = {"bar", "foo", "the"};
        List<Integer> result = new Solution().findSubstring(s, words);
        for (int ix : result) {
            System.out.print(ix + " ");
        }
    }
}
