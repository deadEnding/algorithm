package leetcode.L127_WordLadder;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * @author: deadend
 * @date: 2:30 PM 12/5/16
 * @version: 1.0
 * @description:
 */


public class Solution {
    public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        final int n = beginWord.length();

        Set<String> visited = new HashSet<>();
        visited.add(beginWord);

        LinkedList<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        queue.offer(null);

        int step = 2;
        while (!queue.isEmpty()) {
            String s = queue.poll();
            if (s != null) {
                char[] sarr = s.toCharArray();
                for (int i = 0; i < n; i++) {
                    char old = sarr[i];
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == old) {
                            continue;
                        }
                        sarr[i] = c;
                        String newStr = new String(sarr);
                        if (newStr.equals(endWord)) {
                            return step;
                        } else if (!visited.contains(newStr) && wordList.contains(newStr)) {
                            visited.add(newStr);
                            queue.offer(newStr);
                        }
                    }
                    sarr[i] = old;
                }
            } else {
                step++;
                if (!queue.isEmpty()) {
                    queue.offer(null);
                }
            }
        }
        return 0;
    }
}