package leetcode.L140_WordBreakII;

import java.util.*;

/**
 * @author: deadend
 * @date: 4:31 PM 3/2/17
 * @version: 1.0
 * @description:
 */

class TimeoutDPSolution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        final int n = s.length();
        HashSet<String> set = new HashSet<>();
        set.addAll(wordDict);

        ArrayList<String>[] dp = new ArrayList[n];
        for (int i = n - 1; i >= 0; i--) {
            dp[i] = new ArrayList<>();
            for (int j = i + 1; j <= n; j++) {
                if (set.contains(s.substring(i, j)) && (j == n || !dp[j].isEmpty())) {
                    String w = s.substring(i, j);
                    if (j == n) {
                        dp[i].add(w);
                    } else {
                        for (String rw : dp[j]) {
                            dp[i].add(w + " " + rw);
                        }
                    }
                }
            }
        }

        return dp[0];
    }

    public static void main(String[] args) {
        String s = "asn";
        String[] ws = {"a","as","n","sn"};
        List<String> words = new LinkedList<>();
        for (String w : ws) {
            words.add(w);
        }
        System.out.println(new TimeoutDPSolution().wordBreak(s, words));
    }
}


public class Solution {
    private ArrayList<String> dfs(String s, HashSet<String> dict, HashMap<String, ArrayList<String>> cache) {
        if (s.equals("")) {
            return new ArrayList<String>() {{ add(""); }};
        }

        if (!cache.containsKey(s)) {
            ArrayList<String> result = new ArrayList<>();
            for (int i = 0; i < s.length(); i++) {
                String t = s.substring(0, i + 1);
                if (dict.contains(t)) {
                    ArrayList<String> rear = dfs(s.substring(i + 1), dict, cache);
                    for (String r : rear) {
                        result.add(t + (r.equals("") ? r : (" " + r)));
                    }
                }
            }
            cache.put(s, result);
        }

        return cache.get(s);
    }

    public List<String> wordBreak(String s, List<String> wordDict) {
        HashSet<String> dict = new HashSet<>();
        dict.addAll(wordDict);
        return dfs(s, dict, new HashMap<>());
    }
}

class OldSolution {
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
}

