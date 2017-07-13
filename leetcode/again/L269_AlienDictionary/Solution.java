package leetcode.again.L269_AlienDictionary;


import java.util.HashMap;
import java.util.HashSet;

/**
 * @author: deadend
 * @date: 9:58 PM 3/15/17
 * @version: 1.0
 * @description:
 */


public class Solution {
    public String alienOrder(String[] words) {
        if (words == null || words.length == 0) {
            return "";
        }

        HashMap<Character, HashSet<Character>> adj = new HashMap<>();
        HashMap<Character, Integer> degree = new HashMap<>();

        for (String w : words) {
            for (char c : w.toCharArray()) {
                adj.put(c, new HashSet<>());
                degree.put(c, 0);
            }
        }

        for (int i = 1; i < words.length; i++) {
            String prev = words[i - 1];
            String curr = words[i];
            int len = Math.min(prev.length(), curr.length());
            for (int j = 0; j < len; j++) {
                char c1 = prev.charAt(j);
                char c2 = curr.charAt(j);
                if (c1 != c2) {
                    if (!adj.get(c1).contains(c2)) {
                        adj.get(c1).add(c2);
                        degree.put(c2, degree.get(c2) + 1);
                    }
                    break;
                }
            }
        }

        StringBuilder builder = new StringBuilder();
        int count = degree.size();
        while (count > 0) {
            HashSet<Character> removed = new HashSet<>();
            for (char key : degree.keySet()) {
                if (degree.get(key) == 0) {
                    removed.add(key);
                    builder.append(key);
                }
            }

            if (removed.size() == 0) {
                return "";
            }

            for (char rm : removed) {
                degree.put(rm, -1);
                for (char neig : adj.get(rm)) {
                    degree.put(neig, degree.get(neig) - 1);
                }
            }

            count -= removed.size();
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        String[] words = {"wrt","wrf","er","ett","rftt"};
        System.out.println(new Solution().alienOrder(words));
    }
}
