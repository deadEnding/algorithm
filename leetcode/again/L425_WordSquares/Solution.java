package leetcode.again.L425_WordSquares;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: deadend
 * @date: 8:53 PM 3/13/17
 * @version: 1.0
 * @description:
 */

class Trie {

    class TreeNode {
        List<String> startsWithWords;
        HashMap<Character, TreeNode> children;
        public TreeNode() {
            startsWithWords = new ArrayList<>();
            children = new HashMap<>();
        }
    }

    private TreeNode root;

    public Trie() {
        root = new TreeNode();
    }

    public void add(String word) {
        TreeNode p = root;
        root.startsWithWords.add(word);
        for (char c : word.toCharArray()) {
            if (!p.children.containsKey(c)) {
                p.children.put(c, new TreeNode());
            }
            p = p.children.get(c);
            p.startsWithWords.add(word);
        }
    }

    public List<String> startsWith(String prefix) {
        List<String> sw = new ArrayList<>();
        TreeNode p = root;
        for (char c : prefix.toCharArray()) {
            if (!p.children.containsKey(c)) {
                return sw;
            }
            p = p.children.get(c);
        }
        sw.addAll(p.startsWithWords);
        return sw;
    }
}

public class Solution {

    private Trie trie = new Trie();

    private void build(String[] words) {
        for (String w : words) {
            trie.add(w);
        }
    }

    private void backtracking(int n, ArrayList<String> path, List<List<String>> result) {
        final int size = path.size();
        if (size == n) {
            result.add(new ArrayList<>(path));
            return;
        }

        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < path.size(); i++) {
            buffer.append(path.get(i).charAt(size));
        }

        List<String> candidates = trie.startsWith(buffer.toString());
        for (String c : candidates) {
            path.add(c);
            backtracking(n, path, result);
            path.remove(path.size() - 1);
        }
    }

    public List<List<String>> wordSquares(String[] words) {
        List<List<String>> result = new LinkedList<>();
        if (words.length == 0) {
            return result;
        }

        build(words);
        backtracking(words[0].length(), new ArrayList<>(), result);
        return result;
    }

    public static void main(String[] args) {
        String[] ws = {"area","lead","wall","lady","ball"};
        System.out.println(new Solution().wordSquares(ws));
//        Trie trie = new Trie();
//        for (String s : ws) {
//            trie.add(s);
//        }
//        System.out.println(trie.startsWith("w"));
    }
}
