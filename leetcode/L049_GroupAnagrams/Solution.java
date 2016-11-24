package leetcode.L049_GroupAnagrams;

import java.util.*;

/**
 * @author: deadend
 * @date: 4:33 PM 11/24/16
 * @version: 1.0
 * @description:
 */


public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();

        for (String str : strs) {
            char[] chs = str.toCharArray();
            Arrays.sort(chs);
            String sorted = new String(chs);
            if (map.containsKey(sorted)) {
                result.get(map.get(sorted)).add(str);
            } else {
                map.put(sorted, result.size());
                LinkedList<String> tmp = new LinkedList<>();
                tmp.add(str);
                result.add(tmp);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> result = new Solution().groupAnagrams(strs);
        for (List<String> list : result) {
            for (String s : list) {
                System.out.print(s + " ");
            }
            System.out.println();
        }
    }
}
