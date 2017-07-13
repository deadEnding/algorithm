package leetcode.again.L249_GroupShiftedStrings;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: deadend
 * @date: 1:12 PM 3/12/17
 * @version: 1.0
 * @description:
 */


public class Solution {
    private String hash(String s) {
        final int n = s.length();
        StringBuffer buffer = new StringBuffer();
        for (int i = 1; i <= n; i++) {
            int d = s.charAt(i % n) - s.charAt((i - 1) % n);
            buffer.append(d >= 0 ? d : 26 + d);
            if (i != n) {
                buffer.append("|");
            }
        }
        return buffer.toString();
    }

    public List<List<String>> groupStrings(String[] strings) {
        List<List<String>> groups = new LinkedList<>();
        HashMap<String, List<String>> map = new HashMap<>();
        for (String s : strings) {
            String h = hash(s);
            if (!map.containsKey(h)) {
                map.put(h, new LinkedList<>());
                groups.add(map.get(h));
            }

            map.get(h).add(s);
        }
        return groups;
    }
}
