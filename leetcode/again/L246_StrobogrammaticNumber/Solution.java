package leetcode.again.L246_StrobogrammaticNumber;

import java.util.HashMap;

/**
 * @author: deadend
 * @date: P10:13 AM 3/11/17
 * @version: 1.0
 * @description:
 */


public class Solution {

    public boolean isStrobogrammatic(String num) {
        HashMap<Character, Character> map = new HashMap<>();
        map.put('0', '0');
        map.put('1', '1');
        map.put('8', '8');
        map.put('6', '9');
        map.put('9', '6');

        for (int i = 0, j = num.length() - 1; i <= j; i++, j--) {
            if (!map.containsKey(num.charAt(i)) || map.get(num.charAt(i)) != num.charAt(j)) {
                return false;
            }
        }
        return true;
    }
}
