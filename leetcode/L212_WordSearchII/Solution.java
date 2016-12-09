package leetcode.L212_WordSearchII;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: deadend
 * @date: 9:57 AM 12/9/16
 * @version: 1.0
 * @description:
 */

class TrieNode {
    String word;
    HashMap<Character, TrieNode> children;

    public TrieNode() {
        word = null;
        children = new HashMap<>();
    }
}

public class Solution {
    private TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for (String word : words) {
            TrieNode p = root;
            for (char c : word.toCharArray()) {
                if (!p.children.containsKey(c)) {
                    p.children.put(c, new TrieNode());
                }
                p = p.children.get(c);
            }
            p.word = word;
        }
        return root;
    }

    private void dfs(char[][] board, int x, int y, TrieNode p, List<String> result) {
        if (x < 0 || y < 0 || x >= board.length || y >= board[0].length || board[x][y] == '#' || p.children.get(board[x][y]) == null) {
            return;
        }

        char c = board[x][y];
        p = p.children.get(c);
        if (p.word != null) {
            result.add(p.word);
            p.word = null;
        }

        board[x][y] = '#';
        dfs(board, x - 1, y, p, result);
        dfs(board, x + 1, y, p, result);
        dfs(board, x, y - 1, p, result);
        dfs(board, x, y + 1, p, result);
        board[x][y] = c;
    }

    public List<String> findWords(char[][] board, String[] words) {
        TrieNode root = buildTrie(words);
        List<String> result = new LinkedList<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(board, i, j, root, result);
            }
        }
        return result;
    }
}
