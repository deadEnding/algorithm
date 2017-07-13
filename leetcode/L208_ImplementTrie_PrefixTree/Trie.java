package leetcode.L208_ImplementTrie_PrefixTree;

import java.util.HashMap;

/**
 * @author: deadend
 * @date: P10:20 PM 12/8/16
 * @version: 1.0
 * @description:
 */


class TrieNode {
    // Initialize your data structure here.
    boolean isWord;
    HashMap<Character, TrieNode> children;

    public TrieNode() {
        isWord = false;
        children = new HashMap<>();
    }
}

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts A word into the trie.
    public void insert(String word) {
        TrieNode p = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (!p.children.containsKey(c)) {
                p.children.put(c, new TrieNode());
            }
            p = p.children.get(c);
        }
        p.isWord = true;
    }

    private TrieNode searchWord(String word) {
        TrieNode p = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (!p.children.containsKey(c)) {
                return null;
            }
            p = p.children.get(c);
        }
        return p;
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        TrieNode p = searchWord(word);
        return p != null && p.isWord;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        return searchWord(prefix) != null;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("deadend");
        System.out.println(trie.search("deadend"));
        System.out.println(trie.startsWith("dead"));
    }
}
