package leetcode.L126_WordLadderII;

import java.util.*;

/**
 * @author: deadend
 * @date: 1:34 PM 2/15/17
 * @version: 1.0
 * @description:
 */


public class Solution {

    private void backtrack(String word, String beginWord, HashMap<String, HashSet<String>> from,
                           LinkedList<String> path, List<List<String>> result) {
        if (word.equals(beginWord)) {
            path.addFirst(beginWord);
            result.add(new LinkedList<>(path));
            path.removeFirst();
            return;
        } else if (result.size() > 0 && result.get(0).size() == path.size()) {
            return;
        }

        path.addFirst(word);
        for (String fw : from.get(word)) {
            backtrack(fw, beginWord, from, path, result);
        }
        path.removeFirst();
    }

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> set = new HashSet<>();
        for (String word : wordList) {
            set.add(word);
        }
        HashMap<String, Integer> distance = new HashMap<>();
        List<List<String>> result = new LinkedList<>();
        HashMap<String, HashSet<String>> from = new HashMap<>();
        LinkedList<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        queue.offer(null);
        boolean isFound = false;
        int step = 0;
        while (!queue.isEmpty()) {
            String word = queue.poll();
            if (word == null) {
                if (isFound) {
                    backtrack(endWord, beginWord, from, new LinkedList<>(), result);
                    break;
                }
                step++;
                if (!queue.isEmpty()) {
                    queue.add(null);
                }
            } else {
                char[] chs = word.toCharArray();
                for (int i = 0; i < chs.length; i++) {
                    char old = chs[i];
                    for (char c = 'a'; c <= 'z'; c++) {
                        chs[i] = c;
                        String newWord = new String(chs);
                        if (set.contains(newWord) && (!distance.containsKey(newWord) || distance.get(newWord) == step)) {
                            queue.add(newWord);
                            distance.put(newWord, step);
                            if (from.get(newWord) == null) {
                                from.put(newWord, new HashSet<>());
                            }
                            from.get(newWord).add(word);
                            if (newWord.equals(endWord)) {
                                isFound = true;
                            }
                        }
                    }
                    chs[i] = old;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
//        String[] words = {"hot","dot","dog", "lot","log"};
        String[] words = {"hot","dot","dog","lot","log","cog"};
        List<List<String>> result = new Solution().findLadders("hit", "cog", Arrays.asList(words));
        for (List<String> path : result) {
            System.out.println(path);
        }
    }
}
