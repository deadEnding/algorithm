package leetcode.L336_PalindromePairs;

import java.util.*;

/**
 * @author: deadend
 * @date: 4:29 PM 11/25/16
 * @version: 1.0
 * @description:
 * http://www.cnblogs.com/xuyan505/p/5383244.html
 * http://blog.csdn.net/u014664226/article/details/50972319
 */


public class Solution {
    List<List<Integer>> result = new LinkedList<>();

    private boolean isPalindrome(String s) {
        for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }

    private String reverse(String s) {
        return new StringBuffer(s).reverse().toString();
    }

    private void add(int i, int j) {
        ArrayList<Integer> tmp = new ArrayList<>(2);
        tmp.add(i);
        tmp.add(j);
        result.add(tmp);
    }

    public List<List<Integer>> palindromePairs(String[] words) {
        final int n = words.length;
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(words[i], i);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 1; j <= words[i].length(); j++) {
                String left = words[i].substring(0, j);
                String right = words[i].substring(j, words[i].length());
                String revLeft = reverse(left);
                String revRight = reverse(right);
                if (isPalindrome(left) && map.containsKey(revRight) && map.get(revRight) != i) {
                    add(map.get(revRight), i);
                }

                if (isPalindrome(right) && map.containsKey(revLeft) && map.get(revLeft) != i) {
                    add(i, map.get(revLeft));
                }
            }

            if (map.containsKey("") && isPalindrome(words[i]) && map.get("") != i) {
                add(i, map.get(""));
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String[] words = {"ll", ""};
        List<List<Integer>> result = new Solution().palindromePairs(words);
        for (List<Integer> list : result) {
            for (int i : list) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
