package leetcode.L466_CountTheRepetitions;


import java.util.HashMap;
import java.util.HashSet;

/**
 * @author: deadend
 * @date: 1:29 PM 2/13/17
 * @version: 1.0
 * @description:
 */


public class Solution {
    public int getMaxRepetitions(String s1, int n1, String s2, int n2) {
        int l1 = s1.length(), l2 = s2.length();
        HashSet<Character> set = new HashSet<>();
        for (char c : s1.toCharArray()) {
            set.add(c);
        }

        for (char c : s2.toCharArray()) {
            if (!set.contains(c)) {
                return 0;
            }
        }

        // 寻找循环节，然后直接跳过中间的循环节
        int x1 = 0, x2 = 0;
        HashMap<Integer, HashMap<Integer, int[]>> map = new HashMap<>();
        while (x1 < l1 * n1) {
            while (s1.charAt(x1 % l1) != s2.charAt(x2 % l2)) {
                x1++;
            }

            if (x1 >= l1 * n1) {
                break;
            }

            int y1 = x1 % l1, y2 = x2 % l2;
            if (!map.containsKey(y1) || !map.get(y1).containsKey(y2)) {  // 记录第一次匹配成功的位置
                if (!map.containsKey(y1)) {
                    map.put(y1, new HashMap<>());
                }
                map.get(y1).put(y2, new int[] {x1, x2});
            } else {
                int[] pair = map.get(y1).get(y2);    // 取出第一次匹配成功的位置
                int dx1 = pair[0], dx2 = pair[1];
                int round = (l1 * n1 - dx1) / (x1 - dx1);  // 循环个数
                x1 = dx1 + round * (x1 - dx1);
                x2 = dx2 + round * (x2 - dx2);
            }

            if (x1 < l1 * n1) {
                x1++;
                x2++;
            }
        }

        return x2 / (n2 * l2);
    }
}

