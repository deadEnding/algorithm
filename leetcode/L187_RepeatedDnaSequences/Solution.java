package leetcode.L187_RepeatedDnaSequences;

import java.util.*;

/**
 * @author: deadend
 * @date: 9:59 AM 11/25/16
 * @version: 1.0
 * @description:
 */

public class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        final int n = s.length();
        HashSet<String> result = new HashSet<>();
        HashSet<Integer> set = new HashSet<>();

        final HashMap<Character, Integer> map = new HashMap<Character, Integer>() {{
            put('A', 0);
            put('C', 0);
            put('G', 0);
            put('T', 0);
        }};

        int hash = 0;
        for (int i = 0; i < n; i++) {
            hash += (hash << 1) + map.get(s.charAt(i));
            hash &= (1 << 20) - 1;
            if (i >= 9) {
                if (set.contains(hash)) {
                    result.add(s.substring(i - 9, i + 1));
                } else {
                    set.add(hash);
                }
            }
        }

        return new ArrayList<>(result);
    }
}

class OldSolution {
    public List<String> findRepeatedDnaSequences(String s) {
        HashSet<String> result = new HashSet<>();
        HashSet<Integer> set = new HashSet<>();

        final HashMap<Character, Integer> map = new HashMap<Character, Integer>() {{
            put('A', 0);
            put('T', 1);
            put('C', 2);
            put('G', 3);
        }};

        int n = 0;
        for (int i = 0; i < s.length(); i++) {
            n = (n << 2) + map.get(s.charAt(i));
            n &= (1 << 20) - 1;
            if (i >= 9) {
                if (set.contains(n)) {
                    result.add(s.substring(i - 9, i + 1));
                } else {
                    set.add(n);
                }
            }
        }
        return new LinkedList<>(result);
    }

    public static void main(String[] args) {
        String s = "AAAAAAAAAAAAA";
        List<String> result = new Solution().findRepeatedDnaSequences(s);
        for (String slug : result) {
            System.out.println(slug);
        }
    }
}

class BasicSolution {
    public List<String> findRepeatedDnaSequences(String s) {
        HashSet<String> result = new HashSet<>();
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i + 10 <= s.length(); i++) {
            String slug = s.substring(i, i + 10);
            if (set.contains(slug)) {
                result.add(slug);
            } else {
                set.add(slug);
            }
        }
        return new LinkedList<>(result);
    }
}
