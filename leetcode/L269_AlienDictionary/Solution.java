package leetcode.L269_AlienDictionary;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/**
 * @author: deadend
 * @date: 9:58 PM 3/15/17
 * @version: 1.0
 * @description:
 */


class Solution {
    public String alienOrder(String[] words) {
        StringBuilder builder = new StringBuilder();
        if (words == null || words.length == 0) {
            return "";
        }

        HashMap<Character, Integer> indegree = new HashMap<>();
        HashMap<Character, HashSet<Character>> neigs = new HashMap<>();
        for (String word : words) {
            for (char c : word.toCharArray()) {
                indegree.put(c, 0);
                neigs.put(c, new HashSet<>());
            }
        }

        final int n = words.length;
        for (int i = 1; i < n; i++) {
            int len = Math.min(words[i - 1].length(), words[i].length());
            for (int j = 0; j < len; j++) {
                char a = words[i - 1].charAt(j);
                char b = words[i].charAt(j);
                if (a != b) {
                    if (!neigs.get(a).contains(b)) {   // 需判断，避免重复计入入度
                        indegree.put(b, indegree.get(b) + 1);
                        neigs.get(a).add(b);
                    }
                    break;
                }
            }
        }

        int count = indegree.size();
        while (count > 0) {
            HashSet<Character> rmd = new HashSet<>();
            for (char c : indegree.keySet()) {
                if (indegree.get(c) == 0) {
                    rmd.add(c);
                }
            }

            if (rmd.isEmpty()) {
                return "";
            }

            count -= rmd.size();
            for (char c : rmd) {
                builder.append(c);
                indegree.put(c, indegree.get(c) - 1);
                for (char nc : neigs.get(c)) {
                    indegree.put(nc, indegree.get(nc) - 1);
                }
            }
        }

        return builder.toString();
    }

    public static void main(String[] args) {
        String[] words = {"za","zb","ca","cb"};
        System.out.println(new Solution().alienOrder(words));
    }
}

























class BasicSolution {
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
}
