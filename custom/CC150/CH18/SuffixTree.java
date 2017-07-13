package custom.CC150.CH18;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author: deadend
 * @date: 8:07 PM 1/5/17
 * @version: 1.0
 * @description: 给定字符串s和短字符串数组t,在s中搜索t各元素，返回各元素所有的起始索引
 */

class SuffixTreeNode {
    ArrayList<Integer> indexes;
    HashMap<Character, SuffixTreeNode> children;

    public SuffixTreeNode() {
        indexes = new ArrayList<>();
        children = new HashMap<>();
    }
}

public class SuffixTree {
    SuffixTreeNode root;

    public SuffixTree(String s) {
        root = new SuffixTreeNode();
        for (int i = 0; i < s.length(); i++) {
            insertString(s.substring(i), i);
        }
    }

    public void insertString(String s, int index) {
        SuffixTreeNode node = root;
        for (char c : s.toCharArray()) {
            if (!node.children.containsKey(c)) {
                node.children.put(c, new SuffixTreeNode());
            }
            node = node.children.get(c);
            node.indexes.add(index);
        }
    }

    public ArrayList<Integer> search(String s) {
        SuffixTreeNode node = root;
        for (char c : s.toCharArray()) {
            if (!node.children.containsKey(c)) {
                return new ArrayList<>();
            }
            node = node.children.get(c);
        }
        return node.indexes;
    }
}
