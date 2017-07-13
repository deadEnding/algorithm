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


public class Solution {

    class TrieNode {
        boolean isWord;
        boolean visited;
        HashMap<Character, TrieNode> children = new HashMap<>();
        public TrieNode() {}
    }

    class Trie {

        TrieNode root = new TrieNode();

        public void insert(String word) {
            TrieNode p = root;
            for (char c : word.toCharArray()) {
                if (!p.children.containsKey(c)) {
                    p.children.put(c, new TrieNode());
                }
                p = p.children.get(c);
            }
            p.isWord = true;
        }
    }

    private Trie trie = new Trie();

    private int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    private void dfs(int x, int y, char[][] board, boolean[][] visited, TrieNode p, StringBuilder path, List<String> result) {
        if (x < 0 || y < 0 || x >= board.length || y >= board[0].length || visited[x][y] || p == null || !p.children.containsKey(board[x][y])) {
            return;
        }

        visited[x][y] = true;
        p = p.children.get(board[x][y]);
        path.append(board[x][y]);
        if (p.isWord && !p.visited) {
            result.add(path.toString());
            p.visited = true;
        }

        for (int[] d : dirs) {
            dfs(x + d[0], y + d[1], board, visited, p, path, result);
        }

        path.deleteCharAt(path.length() - 1);
        visited[x][y] = false;
    }

    public List<String> findWords(char[][] board, String[] words) {
        List<String> result = new LinkedList<>();
        if (board == null || board.length == 0 || board[0].length == 0) {
            return result;
        }

        for (String word : words) {
            trie.insert(word);
        }

        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(i, j, board, visited, trie.root, new StringBuilder(), result);
            }
        }

        return result;
    }
}


class TrieNode {
    String word;
    HashMap<Character, TrieNode> children;

    public TrieNode() {
        word = null;
        children = new HashMap<>();
    }
}

class FirstSolution {
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
