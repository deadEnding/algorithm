package leetcode.L140_WordBreakII;

import java.util.*;

/**
 * @author: deadend
 * @date: 4:31 PM 3/2/17
 * @version: 1.0
 * @description:
 */

public class Solution {
    private ArrayList<String> backtrace(String s, HashSet<String> set, HashMap<String, ArrayList<String>> map) {
        if (map.containsKey(s)) {
            return map.get(s);
        }

        ArrayList<String> result = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            String t = s.substring(0, i + 1);
            if (set.contains(t)) {
                if (i + 1 == s.length()) {
                    result.add(t);
                } else {
                    ArrayList<String> rear = backtrace(s.substring(i + 1), set, map);
                    for (String r : rear) {
                        result.add(t + " " + r);
                    }
                }
            }
        }
        map.put(s, result);
        return result;
    }

    public List<String> wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>();
        for (String w : wordDict) {
            set.add(w);
        }

        return backtrace(s, set, new HashMap<>());
    }
}


class BasicSolution {
    private void backtrace(int ix, String s, HashSet<String> set, HashMap<Integer, ArrayList<String>> map) {
        if (ix == s.length() || map.containsKey(ix)) {
            return;
        }

        ArrayList<String> result = new ArrayList<>();
        for (int i = ix; i < s.length(); i++) {
            String t = s.substring(ix, i + 1);
            if (set.contains(t)) {
                if (i + 1 == s.length()) {
                    result.add(t);
                } else {
                    backtrace(i + 1, s, set, map);
                    for (String r : map.get(i + 1)) {
                        result.add(t + " " + r);
                    }
                }
            }
        }
        map.put(ix, result);
    }

    public List<String> wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>();
        set.addAll(wordDict);
        HashMap<Integer, ArrayList<String>> map = new HashMap<>();
        backtrace(0, s, set, map);
        return map.get(0);
    }

    public static void main(String[] args) {
        String s = "aab";
        List<String> words = new LinkedList<>();
        words.add("A");
        words.add("b");
        System.out.println(new Solution().wordBreak(s, words));
    }
}

