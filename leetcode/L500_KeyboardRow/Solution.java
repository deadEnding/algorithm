package leetcode.L500_KeyboardRow;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * @author: deadend
 * @date: 3:06 PM 2/12/17
 * @version: 1.0
 * @description:
 */


public class Solution {
    public String[] findWords(String[] words) {
        String[] strs = {"QWERTYUIOP", "ASDFGHJKL", "ZXCVBNM"};
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            for (char c : strs[i].toCharArray()) {
                map.put(c, i);
            }
        }

        LinkedList<String> result = new LinkedList<>();
        for (String w : words) {
            if (w.equals("")) {
                continue;
            }
            boolean isOneRow = true;
            String word = w.toUpperCase();
            int row = map.get(word.charAt(0));
            for (int i = 1; i < word.length(); i++) {
                if (map.get(word.charAt(i)) != row) {
                    isOneRow = false;
                    break;
                }
            }

            if (isOneRow) {
                result.add(w);
            }
        }

        return result.toArray(new String[0]);
    }
}
