package leetcode.L438_FindAllAnagramsInAString;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: deadend
 * @date: P10:56 PM 11/25/16
 * @version: 1.0
 * @description:
 */


public class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        final int sl = s.length();
        final int pl = p.length();
        HashMap<Character, Integer> pmap = new HashMap<>();
        for (int i = 0; i < pl; i++) {
            char c = p.charAt(i);
            pmap.put(c, pmap.containsKey(c) ? pmap.get(c) + 1 : 1);
        }

        List<Integer> result = new LinkedList<>();
        HashMap<Character, Integer> tmap = new HashMap<>();
        for (int i = 0; i < sl; i++) {
            char c = s.charAt(i);
            if (pmap.containsKey(c)) {
                tmap.put(c, tmap.containsKey(c) ? tmap.get(c) + 1 : 1);
            }

            if (tmap.equals(pmap)) {
                result.add(i + 1 - pl);
            }

            if (i + 1 >= pl) {
                char sc = s.charAt(i + 1 - pl);
                if (pmap.containsKey(sc)) {
                    tmap.put(sc, tmap.get(sc) - 1);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String s = "cbaebabacd";
        String p = "abc";
        List<Integer> result = new Solution().findAnagrams(s, p);
        for (int i : result) {
            System.out.println(i);
        }
    }
}

class OtherSolution {
    public List<Integer> findAnagrams(String s, String p) {
        final int sl = s.length();
        final int pl = p.length();
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < pl; i++) {
            char c = p.charAt(i);
            map.put(c, map.containsKey(c) ? map.get(c) + 1 : 1);
        }

        List<Integer> result = new LinkedList<>();
        int count = 0;
        for (int i = 0; i < sl; i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) - 1);
                count += map.get(c) >= 0 ? 1 : 0;
            }

            if (i + 1 >= pl) {
                if (count == pl) {
                    result.add(i + 1 - pl);
                }

                char sc = s.charAt(i + 1 - pl);
                if (map.containsKey(sc)) {
                    map.put(sc, map.get(sc) + 1);
                    count -= map.get(sc) > 0 ? 1 : 0;
                }
            }
        }
        return result;
    }
}
