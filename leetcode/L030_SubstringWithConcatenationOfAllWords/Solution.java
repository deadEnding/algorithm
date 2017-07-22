package leetcode.L030_SubstringWithConcatenationOfAllWords;


import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Solution {

    private HashMap<String, Integer> create(String[] words) {
        HashMap<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        return map;
    }

    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new LinkedList<>();
        if (words.length == 0 || s.length() < words.length * words[0].length()) {
            return result;
        }

        final int l = s.length();
        final int m = words[0].length();
        final int n = words.length;

        for (int i = 0; i < m; i++) {
            int count = n;
            HashMap<String, Integer> map = create(words);
            for (int j = i; j + m <= l; j += m) {
                String slug = s.substring(j, j + m);
                if (map.containsKey(slug)) {
                    map.put(slug, map.get(slug) - 1);
                    if (map.get(slug) >= 0) {
                        count--;
                    }
                }

                if (j >= i + m * n) {
                    String oldSlug = s.substring(j - m * n, j - m * n + m);
                    if (map.containsKey(oldSlug)) {
                        map.put(oldSlug, map.get(oldSlug) + 1);
                        if (map.get(oldSlug) > 0) {
                            count++;
                        }
                    }
                }

                if (count == 0) {
                    result.add(j - m * n + m);
                }
            }
        }

        return result;
    }
}
