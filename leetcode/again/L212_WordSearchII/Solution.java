package leetcode.again.L212_WordSearchII;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: deadend
 * @date: 1:27 PM 3/4/17
 * @version: 1.0
 * @description:
 */


public class Solution {

    class TreeNode {
        String word;
        HashMap<Character, TreeNode> children;

        public TreeNode() {
            children = new HashMap<>();
        }
    }

    private TreeNode root = new TreeNode();
    private int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    private void insert(String word) {
        TreeNode p = root;
        for (char c : word.toCharArray()) {
            if (!p.children.containsKey(c)) {
                p.children.put(c, new TreeNode());
            }
            p = p.children.get(c);
        }
        p.word = word;
    }

    private void dfs(int x, int y, char[][] board, TreeNode node, List<String> result) {
        if (x < 0 || y < 0 || x >= board.length || y >= board[0].length ||
                board[x][y] == '#' || node.children.get(board[x][y]) == null) {
            return;
        }

        char ori = board[x][y];
        TreeNode child = node.children.get(ori);
        if (child.word != null) {
            result.add(child.word);
            child.word = null;   // 去重
        }

        board[x][y] = '#';
        for (int[] d : dirs) {
            dfs(x + d[0], y + d[1], board, child, result);
        }
        board[x][y] = ori;
    }

    public List<String> findWords(char[][] board, String[] words) {
        List<String> result = new LinkedList<>();
        if (board == null || board.length == 0 || board[0].length == 0) {
            return result;
        }

        for (String word : words) {
            insert(word);
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(i, j, board, root, result);
            }
        }
        return result;
    }
}
